package com.codesroots.osamaomar.cityrolls.presentationn.screens.feature.aboutus;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.codesroots.osamaomar.cityrolls.R;

public class contactus extends AppCompatActivity {

    WebView webView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus);

        webView = findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://shopgate.codesroots.com/aboutus");
    }
}
