package com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.cartfragment;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import com.codesroots.osamaomar.shopgate.domain.ServerGateway;
import com.codesroots.osamaomar.shopgate.entities.CartItems;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;


public class CartViewModel extends ViewModel {

    public MutableLiveData<List<CartItems.DataBean>> cartItemsMutableLiveData = new MutableLiveData<java.util.List<CartItems.DataBean>>();
    public MutableLiveData<Throwable> throwableMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<Boolean> noItemsFound = new MutableLiveData<>();
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    private ServerGateway serverGateway;
    private ArrayList<Integer> product_ids;

    public CartViewModel(ServerGateway serverGateway1,ArrayList<Integer> ids) {
        serverGateway = serverGateway1;
        product_ids = ids;
        getProductsIfFound();
    }

    private void getProductsIfFound() {
        if (product_ids==null)
            noItemsFound.postValue(true);

        else
        {
            if (product_ids.size()>0)
             getCartProducts();
            else
            noItemsFound.postValue(true);
        }

    }

    private void getCartProducts(){
        mCompositeDisposable.add(
                serverGateway.getCartProducts(product_ids)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe( this::postDataResponse,
                                this::postError));
    }


    private void postDataResponse(CartItems cartItems) {
        cartItemsMutableLiveData.postValue(cartItems.getData());
    }


    private void postError(Throwable throwable) {
        throwableMutableLiveData.postValue(throwable);
    }

}
