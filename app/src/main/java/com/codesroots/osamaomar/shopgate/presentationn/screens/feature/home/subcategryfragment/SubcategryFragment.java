package com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.subcategryfragment;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.codesroots.osamaomar.shopgate.R;
import com.codesroots.osamaomar.shopgate.entities.SubCategriesWithProducts;
import com.codesroots.osamaomar.shopgate.helper.PreferenceHelper;
import com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.mainactivity.MainActivity;
import com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.subcategryfragment.adapters.MoreSalesProductsAdapter;
import com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.subcategryfragment.adapters.SubCatsAdapter;

import java.util.List;

import static com.codesroots.osamaomar.shopgate.entities.names.CAT_ID;
import static com.codesroots.osamaomar.shopgate.entities.names.CAT_NAME;

public class SubcategryFragment extends Fragment {

    private SubCatesViewModel mViewModel;
    RecyclerView subCates,MoreSaleProducts;
    private int catid,userid= PreferenceHelper.getUserId();
    private TextView product_notfound,text;
    private FrameLayout progress;
    private MoreSalesProductsAdapter moreSalesProductsAdapter;
    private  String categry_name;
    private List<SubCategriesWithProducts.ProductsbyrateBean> productsData;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.subcategry_fragment, container, false);
        subCates = view.findViewById(R.id.subcategry_Rec);
        product_notfound = view.findViewById(R.id.product_notfound);
        MoreSaleProducts = view.findViewById(R.id.product_Rec);
        progress = view.findViewById(R.id.progress);
        text = view.findViewById(R.id.text);
        catid = getArguments().getInt(CAT_ID,0);
        categry_name = getArguments().getString(CAT_NAME);
   //     ((MainActivity)getActivity()).head_title.setText(categry_name);
        ((MainActivity)getActivity()).logo.setVisibility(View.VISIBLE);
        mViewModel = ViewModelProviders.of(this,getViewModelFactory()).get(SubCatesViewModel.class);

        mViewModel.subCategriesWithProductsMutableLiveData.observe(this,subCategriesWithProducts ->
                {
                    text.setVisibility(View.VISIBLE);
                    progress.setVisibility(View.GONE);
                    subCates.setAdapter(new SubCatsAdapter(getActivity(),subCategriesWithProducts.getData()));
                    if(subCategriesWithProducts.getProductsbyrate().size()>0) {
                        moreSalesProductsAdapter = new MoreSalesProductsAdapter(getActivity(), subCategriesWithProducts.getProductsbyrate(), mViewModel);
                        productsData = subCategriesWithProducts.getProductsbyrate();
                        MoreSaleProducts.setAdapter(moreSalesProductsAdapter);
                    }
                    else
                        product_notfound.setVisibility(View.VISIBLE);
                });

        mViewModel.throwableMutableLiveData.observe(this,throwable ->
                {
                    progress.setVisibility(View.GONE);
                    Snackbar.make(view,throwable.toString(),Snackbar.LENGTH_SHORT).show();
                });

        mViewModel.addToFavMutableLiveData.observe(this, addToFavModel -> {
            productsData.get(mViewModel.current_item).getProduct()
                    .getFavourites().add(new SubCategriesWithProducts.ProductsbyrateBean.ProductBean.FavouritesBean(addToFavModel.getLikeid()));
            moreSalesProductsAdapter.notifyItemChanged(mViewModel.current_item);
        });

        mViewModel.deleteToFavMutableLiveData.observe(this, aBoolean -> {
            productsData.get(mViewModel.current_item).getProduct()
                    .getFavourites().clear();
            moreSalesProductsAdapter.notifyDataSetChanged();
        });
        return  view;
    }

    private SubCatsViewModelFactory getViewModelFactory() {
        return new SubCatsViewModelFactory(this.getActivity().getApplication(),catid,userid
        );
    }

}
