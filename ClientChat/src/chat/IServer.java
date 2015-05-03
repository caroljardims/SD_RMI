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
}
