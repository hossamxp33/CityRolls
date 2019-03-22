package com.example.osamaomar.shopgate.presentationn.screens.feature.home.subcategryfragment;

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

import com.example.osamaomar.shopgate.R;
import com.example.osamaomar.shopgate.presentationn.screens.feature.home.mainactivity.MainActivity;
import com.example.osamaomar.shopgate.presentationn.screens.feature.home.subcategryfragment.adapters.MoreSalesProductsAdapter;
import com.example.osamaomar.shopgate.presentationn.screens.feature.home.subcategryfragment.adapters.SubCatsAdapter;

import static com.example.osamaomar.shopgate.entities.names.CAT_ID;
import static com.example.osamaomar.shopgate.entities.names.CAT_NAME;

public class SubcategryFragment extends Fragment {

    private SubCatesViewModel mViewModel;
    RecyclerView subCates,MoreSaleProducts;
    private int catid,userid=2;
    private TextView product_notfound,text;
    private FrameLayout progress;
    private  String categry_name;

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
        ((MainActivity)getActivity()).head_title.setText(categry_name);
        ((MainActivity)getActivity()).logo.setVisibility(View.INVISIBLE);
        mViewModel = ViewModelProviders.of(this,getViewModelFactory()).get(SubCatesViewModel.class);

        mViewModel.subCategriesWithProductsMutableLiveData.observe(this,subCategriesWithProducts ->
                {
                    text.setVisibility(View.VISIBLE);
                    progress.setVisibility(View.GONE);
                    subCates.setAdapter(new SubCatsAdapter(getActivity(),subCategriesWithProducts.getData()));
                    if(subCategriesWithProducts.getProductsbyrate().size()>0)
                    MoreSaleProducts.setAdapter(new MoreSalesProductsAdapter(getActivity(),subCategriesWithProducts.getProductsbyrate(),mViewModel));
                    else
                        product_notfound.setVisibility(View.VISIBLE);
                });

        mViewModel.throwableMutableLiveData.observe(this,throwable ->
                {
                    progress.setVisibility(View.GONE);
                    Snackbar.make(view,throwable.toString(),Snackbar.LENGTH_SHORT).show();
                });

        return  view;
    }

    private SubCatsViewModelFactory getViewModelFactory() {
        return new SubCatsViewModelFactory(this.getActivity().getApplication(),catid,userid
        );
    }

}
