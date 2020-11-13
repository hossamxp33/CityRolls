package com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.mainfragment;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.codesroots.osamaomar.shopgate.R;
import com.codesroots.osamaomar.shopgate.entities.MainView;
import com.codesroots.osamaomar.shopgate.helper.PreferenceHelper;
import com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.mainactivity.MainActivity;
import com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.mainfragment.adapters.DepartmentsAdapter;
import com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.mainfragment.adapters.FamousProductsAdapter;
import com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.mainfragment.adapters.MoreSalesProductsAdapter;
import com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.mainfragment.adapters.RecommendedProductsAdapter;
import com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.mainfragment.adapters.SliderPagerAdapter;
import com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.productdetailsfragment.ProductDetailsFragment;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.viewpagerindicator.CirclePageIndicator;
import java.util.Timer;
import java.util.TimerTask;

import static com.codesroots.osamaomar.shopgate.entities.names.PRODUCT_ID;

public class MainFragment extends Fragment {

    private MainFragmentViewModel mViewModel;
    RecyclerView departments, morerate_products, more_sales,recommended_products;
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
                    mShimmerViewContainer2.stopShimmerAnimation();
                    shimmer_view_container4.stopShimmerAnimation();
                    mShimmerViewContainer2.setVisibility(View.GONE);
                    mShimmerViewContainer3.stopShimmerAnimation();
                    shimmer_view_container5.stopShimmerAnimation();
                    mShimmerViewContainer3.setVisibility(View.GONE);
                    shimmer_view_container4.setVisibility(View.GONE);
                    shimmer_view_container5.setVisibility(View.GONE);
                });
        return view;
    }

    private MainViewModelFactory getViewModelFactory() {
        return new MainViewModelFactory(this.getActivity().getApplication());
    }

    private void setDatainViews(MainView mainView) {

        mShimmerViewContainer.stopShimmerAnimation();
        mShimmerViewContainer.setVisibility(View.GONE);
        mShimmerViewContainer2.stopShimmerAnimation();
        shimmer_view_container4.stopShimmerAnimation();
        mShimmerViewContainer2.setVisibility(View.GONE);
        mShimmerViewContainer3.stopShimmerAnimation();
        shimmer_view_container5.stopShimmerAnimation();
        mShimmerViewContainer3.setVisibility(View.GONE);
        shimmer_view_container4.setVisibility(View.GONE);
        shimmer_view_container5.setVisibility(View.GONE);
        progress.setVisibility(View.GONE);
        PreferenceHelper.setDoller_value(mainView.getCurrency().getValue());

        init(mainView.getSliders().size());
        slider.setAdapter(new SliderPagerAdapter(getActivity(),mainView.getSliders()));
        slider.setPadding(80, 0, 50, 0);
        slider.setOffscreenPageLimit(3);
        slider.setPageMargin(20);
        slider.setClipToPadding(false);
        slider.setClipChildren(false);
        indicator.setViewPager(slider);
        morerate_products.setAdapter(new FamousProductsAdapter(getActivity(),mainView.getProductsbyrate()));
        more_sales.setAdapter(new MoreSalesProductsAdapter(getActivity(),mainView.getProductsbysales()));
        recommended_products.setAdapter(new RecommendedProductsAdapter(getActivity(),mainView.getRandproducts()));
        departments.setAdapter(new DepartmentsAdapter(getActivity(),mainView.getCategory()));

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

        more_sales = view.findViewById(R.id.sales_products);
        departments = view.findViewById(R.id.departments);
        slider = view.findViewById(R.id.slider);
        indicator = view.findViewById(R.id.indicator);
        morerate_products = view.findViewById(R.id.famous_products);
        recommended_products = view.findViewById(R.id.recommended_products);
        progress = view.findViewById(R.id.progress);
     //   product_notfound = view.findViewById(R.id.product_notfound);
        mShimmerViewContainer = view.findViewById(R.id.shimmer_view_container1);
        mShimmerViewContainer2 = view.findViewById(R.id.shimmer_view_container2);
        mShimmerViewContainer3 = view.findViewById(R.id.shimmer_view_container3);
        shimmer_view_container4 = view.findViewById(R.id.shimmer_view_container4);
        shimmer_view_container5 = view.findViewById(R.id.shimmer_view_container5);

    }

    @Override
    public void onResume() {
        super.onResume();
        mShimmerViewContainer.startShimmerAnimation();
        mShimmerViewContainer2.startShimmerAnimation();
        mShimmerViewContainer3.startShimmerAnimation();
        shimmer_view_container4.startShimmerAnimation();
        shimmer_view_container5.startShimmerAnimation();
    }

    @Override
    public void onPause() {
        mShimmerViewContainer.stopShimmerAnimation();
        mShimmerViewContainer2.stopShimmerAnimation();
        mShimmerViewContainer3.stopShimmerAnimation();
        shimmer_view_container4.stopShimmerAnimation();
        shimmer_view_container5.stopShimmerAnimation();
        super.onPause();
    }

}
