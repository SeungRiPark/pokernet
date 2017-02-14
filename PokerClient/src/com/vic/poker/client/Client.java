package com.vic.poker.client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Client extends Remote{
	public  void printCard() throws RemoteException;
	public void getName() throws RemoteException;
	public void getResultCard() throws RemoteException;
}
