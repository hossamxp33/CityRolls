package com.codesroots.osamaomar.shopgate.presentationn.screens.feature.conditions;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.webkit.WebView;
import android.widget.TextView;

import com.codesroots.osamaomar.shopgate.R;

public class ConditionsActivity extends AppCompatActivity {

    TextView condition;
    WebView conditions;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conditions);

      //  condition = findViewById(R.id.conditions);
        conditions = findViewById(R.id.conditions);
        conditions.loadUrl("http://shopgate.codesroots.com/users/termsandconditions");
        conditions.getSettings().setJavaScriptEnabled(true);
        conditions.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    }
}
