package com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.home.productdetailsfragment;

import android.app.Application;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.annotation.NonNull;

import com.codesroots.osamaomar.cityrolls.domain.ApiClient;
import com.codesroots.osamaomar.cityrolls.domain.ServerGateway;
import com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.home.morefragment.MenuViewModel;

public class ProductDetailsModelFactory implements ViewModelProvider.Factory {


    private Application application;
    private int productid,userid;

    public ProductDetailsModelFactory(Application application1,int id,int user_id) {
        application = application1;
        productid = id;
        userid = user_id;
    }

    /////// for menu viewmodel
    public ProductDetailsModelFactory(Application application1) {
        application = application1;
    }

    @SuppressWarnings("SingleStatementInBlock")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
         if (modelClass == ProductDetailsViewModel.class)
        {
            return (T) new ProductDetailsViewModel(getApiService(),productid,userid);
        }
        else   if (modelClass == MenuViewModel.class)
         {
             return (T) new MenuViewModel(getApiService());
         }


        throw new IllegalArgumentException("Invalid view model class type");
    }


    private ServerGateway getApiService() {
        return ApiClient.getClient().create(ServerGateway.class);
    }

}
