package com.example.welcome.browser;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by welcome on 20-02-2017.
 */
public class InternetStatusClass extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        //Connectivity manager for handling internet connectivity changes
        ConnectivityManager connectivityManager=(ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();

        //If network if not null and conected
        if(networkInfo!=null && networkInfo.isConnected())
        {
            //Toast.makeText(context,"Connected",Toast.LENGTH_SHORT).show();
        }
        else
        {
            //Toast.makeText(context,"Not Connected",Toast.LENGTH_SHORT).show();

        }

    }
}
