package com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.productdetailsfragment.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.codesroots.osamaomar.shopgate.R;
import com.codesroots.osamaomar.shopgate.entities.ProductDetails;
import com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.productdetailsfragment.ProductDetailsFragment;

import java.util.List;

public class ProductImagesAdapter extends RecyclerView.Adapter<ProductImagesAdapter.ViewHolder>  {

    private Context context;
    List<ProductDetails.ProductdetailsBean.ProductphotosBean> productphotos;
    public  int mSelectedItem = 0 ;
    ProductDetailsFragment fragment ;
    public ProductImagesAdapter(Context mcontext, List<ProductDetails.ProductdetailsBean.ProductphotosBean> productphotos1,
                                ProductDetailsFragment detailsFragment) {
        context = mcontext;
        productphotos = productphotos1;
        fragment = detailsFragment;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.image_item_adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder,final int position) {

        Glide.with(context).load(productphotos.get(position).getPhoto()).into(holder.Image);
        //holder.mView.setOnClickListener(v -> holder.Image.setBackgroundResource(R.drawable.linear_background_for_selected_image));

        if (position == mSelectedItem)
            holder.Image.setBackgroundResource(R.drawable.linear_background_for_selected_image);
        else
            holder.Image.setBackgroundResource(R.drawable.linear_background_for_size);

    }

    @Override
    public int getItemCount() {
        return productphotos.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        final View mView;
        private ImageView Image;

        ViewHolder(View view) {
            super(view);
            mView = view;
            Image = mView.findViewById(R.id.item_img);


            View.OnClickListener clickListener  = v -> {
                mSelectedItem = getAdapterPosition();
                notifyDataSetChanged();
                fragment.setImageToImageView(productphotos.get(mSelectedItem).getPhoto());
            };

            itemView.setOnClickListener(clickListener);
        }
    }
}