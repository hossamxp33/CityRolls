package com.example.osamaomar.shopgate.presentationn.screens.feature.home.productdetailsfragment.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.osamaomar.shopgate.R;
import com.example.osamaomar.shopgate.entities.ProductDetails;
import com.example.osamaomar.shopgate.presentationn.screens.feature.home.productdetailsfragment.ProductDetailsFragment;

import java.util.List;

public class ProductSizesAdapter extends RecyclerView.Adapter<ProductSizesAdapter.ViewHolder>  {

    private Context context;
    ProductDetailsFragment fragment;
    List<ProductDetails.ProductdetailsBean.ProductsizesBean> productsizes ;
    public int mSelectedItem = 0;

    public ProductSizesAdapter(Context mcontext, List<ProductDetails.ProductdetailsBean.ProductsizesBean> sizes,
                               ProductDetailsFragment detailsFragment) {
        context = mcontext;
        productsizes = sizes;
        fragment = detailsFragment;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.size_item_adapter, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder,final int position) {
        holder.text.setText(productsizes.get(position).getSize());
        fragment.amount.setText(context.getText(R.string.remendier)+" "+ String.valueOf(productsizes.get(mSelectedItem).getAmount())+
                " "+  context.getText(R.string.num));

        if (position == mSelectedItem)
            holder.text.setBackgroundResource(R.drawable.linear_background_for_selected_size);
        else
            holder.text.setBackgroundResource(R.drawable.linear_background_for_size);
    }

    @Override
    public int getItemCount() {
        return productsizes.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        final View mView;
        private TextView text;

        ViewHolder(View view) {
            super(view);
            mView = view;
            text = mView.findViewById(R.id.size);

            View.OnClickListener clickListener  = v -> {
                mSelectedItem = getAdapterPosition();
                notifyDataSetChanged();
                fragment.price.setText(productsizes.get(mSelectedItem).getStart_price()+context.getText(R.string.realcoin));
                fragment.amount.setText(context.getText(R.string.remendier)+" "+ String.valueOf(productsizes.get(mSelectedItem).getAmount())+
                      " "+  context.getText(R.string.num));
            };

            itemView.setOnClickListener(clickListener);
        }
    }
}