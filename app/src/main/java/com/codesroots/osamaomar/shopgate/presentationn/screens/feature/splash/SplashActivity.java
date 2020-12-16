package com.codesroots.osamaomar.shopgate.presentationn.screens.feature.splash;

import android.content.Intent;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.codesroots.osamaomar.shopgate.R;
import com.codesroots.osamaomar.shopgate.helper.PreferenceHelper;
import com.codesroots.osamaomar.shopgate.helper.ResourceUtil;
import com.codesroots.osamaomar.shopgate.presentationn.screens.feature.country.CountriesActivity;
import com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.mainactivity.MainActivity;

import java.util.Locale;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Log.i("getCurrentLanguage", "onCreateView: "+ Locale.getDefault().getLanguage());

        if (ResourceUtil.getCurrentLanguage(SplashActivity.this).matches("ar"))
            ResourceUtil.changeLang("ar", SplashActivity.this);
        else
            ResourceUtil.changeLang("en", SplashActivity.this);
        new Handler().postDelayed(() -> {

            if (PreferenceHelper.getFirstForCountry())
            {
                Intent mainIntent = new Intent(SplashActivity.this, CountriesActivity.class);
                PreferenceHelper.setFirstForCountry(false);
                startActivity(mainIntent);
                finish();
            }
            else {


                Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(mainIntent);
                finish();
            }
        }, 5000);
    }
}
