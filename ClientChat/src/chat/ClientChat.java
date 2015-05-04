package chat;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Calendar;

/**
 *
 * @author Felipe
 */
public class ClientChat extends UnicastRemoteObject implements IChat {
    
    public Message m;
    public IChat atendent;
    
    public ClientChat() throws RemoteException {

       try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            IServer stub = (IServer) registry.lookup("Server");
            this.atendent = (IChat) stub.requestAtendent(this);
            System.out.println("Atendente Recebido!");
        } catch (NotBoundException | RemoteException e) {
            System.err.println("Client exception: " + e.toString());
        }
    }

    @Override
    public void deliver(Message msg) throws RemoteException {
        this.m = msg;
    }
    
    public void sendMessage (Message msg) throws RemoteException {
        this.atendent.deliver(msg);
    }
}
