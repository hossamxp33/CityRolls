package com.codesroots.osamaomar.shopgate.presentationn.screens.feature.rate;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.codesroots.osamaomar.shopgate.R;
import com.codesroots.osamaomar.shopgate.entities.ProductRate;
import com.codesroots.osamaomar.shopgate.presentationn.screens.feature.rate.adapter.RateAdapter;

import static com.codesroots.osamaomar.shopgate.entities.names.PRODUCT_ID;

public class RateActivity extends AppCompatActivity {


    RecyclerView Allrates;
    TextView Estimate_rate,customer_count,five_count,four_count,third_count,second_count,first_count,count_user_rate,count_rate,user_rates;
    ProgressBar five_progress,four_progress,third_progress,second_progress,firs_progress;
    int productId;
    private RateAdapter RateAdapter;
    RateViewModel rateViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);
        initialize();
        productId = getIntent().getIntExtra(PRODUCT_ID,0);
        rateViewModel = ViewModelProviders.of(this,getViewModelFactory()).get(RateViewModel.class);
        rateViewModel.rateMutableLiveData.observe(this,this::setdatatintoViews);

    }

    private void setdatatintoViews(ProductRate productRate) {
        if (productRate.getData().size()>0) {
            RateAdapter = new RateAdapter(this, productRate.getData().get(0).getProductrates(), productRate.getData().get(0).getName());
            Allrates.setAdapter(RateAdapter);
            if (productRate.getData().get(0).getTotal_rating().size()>0) {
                Estimate_rate.setText(String.valueOf(productRate.getData().get(0).getTotal_rating().get(0).getStars() /
                        productRate.getData().get(0).getTotal_rating().get(0).getCount()));
                customer_count.setText(getText(R.string.from) + " " + productRate.getData().get(0).getTotal_rating().get(0).getCount() + " " + getText(R.string.client));
                count_user_rate.setText("("+ productRate.getData().get(0).getProductrates().size()+")");
                count_rate.setText("("+ productRate.getData().get(0).getProductrates().size()+")");
            }
            else
            {
                Estimate_rate.setText("0");
                customer_count.setText(getText(R.string.from) + " 0 "  + " " + getText(R.string.client));
                user_rates.setVisibility(View.VISIBLE);
            }
        }
    }

    private ViewModelProvider.Factory getViewModelFactory() {
        return new RateViewModelFactory(getApplication(),productId);
    }

    private void initialize() {
        Allrates = findViewById(R.id.rates);
        ///////texts
        Estimate_rate = findViewById(R.id.rate);
        customer_count = findViewById(R.id.counts);
        five_count = findViewById(R.id.five_count);
        four_count = findViewById(R.id.four_count);
        third_count = findViewById(R.id.third_count);
        second_count = findViewById(R.id.second_count);
        first_count = findViewById(R.id.one_count);
        count_user_rate = findViewById(R.id.count_user_rate);
        count_rate = findViewById(R.id.count_rate);
        user_rates = findViewById(R.id.user_rates);
        ///////// progress
        five_progress = findViewById(R.id.five_progress);
        four_progress = findViewById(R.id.four_progress);
        third_progress = findViewById(R.id.third_progress);
        second_progress = findViewById(R.id.second_progress);
        firs_progress = findViewById(R.id.one_progress);

    }
}
