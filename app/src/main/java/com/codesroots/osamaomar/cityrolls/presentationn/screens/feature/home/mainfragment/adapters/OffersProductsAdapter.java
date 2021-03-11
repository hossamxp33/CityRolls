package com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.home.mainfragment.adapters;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
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
import com.codesroots.osamaomar.cityrolls.R;
import com.codesroots.osamaomar.cityrolls.entities.Category;
import com.codesroots.osamaomar.cityrolls.entities.Offernew;
import com.codesroots.osamaomar.cityrolls.helper.PreferenceHelper;
import com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.home.productdetailsfragment.ProductDetailsFragment;

import java.util.List;

import static com.codesroots.osamaomar.cityrolls.entities.names.PRODUCT_ID;

public class OffersProductsAdapter extends RecyclerView.Adapter<OffersProductsAdapter.ViewHolder> {


    private Context context;
    List<Category> offerproducts;

    public OffersProductsAdapter(Context context, List<Category> offers) {
        this.context = context;
        this.offerproducts = offers;
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
        if (offerproducts.get(position).getItems() != null) {
            Glide.with(context.getApplicationContext())
                    .load(offerproducts.get(position).getItems().get(0).getPhoto())
                    .placeholder(R.drawable.product)
                    .into(holder.item_img);
        }
        try {
            holder.name.setText(offerproducts.get(position).getItems().get(0).getName());
         //   holder.discount.setText(context.getText(R.string.disscount)+" "+offerproducts.get(position).getItems().get(position).getPercentage()+" "+"%");

            //////////// Round Float Number //////////////
            String price = String.format("%.2f",Integer.valueOf((int) offerproducts.get(position).getItems().get(0).getPrice()) *
                     PreferenceHelper.getCurrencyValue() );
            ////////////  //////////////
            if (PreferenceHelper.getCurrencyValue() > 0)
                holder.price.setText(price + " " + PreferenceHelper.getCurrency());

            else
                holder.price.setText(offerproducts.get(position).getItems().get(0).getPrice() + " " + context.getText(R.string.coin));

            //

//            if (productsbysales.get(position).getProduct().getTotal_rating() != null) {
//                if (productsbysales.get(position).getProduct().getTotal_rating().size() > 0)
//                    holder.ratingBar.setRating(productsbysales.get(position).getProduct().getTotal_rating().get(0).getStars() /
//                            productsbysales.get(position).getProduct().getTotal_rating().get(0).getCount());
//            }


//            holder.item_img.setOnClickListener(v ->
//                    {
//                        Intent intent = new Intent(context, ImageActivity.class);
//                        intent.putExtra("url", productsbysales.get(position).getProduct().img);
//                        context.startActivity(intent);
//                    }
//            );

//            holder.ratingBar.setOnTouchListener((v, event) -> {
//                if (event.getAction() == MotionEvent.ACTION_UP) {
//                    Intent intent = new Intent(context, RateActivity.class);
//                    intent.putExtra(PRODUCT_ID, offerproducts.get(position).getId());
//                    context.startActivity(intent);
//                }
//                return true;
//            });



        } catch (Exception e) {
        }

        holder.mView.setOnClickListener(v ->
        {
            Fragment fragment = new ProductDetailsFragment();
            Bundle bundle = new Bundle();
            if (offerproducts.get(position).getItems() != null)
                bundle.putInt(PRODUCT_ID, offerproducts.get(position).getId());
            fragment.setArguments(bundle);
            ((FragmentActivity) context).getSupportFragmentManager().beginTransaction().
                    replace(R.id.mainfram, fragment)
                    .addToBackStack(null).commit();
        });
    }

    @Override
    public int getItemCount() {
        if (offerproducts != null) {
            return offerproducts.size();
        } else
            return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final View mView;
        private ImageView item_img;
        TextView price, name,discount;
        RatingBar ratingBar;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            item_img = view.findViewById(R.id.item_img);
            name = view.findViewById(R.id.item_name);
            price = view.findViewById(R.id.price);
            ratingBar = view.findViewById(R.id.rates);
            discount = mView.findViewById(R.id.discount);
        }
    }

}
