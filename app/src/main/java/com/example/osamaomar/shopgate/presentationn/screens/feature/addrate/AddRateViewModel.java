package com.example.osamaomar.shopgate.presentationn.screens.feature.addrate;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.osamaomar.shopgate.domain.ServerGateway;
import com.example.osamaomar.shopgate.entities.AddToFavModel;
import com.example.osamaomar.shopgate.entities.CartItems;
import com.example.osamaomar.shopgate.entities.DefaultAdd;
import com.example.osamaomar.shopgate.entities.Products;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;


public class AddRateViewModel extends ViewModel {


    public MutableLiveData<Boolean> AddRateMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<Throwable> throwableMutableLiveData = new MutableLiveData<>();
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    private ServerGateway serverGateway;


    AddRateViewModel(ServerGateway serverGateway1) {
        serverGateway = serverGateway1;
    }


    public void AddRateToProduct(int userid,int productid,float rate,String comment){
        mCompositeDisposable.add(
                serverGateway.addProductRate(userid,productid,rate,comment)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe( this::postDataResponse,
                                this::postError));
    }


    private void postDataResponse(DefaultAdd addResponse) {
        AddRateMutableLiveData.postValue(addResponse.isSuccess());
    }


    private void postError(Throwable throwable) {
        throwableMutableLiveData.postValue(throwable);
    }

}
