package chat;


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IChat extends Remote {
    public void deliver(Message msg) throws RemoteException;
    public void setChat(IChat chat)throws java.rmi.RemoteException;
}
