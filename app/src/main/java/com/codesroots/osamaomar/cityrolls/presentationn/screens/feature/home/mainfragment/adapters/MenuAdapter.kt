package com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.home.mainfragment.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.codesroots.osamaomar.cityrolls.R
import com.codesroots.osamaomar.cityrolls.databinding.DepartAdapterItemBinding
import com.codesroots.osamaomar.cityrolls.entities.Category
import com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.ClickHandler
import com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.home.mainactivity.MainActivity
import com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.home.mainfragment.MainFragment
import com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.home.mainfragment.MainFragmentViewModel
import com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.home.mainfragment.MainViewModel
import com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.home.mainfragment.homeFragment


class CatAdapter(var activity: FragmentActivity, var menu: List<Category>,var viewModel: MainFragmentViewModel): RecyclerView.Adapter<CatAdapter.CustomViewHolder>() {

    private val menusData: List<Category> = menu
     var homeFragment : homeFragment ? = null


    override fun getItemCount(): Int {
        return menusData.size
    }
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomViewHolder {
        val binding: DepartAdapterItemBinding
                = DataBindingUtil.inflate (LayoutInflater.from(p0.context), R.layout.depart_adapter_item,p0,false)
        return CustomViewHolder(binding)
    }

    override fun onBindViewHolder(p0: CustomViewHolder, p1: Int) {
        p0.bind(p1,activity,menu.get(p1))
        p0.binding.name.setOnClickListener{
//        homeFragment!!.index = p1
            viewModel.SwtichingCategories(p1)
        // notifyItemChanged(p1);

}

    }




    class CustomViewHolder(
            public val binding: DepartAdapterItemBinding

    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position:Int, context: Context?, data: Category) {

            binding.listener = ClickHandler()
            binding.data = data
            binding.context = context as MainActivity
         //   binding.datamodel = datamodel

            binding.index = position
        }

        }


    }

