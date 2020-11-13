package com.codesroots.osamaomar.shopgate.presentationn.screens.feature.splash;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.codesroots.osamaomar.shopgate.R;
import com.codesroots.osamaomar.shopgate.helper.PreferenceHelper;
import com.codesroots.osamaomar.shopgate.helper.ResourceUtil;
import com.codesroots.osamaomar.shopgate.presentationn.screens.feature.country.CountriesActivity;
import com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.mainactivity.MainActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(() -> {

            if (PreferenceHelper.getFirstForCountry())
            {
                Intent mainIntent = new Intent(SplashActivity.this, CountriesActivity.class);
                PreferenceHelper.setFirstForCountry(false);
                startActivity(mainIntent);
                finish();
            }
            else {
                if (ResourceUtil.getCurrentLanguage(SplashActivity.this).matches("ar"))
                    ResourceUtil.changeLang("ar", SplashActivity.this);
                else
                    ResourceUtil.changeLang("en", SplashActivity.this);

                Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(mainIntent);
                finish();
            }
        }, 5000);
    }
}
