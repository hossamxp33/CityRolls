package com.codesroots.osamaomar.shopgate.presentationn.screens.feature.smallstore.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codesroots.osamaomar.shopgate.R;
import com.codesroots.osamaomar.shopgate.entities.offers;
import com.codesroots.osamaomar.shopgate.helper.PreferenceHelper;
import com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.productdetailsfragment.ProductDetailsFragment;
import com.codesroots.osamaomar.shopgate.presentationn.screens.feature.rate.RateActivity;

import java.util.List;

import static com.codesroots.osamaomar.shopgate.entities.names.PRODUCT_ID;


public class smallStoreAdapter extends RecyclerView.Adapter<com.codesroots.osamaomar.shopgate.presentationn.screens.feature.smallstore.adapter.smallStoreAdapter.ViewHolder>  {

    private Context context;
    private List<offers.DataBean> offersData;
    private float priceafteroffer = 0;
    public smallStoreAdapter(Context mcontext, List<offers.DataBean> offers) {
        context = mcontext;
        offersData = offers;
    }

    @NonNull
    @Override
    public com.codesroots.osamaomar.shopgate.presentationn.screens.feature.smallstore.adapter.smallStoreAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.small_store_adapter, parent, false);

        return new com.codesroots.osamaomar.shopgate.presentationn.screens.feature.smallstore.adapter.smallStoreAdapter.ViewHolder(view);
    }





    @SuppressLint({"ClickableViewAccessibility", "SetTextI18n"})
    @Override
    public void onBindViewHolder(com.codesroots.osamaomar.shopgate.presentationn.screens.feature.smallstore.adapter.smallStoreAdapter.ViewHolder holder, final int position) {

        if (offersData.get(position).getProduct().getProductphotos().size()>0)
            Glide.with(context.getApplicationContext())
                    .load(offersData.get(position).getProduct().getImg()).placeholder(R.drawable.product).dontAnimate()
                    .into(holder.Image);

        holder.name.setText(offersData.get(position).getProduct().getName());
        if (offersData.get(position).getProduct().getTotal_rating()!=null)
            if (offersData.get(position).getProduct().getTotal_rating().size()>0) {
                holder.ratingBar.setRating(offersData.get(position).getProduct().getTotal_rating().get(0).getStars() /
                        offersData.get(position).getProduct().getTotal_rating().get(0).getCount());
            }




        Fragment fragment = new ProductDetailsFragment();
        Bundle bundle = new Bundle() ;
        bundle.putInt(PRODUCT_ID,offersData.get(position).getProduct_id());
        fragment.setArguments(bundle);
        holder.mView.setOnClickListener(v -> ((FragmentActivity)context).getSupportFragmentManager().beginTransaction().
                replace(R.id.mainfram,fragment)
                .addToBackStack(null).commit());

        holder.ratingBar.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_UP) {
                Intent intent = new Intent(context, RateActivity.class);
                intent.putExtra(PRODUCT_ID,offersData.get(position).getId());
                context.startActivity(intent);
            }
            return true;
        });

    }

    @Override
    public int getItemCount() {

        return offersData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        final View mView;
        private ImageView Image;
        private TextView name;
        private RatingBar ratingBar;
        ViewHolder(View view) {
            super(view);
            mView = view;
            Image = mView.findViewById(R.id.item_img);
            name = mView.findViewById(R.id.store_name);
        }
    }
}