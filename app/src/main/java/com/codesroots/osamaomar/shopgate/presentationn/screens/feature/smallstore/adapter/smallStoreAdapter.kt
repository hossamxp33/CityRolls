package com.codesroots.osamaomar.shopgate.presentationn.screens.feature.smallstore.adapter

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy.LOG
import com.codesroots.osamaomar.shopgate.R
import com.codesroots.osamaomar.shopgate.datalayer.Repo.loudImage

import com.codesroots.osamaomar.shopgate.entities.Data
import com.codesroots.osamaomar.shopgate.entities.names.CAT_ID
import com.codesroots.osamaomar.shopgate.entities.names.SUB_CAT_ID
import com.codesroots.osamaomar.shopgate.entities.offers
import com.codesroots.osamaomar.shopgate.helper.ResourceUtil
import com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.productfragment.ProductsFragment
import kotlinx.android.synthetic.main.product_details_fragment.view.*
import kotlinx.android.synthetic.main.small_store_adapter.view.*
import java.util.*


class smallStoreAdapter(activity: FragmentActivity, offers: List<Data>) : RecyclerView.Adapter<smallStoreAdapter.CustomView>() {

    private val context: Context
    private val StoresData: List<Data> = offers

    init {
        this.context = activity
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomView {
        return CustomView(LayoutInflater.from(context).inflate(com.codesroots.osamaomar.shopgate.R.layout.small_store_adapter, parent, false))
    }

    override fun onBindViewHolder(holder: CustomView, position: Int) {

        holder.name.text=StoresData[position].name
        holder.address.text=StoresData[position].address

        loudImage(context,holder.cover,StoresData[position].cover)

        loudImage(context,holder.img,StoresData[position].logo)


    //// Make Call ////////////
        val store_phone =StoresData[position].phone
        holder.call.setOnClickListener({ v -> ResourceUtil.callNumber(store_phone, this.context) })
      ///////////////  Get Location ---------- //////////////
        val lat = StoresData[position].latitude
        val long = StoresData[position].longitude
        val name = StoresData[position].name

        holder.location.setOnClickListener { v ->
            val gmmIntentUri = Uri.parse("geo:${lat},${long}")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
           context. startActivity(mapIntent)
        }
//
        holder.mView.setOnClickListener {
            val f = ProductsFragment()
            val args = Bundle()
          //  f.arguments = args
            args.putInt(SUB_CAT_ID, StoresData[position].id)

         //   args.putSerializable("offerDetails", offers.DataBean.ProductBean[position])
          //  val      bundle.putInt(CAT_ID, categories.get(position).getId())


            f.setArguments(args)
            (holder.itemView.context as FragmentActivity).supportFragmentManager?.beginTransaction()
                    ?.replace(com.codesroots.osamaomar.shopgate.R.id.mainfram,f)?.addToBackStack(null)?.commit()
        }
    }

    override fun getItemCount(): Int {
        return StoresData.size
    }

    class CustomView (val mView: View) : RecyclerView.ViewHolder(mView) {
       val img = mView.item_img
        val cover = mView.backgroundcover
        val call = mView.mobile
        val location = mView.store_location
         val name = mView.store_name
//        val price = mView.price
//        val viewsnum = mView.viewsnum
        val address = mView.store_adress
    }



}


