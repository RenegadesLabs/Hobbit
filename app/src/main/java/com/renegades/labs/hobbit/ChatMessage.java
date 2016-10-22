package com.renegades.labs.hobbit;

import java.util.Locale;
import java.util.Random;

/**
 * Created by Виталик on 03.10.2016.
 */

public class ChatMessage {
    public String body, sender, receiver;
    public String date, time;
    public String msgId;
    public boolean isMine;// Did I send the message.

    public ChatMessage(String sender, String receiver, String messageString,
                       String msgId, boolean isMine) {
        body = messageString;
        this.isMine = isMine;
        this.sender = sender;
        this.msgId = msgId;
        this.receiver = receiver;
    }

    public void setMsgID() {
        msgId += "-" + String.format(Locale.ENGLISH, "%02d", new Random().nextInt(100));
    }
}
