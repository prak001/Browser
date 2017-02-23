package com.example.welcome.browser;

import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView socialImageView;
    ImageView walletImageView;
    ImageView shoppingImageView;
    ImageView googleImageView;
    WebView webView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inflate Views of
        socialImageView=(ImageView)findViewById(R.id.social_id);
        walletImageView=(ImageView)findViewById(R.id.wallet_id);
        shoppingImageView=(ImageView)findViewById(R.id.shopping_id);
        googleImageView=(ImageView)findViewById(R.id.google_id);
        webView=(WebView)findViewById(R.id.webViewId);

        //enable web view client for loading in webview itself
        webView.setWebViewClient(new WebViewClient());

        //Handle webSettings for webView
        handleWebSettings();

        //load google page on crating this activity
        webView.loadUrl("http://www.google.co.in");

        //Set on Click listener for google imageview
        googleImageView.setOnClickListener(googleClickListener);

    }
    View.OnClickListener googleClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //load url in web view
            webView.loadUrl("http://www.google.co.in");
        }
    };
    public  void handleWebSettings()
    {
        WebSettings webSettings=webView.getSettings();
        webView.getSettings().setJavaScriptEnabled(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setPluginState(WebSettings.PluginState.ON_DEMAND);
        webSettings.setSupportZoom(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setDomStorageEnabled(true);
    }
    //Handle back button to back back to previous web page in web view
    @Override
    public void onBackPressed() {
        if(webView!=null)
        {
            if(webView.canGoBack())
            {
                webView.goBack();
            }
        }
        super.onBackPressed();
    }
    @Override
    protected void onResume() {
        super.onResume();
        InternetStatusClass internetStatusClass=new InternetStatusClass();
        /**
         * Register broadcast reciver for
         * connectivity change
         * wifi status change
         */
        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE" );
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        registerReceiver(internetStatusClass,intentFilter);

    }

    @Override
    protected void onStart() {
        super.onStart();

    }
}
