package com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.myorders.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codesroots.osamaomar.shopgate.R;
import com.codesroots.osamaomar.shopgate.entities.MyOrders;
import com.codesroots.osamaomar.shopgate.helper.PreferenceHelper;
import com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.myorders.productsinsideorder.ProductsInsideorderFragment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.codesroots.osamaomar.shopgate.entities.names.ORDER;
import static com.codesroots.osamaomar.shopgate.entities.names.ORDER_ID;

public class MyOrdersAdapter extends RecyclerView.Adapter<MyOrdersAdapter.ViewHolder> {

    private Context context;
    private List<MyOrders.DataBean> orderdata;

    public MyOrdersAdapter(Context mcontext, List<MyOrders.DataBean> data) {
        context = mcontext;
        orderdata = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.myorder_item_adapter, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        try {
            if (PreferenceHelper.getCurrencyValue()>0)
                holder.orderdate.setText(String.valueOf(Float.valueOf(orderdata.get(position).getPrice())
                        *PreferenceHelper.getCurrencyValue()+" "+PreferenceHelper.getCurrency()));
            else
                holder.orderPrice.setText(orderdata.get(position).getPrice());

            holder.orderdate.setText(getdate(orderdata.get(position).getCreated()));
            holder.ordernum.setText(String.valueOf(orderdata.get(position).getId()));
            holder.payment.setText(orderdata.get(position).getType());
            holder.productCount.setText(String.valueOf(orderdata.get(position).getOrderdetails().size()) +" "+ context.getText(R.string.num));
            holder.productname.setText(orderdata.get(position).getOrderdetails().
                    get(0).getProductsize().getProduct().getName());

           holder.ratecount.setText("("+orderdata.get(position).getOrderdetails().
                   get(0).getProductsize().getProduct().getTotal_rating().get(0).getCount()+")");

           holder.ratingBar.setRating(orderdata.get(position).getOrderdetails().
                   get(0).getProductsize().getProduct().getTotal_rating().get(0).getStars()/orderdata.get(position).getOrderdetails().
                   get(0).getProductsize().getProduct().getTotal_rating().get(0).getCount());

            if (orderdata.get(position).getOrder_status().matches("2")) {
                holder.statues2.setTextColor(R.color.white);
                holder.statues2.setBackgroundResource(R.drawable.selected_progress);
            } else if (orderdata.get(position).getOrder_status().matches("3")) {
                holder.statues2.setTextColor(R.color.white);
                holder.statues3.setTextColor(R.color.white);
                holder.statues2.setBackgroundResource(R.drawable.selected_progress);
                holder.statues3.setBackgroundResource(R.drawable.selected_progress);
            }

            else if (orderdata.get(position).getOrder_status().matches("4")) {
                holder.statues2.setTextColor(R.color.white);
                holder.statues3.setTextColor(R.color.white);
                holder.statues4.setTextColor(R.color.white);
                holder.statues2.setBackgroundResource(R.drawable.selected_progress);
                holder.statues3.setBackgroundResource(R.drawable.selected_progress);
                holder.statues4.setBackgroundResource(R.drawable.selected_progress);
            }
            Glide.with(context).load(orderdata.get(position).getOrderdetails().
                    get(0).getProductsize().getProduct().getImg()).
                    dontAnimate().placeholder(R.drawable.product).into(holder.Image);

        } catch (Exception e) {
        }

        holder.gotodetails.setOnClickListener(v -> {
            Fragment fragment = new ProductsInsideorderFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(ORDER_ID, orderdata.get(position).getId());
            bundle.putSerializable(ORDER,orderdata.get(position));
            fragment.setArguments(bundle);
            ((FragmentActivity) context).getSupportFragmentManager().beginTransaction().replace(R.id.mainfram, fragment).addToBackStack(null).commit();
        });


    }

    @Override
    public int getItemCount() {
        return orderdata.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        final View mView;
        private ImageView Image;
        private TextView statues1, statues2, statues3,statues4, orderPrice, productCount, orderdate, ordernum, productname, ratecount, gotodetails, payment;
        private RatingBar ratingBar;
        ViewHolder(View view) {
            super(view);
            mView = view;
            Image = mView.findViewById(R.id.item_img);
            statues1 = mView.findViewById(R.id.progress1);
            statues2 = mView.findViewById(R.id.progress2);
            statues3 = mView.findViewById(R.id.progress3);
            statues4 = mView.findViewById(R.id.progress4);
            productCount = mView.findViewById(R.id.product_count);
            orderPrice = mView.findViewById(R.id.totalprice);
            orderdate = mView.findViewById(R.id.order_date);
            ordernum = mView.findViewById(R.id.ordernum);
            payment = mView.findViewById(R.id.payment);
            productname = mView.findViewById(R.id.item_name);
            ratecount = mView.findViewById(R.id.rate_count);
            ratingBar = mView.findViewById(R.id.rates);
            gotodetails = mView.findViewById(R.id.gotodetails);
        }
    }

    private String getdate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZZ");
        try {
            Date dateObj = sdf.parse(date);
            Log.d("newdatein", dateObj.getTime() + "");
            String timestamp = String.valueOf(dateObj.getTime());//  //Example -> in ms
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String dateString = formatter.format(new Date(Long.parseLong(timestamp)));
            return dateString;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}