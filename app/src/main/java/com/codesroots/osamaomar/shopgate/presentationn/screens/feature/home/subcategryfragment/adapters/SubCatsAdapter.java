package com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.subcategryfragment.adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codesroots.osamaomar.shopgate.R;
import com.codesroots.osamaomar.shopgate.entities.SubCategriesWithProducts;
import com.codesroots.osamaomar.shopgate.helper.ResourceUtil;
import com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.productfragment.ProductsFragment;

import java.util.List;

import static com.codesroots.osamaomar.shopgate.entities.names.CAT_TYPE;
import static com.codesroots.osamaomar.shopgate.entities.names.SUBCATES_NAME;
import static com.codesroots.osamaomar.shopgate.entities.names.SUB_CAT_ID;

public class SubCatsAdapter extends RecyclerView.Adapter<SubCatsAdapter.ViewHolder>  {

    private Context context;
    private List<SubCategriesWithProducts.DataBean> subcates;
    public SubCatsAdapter(Context mcontext, List<SubCategriesWithProducts.DataBean> data) {
        context = mcontext;
        subcates = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.subcat_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder,final int position) {

        holder.name.setText(subcates.get(position).getName());
        if (ResourceUtil.getCurrentLanguage(context).matches("en"))
            holder.name.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_next, 0);

        holder.itemView.setOnClickListener(v -> {
            Fragment fragment = new ProductsFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(SUB_CAT_ID,subcates.get(position).getId());
            bundle.putString(SUBCATES_NAME,subcates.get(position).getName());
            bundle.putInt(CAT_TYPE,1);
            fragment.setArguments(bundle);
            ((FragmentActivity)context).getSupportFragmentManager().beginTransaction().replace(R.id.mainfram,fragment).addToBackStack(null).commit();
        });
    }


    @Override
    public int getItemCount() {
        return subcates.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        final View mView;
        private TextView name;

        ViewHolder(View view) {
            super(view);
            mView = view;
            name = mView.findViewById(R.id.name);
        }
    }
}