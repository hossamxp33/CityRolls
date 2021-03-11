package com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.home.morefragment;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.codesroots.osamaomar.cityrolls.domain.ServerGateway;
import com.codesroots.osamaomar.cityrolls.entities.Currency;

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
