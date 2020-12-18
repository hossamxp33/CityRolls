package com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.mainactivity.adapter;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codesroots.osamaomar.shopgate.R;


import com.codesroots.osamaomar.shopgate.entities.Subcat;
import com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.mainactivity.MainActivity;
import com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.productfragment.ProductsFragment;
import com.codesroots.osamaomar.shopgate.presentationn.screens.feature.smallstore.smallStoreFramgent;

import java.util.List;

import static com.codesroots.osamaomar.shopgate.entities.names.CAT_ID;
import static com.codesroots.osamaomar.shopgate.entities.names.CAT_TYPE;
import static com.codesroots.osamaomar.shopgate.entities.names.SUBCATES_NAME;
import static com.codesroots.osamaomar.shopgate.entities.names.SUB_CAT_ID;


public class AllSubDepartsAdapter extends RecyclerView.Adapter<AllSubDepartsAdapter.ViewHolder>  {

    private Context context;
    private  List<Subcat> subcats;
    public AllSubDepartsAdapter(Context mcontext, List<Subcat> subcats1) {
        context = mcontext;
        subcats = subcats1;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sub_departs_item_adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        holder.text.setText(subcats.get(position).getName());
        Glide.with(context).load(subcats.get(position).getPhoto()).into(holder.Image);
        holder.mView.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putInt(CAT_ID,subcats.get(position).getId());
            bundle.putString(SUBCATES_NAME,subcats.get(position).getName());
            bundle.putInt(CAT_TYPE,1);

            Fragment fragment  = new smallStoreFramgent();
            fragment.setArguments(bundle);
            ((FragmentActivity)context).getSupportFragmentManager().beginTransaction().replace(R.id.mainfram,fragment).addToBackStack(null).commit();
            ((MainActivity)context).drawer.closeDrawer(GravityCompat.START);;
        });

    }

    @Override
    public int getItemCount() {
        return subcats.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final View mView;
        private ImageView Image;
        private TextView text;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            Image = mView.findViewById(R.id.item_img);
            text = mView.findViewById(R.id.name);
        }
    }
}