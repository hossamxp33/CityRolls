package com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.productdetailsfragment.adapters;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.codesroots.osamaomar.shopgate.R;
import com.codesroots.osamaomar.shopgate.entities.MainView;
import com.codesroots.osamaomar.shopgate.entities.ProductDetails;

import java.util.List;


public class SliderProductDetailsAdapter extends PagerAdapter {
    private Context activity;
   private List<ProductDetails.ProductdetailsBean.ProductphotosBean> slider;
    public SliderProductDetailsAdapter(FragmentActivity context, List<ProductDetails.ProductdetailsBean.ProductphotosBean> sliders) {
        activity=context;
        slider=sliders;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        LayoutInflater layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert layoutInflater != null;
        View view = layoutInflater.inflate(R.layout.viewpagerslide_home1, container, false);
        ImageView im_slider =  view.findViewById(R.id.im_slider);

        Glide.with(activity.getApplicationContext())
                .load(slider.get(position).getPhoto())
                .into(im_slider);

        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
       return  slider.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }


}

