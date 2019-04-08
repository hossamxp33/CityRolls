package com.example.osamaomar.shopgate.presentationn.screens.feature.login;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.osamaomar.shopgate.R;
import com.example.osamaomar.shopgate.presentationn.screens.feature.register.RegisterFragment;

public class LoginFragment extends Fragment {

    private AuthenticationViewModel mViewModel;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    TextView gotoregister;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.login_fragment, container, false);

        gotoregister = view.findViewById(R.id.gotoregister);
        gotoregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.mainfram, new RegisterFragment()).addToBackStack(null).commit();

            }
        });
        return  view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(AuthenticationViewModel.class);
        // TODO: Use the ViewModel
    }

}
