package com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.home.productfragment.myorders;

import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.codesroots.osamaomar.cityrolls.R;
import com.codesroots.osamaomar.cityrolls.helper.PreferenceHelper;
import com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.home.mainactivity.MainActivity;
import com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.home.productfragment.myorders.adapters.MyOrdersAdapter;

public class MyOrdersFragment extends Fragment {

    private MyOrdersViewModel mViewModel;
    private RecyclerView orders;
    private int userid = PreferenceHelper.getUserId();
    private FrameLayout loading;
    private TextView product_notfound;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.my_orders_fragment, container, false);
        orders = view.findViewById(R.id.allorders);
        loading = view.findViewById(R.id.progress);
        product_notfound = view.findViewById(R.id.product_notfound);

      //  ((MainActivity) getActivity()).head_title.setText(getText(R.string.myorders));
        ((MainActivity) getActivity()).logo.setVisibility(View.VISIBLE);
        mViewModel = ViewModelProviders.of(this, getViewModelFactory()).get(MyOrdersViewModel.class);

        mViewModel.myOrdersMutableLiveData.observe(this, myOrders ->
        {
            loading.setVisibility(View.GONE);
            if (myOrders.getData().size()>0)
            orders.setAdapter(new MyOrdersAdapter(getActivity(), myOrders.getData()));
            else
                product_notfound.setVisibility(View.VISIBLE);

        });

        mViewModel.throwableMutableLiveData.observe(this, throwable -> Toast.makeText(getActivity(), throwable.getMessage(), Toast.LENGTH_SHORT));
        return view;
    }

    private MyOrdersViewModelFactory getViewModelFactory() {
        return new MyOrdersViewModelFactory(getActivity().getApplication(), userid);
    }

}
