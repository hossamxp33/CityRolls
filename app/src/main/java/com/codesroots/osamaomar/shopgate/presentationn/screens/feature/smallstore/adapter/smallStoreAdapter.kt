package com.codesroots.osamaomar.shopgate.presentationn.screens.feature.smallstore.adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.codesroots.osamaomar.shopgate.R
import com.codesroots.osamaomar.shopgate.entities.MainView
import kotlinx.android.synthetic.main.product_details_fragment.view.*


class smallStoreAdapter(activity: FragmentActivity, offers: List<MainView>) : RecyclerView.Adapter<smallStoreAdapter.CustomView>() {

    private val context: Context
    private val offersData: List<MainView> = offers

    init {
        this.context = activity
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomView {
        return CustomView(LayoutInflater.from(context).inflate(R.layout.small_store_adapter, parent, false))
    }

    override fun onBindViewHolder(holder: CustomView, position: Int) {

//        loudImage(context,holder.img,offersData[position].photo)
//        holder.name.text=offersData[position].name
//        holder.price.text=offersData[position].price+" "+offersData[position].currency
//        holder.viewsnum.text=offersData[position].totalviews.toString()
//
//        holder.mView.setOnClickListener {
//            val f = OfferDetailsFragment()
//            val args = Bundle()
//            args.putSerializable("offerDetails",offersData[position])
//            f.setArguments(args)
//            (holder.itemView.context as FragmentActivity).supportFragmentManager?.beginTransaction()
//                    ?.replace(R.id.fragment,f)?.addToBackStack(null)?.commit()
//        }
    }

    override fun getItemCount(): Int {
        return offersData.size
    }

    class CustomView (val mView: View) : RecyclerView.ViewHolder(mView) {
//        val img = mView.exp_img
//        val name = mView.description
//        val price = mView.price
//        val viewsnum = mView.viewsnum
//        val discount = mView.discount
    }
}