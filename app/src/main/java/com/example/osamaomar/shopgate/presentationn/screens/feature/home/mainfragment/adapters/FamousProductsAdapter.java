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

public class FamousProductsAdapter extends RecyclerView.Adapter<FamousProductsAdapter.ViewHolder> {


    private Context context;
    List<MainView.ProductsbyrateBean> famousProduct;
    public FamousProductsAdapter(Context context, List<MainView.ProductsbyrateBean> productsbyrate)
    {
        this.context =  context;
        this.famousProduct = productsbyrate;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_more_rate_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        if (famousProduct.get(position).getProduct()!=null) {
            holder.name.setText(famousProduct.get(position).getProduct().getName());
            if (famousProduct.get(position).getProduct().getProductphotos() != null) {
                if (famousProduct.get(position).getProduct().getProductphotos().size() > 0)
                    Glide.with(context.getApplicationContext())
                            .load(famousProduct.get(position).getProduct().getProductphotos().get(0).getPhoto())
                            .into(holder.item_img);
            }
        }

        if (famousProduct.get(position).getProduct()!=null) {
            if (famousProduct.get(position).getProduct().getTotal_rating() != null) {
                if (famousProduct.get(position).getProduct().getTotal_rating().size() > 0)
                    holder.ratingBar.setRating(famousProduct.get(position).getProduct().getTotal_rating().get(0).getStars() /
                            famousProduct.get(position).getProduct().getTotal_rating().get(0).getCount());
            }
        }

        if (PreferenceHelper.getCurrencyValue()>0)
        holder.price.setText(Float.valueOf(famousProduct.get(position).getStart_price())*PreferenceHelper.getCurrencyValue()+" "+PreferenceHelper.getCurrency());
        else
            holder.price.setText(famousProduct.get(position).getStart_price()+" "+context.getText(R.string.coin));


        holder.mView.setOnClickListener(v ->
        {
            Fragment fragment = new ProductDetailsFragment();
            Bundle bundle = new Bundle();
            if (famousProduct.get(position).getProduct()!=null)
                bundle.putInt(PRODUCT_ID,famousProduct.get(position).getProduct().getId());
            fragment.setArguments(bundle);
            ((FragmentActivity)context).getSupportFragmentManager().beginTransaction().
                    replace(R.id.mainfram,fragment)
                    .addToBackStack(null).commit();
        });

        holder.ratingBar.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_UP) {
                Intent intent = new Intent(context, RateActivity.class);
                intent.putExtra(PRODUCT_ID,famousProduct.get(position).getId());
                context.startActivity(intent);
            }
            return true;
        });

    }

    @Override
    public int getItemCount() {
        if (famousProduct!=null)
        return famousProduct.size();
        else
            return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        private ImageView item_img;
        TextView price,name;
        RatingBar ratingBar;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            item_img =view.findViewById(R.id.item_img);
            name =view.findViewById(R.id.item_name);
            price =view.findViewById(R.id.price);
            ratingBar =view.findViewById(R.id.rates);
        }
    }

}
