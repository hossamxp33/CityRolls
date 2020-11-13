package com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.productdetailsfragment;

import android.annotation.SuppressLint;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;
import android.util.Log;

import com.codesroots.osamaomar.shopgate.domain.ServerGateway;
import com.codesroots.osamaomar.shopgate.entities.DefaultAdd;
import com.codesroots.osamaomar.shopgate.entities.AddToFavModel;
import com.codesroots.osamaomar.shopgate.entities.ProductDetails;
import com.codesroots.osamaomar.shopgate.entities.StoreSetting;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

class ProductDetailsViewModel extends ViewModel {
    public MutableLiveData<ProductDetails.ProductdetailsBean> productDetailsizeMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<ProductDetails> productDetailsMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<AddToFavModel> addToFavMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<AddToFavModel> deleteToFavMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<Throwable> throwableMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<StoreSetting> storeSettingMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<Throwable> throwablefav = new MutableLiveData<>();
    private ServerGateway serverGateway;
    private  int product_id,userid;
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

     ProductDetailsViewModel(ServerGateway serverGateway1,int id,int user_id) {
        serverGateway = serverGateway1;
        product_id = id;
         userid = user_id;
       // getData();
         getSettingData();
    }

    public void getData() {
        getObservable().subscribeWith(getObserver());
    }


    public void getSettingData() {
        mCompositeDisposable.add(
                serverGateway.getStorSetting()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe( this::postDataResponse,
                                this::postError));
    }

    private void postDataResponse(StoreSetting storeSetting) {
         storeSettingMutableLiveData.postValue(storeSetting);
    }


    private void postError(Throwable throwable) {
        throwableMutableLiveData.postValue(throwable);
    }

    public  void AddToFav ()
    {
        getObservableToFavObservable().subscribeWith(getObserverAddFav());
    }

    public  void DeleteFav (int user,int product)
    {
        getObservableToDeleteFav(user,product).subscribeWith(getObserverDeletFav());
    }

    ////////////// getData
    @SuppressLint("CheckResult")
    private Observable<ProductDetails> getObservable() {
        Observable<ProductDetails> photographersData = serverGateway.getProductDetails(product_id,userid);
        photographersData.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        return photographersData;
    }

    private DisposableObserver<ProductDetails> getObserver() {
        return new DisposableObserver<ProductDetails>() {
            @Override
            public void onNext(@NonNull ProductDetails result) {
                if (productDetailsMutableLiveData !=null)
                    productDetailsMutableLiveData.postValue(result);
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


    //////////////// add to fav
    @SuppressLint("CheckResult")
    private Observable<AddToFavModel> getObservableToFavObservable() {
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


    @Override
    protected void onCleared() {
        super.onCleared();
        mCompositeDisposable.clear();
    }
}
