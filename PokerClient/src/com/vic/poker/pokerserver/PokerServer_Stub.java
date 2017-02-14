// Stub class generated by rmic, do not edit.
// Contents subject to change without notice.

package com.vic.poker.pokerserver;

public final class PokerServer_Stub
    extends java.rmi.server.RemoteStub
    implements com.vic.poker.server.Server, java.rmi.Remote
{
    private static final long serialVersionUID = 2;
    
    private static java.lang.reflect.Method $method_callCardPrint_0;
    private static java.lang.reflect.Method $method_callEndGame_1;
    private static java.lang.reflect.Method $method_callResultCard_2;
    private static java.lang.reflect.Method $method_callStartGame_3;
    private static java.lang.reflect.Method $method_getChangeCard_4;
    private static java.lang.reflect.Method $method_playGame_5;
    private static java.lang.reflect.Method $method_setCard_6;
    private static java.lang.reflect.Method $method_setResult_7;
    private static java.lang.reflect.Method $method_setRndCard_8;
    
    static {
	try {
	    $method_callCardPrint_0 = com.vic.poker.server.Server.class.getMethod("callCardPrint", new java.lang.Class[] {java.lang.String[].class});
	    $method_callEndGame_1 = com.vic.poker.server.Server.class.getMethod("callEndGame", new java.lang.Class[] {});
	    $method_callResultCard_2 = com.vic.poker.server.Server.class.getMethod("callResultCard", new java.lang.Class[] {});
	    $method_callStartGame_3 = com.vic.poker.server.Server.class.getMethod("callStartGame", new java.lang.Class[] {});
	    $method_getChangeCard_4 = com.vic.poker.server.Server.class.getMethod("getChangeCard", new java.lang.Class[] {java.lang.String.class, java.util.ArrayList.class});
	    $method_playGame_5 = com.vic.poker.server.Server.class.getMethod("playGame", new java.lang.Class[] {java.lang.String.class, com.vic.poker.client.Client.class});
	    $method_setCard_6 = com.vic.poker.server.Server.class.getMethod("setCard", new java.lang.Class[] {});
	    $method_setResult_7 = com.vic.poker.server.Server.class.getMethod("setResult", new java.lang.Class[] {});
	    $method_setRndCard_8 = com.vic.poker.server.Server.class.getMethod("setRndCard", new java.lang.Class[] {});
	} catch (java.lang.NoSuchMethodException e) {
	    throw new java.lang.NoSuchMethodError(
		"stub class initialization failed");
	}
    }
    
    // constructors
    public PokerServer_Stub(java.rmi.server.RemoteRef ref) {
	super(ref);
    }
    
    // methods from remote interfaces
    
    // implementation of callCardPrint(String[])
    public void callCardPrint(java.lang.String[] $param_arrayOf_String_1)
	throws java.rmi.RemoteException
    {
	try {
	    ref.invoke(this, $method_callCardPrint_0, new java.lang.Object[] {$param_arrayOf_String_1}, 5419761805958305177L);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of callEndGame()
    public void callEndGame()
	throws java.rmi.RemoteException
    {
	try {
	    ref.invoke(this, $method_callEndGame_1, null, 1156671363830458880L);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of callResultCard()
    public void callResultCard()
	throws java.rmi.RemoteException
    {
	try {
	    ref.invoke(this, $method_callResultCard_2, null, -6027864848935436272L);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of callStartGame()
    public void callStartGame()
	throws java.rmi.RemoteException
    {
	try {
	    ref.invoke(this, $method_callStartGame_3, null, 5712132121101171209L);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of getChangeCard(String, ArrayList)
    public int getChangeCard(java.lang.String $param_String_1, java.util.ArrayList $param_ArrayList_2)
	throws java.rmi.RemoteException
    {
	try {
	    Object $result = ref.invoke(this, $method_getChangeCard_4, new java.lang.Object[] {$param_String_1, $param_ArrayList_2}, -3579740555581475474L);
	    return ((java.lang.Integer) $result).intValue();
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of playGame(String, Client)
    public int playGame(java.lang.String $param_String_1, com.vic.poker.client.Client $param_Client_2)
	throws java.rmi.RemoteException
    {
	try {
	    Object $result = ref.invoke(this, $method_playGame_5, new java.lang.Object[] {$param_String_1, $param_Client_2}, 8154394097351185053L);
	    return ((java.lang.Integer) $result).intValue();
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of setCard()
    public java.util.Map setCard()
	throws java.rmi.RemoteException
    {
	try {
	    Object $result = ref.invoke(this, $method_setCard_6, null, -6455033336224614612L);
	    return ((java.util.Map) $result);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of setResult()
    public java.util.Map setResult()
	throws java.rmi.RemoteException
    {
	try {
	    Object $result = ref.invoke(this, $method_setResult_7, null, 3739036986601981730L);
	    return ((java.util.Map) $result);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of setRndCard()
    public void setRndCard()
	throws java.rmi.RemoteException
    {
	try {
	    ref.invoke(this, $method_setRndCard_8, null, 6364029070564394204L);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
}
