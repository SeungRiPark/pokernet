package com.vic.poker.pokerclient;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.vic.poker.client.Client;

public abstract class PokerClient extends UnicastRemoteObject implements Client {
	
	
	public PokerClient() throws RemoteException {
	}

	
	
	public abstract  void printCard() throws RemoteException;
	
	public abstract void getName() throws RemoteException;
	
	public abstract void getResultCard() throws RemoteException;
}
