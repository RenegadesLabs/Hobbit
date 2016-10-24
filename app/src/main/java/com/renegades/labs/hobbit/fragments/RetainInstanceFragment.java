package com.renegades.labs.hobbit.fragments;

import android.os.Bundle;

import com.renegades.labs.hobbit.ChatAdapter;
import com.renegades.labs.hobbit.ChatMessage;

import java.util.ArrayList;

/**
 * Created by Виталик on 24.10.2016.
 */

public class RetainInstanceFragment extends android.support.v4.app.Fragment {
    private final ArrayList<ChatMessage> chatList;
    private final ChatAdapter chatAdapter;

    public RetainInstanceFragment() {
        this.chatList = Chats.chatList;
        this.chatAdapter = Chats.chatAdapter;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public ArrayList<ChatMessage> getChatList() {
        return chatList;
    }

    public ChatAdapter getChatAdapter() {
        return chatAdapter;
    }
}
