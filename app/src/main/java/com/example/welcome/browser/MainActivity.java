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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("klkl","jkjkjkj");

        InternetStatusClass internetStatusClass=new InternetStatusClass();
        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE" );
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        registerReceiver(internetStatusClass,intentFilter);
        Log.i("nnjn","saddsd");
    }

    @Override
    protected void onStart() {
        super.onStart();

    }
}
