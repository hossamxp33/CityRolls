package com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.detailsfragment

import android.app.PendingIntent.getActivity
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders

import com.codesroots.osamaomar.cityrolls.R
import com.codesroots.osamaomar.cityrolls.databinding.ItemDetailsBinding
import com.codesroots.osamaomar.cityrolls.entities.Items
import com.codesroots.osamaomar.cityrolls.helper.AddorRemoveCallbacks
import com.codesroots.osamaomar.cityrolls.helper.PreferenceHelper
import com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.ClickHandler
import com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.home.mainactivity.MainActivity
import com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.home.mainfragment.MainFragmentViewModel
import com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.home.mainfragment.MainViewModelFactory

public class ItemDetails  : AppCompatActivity(){



    lateinit var viewModel: MainFragmentViewModel
    var Itemdata : Items? = null
    var  binding : ItemDetailsBinding? = null
    private fun getViewModelFactory(): MainViewModelFactory {
        return MainViewModelFactory(this.application)
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.item_details)

        viewModel = ViewModelProviders.of(this, getViewModelFactory()).get(MainFragmentViewModel::class.java)

        val extras = intent.extras

         Itemdata = extras?.getParcelable<Items>("myobj")


        // binding!!.itemName.text = Itemdata!!.name

        binding!!.context = this
        binding!!.listener = ClickHandler()
        binding!!.viewmodel = viewModel
        binding!!.data = Itemdata

        binding!!.itemImg.setOnClickListener {

            if (PreferenceHelper.retriveCartItemsValue() != null) run {

                    (this as AddorRemoveCallbacks).onAddProduct()
                    Toast.makeText(this, this.getText(R.string.addtocartsuccess), Toast.LENGTH_SHORT).show()


                } else
                    Toast.makeText(this, this.getText(R.string.aleady_exists), Toast.LENGTH_SHORT).show()

        }



    }


//    fun SwitchingCategories(){
//
//        viewModel.ItemIndex.observe(this,androidx.lifecycle.Observer {
//
//            datArray.addAll(MainData!!.items.get(it).items)
//
//        })
//    }



}