package com.codesroots.osamaomar.shopgate.presentationn.screens.feature.smallstore

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codesroots.osamaomar.shopgate.R
import com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.mainactivity.MainActivity
import com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.mainfragment.MainViewModel
import com.codesroots.osamaomar.shopgate.presentationn.screens.feature.smallstore.adapter.smallStoreAdapter

class smallStoreFramgent :Fragment() {






    lateinit var smallStoreAdapter: smallStoreAdapter
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.small_store_fragment, container, false)




        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        view.viewModel =  viewModel

        viewModel.GetMyTrans();

        viewModel.mytransResponseLD?.observe(this, androidx.lifecycle.Observer {
            MainAdapter = mytransAdapter(viewModel, context, it)
            recylere.layoutManager = LinearLayoutManager(context);
            recylere.adapter = MainAdapter;


            MainAdapter.notifyDataSetChanged()

        })





        return view.root;

    }

}



