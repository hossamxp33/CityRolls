package com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.home.productfragment.myorders.productsinsideorder;

import android.app.Application;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.annotation.NonNull;
import com.codesroots.osamaomar.cityrolls.domain.ApiClient;
import com.codesroots.osamaomar.cityrolls.domain.ServerGateway;


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
