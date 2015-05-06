
import java.rmi.Remote;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Felipe
 */
public interface IChat extends Remote {
    public void deliver(Message msg) throws java.rmi.RemoteException;
    public void setChat(IChat chat)throws java.rmi.RemoteException;
	public void closeChat()throws java.rmi.RemoteException;
}
