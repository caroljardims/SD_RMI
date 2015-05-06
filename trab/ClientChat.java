
import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Felipe
 */
public class ClientChat extends UnicastRemoteObject implements IChat {
    
    public Message m;
    public IChat atendent = null;
    private javax.swing.JTextArea toRead;
    private javax.swing.JButton enviar;
    public ClientChat(javax.swing.JTextArea toRead, javax.swing.JButton enviar) throws RemoteException {
        this.toRead = toRead;
		this.enviar = enviar;
        try {
            IServer stub = (IServer) Naming.lookup("rmi://localhost/ChatServer");
            this.atendent = (IChat) stub.requestAtendent(this);
            this.atendent.setChat(this);
            System.out.println("Atendente Recebido!");
        } catch (NotBoundException | RemoteException e) {
            System.err.println("Client exception: " + e.toString());
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClientChat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sendMessage (Message msg) throws RemoteException {
        this.atendent.deliver(msg);
    }

    @Override
    public void setChat(IChat chat) throws RemoteException {}
    
	public void closeChat() throws RemoteException {
		this.atendent = null;
	}
	
    @Override
    public void deliver(Message msg) throws RemoteException {
        this.m = msg;
        Date date = m.getDate().getTime();
        this.toRead.setText(this.toRead.getText()+"\n"+date+" | Atendente > "+m.getMessage());
		if (msg.getMessage().equals("----- CONEXÃO ENCERRADA -----")) {
				enviar.setEnabled(false);
				atendent.closeChat();
		}
    }
}
