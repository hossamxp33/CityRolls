package com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.myorders.productsinsideorder;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.codesroots.osamaomar.shopgate.domain.ServerGateway;
import com.codesroots.osamaomar.shopgate.entities.Products;


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
//        Observable<Products> productsObservable = serverGateway.getOrderdetails(subcattegry_id,type,userid);
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
