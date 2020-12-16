package com.codesroots.osamaomar.shopgate.presentationn.screens.feature.contact;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.codesroots.osamaomar.shopgate.R;
import com.codesroots.osamaomar.shopgate.helper.ResourceUtil;
import com.codesroots.osamaomar.shopgate.presentationn.screens.feature.register.RegisterViewModel;
import com.codesroots.osamaomar.shopgate.presentationn.screens.feature.register.RegisterViewModelFactory;

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

        whats.setOnClickListener(v -> ResourceUtil.openWhatsApp("+07735588559",getContext(),getActivity()));
        phone1.setOnClickListener(v -> ResourceUtil.callNumber("+07735588559",getContext()));
        phone2.setOnClickListener(v -> ResourceUtil.callNumber("+07735588559",getContext()));
        insta.setOnClickListener(v ->
                {
                    String url = "https://instagram.com/alajwadshopp_iq";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                });

        mViewModel = ViewModelProviders.of(this, getViewModelFactory()).get(RegisterViewModel.class);
        return view;
    }

    @NonNull
    private ViewModelProvider.Factory getViewModelFactory() {
        return new RegisterViewModelFactory(getActivity().getApplication());
    }

}
