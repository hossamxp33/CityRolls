package com.codesroots.osamaomar.shopgate.presentationn.screens.feature.rate;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.codesroots.osamaomar.shopgate.domain.ServerGateway;
import com.codesroots.osamaomar.shopgate.entities.ProductRate;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;


public class RateViewModel extends ViewModel {

    public MutableLiveData<ProductRate> rateMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<Throwable> throwableMutableLiveData = new MutableLiveData<>();
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    private ServerGateway serverGateway;
    private int product_id;

    public RateViewModel(ServerGateway serverGateway1,int id) {
        serverGateway = serverGateway1;
        product_id = id;
        getProductRates();
    }

    private void getProductRates(){
        mCompositeDisposable.add(
                serverGateway.getProductRates(product_id)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe( this::postDataResponse,
                                this::postError));
    }


    private void postDataResponse(ProductRate productRates) {
        rateMutableLiveData.postValue(productRates);
    }


    private void postError(Throwable throwable) {
        throwableMutableLiveData.postValue(throwable);
    }

}
