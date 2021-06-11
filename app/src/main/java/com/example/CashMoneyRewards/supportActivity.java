package com.example.CashMoneyRewards;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class supportActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_support );

        webView = (WebView) findViewById( R.id.webview );
        webView.setWebViewClient( new WebViewClient() );
        webView.loadUrl( "https://www.facebook.com/Cashmoneyrewards" );

    WebSettings webSettings = webView.getSettings();
    webSettings.setJavaScriptEnabled(true);
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}