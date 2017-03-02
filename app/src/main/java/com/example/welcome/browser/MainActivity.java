package com.example.welcome.browser;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Picture;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;

import static android.R.id.progress;

public class MainActivity extends AppCompatActivity {
    ImageView socialImageView;
    ImageView walletImageView;
    ImageView shoppingImageView;
    ImageView googleImageView;
    WebView webView;
    ProgressBar progressBar;
    ImageView moveTopImageView;
    MyWebChromeClient myWebChromeClient;
    MyWebClient myWebClient;
    ListView listView;
    private  String[] shoppingArray;
    private String[] shoppingArrayLinks;
    private  String[] walletArray;
    private String[] walletArrayLinks;
    private  String[] socialArray;
    private String[] socialArrayLinks;
    DrawerLayout drawerLayout;

    //Images of shoipping for navigation drawer
    int []shoppingImages={R.drawable.flipkart,R.drawable.amazon,R.drawable.snapdeal,R.drawable.paytm};
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
        moveTopImageView=(ImageView)findViewById(R.id.move_top_id);
        listView=(ListView)findViewById(R.id.navigation_list);
        drawerLayout=(DrawerLayout)findViewById(R.id.MainLayout);




        //Get arrays from String array resource...
        shoppingArray=this.getResources().getStringArray(R.array.navigation_shopping);
        walletArray=this.getResources().getStringArray(R.array.navigation_wallet);
        socialArray=this.getResources().getStringArray(R.array.navigation_social);


        //webViewClient=new WebViewClient();
        myWebClient=new MyWebClient(getApplicationContext());

        //enable web view client for loading in webview itself
        webView.setWebViewClient(myWebClient);

        //webView.setWebChromeClient(new MyWebChromeClient());
        //myWebChromeClient=new MyWebChromeClient();

        //Handle webSettings for webView
        handleWebSettings();

        //load google page on crating this activity
        webView.loadUrl("http://www.google.co.in");
        //Set click listener for move web page to top
        moveTopImageView.setOnClickListener(moveTopClickListener);
        /**
         * On click listener for
         * Shopping,Wallet,Social,Google
         */
        googleImageView.setOnClickListener(googleClickListener);
        shoppingImageView.setOnClickListener(shoppingClickListener);
        walletImageView.setOnClickListener(walletClickListener);
        socialImageView.setOnClickListener(socialClickListener);

    }
    View.OnClickListener googleClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //load url in web view

            webView.loadUrl("http://www.google.co.in");
        }
    };

    View.OnClickListener moveTopClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            /**
            TODO move to top on button click
            *make a variable true is web page is loaded
             */


        }
    };
    View.OnClickListener shoppingClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //populate shopping in navigation drawer list view
            drawerLayout.openDrawer(Gravity.LEFT);
            shoppingArray = getResources().getStringArray(R.array.navigation_shopping);
            shoppingArrayLinks = getResources().getStringArray(R.array.navigation_shopping_links);
            //Make custom list
            CustomAdapterNavigationList customAdapterNavigationList = new CustomAdapterNavigationList(drawerLayout,webView,
                    MainActivity.this, shoppingArray, shoppingArrayLinks, shoppingImages);
            listView.setAdapter(customAdapterNavigationList);
        }
    };
    View.OnClickListener walletClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };
    View.OnClickListener socialClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };
    public  void handleWebSettings()
    {
        WebSettings webSettings=webView.getSettings();
        webView.getSettings().setJavaScriptEnabled(true);
        //Set zoom on web pages
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDefaultZoom(WebSettings.ZoomDensity.FAR);
        webSettings.setSupportZoom(true);

        webSettings.setPluginState(WebSettings.PluginState.ON_DEMAND);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);


    }

    //Handle back button to back back to previous web page in web view
    @Override
    public void onBackPressed() {
        if(webView!=null)
        {
            if(webView.canGoBack())
            {
                webView.goBack();
                return;
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

