package com.example.osamaomar.shopgate.presentationn.screens.feature.home.offerfragment;

import android.annotation.SuppressLint;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.osamaomar.shopgate.domain.ServerGateway;
import com.example.osamaomar.shopgate.entities.MyOrders;
import com.example.osamaomar.shopgate.entities.Products;
import com.example.osamaomar.shopgate.entities.offers;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;


class OffersViewModel extends ViewModel {


    public MutableLiveData<offers> offersMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<Throwable> throwableMutableLiveData = new MutableLiveData<>();
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    private ServerGateway serverGateway;

    OffersViewModel(ServerGateway serverGateway1) {
        serverGateway = serverGateway1;
        getOffersData();
    }

    private void getOffersData(){
        mCompositeDisposable.add(
                serverGateway.retrieveOffers()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe( this::postDataResponse,
                                this::postError));
    }

    private void postDataResponse(offers productRates) {
        offersMutableLiveData.postValue(productRates);
    }

    private void postError(Throwable throwable) {
        throwableMutableLiveData.postValue(throwable);
    }


}
