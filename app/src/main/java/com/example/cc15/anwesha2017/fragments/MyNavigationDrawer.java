package com.example.cc15.anwesha2017.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;

import com.example.cc15.anwesha2017.R;
import com.example.cc15.anwesha2017.activities.Home;
import com.example.cc15.anwesha2017.activities.Sponsors;
import com.example.cc15.anwesha2017.activities.Team;

public class MyNavigationDrawer implements NavigationView.OnNavigationItemSelectedListener {

    Activity activity;
    public MyNavigationDrawer(Activity activity)
    {
        this.activity = activity;

    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_events) {
            //if(openEvent(activity)) activity.finish();

        } else if (id == R.id.nav_sponsors) {
            openActivity(activity,Sponsors.class);
            activity.finish();
        } else if (id == R.id.nav_gallery) {
            //if(openGallery(activity)) activity.finish();

        } else if (id == R.id.nav_pronites) {
            //if(openPronites(activity)) activity.finish();

        } else if (id == R.id.nav_schedule) {
            //if(openSchedule(activity)) activity.finish();

        } else if (id == R.id.nav_map) {
            //if(openMap(activity)) activity.finish();

        } else if (id == R.id.nav_about) {
            //if(openAbout(activity)) activity.finish();

        } else if (id == R.id.nav_team) {
            openActivity(activity,Team.class);
            activity.finish();
        }

        DrawerLayout drawer = (DrawerLayout) activity.findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    static protected void openActivity(Context context,Class class_name)
    {
        Intent in=new Intent(context,class_name);
        context.startActivity(in);

    }



}

