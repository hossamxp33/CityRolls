package com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.productfragment.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
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
import com.codesroots.osamaomar.shopgate.entities.Products;
import com.codesroots.osamaomar.shopgate.helper.PreferenceHelper;
import com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.productdetailsfragment.ProductDetailsFragment;
import com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.productfragment.ProductsViewModel;
import com.codesroots.osamaomar.shopgate.presentationn.screens.feature.rate.RateActivity;

import java.util.List;

import static com.codesroots.osamaomar.shopgate.entities.names.PRODUCT_ID;


public class AllProductsAdapter extends RecyclerView.Adapter<AllProductsAdapter.ViewHolder> {

    private Context context;
    private int type = 0;
    private List<Products.ProductsbycategoryBean> productsbysubcats;
    boolean[] favorite;
    ProductsViewModel viewModel;
    int userid = PreferenceHelper.getUserId();

    public AllProductsAdapter(Context mcontext, int viewType, List<Products.ProductsbycategoryBean> productsbysubcats1,
                              ProductsViewModel mViewModel) {
        context = mcontext;
        type = viewType;
        productsbysubcats = productsbysubcats1;
        viewModel = mViewModel;
        favorite = new boolean[productsbysubcats.size()];
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        if (type == 0)
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.product_item_adapter, parent, false);
        else
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.horizental_product_item_adapter, parent, false);

        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        if (productsbysubcats.get(position).getProductphotos().size() > 0)
            Glide.with(context.getApplicationContext())
                    .load(productsbysubcats.get(position).getImg()).placeholder(R.drawable.product).dontAnimate()
                    .into(holder.Image);

        holder.name.setText(productsbysubcats.get(position).getName());

        if (productsbysubcats.get(position).getTotal_rating() != null)
            if (productsbysubcats.get(position).getTotal_rating().size() > 0) {
                holder.ratingBar.setRating(productsbysubcats.get(position).getTotal_rating().get(0).getStars() /
                        productsbysubcats.get(position).getTotal_rating().get(0).getCount());
                holder.rateCount.setText("(" + productsbysubcats.get(position).getTotal_rating().get(0).getCount() + ")");
            }

        if (productsbysubcats.get(position).getProductsizes().size() > 0) {
            holder.amount.setText(context.getText(R.string.remendier) + " " +
                    String.valueOf(productsbysubcats.get(position).getProductsizes().get(0).getAmount()) + " " + context.getText(R.string.num));
            holder.price.setText(productsbysubcats.get(position).getProductsizes().get(0).getStart_price() + " " + context.getText(R.string.realcoin));
        }

        Fragment fragment = new ProductDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(PRODUCT_ID, productsbysubcats.get(position).getId());
        fragment.setArguments(bundle);
        holder.mView.setOnClickListener(v -> ((FragmentActivity) context).getSupportFragmentManager().beginTransaction().
                replace(R.id.mainfram, fragment)
                .addToBackStack(null).commit());

        holder.ratingBar.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_UP) {
                Intent intent = new Intent(context, RateActivity.class);
                intent.putExtra(PRODUCT_ID, productsbysubcats.get(position).getId());
                context.startActivity(intent);
            }
            return true;
        });

        //////////////////  inialize with all product
        if (userid > 0) {
            if (productsbysubcats.get(position).getFavourites()!=null) {
                if (productsbysubcats.get(position).getFavourites().size() > 0) {
                    holder.favorite.setImageResource(R.drawable.favoried);
                    favorite[position] = true;
                } else {
                    holder.favorite.setImageResource(R.drawable.like);
                    favorite[position] = false;
                }
            }
        }

        holder.favorite.setOnClickListener(v -> {
            if (userid > 0) {
                if (!favorite[position]) {
                    viewModel.AddToFav(productsbysubcats.get(position).getId());
                    viewModel.current_item = position;
                }
                ////////////// delete here
                else {
                    viewModel.DeleteFav(userid,productsbysubcats.get(position).getId());
                    viewModel.current_item = position;
                }
            } else
                Snackbar.make(v, context.getText(R.string.loginfirst), Snackbar.LENGTH_LONG).show();
        });
    }

    @Override
    public int getItemCount() {

        return productsbysubcats.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        final View mView;
        private ImageView Image, favorite;
        private TextView name, rateCount, amount, price, add_to_cart;
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
            favorite = mView.findViewById(R.id.favorite);
            add_to_cart = mView.findViewById(R.id.add_to_cart);
        }
    }
}