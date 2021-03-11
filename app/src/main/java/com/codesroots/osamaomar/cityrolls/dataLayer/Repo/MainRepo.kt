package com.codesroots.osamaomar.cityrolls.dataLayer.Repo

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import com.codesroots.osamaomar.cityrolls.domain.ApiClient
import com.codesroots.osamaomar.cityrolls.domain.ServerGateway
import com.codesroots.osamaomar.cityrolls.entities.StoreData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class  DataRepo {
    @SuppressLint("CheckResult")

    fun GetSearchData(id:Int,type:Int,livedata: MutableLiveData<StoreData>?) {

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
