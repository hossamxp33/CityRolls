package com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.subcategryfragment;

import android.annotation.SuppressLint;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;
import android.util.Log;

import com.codesroots.osamaomar.shopgate.domain.ServerGateway;
import com.codesroots.osamaomar.shopgate.entities.DefaultAdd;
import com.codesroots.osamaomar.shopgate.entities.AddToFavModel;
import com.codesroots.osamaomar.shopgate.entities.SubCategriesWithProducts;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;


public class SubCatesViewModel extends ViewModel {

    public MutableLiveData<SubCategriesWithProducts> subCategriesWithProductsMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<Throwable> throwableMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<AddToFavModel> addToFavMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<AddToFavModel> deleteToFavMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<Throwable> throwablefav = new MutableLiveData<>();
    private ServerGateway serverGateway;
    private  int cattegry_id,userid;
    public int current_item = 0;

     public SubCatesViewModel(ServerGateway serverGateway1, int id, int user_id) {
        serverGateway = serverGateway1;
        cattegry_id = id;
        userid = user_id;
        getData();
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


    ///////////// get Data
    @SuppressLint("CheckResult")
    private Observable<SubCategriesWithProducts> getObservable() {
        Observable<SubCategriesWithProducts> subCatswithProducts = serverGateway.getSubCatswithProducts(cattegry_id,userid);
        subCatswithProducts.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        return subCatswithProducts;
    }

    private DisposableObserver<SubCategriesWithProducts> getObserver() {
        return new DisposableObserver<SubCategriesWithProducts>() {
            @Override
            public void onNext(@NonNull SubCategriesWithProducts result) {
                if (subCategriesWithProductsMutableLiveData !=null)
                    subCategriesWithProductsMutableLiveData.postValue(result);
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
    private Observable<AddToFavModel> getObservableToFavObservable(int productid) {
        Observable<AddToFavModel> addToFavObservable = serverGateway.addToFave(userid,productid);
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
