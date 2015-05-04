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
import java.util.Date;

/**
 *
 * @author Felipe
 */
public class AtendentChat extends UnicastRemoteObject implements IChat {
    public Message m = new Message();
    public IChat client;
    private javax.swing.JTextArea toRead;
    public AtendentChat(javax.swing.JTextArea toRead) throws RemoteException {
        this.toRead = toRead;
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
    public void setChat(IChat client){
        this.client = client;
        System.out.println("Recebido!");
    }
    
    @Override
    public void deliver(Message msg) throws RemoteException {
        this.m = msg;
        Date date = m.getDate().getTime();
        this.toRead.setText(this.toRead.getText()+"\n"+date+" | Cliente > "+m.getMessage());
    }
    
    public void sendMessage (Message msg) throws RemoteException {
        this.client.deliver(msg);
    }
}
