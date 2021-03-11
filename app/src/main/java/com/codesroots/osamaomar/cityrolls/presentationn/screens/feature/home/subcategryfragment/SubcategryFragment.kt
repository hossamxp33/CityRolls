package com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.home.subcategryfragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager

import com.codesroots.osamaomar.cityrolls.R
import com.codesroots.osamaomar.cityrolls.entities.Category
import com.codesroots.osamaomar.cityrolls.entities.Items
import com.codesroots.osamaomar.cityrolls.helper.PreferenceHelper
import com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.home.mainactivity.MainActivity

import com.codesroots.osamaomar.cityrolls.entities.names.CAT_ID
import com.codesroots.osamaomar.cityrolls.entities.names.SUBCATES_NAME
import com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.home.subcategryfragment.MainViewModelFactory
import com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.home.mainfragment.adapters.CatAdapter
import com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.home.subcategryfragment.adapters.SubCatsAdapter
import kotlinx.android.synthetic.main.subcategry_fragment.view.*

class SubcategryFragment : Fragment() {

    private var viewModel: MainFragmentViewModel? = null
    private var catid: Int = 0
    private val userid = PreferenceHelper.getUserId()
    private var product_notfound: TextView? = null
    private var text: TextView? = null
    private var progress: FrameLayout? = null
    private var categry_name: String? = null
    var adapterr: SubCatsAdapter? = null
    var data: Category? = null
    var datArray : List<Items>? = null
    private fun getViewModelFactory(): MainViewModelFactory {
        return MainViewModelFactory(this.activity!!.application)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.subcategry_fragment, container, false)
        product_notfound = view.findViewById(R.id.product_notfound)
        progress = view.findViewById(R.id.progress)
        text = view.findViewById(R.id.text)

        catid = arguments!!.getInt(CAT_ID, 0)
             data = arguments!!.getParcelable("data")

      //  categry_name = arguments!!.getString(SUBCATES_NAME)

        if (data != null) {
        datArray = data!!.items
        adapterr!!.notifyDataSetChanged()


        }

        (activity as MainActivity).head_title.text = categry_name
        (activity as MainActivity).logo.visibility = View.VISIBLE

        viewModel = ViewModelProviders.of(this, getViewModelFactory()).get(MainFragmentViewModel::class.java)
        viewModel!!.mainViewMutableLiveData?.observe(this, androidx.lifecycle.Observer {
            datArray = it.items.get(0).items
            adapterr = SubCatsAdapter(context as FragmentActivity, datArray!!)
            view.subcategry_Rec.layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
            view.subcategry_Rec?.adapter = adapterr

        })

        return view
    }

}
