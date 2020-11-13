package com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.productfragment;

import android.annotation.SuppressLint;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.util.Log;

import com.codesroots.osamaomar.shopgate.domain.ServerGateway;
import com.codesroots.osamaomar.shopgate.entities.DefaultAdd;
import com.codesroots.osamaomar.shopgate.entities.AddToFavModel;
import com.codesroots.osamaomar.shopgate.entities.Products;
import com.codesroots.osamaomar.shopgate.helper.PreferenceHelper;

import java.util.Collections;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;


public class ProductsViewModel extends ViewModel {


    public MutableLiveData<Products> productsMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<AddToFavModel> addToFavMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<AddToFavModel> deleteToFavMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<Throwable> throwableMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<Throwable> throwablefav = new MutableLiveData<>();
    private ServerGateway serverGateway;
    private int subcattegry_id, userid,type;
    private  Products resultData;
    public int current_item = 0;
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    ProductsViewModel(ServerGateway serverGateway1, int id, int user_id,int type1) {
        serverGateway = serverGateway1;
        subcattegry_id = id;
        userid = user_id;
        type = type1;
        //getData();
    }


    public void getSearchData(String key) {
        mCompositeDisposable.add(
                serverGateway.getSearchResult(key,"ar", PreferenceHelper.getUserId())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe( this::postDataResponse,
                                this::postError));
    }


    private void postDataResponse(Products products) {
        productsMutableLiveData.postValue(products);
        resultData = products;
    }


    private void postError(Throwable throwable) {
        throwableMutableLiveData.postValue(throwable);
    }

    public void getData() {
        getObservable().subscribeWith(getObserver());
    }

    public  void AddToFav (int productid)
    {
        getObservableToFavObservable(productid).subscribeWith(getObserverAddFav());
    }

    public  void DeleteFav (int user,int product)
    {
        getObservableToDeleteFav(user,product).subscribeWith(getObserverDeletFav());

    }


    //////////// get productsData
    @SuppressLint("CheckResult")
    private Observable<Products> getObservable() {
        Observable<Products> productsObservable = serverGateway.getProducts(type,subcattegry_id,userid);
        productsObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        return productsObservable;
    }
    private DisposableObserver<Products> getObserver() {
        return new DisposableObserver<Products>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onNext(@NonNull Products result) {
                resultData = result;
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


    public  void  compareLessprice ()
    {
        Collections.sort(resultData.getProductsbycategory(), (o1, o2) -> {
            return Float.valueOf(o1.getProductsizes().get(0).getStart_price()).compareTo(Float.valueOf(o2.getProductsizes().get(0).getStart_price()));
        });
        productsMutableLiveData.postValue(resultData);
    }

    public  void  compareMoreprice()
    {
        Collections.sort(resultData.getProductsbycategory(), (o1, o2) -> {
            return Float.valueOf(o2.getProductsizes().get(0).getStart_price()).compareTo(Float.valueOf(o1.getProductsizes().get(0).getStart_price()));
        });
        productsMutableLiveData.postValue(resultData);
    }

    public  void comparemorerate ()
    {
        Collections.sort(resultData.getProductsbycategory(), (o1, o2) -> {
            return Float.valueOf(o1.getTotal_rating().get(0).getCount()/o1.getTotal_rating().get(0).getStars())
                    .compareTo(Float.valueOf(o2.getTotal_rating().get(0).getCount()/o2.getTotal_rating().get(0).
                            getStars()));
        });
        productsMutableLiveData.postValue(resultData);
    }

    //////////////// add to fav
    @SuppressLint("CheckResult")
    private Observable<AddToFavModel> getObservableToFavObservable(int product_id) {
        Observable<AddToFavModel> addToFavObservable = serverGateway.addToFave(userid,product_id);
        addToFavObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        return addToFavObservable;
    }
    private DisposableObserver<AddToFavModel> getObserverAddFav() {
        return new DisposableObserver<AddToFavModel>() {
            @Override
            public void onNext(@NonNull AddToFavModel result) {
                addToFavMutableLiveData.postValue(result);
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

    ///////////// delete fav
    @SuppressLint("CheckResult")
    private Observable<AddToFavModel> getObservableToDeleteFav(int user,int product) {
        Observable<AddToFavModel> addToFavObservable = serverGateway.DeleteFav(user,product);
        addToFavObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        return addToFavObservable;
    }

    private DisposableObserver<AddToFavModel> getObserverDeletFav() {
        return new DisposableObserver<AddToFavModel>() {
            @Override
            public void onNext(@NonNull AddToFavModel result) {
                deleteToFavMutableLiveData.postValue(result);
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
