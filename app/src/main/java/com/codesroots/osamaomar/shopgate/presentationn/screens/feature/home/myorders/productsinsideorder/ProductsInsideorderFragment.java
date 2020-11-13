package com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.myorders.productsinsideorder;

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
import com.codesroots.osamaomar.shopgate.entities.MyOrders;
import com.codesroots.osamaomar.shopgate.entities.Products;
import com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.mainactivity.MainActivity;
import com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.myorders.productsinsideorder.adapter.AllProductsInsideOrderAdapter;

import static com.codesroots.osamaomar.shopgate.entities.names.ORDER;
import static com.codesroots.osamaomar.shopgate.entities.names.ORDER_ID;

public class ProductsInsideorderFragment extends Fragment {

    private ProductsInsideOrderViewModel mViewModel;
    RecyclerView productsRecycle;
    int orderid;
    private Products productsData;
    private FrameLayout progress;
    private TextView ordernum;
    private MyOrders.DataBean order;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.products_insideorderfragment, container, false);

     //   ((MainActivity) getActivity()).head_title.setText(getText(R.string.order_details));
        ((MainActivity) getActivity()).logo.setVisibility(View.VISIBLE);
        orderid = getArguments().getInt(ORDER_ID, 0);
        order = (MyOrders.DataBean) getArguments().getSerializable(ORDER);
        productsRecycle = view.findViewById(R.id.allProducts);
        ordernum = view.findViewById(R.id.ordernum);
        ordernum.setText(String.valueOf(orderid));
        progress = view.findViewById(R.id.progress);
        if (order!=null)
             productsRecycle.setAdapter(new AllProductsInsideOrderAdapter(getActivity(),order.getOrderdetails()));

        mViewModel = ViewModelProviders.of(this, getViewModelFactory()).get(ProductsInsideOrderViewModel.class);

        mViewModel.productsMutableLiveData.observe(this, products ->
        {

        });

        mViewModel.throwableMutableLiveData.observe(this, throwable ->
        {
            progress.setVisibility(View.GONE);
            Toast.makeText(getActivity(), throwable.toString(), Toast.LENGTH_SHORT).show();
        });
        return view;
    }

    private ProductsInsideOrderViewModelFactory getViewModelFactory() {
        return new ProductsInsideOrderViewModelFactory(this.getActivity().getApplication(),orderid);
    }


}
