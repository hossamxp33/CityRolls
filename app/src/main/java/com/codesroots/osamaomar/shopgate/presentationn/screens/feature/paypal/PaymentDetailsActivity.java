package com.codesroots.osamaomar.shopgate.presentationn.screens.feature.paypal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.codesroots.osamaomar.shopgate.R;

import org.json.JSONObject;

public class PaymentDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_details);

        Intent intent = getIntent();
        try {
            JSONObject jsonObject = new JSONObject(intent.getStringExtra("paymentDetails"));

//
//            Toast.makeText(this,jsonObject.get)
        }
        catch (Exception  e)
        {}
    }
}
