package com.example.osamaomar.shopgate.presentationn.screens.feature.home.mainfragment;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.osamaomar.shopgate.R;
import com.example.osamaomar.shopgate.entities.MainView;
import com.example.osamaomar.shopgate.presentationn.screens.feature.home.mainactivity.MainActivity;
import com.example.osamaomar.shopgate.presentationn.screens.feature.home.mainfragment.adapters.DepartmentsAdapter;
import com.example.osamaomar.shopgate.presentationn.screens.feature.home.mainfragment.adapters.DiffProductsAdapter;
import com.example.osamaomar.shopgate.presentationn.screens.feature.home.mainfragment.adapters.FamousProductsAdapter;
import com.example.osamaomar.shopgate.presentationn.screens.feature.home.mainfragment.adapters.SliderPagerAdapter;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.viewpagerindicator.CirclePageIndicator;
import java.util.Timer;
import java.util.TimerTask;

public class MainFragment extends Fragment {

    private MainFragmentViewModel mViewModel;
    RecyclerView departments,famous_products,diff_products;
    ViewPager slider;
    CirclePageIndicator indicator;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private FrameLayout progress;
    private TextView product_notfound;
    private ShimmerFrameLayout mShimmerViewContainer,mShimmerViewContainer2,mShimmerViewContainer3;

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
                    mShimmerViewContainer2.setVisibility(View.GONE);
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
        mShimmerViewContainer2.stopShimmerAnimation();
        mShimmerViewContainer2.setVisibility(View.GONE);
        mShimmerViewContainer3.stopShimmerAnimation();
        mShimmerViewContainer3.setVisibility(View.GONE);
        progress.setVisibility(View.GONE);
        setupDiffRecycle();
        setupviewPager(slider);
        init(mainView.getSliders().size());
        slider.setAdapter(new SliderPagerAdapter(getActivity(),mainView.getSliders()));
        indicator.setViewPager(slider);
        famous_products.setAdapter(new FamousProductsAdapter(getActivity(),mainView.getProductsbyrate()));
        diff_products.setAdapter(new DiffProductsAdapter(getActivity(),mainView.getSubcats()));
        departments.setAdapter(new DepartmentsAdapter(getActivity(),mainView.getCategory()));
    }

    private void setupviewPager(ViewPager viewPager) {
        viewPager.setPageTransformer(true, (view, position) -> {
            view.setTranslationX(-position * view.getWidth());
            if (Math.abs(position) < 0.5) {
                view.setVisibility(View.VISIBLE);
                view.setScaleX(1 - Math.abs(position));
                view.setScaleY(1 - Math.abs(position));
            } else if (Math.abs(position) > 0.5) {
                view.setVisibility(View.GONE);
            }
        });
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

    private void setupDiffRecycle() {
        final GridLayoutManager mng_layout = new GridLayoutManager(this.getActivity(), 2);
        mng_layout.setOrientation(LinearLayout.HORIZONTAL);
        mng_layout.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return (position ) == 0 ? 2 : 1;
            }
        });

        diff_products.setLayoutManager(mng_layout);
    }

    private void findViewsFromXml(View view) {
        diff_products = view.findViewById(R.id.diff_products);
        departments = view.findViewById(R.id.departments);
        slider = view.findViewById(R.id.slider);
        indicator = view.findViewById(R.id.indicator);
        famous_products = view.findViewById(R.id.famous_products);
        progress = view.findViewById(R.id.progress);
     //   product_notfound = view.findViewById(R.id.product_notfound);
        mShimmerViewContainer = view.findViewById(R.id.shimmer_view_container1);
        mShimmerViewContainer2 = view.findViewById(R.id.shimmer_view_container2);
        mShimmerViewContainer3 = view.findViewById(R.id.shimmer_view_container3);
        ((MainActivity) getActivity()).head_title.setVisibility(View.GONE);
        ((MainActivity) getActivity()).logo.setVisibility(View.VISIBLE);
    }

    @Override
    public void onResume() {
        super.onResume();
        mShimmerViewContainer.startShimmerAnimation();
        mShimmerViewContainer2.startShimmerAnimation();
        mShimmerViewContainer3.startShimmerAnimation();
    }

    @Override
    public void onPause() {
        mShimmerViewContainer.stopShimmerAnimation();
        mShimmerViewContainer2.stopShimmerAnimation();
        mShimmerViewContainer3.stopShimmerAnimation();
        super.onPause();
    }

}
