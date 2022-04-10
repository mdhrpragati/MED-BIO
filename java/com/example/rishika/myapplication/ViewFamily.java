package com.example.rishika.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;

/**
 * Created by pragati on 3/10/2017.
 */
public class ViewFamily extends AppCompatActivity {
    private DatabaseHelper myDb;
    Cursor res;
    ArrayAdapter<String> adapter;
    ListView lvfamily;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_family);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.ic_keyboard_backspace_black_24dp); // Set the icon

        // Icon click listener
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ViewFamily.this,AddPlants.class);
                startActivity(i);
                finish();
            }
        });

        lvfamily = (ListView) findViewById(R.id.lvfamily);
        myDb = new DatabaseHelper(this);
        myDb.getReadableDatabase();

        ArrayList<String> familylist=new ArrayList<>();
        res = myDb.getAllData();
        if (res.getCount() == 0) {
            // show message
            // showMessage("Error","Nothing found");
            Toast.makeText(ViewFamily.this, "the database is empty ", Toast.LENGTH_LONG).show();
        } else {
            if (res.moveToFirst()) {
                do {

                    familylist.add(res.getString(5));

                } while (res.moveToNext());
            }
        }
        familylist = new ArrayList<String>(new LinkedHashSet<String>(familylist));

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, familylist);
        lvfamily.setAdapter(adapter);

        lvfamily.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent a = new Intent(ViewFamily.this, PlantsInFamily.class);
                a.putExtra("family",lvfamily.getItemAtPosition(i).toString());
                startActivity(a);
                finish();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        getMenuInflater().inflate(R.menu.menu_search, menu);
        final MenuItem item = menu.findItem(R.id.menusearch);
        SearchView searchView = (SearchView) item.getActionView();


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newtext) {
                adapter.getFilter().filter(newtext);
                return true;

            }
        });
        return super.onCreateOptionsMenu(menu);
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

    @Override
    public void onBackPressed() {

        Intent intent_map = new Intent(this, AddActivity.class);
        startActivity(intent_map);
        finish();

    }

}