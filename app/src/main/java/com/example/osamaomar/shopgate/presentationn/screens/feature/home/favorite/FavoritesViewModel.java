package com.example.osamaomar.shopgate.presentationn.screens.feature.home.favorite;

import android.annotation.SuppressLint;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.osamaomar.shopgate.domain.ServerGateway;
import com.example.osamaomar.shopgate.entities.DefaultAdd;
import com.example.osamaomar.shopgate.entities.Favoriets;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;


public class FavoritesViewModel extends ViewModel {


    public MutableLiveData<Favoriets> productsMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<Boolean> deleteToFavMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<Throwable> throwableMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<Throwable> throwablefav = new MutableLiveData<>();
    private ServerGateway serverGateway;
    private int userid;

    FavoritesViewModel(ServerGateway serverGateway1,int user_id) {
        serverGateway = serverGateway1;
        userid = user_id;
        getData();
    }

    public void getData() {
        getObservable().subscribeWith(getObserver());
    }

    public  void DeleteFav (int favid)
    {
        getObservableToDeleteFav(favid).subscribeWith(getObserverDeletFav());
    }

    //////////// get productsData
    @SuppressLint("CheckResult")
    private Observable<Favoriets> getObservable() {
        Observable<Favoriets> productsObservable = serverGateway.getFavProducts(userid);
        productsObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        return productsObservable;
    }

    private DisposableObserver<Favoriets> getObserver() {
        return new DisposableObserver<Favoriets>() {
            @Override
            public void onNext(@NonNull Favoriets result) {
                if (productsMutableLiveData != null)
                    productsMutableLiveData.postValue(result);
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


    ///////////// delete fav
    @SuppressLint("CheckResult")
    private Observable<DefaultAdd> getObservableToDeleteFav(int favid) {
        Observable<DefaultAdd> addToFavObservable = serverGateway.DeleteFav(favid);
        addToFavObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        return addToFavObservable;
    }

    private DisposableObserver<DefaultAdd> getObserverDeletFav() {
        return new DisposableObserver<DefaultAdd>() {
            @Override
            public void onNext(@NonNull DefaultAdd result) {
                deleteToFavMutableLiveData.postValue(result.isSuccess());
            }
            @Override
            public void onError(@NonNull Throwable e) {
                Log.d("Errors", "Error" + e);
                e.printStackTrace();
                throwablefav.postValue(e);
            }
            @Override
            public void onComplete() {
            }
        };
    }

}
