package com.example.osamaomar.shopgate.presentationn.screens.feature.home.offerfragment.adapter;

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
import com.example.osamaomar.shopgate.R;
import com.example.osamaomar.shopgate.entities.Products;
import com.example.osamaomar.shopgate.presentationn.screens.feature.home.productdetailsfragment.ProductDetailsFragment;
import com.example.osamaomar.shopgate.presentationn.screens.feature.rate.RateActivity;

import java.util.List;

import static com.example.osamaomar.shopgate.entities.names.PRODUCT_ID;

public class AllOffersAdapter extends RecyclerView.Adapter<AllOffersAdapter.ViewHolder>  {

    private Context context;
    private int type = 0;
    private List<Products.ProductsbycategoryBean> productsbysubcats;
    public AllOffersAdapter(Context mcontext) {
        context = mcontext;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.offer_item_adapter, parent, false);

        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder,final int position) {
//
//        if (productsbysubcats.get(position).getProductphotos().size()>0)
//            Glide.with(context.getApplicationContext())
//                    .load(productsbysubcats.get(position).getProductphotos().get(0).getPhoto()).placeholder(R.drawable.product).dontAnimate()
//                    .into(holder.Image);
//
//            holder.name.setText(productsbysubcats.get(position).getName());
//
//
//        if (productsbysubcats.get(position).getProductsizes().get(0).getTotal_rating()!=null)
//        if (productsbysubcats.get(position).getProductsizes().get(0).getTotal_rating().size()>0) {
//            holder.ratingBar.setRating(productsbysubcats.get(position).getProductsizes().get(0).getTotal_rating().get(0).getStars() /
//                    productsbysubcats.get(position).getProductsizes().get(0).getTotal_rating().get(0).getCount());
//            holder.rateCount.setText("("+ productsbysubcats.get(position).getProductsizes().get(0).getTotal_rating().get(0).getCount()+")");
//        }
//
//        holder.amount.setText(context.getText(R.string.remendier)+" "+
//                String.valueOf(productsbysubcats.get(position).getProductsizes().get(0).getAmount())+" "+context.getText(R.string.num));
//
//        holder.price.setText(productsbysubcats.get(position).getProductsizes().get(0).getStart_price()+" "+context.getText(R.string.realcoin));
//        Fragment fragment = new ProductDetailsFragment();
//        Bundle bundle = new Bundle() ;
//        bundle.putInt(PRODUCT_ID,productsbysubcats.get(position).getId());
//        fragment.setArguments(bundle);
//        holder.mView.setOnClickListener(v -> ((FragmentActivity)context).getSupportFragmentManager().beginTransaction().
//                replace(R.id.mainfram,fragment)
//                .addToBackStack(null).commit());
//
//        holder.ratingBar.setOnTouchListener((v, event) -> {
//            if (event.getAction() == MotionEvent.ACTION_UP) {
//                Intent intent = new Intent(context, RateActivity.class);
//                intent.putExtra(PRODUCT_ID,productsbysubcats.get(position).getId());
//                context.startActivity(intent);
//            }
//            return true;
//        });

    }

    @Override
    public int getItemCount() {

        return 5;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        final View mView;
        private ImageView Image;
        private TextView name,rateCount,amount,price,oldprice;
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
            oldprice = mView.findViewById(R.id.old_price);
            oldprice.setPaintFlags(oldprice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        }
    }
}