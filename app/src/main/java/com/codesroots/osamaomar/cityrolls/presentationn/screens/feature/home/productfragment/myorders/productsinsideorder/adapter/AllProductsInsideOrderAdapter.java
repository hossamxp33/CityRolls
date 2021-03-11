package com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.home.productfragment.myorders.productsinsideorder.adapter;

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
import com.codesroots.osamaomar.cityrolls.entities.MyOrders;
import com.codesroots.osamaomar.cityrolls.helper.PreferenceHelper;
import com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.addrate.AddRateFragment;

import java.util.List;

import static com.codesroots.osamaomar.cityrolls.entities.names.PRODUCT_ID;
import static com.codesroots.osamaomar.cityrolls.entities.names.PRODUCT_NAME;
import static com.codesroots.osamaomar.cityrolls.entities.names.PRODUCT_PHOTO;

public class AllProductsInsideOrderAdapter extends RecyclerView.Adapter<AllProductsInsideOrderAdapter.ViewHolder>  {

    private Context context;
    private List<MyOrders.DataBean.OrderdetailsBean> orderdetailsBeans;

    public AllProductsInsideOrderAdapter(Context mcontext, List<MyOrders.DataBean.OrderdetailsBean> orderdetails1) {
        context = mcontext;
        orderdetailsBeans = orderdetails1;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.product_insideorder_item_adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder,final int position) {

        holder.rate_product.setOnClickListener(v -> {
            Fragment fragment = new AddRateFragment();
            Bundle bundle = new Bundle() ;
            bundle.putInt(PRODUCT_ID,orderdetailsBeans.get(position).getProductsize().getProduct().getId());
            bundle.putString(PRODUCT_NAME,orderdetailsBeans.get(position).getProductsize().getProduct().getName());
            bundle.putString(PRODUCT_PHOTO,orderdetailsBeans.get(position).getProductsize().getProduct().getImg());
           // bundle.putString(PRODUCT_PHOTO,"http://shopgate.codesroots.com/library/attachment/pd1.jpg");
            fragment.setArguments(bundle);
            ((FragmentActivity)context).getSupportFragmentManager().beginTransaction().
            replace(R.id.mainfram,fragment)
            .addToBackStack(null).commit();
        });

        if (orderdetailsBeans.get(position).getProductsize().getProduct()!=null)
            Glide.with(context.getApplicationContext())
                    .load(orderdetailsBeans.get(position).getProductsize().getProduct().getImg()).placeholder(R.drawable.product).dontAnimate()
                    .into(holder.Image);
        try {
            holder.name.setText(orderdetailsBeans.get(position).getProductsize().getProduct().getName()  +  "/" + orderdetailsBeans.get(position).getProductsize().getSize()  +  "/" + orderdetailsBeans.get(position).getProduct_color().getColor() );

        } catch (Exception e) {
        }


        if (orderdetailsBeans.get(position).getProductsize().getProduct().getTotal_rating()!=null)
        if (orderdetailsBeans.get(position).getProductsize().getProduct().getTotal_rating().size()>0) {
            holder.rateCount.setText("("+orderdetailsBeans.get(position).getProductsize().getProduct().getTotal_rating().get(0).getCount()+")");
            holder.ratingBar.setRating(orderdetailsBeans.get(position).getProductsize().getProduct().getTotal_rating().get(0).getStars()/
                    orderdetailsBeans.get(position).getProductsize().getProduct().getTotal_rating().get(0).getCount());

        }

        holder.amount.setText(context.getText(R.string.remendier)+" "+
                String.valueOf(orderdetailsBeans.get(position).getProductsize().getAmount())+" "+context.getText(R.string.num));

       holder.price.setText(String.valueOf(Float.valueOf(orderdetailsBeans.get(position).getTotal())
               *PreferenceHelper.getCurrencyValue()+" "+PreferenceHelper.getCurrency()));


    }

    @Override
    public int getItemCount() {

        return orderdetailsBeans.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        final View mView;
        private ImageView Image;
        private TextView name,rateCount,amount,price,rate_product;
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
            rate_product = mView.findViewById(R.id.rate_product);
        }
    }
}