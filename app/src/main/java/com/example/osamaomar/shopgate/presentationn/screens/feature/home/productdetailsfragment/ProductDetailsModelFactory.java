package com.example.osamaomar.shopgate.presentationn.screens.feature.home.productdetailsfragment;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.osamaomar.shopgate.domain.ApiClient;
import com.example.osamaomar.shopgate.domain.ServerGateway;

public class ProductDetailsModelFactory implements ViewModelProvider.Factory {


    private Application application;
    private int productid,userid;

    public ProductDetailsModelFactory(Application application1,int id,int user_id) {
        application = application1;
        productid = id;
        userid = user_id;
    }

    @SuppressWarnings("SingleStatementInBlock")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
         if (modelClass == ProductDetailsViewModel.class)
        {
            return (T) new ProductDetailsViewModel(getApiService(),productid,userid);
        }

        throw new IllegalArgumentException("Invalid view model class type");
    }


    private ServerGateway getApiService() {
        return ApiClient.getClient().create(ServerGateway.class);
    }

}
