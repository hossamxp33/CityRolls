package com.example.osamaomar.shopgate.presentationn.screens.feature.home.productdetailsfragment;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.example.osamaomar.shopgate.R;
import com.example.osamaomar.shopgate.entities.ProductDetails;
import com.example.osamaomar.shopgate.entities.StoreSetting;
import com.example.osamaomar.shopgate.helper.AddorRemoveCallbacks;
import com.example.osamaomar.shopgate.helper.PreferenceHelper;
import com.example.osamaomar.shopgate.helper.ResourceUtil;
import com.example.osamaomar.shopgate.presentationn.screens.feature.home.mainactivity.MainActivity;
import com.example.osamaomar.shopgate.presentationn.screens.feature.home.productdetailsfragment.adapters.ProductImagesAdapter;
import com.example.osamaomar.shopgate.presentationn.screens.feature.home.productdetailsfragment.adapters.ProductSizesAdapter;
import com.example.osamaomar.shopgate.presentationn.screens.feature.rate.RateActivity;
import java.util.ArrayList;
import static com.example.osamaomar.shopgate.entities.names.PRODUCT_ID;


public class ProductDetailsFragment extends Fragment {

    private ProductDetailsViewModel mViewModel;
    RecyclerView images_rec, sizes_rec;
    private int productid;
    FrameLayout loading;
    public TextView product_name, description, price, ratecount,amount,addtocart,charege;
    RatingBar ratingBar;
    public ImageView item_img;
    int userid = PreferenceHelper.getUserId(),favid =0;
    ProductSizesAdapter productSizesAdapter;
    ProductImagesAdapter productImagesAdapter;
    ArrayList<String> images = new ArrayList<>();
    ImageView addToFav;
    boolean productfav;
    ProductDetails.ProductdetailsBean productdetails;
    public StoreSetting setting;
    public  boolean  freecharg = false;


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.product_details_fragment, container, false);
        ((MainActivity) getActivity()).head_title.setText(getText(R.string.product_details));
        ((MainActivity) getActivity()).logo.setVisibility(View.INVISIBLE);
        productid = getArguments().getInt(PRODUCT_ID, 0);
        findViewsFromXml(view);

        mViewModel = ViewModelProviders.of(this, getViewModelFactory()).get(ProductDetailsViewModel.class);

        if (ResourceUtil.getCurrentLanguage(getActivity()).matches("en"))
            description.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_next,0);

        mViewModel.throwableMutableLiveData.observe(this,throwable -> Toast.makeText(getActivity(),throwable.toString(),Toast.LENGTH_SHORT));
        mViewModel.storeSettingMutableLiveData.observe(this,storeSetting ->
                {
                    mViewModel.getData();
                    setting = storeSetting;
                });

        charege.setOnClickListener(v -> {
            if (!freecharg)
                    new AlertDialog.Builder(getActivity())
                            .setTitle(getText(R.string.charge_rules))
                            .setMessage(setting.getData().get(0).getShipping())
                            .setPositiveButton("OK", (dialog, id) -> dialog.cancel()).show();
        });


        mViewModel.productDetailsMutableLiveData.observe(this, productDetails ->
        {
            loading.setVisibility(View.GONE);
            if (productDetails.getProductdetails().size()>0) {
                productdetails = productDetails.getProductdetails().get(0);
                if (productDetails.getProductdetails() != null)
                    setDataToViews(productDetails.getProductdetails().get(0));
            }
            else
                Toast.makeText(getActivity(), getActivity().getText(R.string.error_in_data), Toast.LENGTH_SHORT).show();

        });

        addtocart.setOnClickListener(v -> {
            if (userid>0) {
                if (PreferenceHelper.retriveCartItemsValue() != null) {
                    if (!PreferenceHelper.retriveCartItemsValue().contains(String.valueOf(productdetails.getProductsizes().get(productSizesAdapter.mSelectedItem).getId()))) {
                        PreferenceHelper.addItemtoCart(productdetails.getProductsizes().get(productSizesAdapter.mSelectedItem).getId());
                        ((AddorRemoveCallbacks) getActivity()).onAddProduct();
                        Toast.makeText(getActivity(), getActivity().getText(R.string.addtocartsuccess), Toast.LENGTH_SHORT).show();
                    } else
                        Toast.makeText(getActivity(), getActivity().getText(R.string.aleady_exists), Toast.LENGTH_SHORT).show();
                } else {
                    PreferenceHelper.addItemtoCart(productdetails.getProductsizes().get(productSizesAdapter.mSelectedItem).getId());
                    ((AddorRemoveCallbacks) getActivity()).onAddProduct();
                    Toast.makeText(getActivity(), getActivity().getText(R.string.addtocartsuccess), Toast.LENGTH_SHORT).show();
                }
            }
            else
                Toast.makeText(getActivity(), getActivity().getText(R.string.loginfirst), Toast.LENGTH_SHORT).show();

        });

        addToFav.setOnClickListener(v ->
                {
                    addToFav.setEnabled(false);
                    if (!productfav)
                    {mViewModel.AddToFav();
                        productfav = true;
                    }
                    else
                    {
                        mViewModel.DeleteFav(favid);
                        productfav = false;
                    }
                });

        mViewModel.addToFavMutableLiveData.observe(this, aBoolean ->
        {
            addToFav.setEnabled(true);
            addToFav.setImageResource(R.drawable.favoried);
        });

        mViewModel.deleteToFavMutableLiveData.observe(this, aBoolean ->
        {
            addToFav.setEnabled(true);
            addToFav.setImageResource(R.drawable.like);
        });

        mViewModel.throwablefav.observe(this,throwable ->
                {
                    addToFav.setEnabled(false);
                    Toast.makeText(getActivity(),getText(R.string.error_tryagani),Toast.LENGTH_SHORT).show();
                } );

        ratingBar.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_UP) {
                Intent intent = new Intent(getActivity(), RateActivity.class);
                intent.putExtra(PRODUCT_ID,productid);
                getActivity().startActivity(intent);
            }
            return true;
        });

        return view;
    }

    private void findViewsFromXml(View view) {
        images_rec = view.findViewById(R.id.images_rec);
        sizes_rec = view.findViewById(R.id.sizes);
        loading = view.findViewById(R.id.progress);
        product_name = view.findViewById(R.id.product_name);
        description = view.findViewById(R.id.description);
        price = view.findViewById(R.id.price);
        ratecount = view.findViewById(R.id.rate_count);
        ratingBar = view.findViewById(R.id.rates);
        item_img = view.findViewById(R.id.item_img);
        addToFav = view.findViewById(R.id.fav);
        amount = view.findViewById(R.id.amount);
        addtocart = view.findViewById(R.id.addtocart);
        charege = view.findViewById(R.id.charge);
    }

    @SuppressLint("SetTextI18n")
    private void setDataToViews(ProductDetails.ProductdetailsBean productdetailsBean) {

        for (int i = 0; i < productdetailsBean.getProductphotos().size(); i++)
            images.add(productdetailsBean.getProductphotos().get(i).getPhoto());
        Glide.with(getActivity()).load(productdetailsBean.getProductphotos().get(0).getPhoto())
                .useAnimationPool(true).placeholder(R.drawable.product).into(item_img);
        if (productdetailsBean.getOffers().size()>0)
        productSizesAdapter = new ProductSizesAdapter(getActivity(), productdetailsBean.getProductsizes(),
                this,productdetailsBean.getOffers().get(0).getPercentage());
        else
            productSizesAdapter = new ProductSizesAdapter(getActivity(), productdetailsBean.getProductsizes(), this,0);

        productImagesAdapter = new ProductImagesAdapter(getActivity(), productdetailsBean.getProductphotos(), this);
        images_rec.setAdapter(productImagesAdapter);
        sizes_rec.setAdapter(productSizesAdapter);
        product_name.setText(productdetailsBean.getName());
        if (productdetailsBean.getOffers().size()>0)
        {

            float priceafteroffer =Float.valueOf(productdetailsBean.getProductsizes().get(productSizesAdapter.mSelectedItem).getStart_price())- Float.valueOf(productdetailsBean.getProductsizes().get(productSizesAdapter.mSelectedItem).getStart_price())*
                    productdetailsBean.getOffers().get(0).getPercentage()/100;
            if (PreferenceHelper.getCurrencyValue()>0)
                price.setText(String.valueOf(priceafteroffer)+PreferenceHelper.getCurrency());
           else
            price.setText(String.valueOf(priceafteroffer)+getText(R.string.realcoin));
        }
        else
        price.setText(productdetailsBean.getProductsizes().get(productSizesAdapter.mSelectedItem).getStart_price() + getText(R.string.realcoin));

     if (Float.valueOf(productdetailsBean.getProductsizes().get(productSizesAdapter.mSelectedItem).getStart_price())<setting.getData().get(0).getShippingPrice())
        {  freecharg = false;
            charege.setText(R.string.charge_rules);
        }

        description.setText(productdetailsBean.getDescription());
        if (productdetailsBean.getTotal_rating() != null) {
            if (productdetailsBean.getTotal_rating().size() > 0) {
                ratecount.setText("(" + productdetailsBean.getTotal_rating().get(0).getCount() + ")");
                ratingBar.setRating(productdetailsBean.getTotal_rating().get(0).getStars() /
                        productdetailsBean.getTotal_rating().get(0).getCount());
            }
        }

        if (productdetailsBean.getFavourites().size() > 0) {
            addToFav.setImageResource(R.drawable.favoried);
            productfav = true;
            favid = productdetailsBean.getFavourites().get(0).getId();
        } else {
            addToFav.setImageResource(R.drawable.like);
            productfav = false;
        }
    }

    public void setImageToImageView(String url) {
        Glide.with(getActivity()).load(url)
                .useAnimationPool(true).placeholder(R.drawable.product).into(item_img);
    }


    private ProductDetailsModelFactory getViewModelFactory() {
        return new ProductDetailsModelFactory(this.getActivity().getApplication(), productid, userid);
    }

}
