package com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.home.productfragment.myorders;

import android.app.Application;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.annotation.NonNull;

import com.codesroots.osamaomar.cityrolls.domain.ApiClient;
import com.codesroots.osamaomar.cityrolls.domain.ServerGateway;

public class MyOrdersViewModelFactory implements ViewModelProvider.Factory {

    private Application application;
    private int userid;

    public MyOrdersViewModelFactory(Application application1, int id) {
        application = application1;
        userid = id;
    }

    @SuppressWarnings("SingleStatementInBlock")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
         if (modelClass == MyOrdersViewModel.class)
        {
            return (T) new MyOrdersViewModel(getApiService(), userid);
        }
        throw new IllegalArgumentException("Invalid view model class type");
    }


    private ServerGateway getApiService() {
        return ApiClient.getClient().create(ServerGateway.class);
    }

}
