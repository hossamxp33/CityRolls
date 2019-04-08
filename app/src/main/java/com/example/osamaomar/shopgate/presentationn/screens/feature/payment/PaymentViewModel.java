package com.example.osamaomar.shopgate.presentationn.screens.feature.payment;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.osamaomar.shopgate.domain.ServerGateway;
import com.example.osamaomar.shopgate.entities.DefaultAdd;
import com.example.osamaomar.shopgate.entities.MyOrders;
import com.example.osamaomar.shopgate.entities.OrderModel;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PaymentViewModel extends ViewModel {

    public MutableLiveData<Boolean> myOrdersMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<Throwable> throwableMutableLiveData = new MutableLiveData<>();
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    private ServerGateway serverGateway;

    public PaymentViewModel(ServerGateway serverGateway1) {
        serverGateway = serverGateway1;
    }

//    private void makeOrder(OrderModel orderModel){
//        mCompositeDisposable.add(
//                serverGateway.makeOrder(orderModel)
//                        .subscribeOn(Schedulers.io())
//                        .observeOn(AndroidSchedulers.mainThread())
//                        .subscribe( this::postDataResponse,
//                                this::postError));
//    }
//
//    private void postDataResponse(MyOrders productRates) {
//        myOrdersMutableLiveData.postValue(productRates);
//    }
//
//    private void postError(Throwable throwable) {
//        throwableMutableLiveData.postValue(throwable);
//    }


    public void addOrder(OrderModel orderModel) {
        serverGateway.makeOrder(orderModel).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, final Response<ResponseBody> response) {
                try {
                    if (response != null)
                        myOrdersMutableLiveData.postValue(true);
                } catch (Exception e) {
                   // onError.accept(e.getCause());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                if (throwableMutableLiveData != null) {
                    throwableMutableLiveData.postValue(t);
                }
            }
        });
    }
}
