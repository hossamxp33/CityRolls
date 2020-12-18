package com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.mainfragment.adapters;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codesroots.osamaomar.shopgate.R;
import com.codesroots.osamaomar.shopgate.entities.Newdata;
import com.codesroots.osamaomar.shopgate.helper.PreferenceHelper;
import com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.productdetailsfragment.ProductDetailsFragment;

import java.util.List;

import static com.codesroots.osamaomar.shopgate.entities.names.PRODUCT_ID;

public class FamousProductsAdapter extends RecyclerView.Adapter<FamousProductsAdapter.ViewHolder> {


    private Context context;
    List<Newdata> famousProduct;

    public FamousProductsAdapter(Context context, List<Newdata> newdata) {
        this.context = context;
        this.famousProduct = newdata;
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
        try {
        holder.name.setText(famousProduct.get(position).getName());
        if (famousProduct.get(position).getImg() != null) {
                Glide.with(context.getApplicationContext())
                        .load(famousProduct.get(position).getImg())
                        .into(holder.item_img);
        }

        if (PreferenceHelper.getCurrency() !=  null)
            holder.price.setText(Integer.valueOf((int) famousProduct.get(position).getProductsizes().get(0).getCurrent_price()) *
                    PreferenceHelper.getCurrencyValue() + " " + PreferenceHelper.getCurrency());
         else
            holder.price.setText(famousProduct.get(position).getProductsizes().get(0).getCurrent_price() + " " + context.getText(R.string.coin));


        holder.mView.setOnClickListener(v ->
        {
            Fragment fragment = new ProductDetailsFragment();
            Bundle bundle = new Bundle();
            if (famousProduct.get(position) != null)
                bundle.putInt(PRODUCT_ID, famousProduct.get(position).getId());
            fragment.setArguments(bundle);
            ((FragmentActivity) context).getSupportFragmentManager().beginTransaction().
                    replace(R.id.mainfram, fragment)
                    .addToBackStack(null).commit();
        });

        }catch (Exception e)
        {

            Log.i("error", "onBindViewHolder: "+e);
        }

    }

    @Override
    public int getItemCount() {
        if (famousProduct != null) {
            if (famousProduct.size() > 6)
                return 6;
            else
                return famousProduct.size();
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
        }
    }

}
