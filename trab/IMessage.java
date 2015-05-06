


import java.util.Calendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Felipe
 */
public interface IMessage {
    public void setMessage(String msg) throws java.rmi.RemoteException;
    public String getMessage() throws java.rmi.RemoteException;
    public void setDate(Calendar c) throws java.rmi.RemoteException;
    public Calendar getDate() throws java.rmi.RemoteException;
}
