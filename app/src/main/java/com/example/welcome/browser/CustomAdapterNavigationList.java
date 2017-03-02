package com.example.welcome.browser;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by welcome on 02-03-2017.
 */

public class CustomAdapterNavigationList extends BaseAdapter{
    Activity context;
    String [] commonNameList;
    String [] commonLinkList;
    int [] commonImagesList;
    WebView webView;
    DrawerLayout drawerLayout;
    /**
     *
     * @param context
     * @param commonNameLIst names of all websites in navigation drawer
     * @param commonLinkList links of all websites in navigation drawer
     * @param commonImagesList images of all websites
     */
    public CustomAdapterNavigationList(DrawerLayout drawerLayout,WebView webView, Activity context, String [] commonNameLIst, String [] commonLinkList, int [] commonImagesList) {
        this.drawerLayout=drawerLayout;
        this.webView=webView;
        this.context=context;
        this.commonNameList=commonNameLIst;
        this.commonLinkList=commonLinkList;
        this.commonImagesList=commonImagesList;

    }
    private class ViewHolder
    {
        ImageView imageViewIcon;
        TextView textViewName;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewholder=new ViewHolder();
        //Inflate view of item for navigation drawer
        LayoutInflater inflater = ( LayoutInflater )context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v=inflater.inflate(R.layout.navigation_item,null);

        viewholder.imageViewIcon =(ImageView)v.findViewById(R.id.navigation_item_image);
        viewholder.textViewName=(TextView)v.findViewById(R.id.navigation_item_text);
        //Set images and text in navigation drawer item
        viewholder.imageViewIcon.setImageResource(commonImagesList[position]);
        viewholder.textViewName.setText(commonNameList[position]);
        //Set click listener for a view and
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Drawer will be closed and url will be called
                
                drawerLayout.closeDrawers();
                webView.loadUrl(commonLinkList[position]);

            }
        });
        return v;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public int getCount() {
        return commonNameList.length;
    }
}
