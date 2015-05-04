package chat;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Felipe
 */
public class ClientChat extends UnicastRemoteObject implements IChat {
    
    public Message m;
    public IChat atendent;
    private javax.swing.JTextArea toRead;
    public ClientChat(javax.swing.JTextArea toRead) throws RemoteException {
        this.toRead = toRead;
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            IServer stub = (IServer) registry.lookup("Server");
            this.atendent = (IChat) stub.requestAtendent(this);
            this.atendent.setChat(this);
            System.out.println("Atendente Recebido!");
        } catch (NotBoundException | RemoteException e) {
            System.err.println("Client exception: " + e.toString());
        }
    }
    
    public void sendMessage (Message msg) throws RemoteException {
        this.atendent.deliver(msg);
    }

    @Override
    public void setChat(IChat chat) throws RemoteException {}
    
    @Override
    public void deliver(Message msg) throws RemoteException {
        this.m = msg;
        Date date = m.getDate().getTime();
        this.toRead.setText(this.toRead.getText()+"\n"+date+" | Atendente > "+m.getMessage());
    }
}