package com.example.rishika.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by pragati on 3/10/2017.
 */
public class PlantsInFamily extends AppCompatActivity {
    private DatabaseHelper myDb;
    Cursor res;
    private Itemlistadapter adapter;
    private List<Item> mProductlist;
    ListView listplantsinfamily;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_plantsinfamily);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_keyboard_backspace_black_24dp); // Set the icon
        // Icon click listener
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PlantsInFamily.this, ViewFamily.class);
                startActivity(i);
                finish();
            }
        });

        Intent i = getIntent();
        String txt = i.getStringExtra("family");

        listplantsinfamily = (ListView) findViewById(R.id.lvplantsinfamily);

        myDb = new DatabaseHelper(this);
        myDb.getReadableDatabase();

        mProductlist = new ArrayList<>();
        adapter = new Itemlistadapter(this, mProductlist);
        listplantsinfamily.setAdapter(adapter);
        res = myDb.getAllData();
        if (res.getCount() == 0) {
            // show message
            // showMessage("Error","Nothing found");
            Toast.makeText(PlantsInFamily.this, "the database is empty ", Toast.LENGTH_LONG).show();
        }
        else {
            if (res.moveToFirst()) {
                do {
                      if (res.getString(5).equals(txt)) {

                          mProductlist.add(new Item(res.getBlob(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6)));
                      }
                } while (res.moveToNext());
            }
            adapter = new Itemlistadapter(getApplicationContext(), mProductlist);
            listplantsinfamily.setAdapter(adapter);
        }

        Comparator<Item> mycomparator = new Comparator<Item>() {
            @Override
            public int compare(Item t1, Item t2) {
                return t1.getBotanicalname().compareTo(t2.getBotanicalname());
            }
        };
        Collections.sort(mProductlist, mycomparator);
        adapter.notifyDataSetChanged();

        listplantsinfamily.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ImageView imageView=(ImageView)view.findViewById(R.id.imgplant);
                TextView botname=(TextView)view.findViewById(R.id.textViewNAME);
                TextView engname=(TextView)view.findViewById(R.id.textViewENGLISH);
                TextView nepname=(TextView)view.findViewById(R.id.textViewNEPALI);
                TextView location1=(TextView)view.findViewById(R.id.textViewLOCATION);
                TextView description1=(TextView)view.findViewById(R.id.textViewDESCRIPTION);
                //    TextView id=(TextView)view.findViewById(R.id.textViewID);

                byte[] im=imageViewToByte(imageView);


                String botanicalname=botname.getText().toString();
                String englishname=engname.getText().toString();
                String nepaliname=nepname.getText().toString();
                String location=location1.getText().toString();
                String description=description1.getText().toString();
                // String id1=id.getText().toString();

                //Passing layout data to DetailActivity
                Intent in=new Intent(getApplicationContext(),DetailActivity.class);
                in.putExtra("imagekey",im);
                in.putExtra("namekey",botanicalname);
                in.putExtra("englishkey",englishname);
                in.putExtra("nepalikey",nepaliname);
                in.putExtra("locationkey",location);
                in.putExtra("descriptionkey",description);
                // in.putExtra("idkey",id1);



                startActivity(in);
                finish();

            }
        });





    }
    private byte[] imageViewToByte(ImageView image) {
        Bitmap bitmap = ((BitmapDrawable)image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
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
                adapter.filter(newtext);
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

        Intent intent_map = new Intent(this, ViewFamily.class);
        startActivity(intent_map);
        finish();

    }

}
