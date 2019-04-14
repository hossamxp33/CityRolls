package com.example.osamaomar.shopgate.presentationn.screens.feature.login;

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
import android.widget.TextView;
import android.widget.Toast;

import com.example.osamaomar.shopgate.R;
import com.example.osamaomar.shopgate.entities.User;
import com.example.osamaomar.shopgate.helper.PreferenceHelper;
import com.example.osamaomar.shopgate.presentationn.screens.feature.home.mainfragment.MainFragment;
import com.example.osamaomar.shopgate.presentationn.screens.feature.register.RegisterFragment;
import com.example.osamaomar.shopgate.presentationn.screens.feature.register.RegisterViewModel;
import com.example.osamaomar.shopgate.presentationn.screens.feature.register.RegisterViewModelFactory;

public class LoginFragment extends Fragment {

    private RegisterViewModel mViewModel;
    TextView loginbtn;
    EditText username,password;
    private User user = new User();
    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    TextView gotoregister;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.login_fragment, container, false);
        mViewModel = ViewModelProviders.of(this,getViewModelFactory()).get(RegisterViewModel.class);

        loginbtn = view.findViewById(R.id.login);
        username = view.findViewById(R.id.username);
        password = view.findViewById(R.id.password);
        loginbtn.setOnClickListener(v -> {
            User user = new User();
            user.setUsername(username.getText().toString());
            user.setPassword(password.getText().toString());
            mViewModel.userLogin(user);
        });

        mViewModel.loginResponseMutableLiveData.observe(this,response ->
                {
                    if (response.isSuccess())
                    {
                        PreferenceHelper.setUserId(response.getData().getId());
                        PreferenceHelper.setUserName(response.getData().getUsername());
                        PreferenceHelper.setToken(response.getData().getToken());
                        Toast.makeText(getActivity(),getText(R.string.hello)+" "+response.getData().getUsername(),Toast.LENGTH_SHORT).show();
                        FragmentManager fm = getActivity().getSupportFragmentManager();
                        for (int i = 0; i < fm.getBackStackEntryCount(); ++i) {
                            fm.popBackStack();
                        }
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.mainfram, new MainFragment()).addToBackStack(null).commit();

                    }
                    else
                        Toast.makeText(getActivity(),getText(R.string.error_tryagani),Toast.LENGTH_SHORT).show();

                });

        mViewModel.errorinRegister.observe(this,throwable ->
                Toast.makeText(getActivity(),throwable.toString(),Toast.LENGTH_SHORT).show() );


        gotoregister = view.findViewById(R.id.gotoregister);
        gotoregister.setOnClickListener(v -> getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.mainfram, new RegisterFragment()).addToBackStack(null).commit());
        return  view;
    }


    @NonNull
    private ViewModelProvider.Factory getViewModelFactory() {
        return new RegisterViewModelFactory(getActivity().getApplication());
    }

}
