package com.codesroots.osamaomar.shopgate.dataLayer.Repo

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import com.codesroots.osamaomar.shopgate.domain.ApiClient
import com.codesroots.osamaomar.shopgate.domain.ServerGateway
import com.codesroots.osamaomar.shopgate.entities.MainView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class  DataRepo {
    @SuppressLint("CheckResult")

    fun GetSearchData(id:Int,type:Int,livedata: MutableLiveData<MainView>?) {

        getServergetway().GetSmallStore(id,type)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map { data -> data }
                .subscribe(
                        { books ->
                            livedata?.postValue(books)
                        },
                        { error ->

                        }
                )
    }
    fun getServergetway () : ServerGateway
    {
        return ApiClient.getClient().create(ServerGateway::class.java)
    }

}
