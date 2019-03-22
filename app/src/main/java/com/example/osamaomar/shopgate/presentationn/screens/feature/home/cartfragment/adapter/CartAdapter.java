package com.example.osamaomar.shopgate.presentationn.screens.feature.home.cartfragment.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.osamaomar.shopgate.R;
import com.example.osamaomar.shopgate.entities.CartItems;
import com.example.osamaomar.shopgate.helper.PreferenceHelper;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder>  {

    private Context context;
    private  List<CartItems.DataBean> dataBeans;
    public CartAdapter(Context mcontext, List<CartItems.DataBean> dataBeans1) {
        context = mcontext;
        dataBeans = dataBeans1;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cart_item_adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder,final int position) {


        if (dataBeans.get(position).getProductphotos().size()>0)
            Glide.with(context.getApplicationContext())
                    .load(dataBeans.get(position).getProductphotos().get(0).getPhoto()).placeholder(R.drawable.product).dontAnimate()
                    .into(holder.Image);

        holder.name.setText(dataBeans.get(position).getName());

        if (dataBeans.get(position).getTotal_rating()!=null)
            if (dataBeans.get(position).getTotal_rating().size()>0) {
                holder.ratingBar.setRating(dataBeans.get(position).getTotal_rating().get(0).getStars() /
                        dataBeans.get(position).getTotal_rating().get(0).getCount());
                holder.rateCount.setText("("+ dataBeans.get(position).getTotal_rating().get(0).getCount()+")");
            }
        holder.amount.setText(context.getText(R.string.remendier)+" "+
                String.valueOf(dataBeans.get(position).getProductsizes().get(0).getAmount())+" "+context.getText(R.string.num));

        holder.price.setText(dataBeans.get(position).getProductsizes().get(0).getStart_price()+" "+context.getText(R.string.realcoin));

        holder.delete_item.setOnClickListener(v -> {
            PreferenceHelper.removeItemFromCart(dataBeans.get(position).getId());
            dataBeans.remove(position);
            notifyDataSetChanged();
        });

        holder.quintityPlus.setOnClickListener(v -> holder.products_count.setText(String.valueOf(Integer.valueOf(holder.products_count.getText().toString())+1)));

        holder.quintityMinus.setOnClickListener(v -> {
            int newValue = Integer.valueOf(holder.products_count.getText().toString())-1;
            if (newValue >=0)
            holder.products_count.setText(String.valueOf(newValue));
        });
    }

    @Override
    public int getItemCount() {
        return dataBeans.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        final View mView;
        private ImageView Image,favorite,delete_item,quintityMinus,quintityPlus;
        private TextView name,rateCount,amount,price;
        private RatingBar ratingBar;
        private EditText products_count;
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
            delete_item = mView.findViewById(R.id.delete_item);
            quintityMinus = mView.findViewById(R.id.quintityMinus);
            quintityPlus = mView.findViewById(R.id.quintityPlus);
            products_count = mView.findViewById(R.id.quintity_value);
        }
    }
}