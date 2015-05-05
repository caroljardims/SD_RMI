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
    public IServer stub;
    private javax.swing.JTextArea toRead;
    private javax.swing.JButton enviar;
    
    public AtendentChat(javax.swing.JTextArea toRead, javax.swing.JButton enviar) throws RemoteException {
        this.toRead = toRead;
        this.enviar = enviar;
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            this.stub = (IServer) registry.lookup("Server");
            this.stub.requestJoin(this);
            System.out.println("Conectou com o servidor!"); 
        } catch (NotBoundException | RemoteException e) {
            System.err.println("Client exception: " + e.toString());
        }
    }
    
    @Override
    public void setChat(IChat client){
        enviar.setEnabled(true);
        this.client = client;
        System.out.println("Cliente Recebido!");
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
