package com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.morefragment;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.codesroots.osamaomar.shopgate.domain.ServerGateway;
import com.codesroots.osamaomar.shopgate.entities.Currency;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;


public class MenuViewModel extends ViewModel {

    public MutableLiveData<Currency> currencyMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<Throwable> throwableMutableLiveData = new MutableLiveData<>();
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    private ServerGateway serverGateway;


    public MenuViewModel(ServerGateway apiService) {
        serverGateway = apiService;
    }



    public void getCurrencyData() {
        mCompositeDisposable.add(
                serverGateway.Currency()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe( this::postDataResponse,
                                this::postError));
    }

    private void postDataResponse(Currency currency) {
        currencyMutableLiveData.postValue(currency);
    }


    private void postError(Throwable throwable) {
        throwableMutableLiveData.postValue(throwable);
    }


}
