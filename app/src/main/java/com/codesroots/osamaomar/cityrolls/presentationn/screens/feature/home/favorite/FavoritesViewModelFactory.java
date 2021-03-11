package com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.home.favorite;

import android.app.Application;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.annotation.NonNull;

import com.codesroots.osamaomar.cityrolls.domain.ApiClient;
import com.codesroots.osamaomar.cityrolls.domain.ServerGateway;

public class FavoritesViewModelFactory implements ViewModelProvider.Factory {


    private Application application;
    private int subcategry_id,user_Id,type;

    public FavoritesViewModelFactory(Application application1,int userid) {
        application = application1;
        user_Id = userid;
    }

    @SuppressWarnings("SingleStatementInBlock")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
         if (modelClass == FavoritesViewModel.class)
        {
            return (T) new FavoritesViewModel(getApiService(),user_Id);
        }

        throw new IllegalArgumentException("Invalid view model class type");
    }


    private ServerGateway getApiService() {
        return ApiClient.getClient().create(ServerGateway.class);
    }

}
