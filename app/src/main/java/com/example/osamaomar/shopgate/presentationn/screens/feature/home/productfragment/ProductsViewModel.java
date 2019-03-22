package com.example.osamaomar.shopgate.presentationn.screens.feature.home.productfragment;

import android.annotation.SuppressLint;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.util.Log;

import com.example.osamaomar.shopgate.domain.ServerGateway;
import com.example.osamaomar.shopgate.entities.DefaultAdd;
import com.example.osamaomar.shopgate.entities.AddToFavModel;
import com.example.osamaomar.shopgate.entities.Products;

import java.util.Collections;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;


public class ProductsViewModel extends ViewModel {


    public MutableLiveData<Products> productsMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<AddToFavModel> addToFavMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<Boolean> deleteToFavMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<Throwable> throwableMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<Throwable> throwablefav = new MutableLiveData<>();
    private ServerGateway serverGateway;
    private int subcattegry_id, userid,type;
    private  Products resultData;
    public int current_item = 0;

    ProductsViewModel(ServerGateway serverGateway1, int id, int user_id,int type1) {
        serverGateway = serverGateway1;
        subcattegry_id = id;
        userid = user_id;
        type = type1;
        getData();
    }

    public void getData() {
        getObservable().subscribeWith(getObserver());
    }

    public  void AddToFav (int productid)
    {
        getObservableToFavObservable(productid).subscribeWith(getObserverAddFav());
    }

    public  void DeleteFav (int favid)
    {
        getObservableToDeleteFav(favid).subscribeWith(getObserverDeletFav());

    }


    //////////// get productsData
    @SuppressLint("CheckResult")
    private Observable<Products> getObservable() {
        Observable<Products> productsObservable = serverGateway.getProducts(subcattegry_id,type,userid);
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


    public  void comparelessprice ()
    {
        Collections.sort(resultData.getProductsbycategory(), (o1, o2) -> {
            return Float.valueOf(o1.getProductsizes().get(0).getStart_price()).compareTo(Float.valueOf(o2.getProductsizes().get(0).getStart_price()));
        });
        productsMutableLiveData.postValue(resultData);
    }


    public  void comparemorerate ()
    {
        Collections.sort(resultData.getProductsbycategory(), (o1, o2) -> {
            return Float.valueOf(o1.getProductsizes().get(0).getTotal_rating().get(0).getCount()/o1.getProductsizes().get(0).getTotal_rating().get(0).getStars())
                    .compareTo(Float.valueOf(o2.getProductsizes().get(0).getTotal_rating().get(0).getCount()/o2.getProductsizes().get(0).getTotal_rating().get(0).
                            getStars()));
        });
        productsMutableLiveData.postValue(resultData);
    }


    public  void comparelessrate ()
    {
        Collections.sort(resultData.getProductsbycategory(), (o1, o2) -> {
            return Float.valueOf(o1.getProductsizes().get(0).getTotal_rating().get(0).getCount()/o1.getProductsizes().get(0).getTotal_rating().get(0).getStars())
                    .compareTo(Float.valueOf(o2.getProductsizes().get(0).getTotal_rating().get(0).getCount()/o2.getProductsizes().get(0).getTotal_rating().get(0).
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
