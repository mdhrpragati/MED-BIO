package com.example.rishika.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * Created by pragati on 3/10/2017.
 */
public class AddPlants  extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
        Button buttonadd,buttonview,buttonviewfamily;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addplants1);

        //Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Floating Action Button

        //Drawer Layout
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        //Navigation View
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //button with their respective id from layout
        buttonadd=(Button)findViewById(R.id.buttonadd);
        buttonview=(Button)findViewById(R.id.buttonview);
        buttonviewfamily=(Button)findViewById(R.id.buttonviewfamily);

        //call AddActivity.class when Add Plants button is clicked
        buttonadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent add=new Intent(AddPlants.this,AddActivity.class);
                startActivity(add);
                finish();
            }
        });

        //call ViewPlants.class when View Plants button is clicked
        buttonview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewplant=new Intent(AddPlants.this,ViewPlants.class);
                startActivity(viewplant);
                finish();
            }
        });

        //call ViewFamily.class when View Family button is clicked
        buttonviewfamily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewfamily=new Intent(AddPlants.this,ViewFamily.class);
                startActivity(viewfamily);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
            finish();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent home_intent = new Intent(this, MainActivity.class);
            startActivity(home_intent);
            finish();

        } else if (id == R.id.nav_medicinalplants) {
            Intent medicinalplants_intent = new Intent(this, MedicinalPlants.class);
            startActivity(medicinalplants_intent);
            finish();

        } else if (id == R.id.nav_addplants) {
            Intent family_intent = new Intent(this, AddPlants.class);
            startActivity(family_intent);
            finish();

        } else if (id == R.id.nav_family) {
            Intent family_intent = new Intent(this, Family.class);
            startActivity(family_intent);
            finish();


        } else if (id == R.id.nav_aboutus) {
            Intent aboutus_intent = new Intent(this, AboutUs.class);
            startActivity(aboutus_intent);
            finish();


        } else  if (id == R.id.nav_share) {

            String sharebody="This is great App,you should try it out";
            Intent shareintent=new Intent(Intent.ACTION_SEND);
            shareintent.setType("text/plain");
            shareintent.putExtra(android.content.Intent.EXTRA_SUBJECT,"My App");
            shareintent.putExtra(android.content.Intent.EXTRA_TEXT,sharebody);
            startActivity(Intent.createChooser(shareintent,"Share via"));
            finish();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
