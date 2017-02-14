package application;

import java.net.URL;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import com.vic.poker.pokerclient.PokerClient;
import com.vic.poker.server.Server;
import com.vic.poker.vo.ResultVO;

public class MainController extends PokerClient implements Initializable{
	public MainController() throws RemoteException {

	}

	@FXML private ImageView img_dic_up_1;
	@FXML private ImageView img_dic_up_2;
	@FXML private ImageView img_dic_up_3;
	@FXML private ImageView img_dic_up_4;
	@FXML private ImageView img_dic_up_5;
	@FXML private ImageView img_dic_up_6;
	@FXML private ImageView img_dic_up_7;
	@FXML private ImageView img_dic_down_1;
	@FXML private ImageView img_dic_down_2;
	@FXML private ImageView img_dic_down_3;
	@FXML private ImageView img_dic_down_4;
	@FXML private ImageView img_dic_down_5;
	@FXML private ImageView img_dic_down_6;
	@FXML private ImageView img_dic_down_7;
	@FXML private Button btn_play;
	@FXML private Label label_whosWin;
	@FXML private Label label_pc;
	@FXML private Label label_user;
	@FXML private Label usr_money;
	@FXML private Label bat_money;
	@FXML private Label pc_money;
	@FXML private Button btn_batup;
	@FXML private Button btn_batdown;
	@FXML private TextField textField_id;
	@FXML private Button btn_connect;




	private ImageView[] arrImageView_1;
	private ImageView[] arrImageView_2;

	private Image[] arrImage_dice;

	private int[] arrCard_1 = new int[7];
	private int[] arrCard_2 = new int[7];

	HashMap<String,ResultVO> resultMap; 
	Server server;

	String name_my="";  
	String name_enermy ="";

	ArrayList<Integer> list = new ArrayList<Integer>();
	int cnt;
	boolean isStart = false, isEnd = true;





	@Override
	public void initialize(URL location, ResourceBundle resources) {

		arrImage_dice = new Image[52];


		for(int i = 0 ; i < arrImage_dice.length ; i++){

			arrImage_dice[i] = new Image("resource/poker_"+(i+1)+".JPG");

		}

		arrImageView_1 = new ImageView[7];
		arrImageView_1[0] = img_dic_up_1;
		arrImageView_1[1] = img_dic_up_2;
		arrImageView_1[2] = img_dic_up_3;
		arrImageView_1[3] = img_dic_up_4;
		arrImageView_1[4] = img_dic_up_5;
		arrImageView_1[5] = img_dic_up_6;
		arrImageView_1[6] = img_dic_up_7;
		arrImageView_2 = new ImageView[7];	
		arrImageView_2[0] = img_dic_down_1;
		arrImageView_2[1] = img_dic_down_2;
		arrImageView_2[2] = img_dic_down_3;
		arrImageView_2[3] = img_dic_down_4;
		arrImageView_2[4] = img_dic_down_5;
		arrImageView_2[5] = img_dic_down_6;
		arrImageView_2[6] = img_dic_down_7;

		pc_money.setText("10000");
		usr_money.setText("50000");
		bat_money.setText("1000");
	}

	@FXML
	public void onClickBatCard(ActionEvent event) {
	

		if(!isStart) {
			
			String[] name = {name_my,name_enermy};
			try {
				server.callStartGame();
				server.setRndCard();
				server.callCardPrint(name);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
	}




	@FXML
	public void setOnClickBatUp(ActionEvent event) {
		int betMoney = Integer.parseInt( bat_money.getText());

		if(betMoney < 10000 && betMoney <=  Integer.parseInt(usr_money.getText())) {
			betMoney+= 1000;
			bat_money.setText(betMoney+"");
		}

	}

	@FXML
	public void setOnClickBatDown(ActionEvent event) {
		int betMoney = Integer.parseInt( bat_money.getText());

		if(betMoney > 1000 ) {
			betMoney-= 1000;
			bat_money.setText(betMoney+"");
		}
	}

	@FXML
	public void setOnclickChangeCard(MouseEvent event) {

		if(isStart && !isEnd){
			((ImageView)event.getTarget()).setImage(new Image("resource/poker_0.JPG"));
			list.add(Integer.parseInt(((ImageView)event.getTarget()).getId()));
		}
	}

	@FXML
	public void setOnClickCahngeButton() {

		if(isStart && !isEnd ){

			try {

				cnt = server.getChangeCard(name_my, list);
				resultMap = (HashMap<String, ResultVO>) server.setResult();
				arrCard_2 = resultMap.get(name_my).getArrCard_1();
				myCardPrint();
				if(cnt == 2){
					server.callCardPrint(new String[]{name_my,name_enermy});
					server.callResultCard();
					server.callEndGame();

				}
				System.out.println("1");


			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}




	}

	@Override
	public void getResultCard() {
		try {


			resultMap = (HashMap<String, ResultVO>) server.setResult();

			//			label_pc.setText(resultMap.get(name_my).getCardRule2().name());
			//			label_user.setText(resultMap.get(name_my).getCardRule1().name());
			//			label_whosWin.setText(resultMap.get(name_enermy).getWhosWin());

			String pc =resultMap.get(name_enermy).getCardRule1().name();
			String user = resultMap.get(name_my).getCardRule1().name();
			String whosWin = resultMap.get(name_enermy).getWhosWin();



			Platform.runLater(new Runnable() {

				@Override
				public void run() {
					label_pc.setText(resultMap.get(name_enermy).getCardRule1().name());
					label_user.setText(resultMap.get(name_my).getCardRule1().name());
					label_whosWin.setText(resultMap.get(name_my).getWhosWin());
				}
			});



		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}




	@FXML 
	public void setOnClickConnect(ActionEvent event) throws Exception {
		if(!isStart && isEnd){
			Registry registry = LocateRegistry.getRegistry("localhost",6566);
			server = (Server) registry.lookup("remote");

			int count=0;

			if(!textField_id.getText().equals("")){
				name_my = textField_id.getText();  
				name_enermy ="";
				count = server.playGame(name_my,this);

			}
		}
	}

	@Override
	public void getName(){
		try {
			resultMap = (HashMap<String, ResultVO>) server.setCard();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		if(resultMap.get(name_my).getName1().equals(name_my) ){
			name_enermy = resultMap.get(name_my).getName2();

		}else {
			name_enermy = resultMap.get(name_my).getName1();
		}

		arrCard_2 = resultMap.get(name_my).getArrCard_1();
		arrCard_1 = resultMap.get(name_enermy).getArrCard_1();


	}

	@Override
	public void printCard() {

		try {
			resultMap = (HashMap<String, ResultVO>) server.setCard();
			arrCard_2 = resultMap.get(name_my).getArrCard_1();
			arrCard_1 = resultMap.get(name_enermy).getArrCard_1();
		} catch (RemoteException e) {
			e.printStackTrace();
		}



		myCardPrint();
		enermyCardPrint();
	}

	public void startGame() {
		isEnd = false;
		isStart = true;
	}

	public void endGame() {
		isStart = false;
		isEnd = true;
	}

	public void myCardPrint() {
		for(int i = 0 ; i < arrImageView_1.length; i++) {


			arrImageView_2[i].setImage(arrImage_dice[arrCard_2[i]]);
			arrImageView_2[i].setId(""+(arrCard_2[i]));
		}
	}

	public void enermyCardPrint() {
		for(int i = 0 ; i < arrImageView_1.length; i++) {

			arrImageView_1[i].setImage(arrImage_dice[arrCard_1[i]]);
			arrImageView_1[i].setId(""+(arrCard_1[i]));
		}
	}

}
