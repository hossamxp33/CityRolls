package com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.home.favorite.adapter;

import android.annotation.SuppressLint;
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
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.codesroots.osamaomar.cityrolls.R;
import com.codesroots.osamaomar.cityrolls.entities.Favoriets;
import com.codesroots.osamaomar.cityrolls.helper.PreferenceHelper;
import com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.home.favorite.FavoritesViewModel;
import com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.home.productdetailsfragment.ProductDetailsFragment;

import java.util.List;

import static com.codesroots.osamaomar.cityrolls.entities.names.PRODUCT_ID;


public class AllFavProductsAdapter extends RecyclerView.Adapter<AllFavProductsAdapter.ViewHolder> {

    private Context context;
    private List<Favoriets.DataBean> productsbysubcats;
    FavoritesViewModel viewModel;
    int userid = PreferenceHelper.getUserId(), favid = 0;
    public AllFavProductsAdapter(Context mcontext, List<Favoriets.DataBean> productsbysubcats1, FavoritesViewModel mViewModel) {
        context = mcontext;
        productsbysubcats = productsbysubcats1;
        viewModel = mViewModel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.horizental_product_item_adapter, parent, false);
        return new ViewHolder(view);
    }


    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.favorite.setVisibility(View.GONE);
        holder.addtocart.setVisibility(View.GONE);
        try {
            holder.del_favorite.setVisibility( View.VISIBLE);
            holder.oldprice.setVisibility(View.INVISIBLE);
            if (productsbysubcats.get(position).getProduct().getProductphotos().size() > 0)
                Glide.with(context.getApplicationContext())
                        .load(productsbysubcats.get(position).getProduct().getImg())
                        .placeholder(R.drawable.product).dontAnimate()
                        .into(holder.Image);
            holder.price.setText(productsbysubcats.get(position).getProduct().getProductsizes().get(0).getCurrent_price() + " " +
                    PreferenceHelper.getCurrency());
            holder.name.setText(productsbysubcats.get(position).getProduct().getName());
            holder.amount.setText(context.getText(R.string.remendier) + " " +
                    String.valueOf(productsbysubcats.get(position).getProduct().getProductsizes().get(position).getAmount()) + " " + context.getText(R.string.num));

            if (productsbysubcats.get(position).getProduct().getTotal_rating() != null)
                if (productsbysubcats.get(position).getProduct().getTotal_rating().size() > 0) {
                    holder.ratingBar.setRating(productsbysubcats.get(position).getProduct().getTotal_rating().get(position).getStars() /
                            productsbysubcats.get(position).getProduct().getTotal_rating().get(position).getCount());
                    holder.rateCount.setText("(" + productsbysubcats.get(position).getProduct().getTotal_rating().get(position).getCount() + ")");
                }


        } catch (Exception e) {
        }

        holder.mView.setOnClickListener(v ->{

                    Fragment fragment = new ProductDetailsFragment();
                    Bundle bundle = new Bundle();
                    bundle.putInt(PRODUCT_ID, productsbysubcats.get(position).getProduct().getId());
                    fragment.setArguments(bundle);
                    ((FragmentActivity) context).getSupportFragmentManager().beginTransaction().
                            replace(R.id.mainfram, fragment)
                            .addToBackStack(null).commit();
                }

        );


//        holder.ratingBar.setOnTouchListener((v, event) -> {
//            if (event.getAction() == MotionEvent.ACTION_UP) {
//                Intent intent = new Intent(context, RateActivity.class);
//                intent.putExtra(PRODUCT_ID, productsbysubcats.get(position).getId());
//                context.startActivity(intent);
//            }
//            return true;
//        });

        holder.del_favorite.setOnClickListener(v -> {
            viewModel.curent_position=position;
            viewModel.DeleteFav(PreferenceHelper.getUserId(),productsbysubcats.get(position).getProduct_id());
        });


        viewModel.deleteToFavMutableLiveData.observe((FragmentActivity) context, addToFavModel  ->
        {
            if (addToFavModel.getLikeid()>0) {
                Toast.makeText(context, context.getText(R.string.deletefromfavsucces), Toast.LENGTH_SHORT).show();
                if (viewModel.curent_position>-1&&viewModel.curent_position<productsbysubcats.size()) {
                    productsbysubcats.remove(viewModel.curent_position);
                    this.notifyDataSetChanged();
                    viewModel.curent_position = -1;
                }
            } else
                Toast.makeText(context, context.getText(R.string.error_tryagani), Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return productsbysubcats.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        private ImageView Image, favorite,del_favorite;
        private TextView name, rateCount, amount, price,oldprice,addtocart;
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
            del_favorite = mView.findViewById(R.id.del_favorite);
            favorite = mView.findViewById(R.id.favorite);

            oldprice = mView.findViewById(R.id.old_price);
              addtocart = mView.findViewById(R.id.add_to_cart);

        }
    }
}