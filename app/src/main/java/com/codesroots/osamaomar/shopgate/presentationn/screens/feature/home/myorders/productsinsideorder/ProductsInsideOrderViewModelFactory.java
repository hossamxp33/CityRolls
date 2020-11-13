package com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.myorders.productsinsideorder;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;
import com.codesroots.osamaomar.shopgate.domain.ApiClient;
import com.codesroots.osamaomar.shopgate.domain.ServerGateway;


public class ProductsInsideOrderViewModelFactory implements ViewModelProvider.Factory {

    private Application application;
    private int order_id;

    public ProductsInsideOrderViewModelFactory(Application application1, int id) {
        application = application1;
        order_id = id;
    }

    @SuppressWarnings("SingleStatementInBlock")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
         if (modelClass == ProductsInsideOrderViewModel.class)
        {
            return (T) new ProductsInsideOrderViewModel(getApiService(),order_id);
        }

        throw new IllegalArgumentException("Invalid view model class type");
    }


    private ServerGateway getApiService() {
        return ApiClient.getClient().create(ServerGateway.class);
    }

}
