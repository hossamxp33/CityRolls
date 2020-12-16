package com.codesroots.osamaomar.shopgate.presentationn.screens.feature.smallstore.adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.codesroots.osamaomar.shopgate.R
import com.codesroots.osamaomar.shopgate.datalayer.Repo.loudImage

import com.codesroots.osamaomar.shopgate.entities.Data
import com.codesroots.osamaomar.shopgate.entities.names.CAT_ID
import com.codesroots.osamaomar.shopgate.entities.names.SUB_CAT_ID
import com.codesroots.osamaomar.shopgate.entities.offers
import com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.productfragment.ProductsFragment
import kotlinx.android.synthetic.main.product_details_fragment.view.*
import kotlinx.android.synthetic.main.small_store_adapter.view.*


class smallStoreAdapter(activity: FragmentActivity, offers: List<Data>) : RecyclerView.Adapter<smallStoreAdapter.CustomView>() {

    private val context: Context
    private val StoresData: List<Data> = offers

    init {
        this.context = activity
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomView {
        return CustomView(LayoutInflater.from(context).inflate(R.layout.small_store_adapter, parent, false))
    }

    override fun onBindViewHolder(holder: CustomView, position: Int) {

        holder.name.text=StoresData[position].name
        holder.address.text=StoresData[position].address

        loudImage(context,holder.cover,StoresData[position].cover)

        loudImage(context,holder.img,StoresData[position].logo)



      //  holder.address.text=StoresData[position].address.toString()

//        holder.price.text=offersData[position].price+" "+offersData[position].currency
//        holder.viewsnum.text=offersData[position].totalviews.toString()
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
                    ?.replace(R.id.mainfram,f)?.addToBackStack(null)?.commit()
        }
    }

    override fun getItemCount(): Int {
        return StoresData.size
    }

    class CustomView (val mView: View) : RecyclerView.ViewHolder(mView) {
       val img = mView.item_img
        val cover = mView.backgroundcover

         val name = mView.store_name
//        val price = mView.price
//        val viewsnum = mView.viewsnum
        val address = mView.store_adress
    }
}


