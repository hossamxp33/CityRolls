package com.codesroots.osamaomar.shopgate.presentationn.screens.feature.rate;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.codesroots.osamaomar.shopgate.domain.ApiClient;
import com.codesroots.osamaomar.shopgate.domain.ServerGateway;

public class RateViewModelFactory implements ViewModelProvider.Factory {

    private Application application;
    private int productid;

    public RateViewModelFactory(Application application1,int id) {
        application = application1;
        productid = id;
    }

    @SuppressWarnings("SingleStatementInBlock")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
         if (modelClass == RateViewModel.class)
        {
            return (T) new RateViewModel(getApiService(),productid);
        }
        throw new IllegalArgumentException("Invalid view model class type");
    }


    private ServerGateway getApiService() {
        return ApiClient.getClient().create(ServerGateway.class);
    }

}
