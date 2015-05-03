package chat;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Felipe
 */
public class ClientChat extends UnicastRemoteObject implements IChat {
    
    public ClientChat() throws RemoteException {

       try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            IServer stub = (IServer) registry.lookup("Server");
            stub.requestAtendent(this);
            System.out.println("Atendente Recebido!");
        } catch (NotBoundException | RemoteException e) {
            System.err.println("Client exception: " + e.toString());
        }
    }
    
    @Override
    public void deliver(Message msg) throws RemoteException {
        
    }
    
}
