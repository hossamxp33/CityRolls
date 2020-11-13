package com.codesroots.osamaomar.shopgate.presentationn.screens.feature.chating;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.codesroots.osamaomar.shopgate.R;
import com.codesroots.osamaomar.shopgate.entities.ChatList;
import com.codesroots.osamaomar.shopgate.entities.chatmessages;
import com.codesroots.osamaomar.shopgate.helper.PreferenceHelper;
import com.codesroots.osamaomar.shopgate.presentationn.screens.feature.chating.adapters.ChatListAdapter;
import com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.mainfragment.MainViewModelFactory;

import java.util.ArrayList;
import java.util.List;

public class MessagesChatingActivity extends AppCompatActivity {

    ChatListAdapter chatListAdapter;
    private List<chatmessages.DataBean> allMessage;
    EditText etMessage;
    private static final int LOAD_IMG_REQUEST_CODE = 123;
    ImageView send, getimage, ivNotFound;
    ChatViewModel chatViewModel;
    RecyclerView recyclerView;
    ImageView ivSend;
    // ActivityChatBinding chatBinding;
    FrameLayout progress;
    List<ChatList.DataBean> messages = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // chatBinding = DataBindingUtil.setContentView(MessagesChatingActivity.this, R.layout.activity_chat);
        setContentView(R.layout.activity_chat);
        chatViewModel = ViewModelProviders.of(this, getViewModelFactory()).get(ChatViewModel.class);
        chatViewModel.getChatData(PreferenceHelper.getUserId());
        recyclerView = findViewById(R.id.recylerview);
        progress = findViewById(R.id.progress);
        etMessage = findViewById(R.id.etMessage);
        ivSend = findViewById(R.id.ivSend);
        Window window = getWindow();

        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(MessagesChatingActivity.this, R.color.colorPrimary));

        chatViewModel.chatListMutableLiveData.observe(this, chatList ->
        {
            messages = chatList.getData();
            progress.setVisibility(View.GONE);
            chatListAdapter = new ChatListAdapter(this, messages);
            recyclerView.setAdapter(chatListAdapter);
            // chatBinding.recylerview.setAdapter(chatListAdapter);
            recyclerView.scrollToPosition(chatListAdapter.getItemCount() - 1);
        });

        chatViewModel.error.observe(this, throwable ->
        {
            progress.setVisibility(View.GONE);
            //  Toast.makeText(this, getText(R.string.erroroccure), Toast.LENGTH_SHORT).show();
        });

        chatViewModel.addmessageMutableLiveData.observe(this, addmessage ->
        {
            messages.add(new ChatList.DataBean(addmessage.getChatting().getSender(), addmessage.getChatting().getMessage_text(), ""));
            chatListAdapter.notifyDataSetChanged();
            etMessage.setText("");
        });

        ivSend.setOnClickListener(v -> {
            //     if (PreferenceHelper.getUserId() > 0) {
            if (etMessage.getText().toString().matches(""))
                etMessage.setError(getText(R.string.empty));
            else
                chatViewModel.addmessge(PreferenceHelper.getUserId(), etMessage.getText().toString());
            //   }
        });
    }

    private MainViewModelFactory getViewModelFactory() {
        return new MainViewModelFactory(getApplication());
    }

}
