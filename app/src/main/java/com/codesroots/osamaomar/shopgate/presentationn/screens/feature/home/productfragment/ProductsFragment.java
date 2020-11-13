package com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.productfragment;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.codesroots.osamaomar.shopgate.R;
import com.codesroots.osamaomar.shopgate.entities.Products;
import com.codesroots.osamaomar.shopgate.helper.PreferenceHelper;
import com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.mainactivity.MainActivity;
import com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.productfragment.adapters.AllProductsAdapter;
import static com.codesroots.osamaomar.shopgate.entities.names.CAT_TYPE;
import static com.codesroots.osamaomar.shopgate.entities.names.SUBCATES_NAME;
import static com.codesroots.osamaomar.shopgate.entities.names.SUB_CAT_ID;

public class ProductsFragment extends Fragment {

    private ProductsViewModel mViewModel;
    RecyclerView productsRecycle;
    ListView filter_option;
    ImageView changeSpane, filter;
    boolean RecycleIsHorizental = true;
    int subCategry, userID, type;
    private Products productsData;
    private FrameLayout progress;
    private TextView notfound, subcates_name;
    private AllProductsAdapter AllProductsAdapter;
    private String title,name;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.products_fragment, container, false);
        initialize(view);
        userID = PreferenceHelper.getUserId();

        mViewModel = ViewModelProviders.of(this, getViewModelFactory()).get(ProductsViewModel.class);
        name = getArguments().getString("name");
        if (name!=null)
            mViewModel.getSearchData(name);
        else
            mViewModel.getData();
        mViewModel.productsMutableLiveData.observe(this, products ->
        {
            productsData = products;
            progress.setVisibility(View.GONE);
            if (products.getProductsbycategory() != null) {
                if (products.getProductsbycategory().size() > 0) {
                    productsRecycle.setLayoutManager(new GridLayoutManager(getActivity(), 2));
                    AllProductsAdapter = new AllProductsAdapter(getActivity(), 0, products.getProductsbycategory(), mViewModel);
                    productsRecycle.setAdapter(AllProductsAdapter);
                } else {
                    notfound.setVisibility(View.VISIBLE);
                    changeSpane.setEnabled(false);
                    filter.setEnabled(false);
                }
            } else {
                notfound.setVisibility(View.GONE);
                changeSpane.setEnabled(false);
                filter.setEnabled(false);
            }
        });

        mViewModel.throwableMutableLiveData.observe(this, throwable ->
        {
            progress.setVisibility(View.GONE);
            Toast.makeText(getActivity(), throwable.toString(), Toast.LENGTH_SHORT).show();
        });

        mViewModel.addToFavMutableLiveData.observe(this, addToFavModel -> {
            try { if (addToFavModel.getLikeid()>0)
                productsData.getProductsbycategory().get(mViewModel.current_item)
                        .getFavourites().add(new Products.ProductsbycategoryBean.FavouritesBean(addToFavModel.getLikeid()));
                AllProductsAdapter.notifyDataSetChanged();
            }
            catch (Exception e)
            {}

        });

        mViewModel.deleteToFavMutableLiveData.observe(this, aBoolean -> {
            productsData.getProductsbycategory().get(mViewModel.current_item).getFavourites().clear();
            AllProductsAdapter.notifyDataSetChanged();
        });
        return view;
    }

    private void initialize(View view) {
        productsRecycle = view.findViewById(R.id.allProducts);
        changeSpane = view.findViewById(R.id.change_span);
        filter = view.findViewById(R.id.filter);
        filter_option = view.findViewById(R.id.filter_option);
        progress = view.findViewById(R.id.progress);
        notfound = view.findViewById(R.id.product_notfound);
        subcates_name = view.findViewById(R.id.subcates_name);
        subCategry = getArguments().getInt(SUB_CAT_ID, 0);
        type = getArguments().getInt(CAT_TYPE, 0);
        title = getArguments().getString(SUBCATES_NAME);
        if (title != null) {
            subcates_name.setText(title);
//            ((MainActivity) getActivity()).head_title.setText(title);
        }
        ((MainActivity) getActivity()).logo.setVisibility(View.INVISIBLE);
        String[] name_of_bookmarks = getResources().getStringArray(R.array.filters);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), R.layout.simple_list_item, name_of_bookmarks);
        filter_option.setAdapter(arrayAdapter);
        filter_option.setOnItemClickListener((parent, view1, position, id) -> {
        });
        changeSpane.setOnClickListener(onClickListener);
        filter.setOnClickListener(onFilterClickListener);
        filter_option.setOnItemClickListener(AdapterView);
    }

    private AdapterView.OnItemClickListener AdapterView = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if (position == 0)
                mViewModel.comparemorerate();
            else if (position == 1)
                mViewModel.compareLessprice();
            else if (position == 2)
                mViewModel.compareMoreprice();

            filter_option.setVisibility(View.GONE);
            hideView(filter_option, 0);
        }
    };

    private ProductsViewModelFactory getViewModelFactory() {
        return new ProductsViewModelFactory(this.getActivity().getApplication(), subCategry, userID, type);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (!RecycleIsHorizental) {
                productsRecycle.setLayoutManager(new GridLayoutManager(getActivity(), 2));
                AllProductsAdapter = new AllProductsAdapter(getActivity(), 0, productsData.getProductsbycategory(), mViewModel);
                productsRecycle.setAdapter(AllProductsAdapter);
                RecycleIsHorizental = true;
            } else {
                productsRecycle.setLayoutManager(new GridLayoutManager(getActivity(), 1));
                AllProductsAdapter = new AllProductsAdapter(getActivity(), 1, productsData.getProductsbycategory(), mViewModel);
                productsRecycle.setAdapter(AllProductsAdapter);
                RecycleIsHorizental = false;
            }
        }
    };

    private void hideView(final View view, int states) {
        Animation animation = null;
        if (states == 1)
            animation = AnimationUtils.loadAnimation(getActivity(), R.anim.animy);
        else
            animation = AnimationUtils.loadAnimation(getActivity(), R.anim.animyforimg);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
            }
        });
        view.startAnimation(animation);
    }

    private View.OnClickListener onFilterClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (filter_option.getVisibility() == View.GONE) {
                filter_option.setVisibility(View.VISIBLE);
                hideView(filter_option, 1);
            } else {
                filter_option.setVisibility(View.GONE);
                hideView(filter_option, 0);
            }
        }
    };

}
