package com.codesroots.osamaomar.shopgate.presentationn.screens.feature.smallstore

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codesroots.osamaomar.shopgate.R
import com.codesroots.osamaomar.shopgate.entities.names.CAT_ID
import com.codesroots.osamaomar.shopgate.entities.names.CAT_TYPE
import com.codesroots.osamaomar.shopgate.presentationn.screens.feature.smallstore.adapter.smallStoreAdapter
import com.codesroots.osamaomar.shopgate.presentationn.screens.feature.smallstore.smallstoreViewmodel.smallstoreViewmodel

class smallStoreFramgent : Fragment() {

    lateinit var viewModel: smallstoreViewmodel
    lateinit var MainAdapter: smallStoreAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.small_store_fragment, container, false)
        val  catid = arguments!!.getInt(CAT_ID, 0)
        val type = arguments!!.getInt(CAT_TYPE, 0)

       viewModel = ViewModelProviders.of(this).get(smallstoreViewmodel::class.java)
       viewModel.GetAllData(catid,type);

     viewModel.SmallStoreResponseLD?.observe(this, androidx.lifecycle.Observer {
          //  MainAdapter = activity?.let { it1 -> smallStoreAdapter(it1, it) }!!
//            recylere.layoutManager = LinearLayoutManager(context);
//            recylere.adapter = MainAdapter;
//
//
//            MainAdapter.notifyDataSetChanged()

     })





        return view;

    }

}
