package com.vic.poker.pokerserver;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.vic.poker.client.Client;
import com.vic.poker.gamerule.CompareCard;
import com.vic.poker.server.Server;
import com.vic.poker.vo.CardRuleVO;
import com.vic.poker.vo.ResultVO;

public class PokerServer extends UnicastRemoteObject implements Server {

	private int[] arrCard_1 = new int[7];
	private int[] arrCard_2 = new int[7];
	private boolean[] isCard = new boolean[52]; 
	private String user1="";
	private String user2="";
	ResultVO vo1 = new ResultVO();
	ResultVO vo2 = new ResultVO();
	HashMap<String,ResultVO> resultMap = new HashMap<String, ResultVO>();
	ArrayList<Client> userList = new ArrayList<Client>();
	int count =0 ;
	int changeCnt = 0;

	// 생성자
	public PokerServer() throws RemoteException {

	}

	// 
	@Override
	public int   getChangeCard(String name, ArrayList<Integer> changedCardList) {
		int[] arrCard = resultMap.get(name).getArrCard_1();

		changeCnt++;
		for(int idx = 0; idx  < changedCardList.size();idx++) {
			int cardNum = changedCardList.get(idx);

			for(int i = 0 ; i < arrCard.length; i++) {
				if(arrCard[i] == cardNum){
					int imageShape1 = 0;
					int imageNumber1 = 0;

					while(true){
						imageShape1 = (int)(Math.random()*4);
						imageNumber1 = (int)(Math.random()*13);
						if(!isCard[imageShape1*13+imageNumber1]) {
							break;
						}
					}
					isCard[cardNum] = false;
					isCard[imageShape1*13+imageNumber1] = true;
					arrCard[i] = (imageShape1*13+imageNumber1);
				}

			}

		}
		resultMap.get(name).setArrCard_1(arrCard);
		if(changeCnt % 2 == 0){
			getResult();
			for(int i = 0; i < isCard.length; i++) {
				isCard[i] = false;
			}
			
			
		}
		return changeCnt;
	}

	public void reset() {
		for(int i = 0; i < isCard.length; i++) {
			isCard[i] = false;
		}
		if(changeCnt == 2) {
			changeCnt = 0;
			
		}
	}

	@Override
	public  Map<String,ResultVO> setCard() throws RemoteException {



		
		vo1.setArrCard_1(arrCard_1);
		vo2.setArrCard_1(arrCard_2);

		resultMap.put(vo1.getName1(), vo1);
		resultMap.put(vo2.getName1(), vo2);

		return resultMap;
	}

	public void callCardPrint(String[] name) {

		try {

			for(Client c : userList){
				
				c.printCard();
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}



	}

	@Override
	public Map<String,ResultVO> setResult() throws RemoteException {


		return resultMap;
	}

	@Override
	public int playGame(String name, Client client) throws RemoteException {
		if(user1.equals("")) {
			user1 = name;
			vo1.setName1(user1);
			userList.add(client);

			count++;
		}else if(user2.equals("")) {
			user2 = name;
			vo2.setName1(user2);
			userList.add(client);
			count++;
		}
		if(count != 0 && count  % 2== 0){

			
			if(vo1.getName1().equals(user1)) {
				vo1.setName2(user2);

			}
			if(vo2.getName1().equals(user2)) {

				vo2.setName2(user1);
			}

			for(Client c : userList){
				c.getName();
			}
		}

		return count;
	}

	@Override
	public void setRndCard() {
		for(int i = 0 ; i < arrCard_1.length; i++) {
			int imageShape1 = 0;
			int imageNumber1 = 0;
			int imageShape2 = 0;
			int imageNumber2 = 0;

			while(true){
				imageShape1 = (int)(Math.random()*4);
				imageNumber1 = (int)(Math.random()*13);
				if(!isCard[imageShape1*13+imageNumber1]) {
					break;
				}
			}
			while(true){
				imageShape2 = (int)(Math.random()*4);
				imageNumber2 = (int)(Math.random()*13);
				if(!isCard[imageShape2*13+imageNumber2]) {
					break;
				}
			}

			isCard[imageShape1*13+imageNumber1] = true;
			arrCard_1[i] = (imageShape1*13+imageNumber1);

			isCard[imageShape2*13+imageNumber2] = true;
			arrCard_2[i] = (imageShape2*13+imageNumber2);
		}
	}

	private void getResult() {
		CompareCard compareCard = new CompareCard();
		CardRuleVO vo1 = compareCard.getRule(arrCard_1);
		CardRuleVO vo2 = compareCard.getRule(arrCard_2);

		resultMap.get(user1).setCardRule1(vo1.getCardRule());
		resultMap.get(user2).setCardRule1(vo2.getCardRule());

		int result = compareCard.compareRule(vo1, vo2);

		String whosWinText ="";
		if(result > 0){
			whosWinText =user1+"가 승리하였습니다.";

			//			pc_money.setText(Integer.parseInt(pc_money.getText())+Integer.parseInt(bat_money.getText())+"");
			//			usr_money.setText(Integer.parseInt(usr_money.getText())-Integer.parseInt(bat_money.getText())+"");


		} else if(result < 0){
			whosWinText = user2+"가 승리하였습니다.";


			//			pc_money.setText(Integer.parseInt(pc_money.getText())-Integer.parseInt(bat_money.getText())+"");
			//			usr_money.setText(Integer.parseInt(usr_money.getText())+Integer.parseInt(bat_money.getText())+"");

		} else {
			whosWinText = "무승부 입니다.";
		}


		//		label_pc.setText(vo1.getCardRule().name());
		//		label_user.setText(vo2.getCardRule().name());
		//		label_whosWin.setText(whosWinText);
		resultMap.get(user1).setWhosWin(whosWinText);
		resultMap.get(user2).setWhosWin(whosWinText);
	


	}

	public void callResultCard() throws RemoteException{
		for(Client c : userList) {
			c.getResultCard();
		}
	}


	public static void main(String[] args) throws Exception {
		Registry registry = LocateRegistry.createRegistry(6566);

		PokerServer server = new PokerServer();
		registry.bind("remote", server);

	}


}
