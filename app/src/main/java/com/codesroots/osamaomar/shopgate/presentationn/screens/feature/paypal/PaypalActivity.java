package com.codesroots.osamaomar.shopgate.presentationn.screens.feature.paypal;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.codesroots.osamaomar.shopgate.R;
import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;

import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;

public class PaypalActivity extends AppCompatActivity {

    private static final  int PAYPAL_REQUEST_CODE = 7171;
    private static PayPalConfiguration configuration = new PayPalConfiguration()
            .environment(PayPalConfiguration.ENVIRONMENT_SANDBOX)
            .clientId(Config.PAYPAL_CLIENT_ID);
    String amount = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paypal);
     //   getActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = new Intent(this,PayPalService.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION,configuration);
        startService(intent);
    }

    private void processpayment()
    {
        PayPalPayment payPalPayment = new PayPalPayment(new BigDecimal(String.valueOf(5)),"USD","oman",PayPalPayment.PAYMENT_INTENT_SALE);
        Intent intent = new Intent(this, PaymentActivity.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION,configuration);
        intent.putExtra(PaymentActivity.EXTRA_PAYMENT,payPalPayment);
        startActivityForResult(intent,PAYPAL_REQUEST_CODE);
    }

    public void payment(View view) {
        processpayment();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
               // NavUtils.navigateUpFromSameTask(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == PAYPAL_REQUEST_CODE)
        {
            if (resultCode == RESULT_OK)
            {
                PaymentConfirmation payPalConfiguration  = data.getParcelableExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION);
                if (payPalConfiguration!=null)
                {
                    try {
                        JSONObject jsonObject = payPalConfiguration.toJSONObject();
                        String state = jsonObject.getJSONObject("response").getString("state");
                        Toast.makeText(this,state,Toast.LENGTH_SHORT).show();
                    }
                    catch (JSONException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
            else if (requestCode == Activity.RESULT_CANCELED)
                Toast.makeText(this,"Cancel",Toast.LENGTH_SHORT).show();

        } else if (resultCode == PaymentActivity.RESULT_EXTRAS_INVALID)
            Toast.makeText(this,"Invalid",Toast.LENGTH_SHORT).show();

        super.onActivityResult(requestCode, resultCode, data);
    }
}
