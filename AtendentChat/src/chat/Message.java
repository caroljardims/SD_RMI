/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.util.Calendar;

/**
 *
 * @author Felipe
 */
public class Message implements IMessage {
    private Calendar date;
    private String msg;

   
    @Override
    public void setMessage(String msg) {
        this.msg = msg;
    }
    @Override
    public String getMessage() {
        return this.msg;
    }
    @Override
    public void setDate(Calendar c) {
        this.date = c;
    }
    @Override
    public Calendar getDate() {
        return this.date;
    }
}
