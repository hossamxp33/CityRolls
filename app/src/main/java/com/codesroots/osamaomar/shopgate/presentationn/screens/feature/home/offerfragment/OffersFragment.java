package com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.offerfragment;

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
import com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.offerfragment.adapter.AllOffersAdapter;


public class OffersFragment extends Fragment {

    private OffersViewModel mViewModel;
    RecyclerView alloffers;
    private FrameLayout progress;
    private TextView notfound;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.offers_fragment, container, false);
     //   ((MainActivity) getActivity()).head_title.setText(getText(R.string.day_offers));
        ((MainActivity) getActivity()).logo.setVisibility(View.VISIBLE);
        alloffers = view.findViewById(R.id.alloffers);
        progress = view.findViewById(R.id.progress);
        notfound = view.findViewById(R.id.offers_notfound);
        mViewModel = ViewModelProviders.of(this,getViewModelFactory()).get(OffersViewModel.class);
        mViewModel.offersMutableLiveData.observe(this,offers ->
                {
                    progress.setVisibility(View.GONE);
                    if (offers.getData().size()>0)
                    alloffers.setAdapter(new AllOffersAdapter(getActivity(),offers.getData()));
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
