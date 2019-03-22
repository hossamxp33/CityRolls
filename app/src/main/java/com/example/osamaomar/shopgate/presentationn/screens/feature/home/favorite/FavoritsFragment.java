package com.example.osamaomar.shopgate.presentationn.screens.feature.home.favorite;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.osamaomar.shopgate.R;
import com.example.osamaomar.shopgate.entities.Products;
import com.example.osamaomar.shopgate.presentationn.screens.feature.home.favorite.adapter.AllFavProductsAdapter;
import com.example.osamaomar.shopgate.presentationn.screens.feature.home.productfragment.adapters.AllProductsAdapter;

import static com.example.osamaomar.shopgate.entities.names.CAT_TYPE;
import static com.example.osamaomar.shopgate.entities.names.SUB_CAT_ID;

public class FavoritsFragment extends Fragment {

    private FavoritesViewModel mViewModel;
    RecyclerView productsRecycle;
    int userID;
    private FrameLayout progress;
    private TextView notfound;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.favorites_fragment, container, false);
        userID = 2;

        productsRecycle = view.findViewById(R.id.allfavProducts);
        progress = view.findViewById(R.id.progress);
        notfound = view.findViewById(R.id.product_notfound);
        mViewModel = ViewModelProviders.of(this,getViewModelFactory()).get(FavoritesViewModel.class);

        mViewModel.productsMutableLiveData.observe(this,favoriets  ->
                {
                    progress.setVisibility(View.GONE);
                    if (favoriets.getData()!=null) {
                        if (favoriets.getData().size() > 0) {
                          productsRecycle.setAdapter(new AllFavProductsAdapter(getActivity(),favoriets.getData(),mViewModel));
                        }
                    }
                    else
                        notfound.setVisibility(View.VISIBLE);

                });

        mViewModel.throwableMutableLiveData.observe(this,throwable ->
                {
                    progress.setVisibility(View.GONE);
                    Toast.makeText(getActivity(),throwable.toString(),Toast.LENGTH_SHORT).show();
                } );

        return  view;
    }

    private FavoritesViewModelFactory getViewModelFactory() {
        return new FavoritesViewModelFactory(this.getActivity().getApplication(),userID);
    }



}
