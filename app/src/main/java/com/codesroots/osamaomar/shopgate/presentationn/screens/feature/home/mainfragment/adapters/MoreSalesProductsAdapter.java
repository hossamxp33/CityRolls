package com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.mainfragment.adapters;

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
import com.codesroots.osamaomar.shopgate.R;
import com.codesroots.osamaomar.shopgate.entities.MainView;
import com.codesroots.osamaomar.shopgate.helper.PreferenceHelper;
import com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.productdetailsfragment.ProductDetailsFragment;
import com.codesroots.osamaomar.shopgate.presentationn.screens.feature.rate.RateActivity;
import com.codesroots.osamaomar.shopgate.presentationn.screens.feature.showimage.ImageActivity;

import java.util.List;

import static com.codesroots.osamaomar.shopgate.entities.names.PRODUCT_ID;

public class MoreSalesProductsAdapter extends RecyclerView.Adapter<MoreSalesProductsAdapter.ViewHolder> {


    private Context context;
    List<MainView.Productsbysales> productsbysales;

    public MoreSalesProductsAdapter(Context context, List<MainView.Productsbysales> productsbyrate) {
        this.context = context;
        this.productsbysales = productsbyrate;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.more_sales_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        try {
            holder.name.setText(productsbysales.get(position).getProduct().getName());


            if (productsbysales.get(position).getProduct() != null) {
                    Glide.with(context.getApplicationContext())
                            .load(productsbysales.get(position).getProduct().getImg())
                            .placeholder(R.drawable.product)
                            .into(holder.item_img);
            }


            if (productsbysales.get(position).getProduct().getTotal_rating() != null) {
                if (productsbysales.get(position).getProduct().getTotal_rating().size() > 0)
                    holder.ratingBar.setRating(productsbysales.get(position).getProduct().getTotal_rating().get(0).getStars() /
                            productsbysales.get(position).getProduct().getTotal_rating().get(0).getCount());
            }

            if (PreferenceHelper.getCurrencyValue() > 0)
                holder.price.setText(Float.valueOf(productsbysales.get(position).getProduct().getProductsizes().get(0).getStart_price()) *
                        PreferenceHelper.getCurrencyValue() + " " + PreferenceHelper.getCurrency());
            else
                holder.price.setText(productsbysales.get(position).getProduct().getProductsizes().get(0).getStart_price() + " " + context.getText(R.string.coin));
//
//            holder.item_img.setOnClickListener(v ->
//                    {
//                        Intent intent = new Intent(context, ImageActivity.class);
//                        intent.putExtra("url", productsbysales.get(position).getProduct().img);
//                        context.startActivity(intent);
//                    }
//            );
            holder.mView.setOnClickListener(v ->
            {
                Fragment fragment = new ProductDetailsFragment();
                Bundle bundle = new Bundle();
                if (productsbysales.get(position) != null)
                    bundle.putInt(PRODUCT_ID, productsbysales.get(position).getId());
                fragment.setArguments(bundle);
                ((FragmentActivity) context).getSupportFragmentManager().beginTransaction().
                        replace(R.id.mainfram, fragment)
                        .addToBackStack(null).commit();
            });

            holder.ratingBar.setOnTouchListener((v, event) -> {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    Intent intent = new Intent(context, RateActivity.class);
                    intent.putExtra(PRODUCT_ID, productsbysales.get(position).getId());
                    context.startActivity(intent);
                }
                return true;
            });

            holder.mView.setOnClickListener(v ->
            {
                Fragment fragment = new ProductDetailsFragment();
                Bundle bundle = new Bundle();
                if (productsbysales.get(position) != null)
                    bundle.putInt(PRODUCT_ID, productsbysales.get(position).getProduct_id());
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
        if (productsbysales != null) {
            return productsbysales.size();
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
