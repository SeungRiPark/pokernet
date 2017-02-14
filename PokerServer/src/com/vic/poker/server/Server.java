package com.vic.poker.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Map;

import com.vic.poker.client.Client;
import com.vic.poker.vo.ResultVO;

public interface Server extends Remote {
	public Map<String,ResultVO> setCard() throws RemoteException;
	public Map<String,ResultVO> setResult() throws RemoteException;
	public int playGame(String name, Client client) throws RemoteException;
	public int  getChangeCard(String name, ArrayList<Integer> changedCardList) throws RemoteException;
	public void callCardPrint(String[] name) throws RemoteException;
	public void callResultCard() throws RemoteException;
	public void setRndCard() throws RemoteException;
	public void callStartGame() throws RemoteException;
	public void callEndGame() throws RemoteException;
}
