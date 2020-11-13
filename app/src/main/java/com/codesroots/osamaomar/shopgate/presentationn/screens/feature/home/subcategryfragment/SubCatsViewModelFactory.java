package com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.subcategryfragment;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.codesroots.osamaomar.shopgate.domain.ApiClient;
import com.codesroots.osamaomar.shopgate.domain.ServerGateway;

public class SubCatsViewModelFactory implements ViewModelProvider.Factory {


    private Application application;
    private int categry_id,userid;

    public SubCatsViewModelFactory(Application application1, int id,int user_id) {
        application = application1;
        categry_id = id;
        userid = user_id;
    }

    @SuppressWarnings("SingleStatementInBlock")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
         if (modelClass == SubCatesViewModel.class)
        {
            return (T) new SubCatesViewModel(getApiService(), categry_id,userid);
        }

        throw new IllegalArgumentException("Invalid view model class type");
    }


    private ServerGateway getApiService() {
        return ApiClient.getClient().create(ServerGateway.class);
    }

}
