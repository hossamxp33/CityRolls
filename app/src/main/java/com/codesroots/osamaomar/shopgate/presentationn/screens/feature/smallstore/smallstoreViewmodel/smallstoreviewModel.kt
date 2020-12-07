package com.codesroots.osamaomar.shopgate.presentationn.screens.feature.smallstore.smallstoreViewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.codesroots.osamaomar.shopgate.dataLayer.Repo.DataRepo
import com.codesroots.osamaomar.shopgate.entities.StoreData
import io.reactivex.disposables.CompositeDisposable

class smallstoreViewmodel : ViewModel() {

    var DateRepoCompnay: DataRepo = DataRepo()

    var mCompositeDisposable = CompositeDisposable()
    var SmallStoreResponseLD : MutableLiveData<StoreData>? = null
    var errorLivedat: MutableLiveData<Throwable> = MutableLiveData()
    var loadingLivedat: MutableLiveData<Boolean> = MutableLiveData()


    init {

        SmallStoreResponseLD = MutableLiveData()

        errorLivedat = MutableLiveData()
        loadingLivedat  = MutableLiveData()
    }


    fun GetAllData(id:Int,type:Int){
        DateRepoCompnay.GetSearchData(id,type,SmallStoreResponseLD)
    }


    override fun onCleared() {
        super.onCleared()
        mCompositeDisposable.dispose()
        mCompositeDisposable.clear()

    }
}


