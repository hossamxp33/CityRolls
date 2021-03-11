package com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.home.productdetailsfragment.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codesroots.osamaomar.cityrolls.R;
import com.codesroots.osamaomar.cityrolls.entities.ProductDetails;
import com.codesroots.osamaomar.cityrolls.helper.PreferenceHelper;
import com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.home.productdetailsfragment.ProductDetailsFragment;
import com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.rate.RateActivity;

import java.util.List;

import static com.codesroots.osamaomar.cityrolls.entities.names.PRODUCT_ID;

public class RelatedProductsAdapter extends RecyclerView.Adapter<RelatedProductsAdapter.ViewHolder> {


    private Context context;
    List<ProductDetails.Related> famousProduct;

    public RelatedProductsAdapter(Context context, List<ProductDetails.Related> relateds) {
        this.context = context;
        this.famousProduct = relateds;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.related_item, parent, false);

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
            String the_price = String.format("%.2f",Float.valueOf(famousProduct.get(position).getProductsizes()
                    .get(0).getCurrent_price() *
                    PreferenceHelper.getCurrencyValue()) );
        if (PreferenceHelper.getCurrencyValue() > 0)
            holder.price.setText(the_price + " " + PreferenceHelper.getCurrency());
        else
            holder.price.setText(Float.valueOf(famousProduct.get(position).getProductsizes().get(0).getCurrent_price()) + " " + context.getText(R.string.coin));


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


//
//            holder.item_img.setOnClickListener(v ->
//                    {
//                        Intent intent = new Intent(context, ImageActivity.class);
//                        intent.putExtra("url",famousProduct.get(position).img);
//                        context.startActivity(intent);
//                    }
//            );
        holder.ratingBar.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_UP) {
                Intent intent = new Intent(context, RateActivity.class);
                intent.putExtra(PRODUCT_ID, famousProduct.get(position).getId());
                context.startActivity(intent);
            }
            return true;
        });
        }catch (Exception e)
        {}

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
            ratingBar = view.findViewById(R.id.rates);
        }
    }

}
