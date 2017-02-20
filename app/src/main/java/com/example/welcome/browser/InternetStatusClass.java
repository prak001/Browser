package com.example.welcome.browser;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.Snackbar;
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

        ConnectivityManager connectivityManager=(ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();

        View view = View.inflate(context, R.layout.activity_main, null);
        if(networkInfo!=null && networkInfo.isConnected())
        {

            /*Snackbar.make(view.findViewById(R.id.MainLayout),"Connected to Internet",Snackbar.LENGTH_SHORT)
                    .setActionTextColor(Color.WHITE)
                    .show();*/
            Toast.makeText(context,"Connected",Toast.LENGTH_SHORT).show();
        }
        else
        {

            /*Snackbar.make(view.findViewById(R.id.MainLayout),"Check Your Internet Connection",Snackbar.LENGTH_SHORT)
                    .setActionTextColor(Color.RED)
                    .show();*/
            Toast.makeText(context,"Not Connected",Toast.LENGTH_SHORT).show();

        }

    }
}
