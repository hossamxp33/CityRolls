package com.codesroots.osamaomar.shopgate.presentationn.screens.feature.smallstore;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.codesroots.osamaomar.shopgate.R;
import com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.mainactivity.MainActivity;
import com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.offerfragment.OffersViewModel;
import com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.offerfragment.OffersViewModelFactory;
import com.codesroots.osamaomar.shopgate.presentationn.screens.feature.smallstore.adapter.smallStoreAdapter;


public class SmallStoreFragment extends Fragment {

    private OffersViewModel mViewModel;
    RecyclerView alloffers;
    private FrameLayout progress;
    private TextView notfound;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.small_store_fragment, container, false);
        //   ((MainActivity) getActivity()).head_title.setText(getText(R.string.day_offers));
        ((MainActivity) getActivity()).logo.setVisibility(View.VISIBLE);
        alloffers = view.findViewById(R.id.smallStore);
        progress = view.findViewById(R.id.progress);
        notfound = view.findViewById(R.id.store_notfound);
        mViewModel = ViewModelProviders.of(this,getViewModelFactory()).get(OffersViewModel.class);
        mViewModel.offersMutableLiveData.observe(this,offers ->
        {
            progress.setVisibility(View.GONE);
            if (offers.getData().size()>0)
                alloffers.setAdapter(new smallStoreAdapter(getActivity(),offers.getData()));
            else
                notfound.setVisibility(View.VISIBLE);
        });

        mViewModel.throwableMutableLiveData.observe(this,throwable ->
        {
            progress.setVisibility(View.GONE);
            Toast.makeText(getActivity(),throwable.getCause().toString(),Toast.LENGTH_SHORT).show();
        });

        return  view;
    }

    private OffersViewModelFactory getViewModelFactory() {
        return new OffersViewModelFactory(this.getActivity().getApplication());
    }

}
