package com.renegades.labs.hobbit.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.renegades.labs.hobbit.ChatAdapter;
import com.renegades.labs.hobbit.ChatMessage;
import com.renegades.labs.hobbit.CommonMethods;
import com.renegades.labs.hobbit.MyService;
import com.renegades.labs.hobbit.R;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Виталик on 03.10.2016.
 */

public class Chats extends Fragment implements View.OnClickListener {

    private EditText msgEditText;
    private String user1 = "hobbit2", user2 = "hobbit1";
    private Random random;
    public static ArrayList<ChatMessage> chatList;
    public static ChatAdapter chatAdapter;
    ListView msgListView;
    private static final String TAG_WORKER = "TAG_WORKER";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chat_layout, container, false);
        random = new Random();
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(
                "Chats");
        msgEditText = (EditText) view.findViewById(R.id.messageEditText);
        msgListView = (ListView) view.findViewById(R.id.msgListView);
        ImageButton sendButton = (ImageButton) view
                .findViewById(R.id.sendMessageButton);
        sendButton.setOnClickListener(this);

        // Set autoscroll of listview when a new message arrives
        msgListView.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
        msgListView.setStackFromBottom(true);

        final RetainInstanceFragment retainInstanceFragment =
                (RetainInstanceFragment) getFragmentManager().findFragmentByTag(TAG_WORKER);

        if (retainInstanceFragment != null) {
            chatList = retainInstanceFragment.getChatList();
            chatAdapter = retainInstanceFragment.getChatAdapter();
        } else {
            chatList = new ArrayList<>();
            chatAdapter = new ChatAdapter(getActivity(), chatList);

            final RetainInstanceFragment retainFragment = new RetainInstanceFragment();
            getFragmentManager().beginTransaction()
                    .add(retainFragment, TAG_WORKER)
                    .commit();
        }

        msgListView.setAdapter(chatAdapter);
        return view;
    }

    public void sendTextMessage() {
        String message = msgEditText.getEditableText().toString();
        if (!message.equals("")) {
            final ChatMessage chatMessage = new ChatMessage(user1, user2,
                    message, "" + random.nextInt(1000), true);
            chatMessage.setMsgID();
            chatMessage.body = message;
            chatMessage.date = CommonMethods.getCurrentDate();
            chatMessage.time = CommonMethods.getCurrentTime();
            msgEditText.setText("");
            chatAdapter.add(chatMessage);
            chatAdapter.notifyDataSetChanged();
            MyService.xmpp.sendMessage(chatMessage);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sendMessageButton:
                sendTextMessage();

        }
    }

}
