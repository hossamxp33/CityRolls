package com.example.osamaomar.shopgate.presentationn.screens.feature.home.myorders.productsinsideorder;

import android.annotation.SuppressLint;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.osamaomar.shopgate.domain.ServerGateway;
import com.example.osamaomar.shopgate.entities.Products;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;


class ProductsInsideOrderViewModel extends ViewModel {


    public MutableLiveData<Products> productsMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<Throwable> throwableMutableLiveData = new MutableLiveData<>();
    private ServerGateway serverGateway;
    private int order_id, userid,type;

    ProductsInsideOrderViewModel(ServerGateway serverGateway1, int id) {
        serverGateway = serverGateway1;
        order_id = id;
       // getData();
    }
//
//    public void getData() {
//        getObservable().subscribeWith(getObserver());
//    }
//
//
//    @SuppressLint("CheckResult")
//    private Observable<Products> getObservable() {
//        Observable<Products> productsObservable = serverGateway.getProducts(subcattegry_id,type,userid);
//        productsObservable.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread());
//        return productsObservable;
//    }
//
//    private DisposableObserver<Products> getObserver() {
//        return new DisposableObserver<Products>() {
//            @Override
//            public void onNext(@NonNull Products result) {
//                if (productsMutableLiveData != null)
//                    productsMutableLiveData.postValue(result);
//            }
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//                Log.d("Errors", "Error" + e);
//                e.printStackTrace();
//                throwableMutableLiveData.postValue(e);
//            }
//
//            @Override
//            public void onComplete() {
//            }
//        };
//    }
}
