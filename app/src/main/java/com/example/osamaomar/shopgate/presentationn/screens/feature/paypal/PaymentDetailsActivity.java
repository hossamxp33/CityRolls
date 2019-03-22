package com.example.osamaomar.shopgate.presentationn.screens.feature.paypal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.osamaomar.shopgate.R;
import com.google.gson.JsonObject;

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
