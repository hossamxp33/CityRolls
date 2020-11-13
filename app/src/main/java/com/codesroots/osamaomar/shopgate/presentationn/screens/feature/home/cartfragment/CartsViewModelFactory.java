package com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.cartfragment;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.codesroots.osamaomar.shopgate.domain.ApiClient;
import com.codesroots.osamaomar.shopgate.domain.ServerGateway;

import java.util.ArrayList;

public class CartsViewModelFactory implements ViewModelProvider.Factory {

    private Application application;
    private ArrayList<Integer> products_ids;

    public CartsViewModelFactory(Application application1,ArrayList<Integer> ids) {
        application = application1;
        products_ids = ids;
    }

    @SuppressWarnings("SingleStatementInBlock")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
         if (modelClass == CartViewModel.class)
        {
            return (T) new CartViewModel(getApiService(),products_ids);
        }
        throw new IllegalArgumentException("Invalid view model class type");
    }


    private ServerGateway getApiService() {
        return ApiClient.getClient().create(ServerGateway.class);
    }

}
