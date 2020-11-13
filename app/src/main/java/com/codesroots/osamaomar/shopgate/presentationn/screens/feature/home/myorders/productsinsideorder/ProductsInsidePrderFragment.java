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
import com.codesroots.osamaomar.shopgate.entities.Products;

import static com.codesroots.osamaomar.shopgate.entities.names.ORDER_ID;

public class ProductsInsidePrderFragment extends Fragment {

    private ProductsInsideOrderViewModel mViewModel;
    RecyclerView productsRecycle;
    int orderid;
    private Products productsData;
    private FrameLayout progress;
    private TextView notfound;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.products_insideorderfragment, container, false);

        orderid = getArguments().getInt(ORDER_ID, 0);
        productsRecycle = view.findViewById(R.id.allProducts);
        progress = view.findViewById(R.id.progress);

    //    productsRecycle.setAdapter(new AllProductsInsideOrderAdapter(getActivity(), order.getOrderdetails()));
        mViewModel = ViewModelProviders.of(this, getViewModelFactory()).get(ProductsInsideOrderViewModel.class);

        mViewModel.productsMutableLiveData.observe(this, products ->
        {
//                    productsData = products;
//                    progress.setVisibility(View.GONE);
//                    if (products.getProductsbycategory()!=null) {
//                        if (products.getProductsbycategory().size() > 0) {
//                            productsRecycle.setLayoutManager(new GridLayoutManager(getActivity(), 2));
//                            productsRecycle.setAdapter(new AllProductsAdapter(getActivity(), 0, products.getProductsbycategory()));
//                        }
//                        else {
//                            notfound.setVisibility(View.GONE);
//                            changeSpane.setEnabled(false);
//                            filter.setEnabled(false);
//                        }
//                    }
//                    else {
//                        notfound.setVisibility(View.GONE);
//                        changeSpane.setEnabled(false);
//                        filter.setEnabled(false);
//                    }
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
