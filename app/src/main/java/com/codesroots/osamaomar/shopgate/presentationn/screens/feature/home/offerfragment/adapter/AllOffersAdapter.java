package com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.offerfragment.adapter;

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

public class AllOffersAdapter extends RecyclerView.Adapter<AllOffersAdapter.ViewHolder>  {

    private Context context;
    private List<offers.DataBean> offersData;
    private float priceafteroffer = 0;
    public AllOffersAdapter(Context mcontext, List<offers.DataBean> offers) {
        context = mcontext;
        offersData = offers;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.offer_item_adapter, parent, false);

        return new ViewHolder(view);
    }


    @SuppressLint({"ClickableViewAccessibility", "SetTextI18n"})
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder,final int position) {

        if (offersData.get(position).getProduct().getProductphotos().size()>0)
            Glide.with(context.getApplicationContext())
                    .load(offersData.get(position).getProduct().getImg()).placeholder(R.drawable.product).dontAnimate()
                    .into(holder.Image);

            holder.name.setText(offersData.get(position).getProduct().getName());
        if (offersData.get(position).getProduct().getTotal_rating()!=null)
        if (offersData.get(position).getProduct().getTotal_rating().size()>0) {
            holder.ratingBar.setRating(offersData.get(position).getProduct().getTotal_rating().get(0).getStars() /
                    offersData.get(position).getProduct().getTotal_rating().get(0).getCount());
            holder.rateCount.setText("("+ offersData.get(position).getProduct().getTotal_rating().get(0).getCount()+")");
        }

        holder.amount.setText(context.getText(R.string.remendier)+" "+
                String.valueOf(offersData.get(position).getProduct().getProductsizes().get(0).getAmount())+" "+context.getText(R.string.num));

        priceafteroffer =Float.valueOf(offersData.get(position).getProduct().getProductsizes().get(0).getCurrent_price())- Float.valueOf(offersData.get(position).getProduct().getProductsizes().get(0).getCurrent_price())*
                Integer.valueOf(offersData.get(position).getPercentage())/100;

        holder.discount.setText(context.getText(R.string.disscount)+" "+offersData.get(position).getPercentage()+" "+"%");

//        if (!offersData.get(position).getPercentage().matches(""))
//        {
            if (PreferenceHelper.getCurrencyValue()>0)
                holder.price.setText(String.valueOf(Float.valueOf(priceafteroffer *PreferenceHelper.getCurrencyValue()+" "+
                        PreferenceHelper.getCurrency())));

            else
                holder.price.setText(String.valueOf(priceafteroffer)+context.getText(R.string.realcoin));

//        }
//        else
//        {
//            if (PreferenceHelper.getCurrencyValue()>0)
//                holder.price.setText(String.valueOf(Float.valueOf(offersData.get(position).getProduct().getProductsizes().get(0).getStart_price())
//                        *PreferenceHelper.getCurrencyValue()+" "+PreferenceHelper.getCurrency()));
//            else
//                holder.oldprice.setText(offersData.get(position).getProduct().getProductsizes().get(0).getStart_price()+" "+context.getText(R.string.realcoin));
//        }

        holder.oldprice.setText(offersData.get(position).getProduct().getProductsizes().get(0).getStart_price()+" "+context.getText(R.string.realcoin));
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
        private TextView name,rateCount,amount,price,oldprice,discount;
        private RatingBar ratingBar;
        ViewHolder(View view) {
            super(view);
            mView = view;
            Image = mView.findViewById(R.id.item_img);
            name = mView.findViewById(R.id.item_name);
            price = mView.findViewById(R.id.item_price);
            amount = mView.findViewById(R.id.quentity);
            rateCount = mView.findViewById(R.id.rate_count);
            ratingBar = mView.findViewById(R.id.rates);
            discount = mView.findViewById(R.id.discount);
            oldprice = mView.findViewById(R.id.old_price);
            oldprice.setPaintFlags(oldprice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }
    }
}