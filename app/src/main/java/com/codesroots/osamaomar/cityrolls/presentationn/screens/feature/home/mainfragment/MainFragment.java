package com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.home.mainfragment;

import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.codesroots.osamaomar.cityrolls.entities.MainView;
import com.google.android.material.snackbar.Snackbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.codesroots.osamaomar.cityrolls.R;
import com.codesroots.osamaomar.cityrolls.helper.PreferenceHelper;
import com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.home.mainfragment.adapters.DepartmentsAdapter;
import com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.home.mainfragment.adapters.FamousProductsAdapter;
import com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.home.mainfragment.adapters.OffersProductsAdapter;
import com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.home.mainfragment.adapters.RecommendedProductsAdapter;
import com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.home.mainfragment.adapters.SliderPagerAdapter;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.viewpagerindicator.CirclePageIndicator;
import com.viewpagerindicator.LinePageIndicator;

import java.util.Timer;
import java.util.TimerTask;

public class MainFragment extends Fragment {

    private MainFragmentViewModel mViewModel;
    RecyclerView departments, sales_products, more_sales,recommended_products;
    ViewPager slider;
    CirclePageIndicator indicator;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private FrameLayout progress;
    private TextView product_notfound;
    private ShimmerFrameLayout mShimmerViewContainer,mShimmerViewContainer2,mShimmerViewContainer3,shimmer_view_container4,shimmer_view_container5;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.main_fragment, container, false);
        findViewsFromXml(view);
        mViewModel = ViewModelProviders.of(this,getViewModelFactory()).get(MainFragmentViewModel.class);
        mViewModel.mainViewMutableLiveData.observe(this,this::setDatainViews);

        mViewModel.throwableMutableLiveData.observe(this,throwable ->
                {
                    progress.setVisibility(View.GONE);
                    showSnackBar(view,throwable.toString());
                    mShimmerViewContainer.stopShimmerAnimation();
                    mShimmerViewContainer.setVisibility(View.GONE);
                    mShimmerViewContainer3.stopShimmerAnimation();
                    mShimmerViewContainer3.setVisibility(View.GONE);

                });
        return view;
    }

    private MainViewModelFactory getViewModelFactory() {
        return new MainViewModelFactory(this.getActivity().getApplication());
    }

    private void setDatainViews(MainView mainView) {
        mShimmerViewContainer.stopShimmerAnimation();
        mShimmerViewContainer.setVisibility(View.GONE);
        mShimmerViewContainer3.stopShimmerAnimation();
        mShimmerViewContainer3.setVisibility(View.GONE);
        progress.setVisibility(View.GONE);

//        PreferenceHelper.setDoller_value(mainView.getCurrency().getValue());
        if (PreferenceHelper.getCurrency() == null) {
            PreferenceHelper.setCURRENCY_VALUE(1);
            PreferenceHelper.setCURRENCY("OMR");
            PreferenceHelper.setCURRENCYArabic("عماني");

        }
        init(mainView.getSliders().size());
        slider.setAdapter(new SliderPagerAdapter(getActivity(),mainView.getSliders()));
        slider.setPadding(80, 0, 50, 0);
        slider.setOffscreenPageLimit(3);
        slider.setPageMargin(20);
        slider.setClipToPadding(false);
        slider.setClipChildren(false);
        indicator.setViewPager(slider);
//        morerate_products.setAdapter(new FamousProductsAdapter(getActivity(),mainView.getNewdata()));
        //sales_products.setAdapter(new OffersProductsAdapter(getActivity(),mainView.getItems()));
    //    recommended_products.setAdapter(new RecommendedProductsAdapter(getActivity(),mainView.getProductsbysales()));
        departments.setAdapter(new DepartmentsAdapter(getActivity(),mainView.getItems()));

    }




    private void init(int size) {
        final float density = getResources().getDisplayMetrics().density;
        indicator.setRadius(4 * density);
        NUM_PAGES = size;
        final Handler handler = new Handler();
        final Runnable Update = () -> {
            if (currentPage == NUM_PAGES) {
                currentPage = 0;
            }
            slider.setCurrentItem(currentPage++, true);
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 4000, 5000);
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                currentPage = position;
            }
            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {}
            @Override
            public void onPageScrollStateChanged(int pos) {}
        });
    }

    private void showSnackBar(View view, String message) {
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).show();
    }

    private void findViewsFromXml(View view) {


        departments = view.findViewById(R.id.departments);
//        sales_products = view.findViewById(R.id.sales_products);
        slider = view.findViewById(R.id.slider);
        indicator = view.findViewById(R.id.indicator);

        recommended_products = view.findViewById(R.id.recommended_products);
        progress = view.findViewById(R.id.progress);
     //   product_notfound = view.findViewById(R.id.product_notfound);
        mShimmerViewContainer = view.findViewById(R.id.shimmer_view_container1);

        mShimmerViewContainer3 = view.findViewById(R.id.shimmer_view_container3);



    }

    @Override
    public void onResume() {
        super.onResume();
        mShimmerViewContainer.startShimmerAnimation();
        mShimmerViewContainer3.startShimmerAnimation();

    }

    @Override
    public void onPause() {
        mShimmerViewContainer.startShimmerAnimation();
        mShimmerViewContainer3.stopShimmerAnimation();

        super.onPause();
    }

}
