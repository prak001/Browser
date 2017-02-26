package com.example.welcome.browser;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

/**
 * Created by welcome on 24-02-2017.
 */

public class MyWebClient extends WebViewClient {
    public  static  Context context;
    public MyWebClient(Context c) {
        context=c;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {

        handleZoomInWebView(view);
        /**
         * Check if link clicked in webview is a pdf
         * If pdf append google doc services
         * will open in pdf reader if installed any
         */
        if(url.endsWith("pdf"))
        {
            try {
                String pdf = url;
                Log.i("pdfpdf",url);
                Toast.makeText(context,"Download is in progress",Toast.LENGTH_SHORT).show();
                view.loadUrl(String.format("http://docs.google.com/viewer?url=%s", url));
            }
            catch (ActivityNotFoundException e)
            {
                Toast.makeText(context,"No Pdf Viewer Installed",Toast.LENGTH_LONG).show();
            }
        }
        else
        {
            Log.i("pdfrtrtrtf",url);
            view.loadUrl(url);
        }
        return true;
    }
    /*
    TO:DO handling zoom effects on all web pages
     */
    public void handleZoomInWebView(WebView webView)
    {
        WebSettings webSettings=webView.getSettings();
        //Enable javascipt
        webSettings.setJavaScriptEnabled(true);
        //Set zoom on all wep pages in webview
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDefaultZoom(WebSettings.ZoomDensity.FAR);
        webSettings.setSupportZoom(true);
        //SET caching in webview
        webSettings.setAppCacheEnabled(true);
        webSettings.setAppCacheMaxSize(1024*1024*8);
        webSettings.setAppCachePath(context.getCacheDir().getPath());
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
        //I dont know working of these
        webSettings.setPluginState(WebSettings.PluginState.ON_DEMAND);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);

    }

}