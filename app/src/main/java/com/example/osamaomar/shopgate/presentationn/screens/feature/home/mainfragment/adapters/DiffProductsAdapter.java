package com.example.osamaomar.shopgate.presentationn.screens.feature.home.mainfragment.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.osamaomar.shopgate.R;
import com.example.osamaomar.shopgate.entities.MainView;
import com.example.osamaomar.shopgate.presentationn.screens.feature.home.mainactivity.MainActivity;
import com.example.osamaomar.shopgate.presentationn.screens.feature.home.productfragment.ProductsFragment;
import com.example.osamaomar.shopgate.presentationn.screens.feature.rate.RateActivity;

import java.util.List;

import static com.example.osamaomar.shopgate.entities.names.PRODUCT_ID;
import static com.example.osamaomar.shopgate.entities.names.SUBCATES_NAME;
import static com.example.osamaomar.shopgate.entities.names.SUB_CAT_ID;

public class DiffProductsAdapter extends RecyclerView.Adapter<DiffProductsAdapter.ViewHolder>  {

    private Context context;
 //   private List<MainView.SubcatsBeanX> subcatsBeans;
    public DiffProductsAdapter(Context mcontext) {
        context = mcontext;
        //subcatsBeans = categories1;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.diff_products_adapter_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder,final int position) {
        if (position==0)
        {
            ViewGroup.LayoutParams layoutParams = holder.Image.getLayoutParams();;
            layoutParams.height=(layoutParams.height*2)+15;
            layoutParams.width=layoutParams.width*2;
            holder.Image.setLayoutParams(layoutParams);
        }

//        holder.name.setText(subcatsBeans.get(position).getName());
//        Glide.with(context).load(subcatsBeans.get(position).getPhoto()).dontAnimate().placeholder(R.drawable.dept1).into(holder.Image);
//
//        holder.mView.setOnClickListener(v ->
//        {
//            Bundle bundle = new Bundle();
//            bundle.putInt(SUB_CAT_ID,subcatsBeans.get(position).getId());
//            bundle.putString(SUBCATES_NAME,subcatsBeans.get(position).getName());
//            Fragment fragment  = new ProductsFragment();
//            fragment.setArguments(bundle);
//            ((FragmentActivity)context).getSupportFragmentManager().beginTransaction().replace(R.id.mainfram,fragment).addToBackStack(null).commit();
//        });
    }


    @Override
    public int getItemCount() {
        return 5;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        final View mView;
        private ImageView Image;
        private TextView name;

        ViewHolder(View view) {
            super(view);
            mView = view;
            Image = mView.findViewById(R.id.item_img);
            name = mView.findViewById(R.id.name);
        }
    }
}