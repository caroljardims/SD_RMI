/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Felipe
 */
public class AtendentChat extends UnicastRemoteObject implements IChat {
    
    public Message m = new Message();
    public AtendentChat() throws RemoteException {
        
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            IServer stub = (IServer) registry.lookup("Server");
            stub.requestJoin(this);
            System.out.println("Conectou com o servidor!"); 
        } catch (NotBoundException | RemoteException e) {
            System.err.println("Client exception: " + e.toString());
        }
    }
    
    @Override
    public void deliver(Message msg) throws RemoteException {
        this.m = msg;
    }
    
}
