package com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.home.mainfragment;

import android.annotation.SuppressLint;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.annotation.NonNull;
import android.util.Log;

import com.codesroots.osamaomar.cityrolls.domain.ServerGateway;
import com.codesroots.osamaomar.cityrolls.entities.MainView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;


public class MainFragmentViewModel extends ViewModel {


    public MutableLiveData<MainView> mainViewMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<Throwable> throwableMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<Integer> ItemIndex = new MutableLiveData<>();

    private ServerGateway serverGateway;

   public   MainFragmentViewModel(ServerGateway serverGateway1) {
        serverGateway = serverGateway1;
        getData();
    }

    public void getData() {
        getObservable().subscribeWith(getObserver());
    }

        public void SwtichingCategories(Integer index){

            ItemIndex.postValue(index);
        }

    @SuppressLint("CheckResult")
    private Observable<MainView> getObservable() {
        Observable<MainView> photographersData = serverGateway.getMainViewData();
        photographersData.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        return photographersData;
    }

    private DisposableObserver<MainView> getObserver() {
        return new DisposableObserver<MainView>() {
            @Override
            public void onNext(@NonNull MainView result) {
                if (mainViewMutableLiveData !=null)
                mainViewMutableLiveData.postValue(result);
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
}
