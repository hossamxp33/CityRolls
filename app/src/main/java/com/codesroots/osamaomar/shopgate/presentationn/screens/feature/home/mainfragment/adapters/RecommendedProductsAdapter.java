package com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.mainfragment.adapters;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codesroots.osamaomar.shopgate.R;
import com.codesroots.osamaomar.shopgate.entities.Productsbysale;
import com.codesroots.osamaomar.shopgate.helper.PreferenceHelper;
import com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.productdetailsfragment.ProductDetailsFragment;

import java.util.List;

import static com.codesroots.osamaomar.shopgate.entities.names.PRODUCT_ID;

public class RecommendedProductsAdapter extends RecyclerView.Adapter<RecommendedProductsAdapter.ViewHolder> {


    private Context context;
    List<Productsbysale> recommendesProducts;

    public RecommendedProductsAdapter(Context context, List<Productsbysale> productsbyrate) {
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


            ///////////////////////////
            holder.name.setText(recommendesProducts.get(position).getProduct().getName());
            if (recommendesProducts.get(position).getProduct().getImg() != null) {
                    Glide.with(context.getApplicationContext())
                            .load(recommendesProducts.get(position).getProduct().getImg())
                            .placeholder(R.drawable.product)
                            .into(holder.item_img);
            }

            //////////// Round Float Number //////////////
            String price = String.format("%.2f",Float.valueOf(recommendesProducts.get(position).getCurrent_price()) *
                    PreferenceHelper.getCurrencyValue());
            if (PreferenceHelper.getCurrencyValue() > 0)
                holder.price.setText(price + " " + PreferenceHelper.getCurrency());
            else
                holder.price.setText(recommendesProducts.get(position).getCurrent_price() + " " + context.getText(R.string.coin));



            holder.mView.setOnClickListener(v ->
            {
                Fragment fragment = new ProductDetailsFragment();
                Bundle bundle = new Bundle();
                if (recommendesProducts.get(position).getProduct() != null)
                    bundle.putInt(PRODUCT_ID, recommendesProducts.get(position).getProduct_id());
                fragment.setArguments(bundle);
                ((FragmentActivity) context).getSupportFragmentManager().beginTransaction().
                        replace(R.id.mainfram, fragment)
                        .addToBackStack(null).commit();
            });




        }catch (Exception e)
        {}



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
        ConstraintLayout productview;
        public ViewHolder(View view) {
            super(view);
            mView = view;
            item_img = view.findViewById(R.id.item_img);
            name = view.findViewById(R.id.item_name);
            price = view.findViewById(R.id.price);
            ratingBar = view.findViewById(R.id.rates);
            productview = view.findViewById(R.id.productview);
        }
    }

}
