package com.example.osamaomar.shopgate.presentationn.screens.feature.home.mainfragment.adapters;

import android.content.Context;
import android.content.Intent;
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
import com.example.osamaomar.shopgate.entities.MainView;
import com.example.osamaomar.shopgate.helper.PreferenceHelper;
import com.example.osamaomar.shopgate.presentationn.screens.feature.home.productdetailsfragment.ProductDetailsFragment;
import com.example.osamaomar.shopgate.presentationn.screens.feature.rate.RateActivity;

import java.util.List;

import static com.example.osamaomar.shopgate.entities.names.PRODUCT_ID;

public class RecommendedProductsAdapter extends RecyclerView.Adapter<RecommendedProductsAdapter.ViewHolder> {


    private Context context;
    List<MainView.RandproductsBean> recommendesProducts;

    public RecommendedProductsAdapter(Context context, List<MainView.RandproductsBean> productsbyrate) {
        this.context = context;
        this.recommendesProducts = productsbyrate;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recommendes_products_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        try {
            holder.name.setText(recommendesProducts.get(position).getName());
            if (recommendesProducts.get(position).getProductphotos() != null) {
                if (recommendesProducts.get(position).getProductphotos().size() > 0)
                    Glide.with(context.getApplicationContext())
                            .load(recommendesProducts.get(position).getProductphotos().get(0).getPhoto())
                            .placeholder(R.drawable.product)
                            .into(holder.item_img);
            }

            if (recommendesProducts.get(position).getTotal_rating() != null) {
                if (recommendesProducts.get(position).getTotal_rating().size() > 0)
                    holder.ratingBar.setRating(recommendesProducts.get(position).getTotal_rating().get(0).getStars() /
                            recommendesProducts.get(position).getTotal_rating().get(0).getCount());
            }
            if (PreferenceHelper.getCurrencyValue() > 0)
                holder.price.setText(Float.valueOf(recommendesProducts.get(position).getProductsizes().get(0).getStart_price()) *
                        PreferenceHelper.getCurrencyValue() + " " + PreferenceHelper.getCurrency());
            else
                holder.price.setText(recommendesProducts.get(position).getProductsizes().get(0).getStart_price() + " " + context.getText(R.string.coin));


            holder.mView.setOnClickListener(v ->
            {
                Fragment fragment = new ProductDetailsFragment();
                Bundle bundle = new Bundle();
                if (recommendesProducts.get(position) != null)
                    bundle.putInt(PRODUCT_ID, recommendesProducts.get(position).getId());
                fragment.setArguments(bundle);
                ((FragmentActivity) context).getSupportFragmentManager().beginTransaction().
                        replace(R.id.mainfram, fragment)
                        .addToBackStack(null).commit();
            });

            holder.ratingBar.setOnTouchListener((v, event) -> {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    Intent intent = new Intent(context, RateActivity.class);
                    intent.putExtra(PRODUCT_ID, recommendesProducts.get(position).getId());
                    context.startActivity(intent);
                }
                return true;
            });

            holder.mView.setOnClickListener(v ->
            {
                Fragment fragment = new ProductDetailsFragment();
                Bundle bundle = new Bundle();
                if (recommendesProducts.get(position) != null)
                    bundle.putInt(PRODUCT_ID, recommendesProducts.get(position).getId());
                fragment.setArguments(bundle);
                ((FragmentActivity) context).getSupportFragmentManager().beginTransaction().
                        replace(R.id.mainfram, fragment)
                        .addToBackStack(null).commit();
            });


        } catch (Exception e) {
        }

    }

    @Override
    public int getItemCount() {
        if (recommendesProducts != null) {
            if (recommendesProducts.size() > 6)
                return 6;
            else
                return recommendesProducts.size();
        } else
            return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final View mView;
        private ImageView item_img;
        TextView price, name;
        RatingBar ratingBar;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            item_img = view.findViewById(R.id.item_img);
            name = view.findViewById(R.id.item_name);
            price = view.findViewById(R.id.price);
            ratingBar = view.findViewById(R.id.rates);
        }
    }

}
