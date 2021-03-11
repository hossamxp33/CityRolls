package com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.payment;

import android.app.Application;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.annotation.NonNull;

import com.codesroots.osamaomar.cityrolls.domain.ApiClient;
import com.codesroots.osamaomar.cityrolls.domain.ServerGateway;

public class PaymentViewModelFactory implements ViewModelProvider.Factory {


    private Application application;

    public PaymentViewModelFactory(Application application1) {
        application = application1;
    }

    @SuppressWarnings("SingleStatementInBlock")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
         if (modelClass == PaymentViewModel.class)
        {
            return (T) new PaymentViewModel(getApiService());
        }
        throw new IllegalArgumentException("Invalid view model class type");
    }

    private ServerGateway getApiService() {
        return ApiClient.getClient().create(ServerGateway.class);
    }

}
