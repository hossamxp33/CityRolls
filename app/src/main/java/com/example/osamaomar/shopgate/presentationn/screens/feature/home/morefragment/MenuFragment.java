package com.example.osamaomar.shopgate.presentationn.screens.feature.home.morefragment;

import android.app.AlertDialog;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.osamaomar.shopgate.R;
import com.example.osamaomar.shopgate.entities.Currency;
import com.example.osamaomar.shopgate.helper.PreferenceHelper;
import com.example.osamaomar.shopgate.presentationn.screens.feature.home.mainfragment.MainFragment;
import com.example.osamaomar.shopgate.presentationn.screens.feature.home.productdetailsfragment.ProductDetailsModelFactory;
import com.example.osamaomar.shopgate.presentationn.screens.feature.login.LoginFragment;

import java.util.ArrayList;
import java.util.List;

public class MenuFragment extends Fragment {

    private MenuViewModel mViewModel;
    private TextView currency, lang,login;
    private List<Currency.DataBean> dataBeanList = new ArrayList<>();
    public static MenuFragment newInstance() {
        return new MenuFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.menu_fragment, container, false);
        mViewModel = ViewModelProviders.of(this,getViewModelFactory()).get(MenuViewModel.class);
        currency = view.findViewById(R.id.currency);
        login = view.findViewById(R.id.login);
        currency.setOnClickListener(v -> mViewModel.getCurrencyData());
        login.setOnClickListener(v -> getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.mainfram,new LoginFragment()).addToBackStack(null).commit());
        mViewModel.currencyMutableLiveData.observe(this,currency1 ->
                {
                    dataBeanList = currency1.getData();
                    showDialog(dataBeanList);
                });

        return view;
    }

    private void showDialog(List<Currency.DataBean> dataBeanList) {
        AlertDialog.Builder builderSingle = new AlertDialog.Builder(getActivity());
        builderSingle.setTitle("Select One Name:-");

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.select_dialog_singlechoice);
        for (int i=0;i<dataBeanList.size();i++)
            arrayAdapter.add(dataBeanList.get(i).getName());
        builderSingle.setNegativeButton("cancel", (dialog, which) -> dialog.dismiss());
        builderSingle.setAdapter(arrayAdapter, (dialog, which) -> {
            String strName = arrayAdapter.getItem(which);
            AlertDialog.Builder builderInner = new AlertDialog.Builder(getActivity());
            builderInner.setMessage(strName);
            PreferenceHelper.setCURRENCY(dataBeanList.get(which).getName());
            PreferenceHelper.setCURRENCYArabic(dataBeanList.get(which).getName_ar());
            PreferenceHelper.setCURRENCY_VALUE(dataBeanList.get(which).getValue());
            builderInner.setTitle("Your Selected Item is");
            builderInner.setPositiveButton("Ok", (dialog1, which1) -> dialog1.dismiss());
            builderInner.show();

            FragmentManager fm = getActivity().getSupportFragmentManager();
            for(int i = 0; i < fm.getBackStackEntryCount(); ++i) {
                fm.popBackStack();
            }

            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.mainfram,new MainFragment()).addToBackStack(null).commit();

        });
        builderSingle.show();
    }


    private ProductDetailsModelFactory getViewModelFactory() {
        return new ProductDetailsModelFactory(this.getActivity().getApplication());
    }

}
