package com.example.cc15.anwesha2017.activities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.cc15.anwesha2017.R;
import com.example.cc15.anwesha2017.adapters.HomeMenuCustomAdapter;
import com.example.cc15.anwesha2017.fragments.MyNavigationDrawer;

import java.util.ArrayList;

public class Home extends AppCompatActivity {
    ListView lv;
    Context context;
    ArrayList prgmName;
    public static int [] menuImages={R.drawable.about, R.drawable.events, R.drawable.pronites, R.drawable.schedule, R.drawable.team};
    public static String [] menuNameList={"ABOUT","EVENTS","PRONITES","SCHEDULE","TEAM"};
    HomeMenuCustomAdapter cd;
    HomeMenuCustomAdapter.Holder h;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new MyNavigationDrawer(this));



        lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(new HomeMenuCustomAdapter(this, menuNameList, menuImages));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                // In the following line "v" refers to the View returned by the `getView()` method; meaning the clicked View.
                //TextView txtName = (TextView) v.findViewById(R.id.textView1);
                //String name = txtName.getText().toString();
                switch (position) {
                    case 0:
                        Intent intent = new Intent(Home.this, About.class);
                        startActivity(intent);
                        break;

                    case 1:
                        Intent intent2 = new Intent(Home.this, EventsCategory.class);
                        startActivity(intent2);
                        break;

                    case 4:
                        Intent intent1 = new Intent(Home.this, Team.class);
                        startActivity(intent1);
                        break;
                    /*case "nameTwo":
                        Intent intent = new Intent(YourCurrentActivity.this, NameTwoActivity.class);
                        startActivity(intent);
                        break;*/

                    //And so on and so forth....
                }

            }
        });
        findViewById(R.id.fb_image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getOpenFacebookPage();
            }
        });
        findViewById(R.id.gp_image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getOpenGooglePPage();
            }
        });
        findViewById(R.id.website).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("http://2016.anwesha.info"));
                startActivity(i);
            }
        });
    }
    void getOpenFacebookPage()
    {

        Intent in;
        try {
            in = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/163423960356924"));
            startActivity(in);
        } catch (Exception e) {
            in = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/anwesha.iitpatna"));
            startActivity(in);
        }

    }
    void getOpenGooglePPage()
    {

        Intent in;
        try {
            in = new Intent(Intent.ACTION_VIEW, Uri.parse("android-app://com.google.android.apps.plus/https/plus.google.com/+iitpatna"));
            in.setPackage("com.google.android.apps.plus");
            startActivity(in);

        } catch (Exception e) {
            in = new Intent(Intent.ACTION_VIEW, Uri.parse("https://plus.google.com/+iitpatna"));
            startActivity(in);
        }


    }




    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




    }

