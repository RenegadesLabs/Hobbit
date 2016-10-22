package com.renegades.labs.hobbit;

import java.util.Random;

/**
 * Created by Виталик on 03.10.2016.
 */

public class ChatMessage {
    public String body, sender, receiver, senderName;
    public String Date, Time;
    public String msgid;
    public boolean isMine;// Did I send the message.

    public ChatMessage(String Sender, String receiver, String messageString,
                       String ID, boolean isMINE) {
        body = messageString;
        isMine = isMINE;
        sender = Sender;
        msgid = ID;
        this.receiver = receiver;
        senderName = sender;
    }

    public void setMsgID() {
        msgid += "-" + String.format("%02d", new Random().nextInt(100));
    }
}
