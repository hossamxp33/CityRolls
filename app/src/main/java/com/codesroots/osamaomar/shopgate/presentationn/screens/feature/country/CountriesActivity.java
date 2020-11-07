package com.codesroots.osamaomar.shopgate.presentationn.screens.feature.country;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.codesroots.osamaomar.shopgate.R;
import com.codesroots.osamaomar.shopgate.entities.Countries;
import com.codesroots.osamaomar.shopgate.helper.PreferenceHelper;
import com.codesroots.osamaomar.shopgate.helper.ResourceUtil;
import com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.mainactivity.MainActivity;
import com.codesroots.osamaomar.shopgate.presentationn.screens.feature.splash.SplashActivity;

import java.util.ArrayList;
import java.util.List;

public class CountriesActivity extends AppCompatActivity {

    CountryViewModel mViewModel;
    List<Countries.DataBean>countries = new ArrayList<>();
    TextView country,done;
    ImageView next,prev;
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries);
        country = findViewById(R.id.country);
        next = findViewById(R.id.next);
        prev = findViewById(R.id.prev);
        done = findViewById(R.id.done);

        mViewModel = ViewModelProviders.of(this,getViewModelFactory()).get(CountryViewModel.class);

        mViewModel.countriesMutableLiveData.observe(this,data ->{
            if (data.getData()!=null)
            countries=data.getData();
            if (countries.size()>0) {
                next.setEnabled(true);
                prev.setEnabled(true);
                country.setText(countries.get(index).getName());
            }
        });

        prev.setOnClickListener(v -> {
            index-=1;
            if (index>=0)
                country.setText(countries.get(index).getName());
            else
                index=0;
        });


        done.setOnClickListener(v -> {
            PreferenceHelper.setCountryId(countries.get(index).getId());
            if (ResourceUtil.getCurrentLanguage(CountriesActivity.this).matches("ar"))
                    ResourceUtil.changeLang("ar", CountriesActivity.this);
                else
                    ResourceUtil.changeLang("en", CountriesActivity.this);

                Intent mainIntent = new Intent(CountriesActivity.this, MainActivity.class);
                startActivity(mainIntent);
                finish();
        });

        next.setOnClickListener(v -> {
            index+=1;
            if (index<=countries.size()-1)
                country.setText(countries.get(index).getName());
            else
                index=countries.size()-1;
        });

        mViewModel.throwableMutableLiveData.observe(this,throwable ->
                Toast.makeText(CountriesActivity.this,R.string.error,Toast.LENGTH_SHORT).show());
    }

    private CountryModelFactory getViewModelFactory() {
        return new CountryModelFactory(getApplication());
    }

}
