/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RemoteServer;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Felipe
 */
public class ServerChat extends UnicastRemoteObject implements IServer {
    
    public ArrayList<IChat> busyAtendent = new ArrayList<>();
    public ArrayList<IChat> freeAtendent = new ArrayList<>();
    public ServerChat() throws RemoteException {}

    @Override
    @SuppressWarnings("empty-statement")
    public synchronized IChat requestAtendent(IChat chat_client) throws RemoteException {
        System.out.println("Requisicao de Atendente Recebida");
        if (this.freeAtendent.isEmpty()) System.out.println("Nenhum Atendente Disponível");
        while(this.freeAtendent.isEmpty()){
            System.out.println("Aguardando Atendente...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ServerChat.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Atendente Disponível");
        IChat atendent = this.freeAtendent.get(0);
        this.busyAtendent.add(atendent);
        this.freeAtendent.remove(0);
        return atendent;
    }

    @Override
    public void requestJoin(IChat chat_atendent) throws RemoteException {
        this.freeAtendent.add(chat_atendent);
        try{
            System.out.println("Atendente localizado em: " + RemoteServer.getClientHost() + " se conectou");
        }catch(ServerNotActiveException e){
        }
    }

    @Override
    public void requestLeave(IChat chat_atendent) throws RemoteException {
        
    }

    @Override
    public void freeAtendent(IChat chat_atendent) throws RemoteException {
        
    }
     
    public static void main(String args[]) throws AlreadyBoundException 
    { 
        try 
        { 
            IServer stub = (IServer) new ServerChat();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("Server", stub);
            System.out.println("Servidor iniciando...");
        } 
        catch (RemoteException e) 
        { 
            System.out.println("Server Error: " + e.getMessage()); 
        } 
    }
    
}
