package com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.userlocations;



import com.codesroots.osamaomar.cityrolls.domain.ServerGateway;
import com.codesroots.osamaomar.cityrolls.entities.AddLocation;
import com.codesroots.osamaomar.cityrolls.entities.UserLocations;
import com.codesroots.osamaomar.cityrolls.entities.ViewLocation;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class UserLocationsViewModel extends ViewModel {

    public MutableLiveData<List<UserLocations.DataBean>> locations = new MutableLiveData<>();
    public MutableLiveData<Throwable> error = new MutableLiveData<>();
    public MutableLiveData<ViewLocation> viewLocationMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<AddLocation> addLocationMutableLiveData = new MutableLiveData<>();
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    private ServerGateway serverGateway;

    public UserLocationsViewModel(ServerGateway serverGateway) {
        this.serverGateway = serverGateway;
    }


    public void retrieveUserLocations(int userid)
    {
       mCompositeDisposable.add(serverGateway.retrieveUserLocations(userid).
               observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).
                subscribe(userLocations -> locations.postValue(userLocations.getData()),
                        throwable -> error.postValue(throwable)));
    }




    public void addUserLocation(int userid, String name , String phone, String address, String country, String city, String notes)
    {
        mCompositeDisposable.add(serverGateway.addBillingAddress(userid,name,phone,address,country,city,notes).
                observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).
                subscribe(addLocation -> addLocationMutableLiveData.postValue(addLocation),
                        throwable -> error.postValue(throwable)));
    }


    public void editUserLocation(int locationid, String name , String phone, String address, String country, String city, String notes)
    {
        mCompositeDisposable.add(serverGateway.editBillingAddress(locationid,name,phone,address,country,city,notes).
                observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).
                subscribe(addLocation -> addLocationMutableLiveData.postValue(addLocation),
                        throwable -> error.postValue(throwable)));
    }



    public void viewLocation(int addressid)
    {
        mCompositeDisposable.add(serverGateway.viewLocation(addressid).
                observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).
                subscribe(addLocation -> viewLocationMutableLiveData.postValue(addLocation),
                        throwable -> error.postValue(throwable)));
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        mCompositeDisposable.clear();
    }
}
