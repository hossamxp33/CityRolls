package com.codesroots.osamaomar.shopgate.presentationn.screens.feature.country;

import android.annotation.SuppressLint;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;
import android.util.Log;

import com.codesroots.osamaomar.shopgate.domain.ServerGateway;
import com.codesroots.osamaomar.shopgate.entities.Countries;
import com.codesroots.osamaomar.shopgate.entities.MainView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;


class CountryViewModel extends ViewModel {


    public MutableLiveData<Countries> countriesMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<Throwable> throwableMutableLiveData = new MutableLiveData<>();
    private ServerGateway serverGateway;

     CountryViewModel(ServerGateway serverGateway1) {
        serverGateway = serverGateway1;
        getData();
    }

    public void getData() {
        getObservable().subscribeWith(getObserver());
    }


    @SuppressLint("CheckResult")
    private Observable<Countries> getObservable() {
        Observable<Countries> photographersData = serverGateway.getCountriesData();
        photographersData.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        return photographersData;
    }

    private DisposableObserver<Countries> getObserver() {
        return new DisposableObserver<Countries>() {
            @Override
            public void onNext(@NonNull Countries result) {
                if (countriesMutableLiveData !=null)
                countriesMutableLiveData.postValue(result);
            }
            @Override
            public void onError(@NonNull Throwable e) {
                Log.d("Errors", "Error" + e);
                e.printStackTrace();
                throwableMutableLiveData.postValue(e);
            }
            @Override
            public void onComplete() {
            }
        };
    }
}
