package com.vic.poker.vo;

import java.io.Serializable;

import com.vic.poker.gamerule.CardRule;

public class ResultVO implements  Serializable {
	String name1;
	String name2;
	
	private int[] arrCard_1 = new int[7];
	

	private int user_1_money;
	
	
	
	private CardRule cardRule1;
	
	
	
	private String whosWin;
	
	
	
	
	
	
	public String getName1() {
		return name1;
	}
	public void setName1(String name1) {
		this.name1 = name1;
	}
	public String getName2() {
		return name2;
	}
	public void setName2(String name2) {
		this.name2 = name2;
	}
	public String getWhosWin() {
		return whosWin;
	}
	public void setWhosWin(String whosWin) {
		this.whosWin = whosWin;
	}
	public int[] getArrCard_1() {
		return arrCard_1;
	}
	public void setArrCard_1(int[] arrCard_1) {
		this.arrCard_1 = arrCard_1;
	}
	
	
	public int getUser_1_money() {
		return user_1_money;
	}
	public void setUser_1_money(int user_1_money) {
		this.user_1_money = user_1_money;
	}
	
	public CardRule getCardRule1() {
		return cardRule1;
	}
	public void setCardRule1(CardRule cardRule1) {
		this.cardRule1 = cardRule1;
	}
	
	
	
	
}
