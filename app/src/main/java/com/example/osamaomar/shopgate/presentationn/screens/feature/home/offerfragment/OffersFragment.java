package com.example.osamaomar.shopgate.presentationn.screens.feature.home.offerfragment;

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
import com.example.osamaomar.shopgate.presentationn.screens.feature.home.mainactivity.MainActivity;
import com.example.osamaomar.shopgate.presentationn.screens.feature.home.offerfragment.adapter.AllOffersAdapter;


public class OffersFragment extends Fragment {

    private OffersViewModel mViewModel;
    RecyclerView alloffers;
    ListView filter_option;
    ImageView changeSpane,filter;
    boolean RecycleIsHorizental=true;
    int subCategry,userID,type;
    private Products productsData;
    private FrameLayout progress;
    private TextView notfound;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.offers_fragment, container, false);

        ((MainActivity) getActivity()).head_title.setText(getText(R.string.day_offers));
        ((MainActivity) getActivity()).logo.setVisibility(View.INVISIBLE);
        alloffers = view.findViewById(R.id.alloffers);
        alloffers.setAdapter(new AllOffersAdapter(getActivity()));

        mViewModel = ViewModelProviders.of(this,getViewModelFactory()).get(OffersViewModel.class);
        mViewModel.productsMutableLiveData.observe(this,products ->
                {}
                );


        mViewModel.throwableMutableLiveData.observe(this,throwable ->
                {
                    progress.setVisibility(View.GONE);
                    Toast.makeText(getActivity(),throwable.toString(),Toast.LENGTH_SHORT).show();
                });

        filter_option = view.findViewById(R.id.filter_option);
        progress = view.findViewById(R.id.progress);
        notfound = view.findViewById(R.id.product_notfound);
        return  view;
    }

    private OffersViewModelFactory getViewModelFactory() {
        return new OffersViewModelFactory(this.getActivity().getApplication(),subCategry,userID,type);
    }


    private void hideView(final View view,int states){
        Animation animation = null;
        if (states == 1)
         animation = AnimationUtils.loadAnimation(getActivity(), R.anim.animy);
        else
            animation = AnimationUtils.loadAnimation(getActivity(), R.anim.animyforimg);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}

            @Override
            public void onAnimationRepeat(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation) {
            }
        });
        view.startAnimation(animation);
    }
    private View.OnClickListener onFilterClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (filter_option.getVisibility()==View.GONE) {
                filter_option.setVisibility(View.VISIBLE);
                hideView(filter_option,1);
            }
            else
            {
                filter_option.setVisibility(View.GONE);
                hideView(filter_option,0);
            }
        }
    };

}
