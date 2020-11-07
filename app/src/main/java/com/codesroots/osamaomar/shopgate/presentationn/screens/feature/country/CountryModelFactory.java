package com.codesroots.osamaomar.shopgate.presentationn.screens.feature.country;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.codesroots.osamaomar.shopgate.domain.ApiClient;
import com.codesroots.osamaomar.shopgate.domain.ServerGateway;
import com.codesroots.osamaomar.shopgate.presentationn.screens.feature.chating.ChatViewModel;

public class CountryModelFactory implements ViewModelProvider.Factory {


    private Application application;


    public CountryModelFactory(Application application1) {
        application = application1;

    }

    @SuppressWarnings("SingleStatementInBlock")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
         if (modelClass == CountryViewModel.class)
        {
            return (T) new CountryViewModel(getApiService());
        }
        throw new IllegalArgumentException("Invalid view model class type");
    }


    private ServerGateway getApiService() {
        return ApiClient.getClient().create(ServerGateway.class);
    }

}
