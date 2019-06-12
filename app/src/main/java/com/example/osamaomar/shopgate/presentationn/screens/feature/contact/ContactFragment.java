package com.example.osamaomar.shopgate.presentationn.screens.feature.contact;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.osamaomar.shopgate.R;
import com.example.osamaomar.shopgate.entities.User;
import com.example.osamaomar.shopgate.helper.PreferenceHelper;
import com.example.osamaomar.shopgate.helper.ResourceUtil;
import com.example.osamaomar.shopgate.presentationn.screens.feature.home.mainfragment.MainFragment;
import com.example.osamaomar.shopgate.presentationn.screens.feature.register.RegisterFragment;
import com.example.osamaomar.shopgate.presentationn.screens.feature.register.RegisterViewModel;
import com.example.osamaomar.shopgate.presentationn.screens.feature.register.RegisterViewModelFactory;

public class ContactFragment extends Fragment {

    private RegisterViewModel mViewModel;
    TextView phone1,phone2,mail;
    ImageView whats,insta;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contact_fragment, container, false);

        phone1 = view.findViewById(R.id.phone1);
        phone2 = view.findViewById(R.id.phone2);
        mail = view.findViewById(R.id.mail);
        insta = view.findViewById(R.id.insta);
        whats = view.findViewById(R.id.whats);

        whats.setOnClickListener(v -> ResourceUtil.openWhatsApp("168484",getContext()));
        phone1.setOnClickListener(v -> ResourceUtil.callNumber("+96898075581",getContext()));
        phone2.setOnClickListener(v -> ResourceUtil.callNumber("+9689418519",getContext()));

        mViewModel = ViewModelProviders.of(this, getViewModelFactory()).get(RegisterViewModel.class);
        return view;
    }

    @NonNull
    private ViewModelProvider.Factory getViewModelFactory() {
        return new RegisterViewModelFactory(getActivity().getApplication());
    }

}
