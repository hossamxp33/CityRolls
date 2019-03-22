package com.example.osamaomar.shopgate.presentationn.screens.feature.home.myorders;

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
import android.widget.Toast;

import com.example.osamaomar.shopgate.R;
import com.example.osamaomar.shopgate.presentationn.screens.feature.home.mainactivity.MainActivity;
import com.example.osamaomar.shopgate.presentationn.screens.feature.home.myorders.adapters.MyOrdersAdapter;

public class MyOrdersFragment extends Fragment {

    private MyOrdersViewModel mViewModel;
    private RecyclerView orders;
    private int userid = 5;
    private FrameLayout loading;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.my_orders_fragment, container, false);
        orders = view.findViewById(R.id.allorders);
        loading = view.findViewById(R.id.progress);

        ((MainActivity)getActivity()).head_title.setText(getText(R.string.myorders));
        ((MainActivity) getActivity()).logo.setVisibility(View.INVISIBLE);
        mViewModel = ViewModelProviders.of(this,getViewModelFactory()).get(MyOrdersViewModel.class);

        mViewModel.myOrdersMutableLiveData.observe(this,myOrders ->
                {
                    loading.setVisibility(View.GONE);
                    orders.setAdapter(new MyOrdersAdapter(getActivity(),myOrders.getData()));
                } );

               mViewModel.throwableMutableLiveData.observe(this,throwable -> Toast.makeText(getActivity(),throwable.getMessage(),Toast.LENGTH_SHORT));
        return view;
    }

    private MyOrdersViewModelFactory getViewModelFactory() {
        return new MyOrdersViewModelFactory(getActivity().getApplication(),userid);
    }

}
