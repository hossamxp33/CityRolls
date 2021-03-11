package com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.home.cartfragment;

import android.app.Application;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.annotation.NonNull;

import com.codesroots.osamaomar.cityrolls.domain.ApiClient;
import com.codesroots.osamaomar.cityrolls.domain.ServerGateway;

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
