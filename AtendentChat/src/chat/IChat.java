package chat;

import java.rmi.Remote;

public interface IChat extends Remote {
    public void deliver(Message msg) throws java.rmi.RemoteException;
}
