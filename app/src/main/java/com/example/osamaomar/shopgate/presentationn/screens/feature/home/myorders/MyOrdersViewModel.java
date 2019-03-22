package com.example.osamaomar.shopgate.presentationn.screens.feature.home.myorders;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.osamaomar.shopgate.domain.ServerGateway;
import com.example.osamaomar.shopgate.entities.MyOrders;
import com.example.osamaomar.shopgate.entities.ProductRate;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;


public class MyOrdersViewModel extends ViewModel {

    public MutableLiveData<MyOrders> myOrdersMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<Throwable> throwableMutableLiveData = new MutableLiveData<>();
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    private ServerGateway serverGateway;
    private int user_id;

    public MyOrdersViewModel(ServerGateway serverGateway1, int id) {
        serverGateway = serverGateway1;
        user_id = id;
        getMyOrders();
    }

    private void getMyOrders(){
        mCompositeDisposable.add(
                serverGateway.retrieveUserOrders(user_id)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe( this::postDataResponse,
                                this::postError));
    }

    private void postDataResponse(MyOrders productRates) {
        myOrdersMutableLiveData.postValue(productRates);
    }

    private void postError(Throwable throwable) {
        throwableMutableLiveData.postValue(throwable);
    }

}
