package com.example.osamaomar.shopgate.presentationn.screens.feature.home.cartfragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.osamaomar.shopgate.R;
import com.example.osamaomar.shopgate.entities.CartItems;
import com.example.osamaomar.shopgate.helper.PreferenceHelper;
import com.example.osamaomar.shopgate.presentationn.screens.feature.home.cartfragment.adapter.CartAdapter;
import com.example.osamaomar.shopgate.presentationn.screens.feature.home.mainactivity.MainActivity;
import com.example.osamaomar.shopgate.presentationn.screens.feature.paypal.PaypalActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CartFragment extends Fragment {

    RecyclerView cartsRecycle;
    private TextView sale;
    private CartAdapter cartAdapter;
    private FrameLayout progress;
    private ArrayList product_ids = new ArrayList<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cart_fragment, container, false);
        initialize(view);
       // product_ids.clear();
        CartViewModel mViewModel = ViewModelProviders.of(this, getViewModelFactory()).get(CartViewModel.class);

        mViewModel.cartItemsMutableLiveData.observe(this, dataBeans -> {
            {
                progress.setVisibility(View.GONE);
                cartAdapter = new CartAdapter(getActivity(), dataBeans);
                cartsRecycle.setAdapter(cartAdapter);
            }
        });

        mViewModel.noItemsFound.observe(this, aBoolean -> {
            sale.setEnabled(false);
            progress.setVisibility(View.GONE);
            Snackbar.make(view,getText(R.string.noitemsincart),Snackbar.LENGTH_SHORT).show();
        });

        mViewModel.throwableMutableLiveData.observe(this, throwable ->
        {
            progress.setVisibility(View.GONE);
            Toast.makeText(getActivity(), throwable.toString(), Toast.LENGTH_SHORT).show();
        });

        sale.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), PaypalActivity.class);
            startActivity(intent);
        });

        return view;
    }

    private void initialize(View view) {
        cartsRecycle = view.findViewById(R.id.cart_Rec);
        sale = view.findViewById(R.id.sale);
        progress = view.findViewById(R.id.progress);
        product_ids = PreferenceHelper.retriveCartItemsValue();
        ((MainActivity) Objects.requireNonNull(getActivity())).head_title.setText(getText(R.string.cart));
        ((MainActivity) getActivity()).logo.setVisibility(View.INVISIBLE);

    }

    private ViewModelProvider.Factory getViewModelFactory() {
        return new CartsViewModelFactory(getActivity().getApplication(), product_ids);
    }


}
