package com.codesroots.osamaomar.shopgate.presentationn.screens.feature.register;

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

import com.codesroots.osamaomar.shopgate.R;
import com.codesroots.osamaomar.shopgate.entities.User;
import com.codesroots.osamaomar.shopgate.helper.PreferenceHelper;
import com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.mainfragment.MainFragment;

public class RegisterFragment extends Fragment {

    private RegisterViewModel mViewModel;

    TextView registerbtn;
    EditText username,password,repassword,phone,mail;
    private User user = new User();
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = ViewModelProviders.of(this,getViewModelFactory()).get(RegisterViewModel.class);

        View  view = inflater.inflate(R.layout.register_fragment, container, false);
        username = view.findViewById(R.id.username);
        password = view.findViewById(R.id.password);
        repassword = view.findViewById(R.id.repassword);
        phone = view.findViewById(R.id.phone);
        mail = view.findViewById(R.id.mail);
        registerbtn = view.findViewById(R.id.register);
        registerbtn.setOnClickListener(v -> {
            User  user = new User();
            user.setUsername(username.getText().toString());
            user.setPassword(password.getText().toString());
            user.setRepassword(repassword.getText().toString());
            user.setMobile(phone.getText().toString());
            user.setMail(mail.getText().toString());
            mViewModel.addUser(user);
            registerbtn.setText(R.string.wait);
            registerbtn.setEnabled(false);
        });

        mViewModel.errorMessage.observe(this,s ->
                {
                    registerbtn.setEnabled(true);
                    registerbtn.setText(R.string.register);
                    Toast.makeText(getActivity(),s,Toast.LENGTH_SHORT).show();
                }
               );

        mViewModel.registerMutableLiveData.observe(this,register ->
                {
                    registerbtn.setEnabled(true);
                    registerbtn.setText(R.string.register);
                 if (register.isSuccess()) {
                     PreferenceHelper.setUserId(register.getData().getId());
                     PreferenceHelper.setUserName(register.getData().getUsername());
                     PreferenceHelper.setToken(register.getData().getToken());
                     Toast.makeText(getActivity(),getText(R.string.registersuccess),Toast.LENGTH_SHORT).show();
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
                        {
                            registerbtn.setEnabled(true);
                            registerbtn.setText(R.string.register);
                            Toast.makeText(getActivity(),throwable.toString(),Toast.LENGTH_SHORT).show();
                        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // TODO: Use the ViewModel
    }

    @NonNull
    private ViewModelProvider.Factory getViewModelFactory() {
        return new RegisterViewModelFactory(getActivity().getApplication());
    }

}
