package com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.country;

import android.annotation.SuppressLint;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.annotation.NonNull;
import android.util.Log;

import com.codesroots.osamaomar.cityrolls.domain.ServerGateway;
import com.codesroots.osamaomar.cityrolls.entities.Countries;

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
