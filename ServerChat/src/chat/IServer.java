/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.rmi.Remote;

/**
 *
 * @author Felipe
 */
public interface IServer extends Remote {

    public IChat requestAtendent(IChat chat_client) throws java.rmi.RemoteException;
    public void requestJoin(IChat chat_atendent) throws java.rmi.RemoteException;
    public void requestLeave(IChat chat_atendent) throws java.rmi.RemoteException;
    public void freeAtendent(IChat chat_atendent) throws java.rmi.RemoteException;

}
