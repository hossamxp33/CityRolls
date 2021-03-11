package com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.home.subcategryfragment.adapters

import android.app.PendingIntent.getActivity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil

import com.codesroots.osamaomar.cityrolls.R
import com.codesroots.osamaomar.cityrolls.databinding.DepartAdapterItemBinding
import com.codesroots.osamaomar.cityrolls.databinding.OfferItemAdapterBinding
import com.codesroots.osamaomar.cityrolls.entities.Category
import com.codesroots.osamaomar.cityrolls.entities.DataBean
import com.codesroots.osamaomar.cityrolls.entities.Items

import com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.home.productfragment.ProductsFragment

import com.codesroots.osamaomar.cityrolls.entities.names.CAT_ID
import com.codesroots.osamaomar.cityrolls.entities.names.CAT_TYPE
import com.codesroots.osamaomar.cityrolls.entities.names.SUBCATES_NAME
import com.codesroots.osamaomar.cityrolls.helper.AddorRemoveCallbacks
import com.codesroots.osamaomar.cityrolls.helper.PreferenceHelper
import com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.ClickHandler
import com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.home.mainactivity.MainActivity
import com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.home.mainfragment.adapters.CatAdapter

class SubCatsAdapter(var activity: FragmentActivity, var menu: List<Items>): RecyclerView.Adapter<SubCatsAdapter.CustomViewHolder>() {

    private val menusData: List<Items> = menu
    internal var userid = PreferenceHelper.getUserId()


    override fun getItemCount(): Int {
        return menusData.size
    }
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomViewHolder {
        val binding: OfferItemAdapterBinding
                = DataBindingUtil.inflate (LayoutInflater.from(p0.context), R.layout.offer_item_adapter,p0,false)
        binding.addtocart.setOnClickListener {
                Toast.makeText(activity,activity.getText(R.string.loginfirst), Toast.LENGTH_SHORT).show()
        }


        return CustomViewHolder(binding)
    }

    override fun onBindViewHolder(p0: CustomViewHolder, p1: Int) {
        p0.bind(p1,activity,menu.get(p1))


    }




    class CustomViewHolder(
            private val binding: OfferItemAdapterBinding

    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position:Int, context: Context?, data: Items) {

            binding.listener = ClickHandler()
            binding.data = data
            binding.context = context as MainActivity
            //   binding.datamodel = datamodel
            binding.index = position
        }

    }


}