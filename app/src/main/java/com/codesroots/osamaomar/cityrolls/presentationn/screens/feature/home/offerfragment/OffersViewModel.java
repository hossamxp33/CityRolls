package com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.home.offerfragment;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.codesroots.osamaomar.cityrolls.domain.ServerGateway;
import com.codesroots.osamaomar.cityrolls.entities.offers;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;


public class OffersViewModel extends ViewModel {


    public MutableLiveData<offers> offersMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<Throwable> throwableMutableLiveData = new MutableLiveData<>();
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    private ServerGateway serverGateway;

    OffersViewModel(ServerGateway serverGateway1) {
        serverGateway = serverGateway1;
        getOffersData();
    }

    private void getOffersData(){
        mCompositeDisposable.add(
                serverGateway.retrieveOffers()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe( this::postDataResponse,
                                this::postError));
    }

    private void postDataResponse(offers productRates) {
        offersMutableLiveData.postValue(productRates);
    }

    private void postError(Throwable throwable) {
        throwableMutableLiveData.postValue(throwable);
    }


}
