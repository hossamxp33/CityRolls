package com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.home.mainfragment;

import android.app.Application;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.annotation.NonNull;

import com.codesroots.osamaomar.cityrolls.domain.ApiClient;
import com.codesroots.osamaomar.cityrolls.domain.ServerGateway;
import com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.chating.ChatViewModel;

public class MainViewModelFactory implements ViewModelProvider.Factory {


    private Application application;


    public MainViewModelFactory(Application application1) {
        application = application1;

    }

    @SuppressWarnings("SingleStatementInBlock")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
         if (modelClass == MainFragmentViewModel.class)
        {
            return (T) new MainFragmentViewModel(getApiService());
        }
        else   if (modelClass == ChatViewModel.class)
         {
             return (T) new ChatViewModel(getApiService());
         }

        throw new IllegalArgumentException("Invalid view model class type");
    }


    private ServerGateway getApiService() {
        return ApiClient.getClient().create(ServerGateway.class);
    }

}
