/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Felipe
 */
public class AtendentChat extends UnicastRemoteObject implements IChat {
    public Message m = new Message();
    public IChat client = null;
    public IServer stub;
    private javax.swing.JTextArea toRead;
    private javax.swing.JButton enviar;
    
    public AtendentChat(javax.swing.JTextArea toRead, javax.swing.JButton enviar) throws RemoteException {
        this.toRead = toRead;
        this.enviar = enviar;
        try {
            this.stub = (IServer) Naming.lookup("rmi://localhost/ChatServer");
            this.stub.requestJoin(this);
            System.out.println("Conectou com o servidor!"); 
        } catch (NotBoundException | RemoteException e) {
            System.err.println("Client exception: " + e.toString());
        } catch (MalformedURLException ex) {
            Logger.getLogger(AtendentChat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void setChat(IChat client) throws RemoteException {
        enviar.setEnabled(true);
        this.client = client;
        System.out.println("Cliente Recebido!");
    }
	
	@Override
	public void closeChat() throws RemoteException {
		client.closeChat();
		this.client = null;
	}
    
    @Override
    public void deliver(Message msg) throws RemoteException {
        this.m = msg;
        Date date = m.getDate().getTime();
        this.toRead.setText(this.toRead.getText()+"\n"+date+" | Cliente > "+m.getMessage());
		if (msg.getMessage().equals("----- CONEXÃO ENCERRADA -----")) {
				enviar.setEnabled(false);
				client.closeChat();
		}
    }
    
    public void sendMessage (Message msg) throws RemoteException {
        this.client.deliver(msg);
    }
}
