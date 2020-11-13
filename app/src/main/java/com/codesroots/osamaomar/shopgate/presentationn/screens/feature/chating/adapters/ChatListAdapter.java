package com.codesroots.osamaomar.shopgate.presentationn.screens.feature.chating.adapters;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.codesroots.osamaomar.shopgate.R;
import com.codesroots.osamaomar.shopgate.entities.ChatList;
import com.codesroots.osamaomar.shopgate.helper.PreferenceHelper;
import com.codesroots.osamaomar.shopgate.helper.Publicusecase;

import java.util.ArrayList;
import java.util.List;


public class ChatListAdapter extends RecyclerView.Adapter<ChatListAdapter.CustomView> {


    private Context context;
    private static final int VIEW_TYPE_MESSAGE_SENT = 1;
    private static final int VIEW_TYPE_MESSAGE_RECEIVED = 2;
    Integer companyId;
    List<ChatList.DataBean> AllMessages = new ArrayList<>();
    int userid = PreferenceHelper.getUserId();
    public ChatListAdapter(FragmentActivity activity, List<ChatList.DataBean> chatList) {
        this.context =  activity;
        AllMessages = chatList;
    }


    @Override
    public ChatListAdapter.CustomView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view;

            if (viewType ==VIEW_TYPE_MESSAGE_SENT)
                view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item_chat_send, parent, false);
            else
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.recycler_item_chat_recievied, parent, false);

        return new ChatListAdapter.CustomView(view);

    }


    @Override
    public int getItemViewType(int position) {

        if (AllMessages.get(position).getSender()==userid)
            return VIEW_TYPE_MESSAGE_SENT;
        else
            return  VIEW_TYPE_MESSAGE_RECEIVED;
    }

    @Override
    public void onBindViewHolder(@NonNull ChatListAdapter.CustomView holder, final int position) {

            holder.message.setText(AllMessages.get(position).getMessage_text());
            holder.cardwithimage.setVisibility(View.GONE);
            holder.cardwithmessage.setVisibility(View.VISIBLE);
            if (AllMessages.get(position).getDated().matches(""))
                holder.time.setText(context.getText(R.string.now));
            else
            holder.time.setText(Publicusecase.getTime(AllMessages.get(position).getDated())+","+Publicusecase.getTimeFromDate(AllMessages.get(position).getDated()));

    }

    @Override
    public int getItemCount() {
        return AllMessages.size();
    }

     class CustomView extends RecyclerView.ViewHolder {

        private final View mView;
        private ImageView itemImage;
        private TextView message,time ,imTime;
        CardView cardwithimage;
        CardView cardwithmessage;


        private CustomView(View view) {
            super(view);
            mView = view;

            message=mView.findViewById(R.id.tvMessage);
            time=mView.findViewById(R.id.tvTime);
            imTime = mView.findViewById(R.id.tvTimeomages);
            itemImage=mView.findViewById(R.id.image);
            cardwithmessage=mView.findViewById(R.id.cardmessage);
            cardwithimage=mView.findViewById(R.id.cardforimage);
        }
    }


    // Shows image  in full screen using  dialog
    public static void showImage(Context context , Uri uri) {
        Dialog dialog = new Dialog(context , android.R.style.Theme_Light);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(
                new ColorDrawable(Color.BLACK));
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                //nothing;
            }
        });
        ImageView imageView = new ImageView(context);
        Glide.with(context)
                .load(uri) // Uri of the picture
                .into(imageView);
        dialog.addContentView(imageView, new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        dialog.show();
}
}
