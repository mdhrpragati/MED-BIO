package com.example.rishika.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * Created by pragati on 1/19/2017.
 */

public class ViewPlants extends AppCompatActivity {
    private DatabaseHelper myDb;
    Cursor res;
    private Itemlistadapter adapter;
    private List<Item> mProductlist;
    ListView listView;
    /*
    private SQLiteDatabase mDatabase;
    SQLiteListAdapter ListAdapter ;
    ArrayList<String> uid = new ArrayList<String>();
    ArrayList<String> botanicalname = new ArrayList<String>();
    ArrayList<String> englishname = new ArrayList<String>();
    ArrayList<String> nepaliname = new ArrayList<String>();
    ArrayList<String> location = new ArrayList<String>();
    ArrayList<String> description = new ArrayList<String>();
    */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_plants);

        //Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Back arrow in toolbar
        toolbar.setNavigationIcon(R.drawable.ic_keyboard_backspace_black_24dp); // Set the icon

        // Icon click listener
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ViewPlants.this,AddPlants.class);
                startActivity(i);
                finish();
            }
        });


        listView = (ListView) findViewById(R.id.display_listview);


        mProductlist = new ArrayList<>();
        adapter = new Itemlistadapter(this, mProductlist);
        listView.setAdapter(adapter);

        myDb = new DatabaseHelper(this);
        myDb.getReadableDatabase();
        res = myDb.getAllData();
        if (res.getCount() == 0) {
            // show message
            // showMessage("Error","Nothing found");
            Toast.makeText(ViewPlants.this, "the database is empty ", Toast.LENGTH_LONG).show();
        } else {
            if (res.moveToFirst()) {
                do {
                    mProductlist.add(new Item(res.getBlob(1),res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6)));

                } while (res.moveToNext());
            }
            adapter = new Itemlistadapter(getApplicationContext(), mProductlist);
            listView.setAdapter(adapter);
        }

        //To click items in listview
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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

                //Transfer data in listview item to DetailActivity.class
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

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                new AlertDialog.Builder( ViewPlants.this )
                        .setTitle( "do you want to delete" )
                        .setPositiveButton( "Delete", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                TextView botname=(TextView)findViewById(R.id.textViewNAME);
                                String nam=botname.getText().toString();
                                Integer deletedRows = myDb.deleteData(nam);
                                if(deletedRows > 0)
                                    Toast.makeText(ViewPlants.this,"Data Deleted",Toast.LENGTH_LONG).show();
                                else
                                    Toast.makeText(ViewPlants.this,"Data not Deleted",Toast.LENGTH_LONG).show();
                                Intent intent=new Intent(ViewPlants.this,ViewPlants.class);
                                startActivity(intent);
                                finish();
                            }
                        })
                .setNegativeButton( "Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d( "AlertDialog", "Negative" );
                    }
                } )
                        .show();

                return true;
            }
        });


        Comparator<Item> mycomparator = new Comparator<Item>() {
            @Override
            public int compare(Item t1, Item t2) {
                return t1.getBotanicalname().compareTo(t2.getBotanicalname());
            }
        };
        Collections.sort(mProductlist, mycomparator);
        adapter.notifyDataSetChanged();

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

        Intent intent_map = new Intent(this, AddActivity.class);
        startActivity(intent_map);
        finish();

    }



}

   /*


   @Override
      public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_plants);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = (ListView) findViewById(R.id.display_listview);

         myDb = new DatabaseHelper(this);
    }

    @Override
         protected void onResume() {

            ShowSQLiteDBdata() ;

            super.onResume();
    }


       private void ShowSQLiteDBdata() {

            myDb.getReadableDatabase();
            mDatabase = myDb.getWritableDatabase();

            Cursor cursor = mDatabase.rawQuery("SELECT * FROM st_table", null);
            //Cursor cursor = myDb.getAllData();
            uid.clear();
            botanicalname.clear();
            englishname.clear();
            nepaliname.clear();
            location.clear();
            description.clear();
            if (cursor.getCount() == 0) {
                show message
                showMessage("Error","Nothing found");
                Toast.makeText(ViewPlants.this, "the database is empty ", Toast.LENGTH_LONG).show();
            }


            if (cursor.moveToFirst()) {
                do {
                    uid.add(cursor.getString(cursor.getColumnIndex(DatabaseHelper.col_1)));
                    botanicalname.add(cursor.getString(cursor.getColumnIndex(DatabaseHelper.col_2)));

                    englishname.add(cursor.getString(cursor.getColumnIndex(DatabaseHelper.col_3)));
                    nepaliname.add(cursor.getString(cursor.getColumnIndex(DatabaseHelper.col_4)));

                    location.add(cursor.getString(cursor.getColumnIndex(DatabaseHelper.col_5)));
                    description.add(cursor.getString(cursor.getColumnIndex(DatabaseHelper.col_6)));


                } while (cursor.moveToNext());
            }

            ListAdapter = new SQLiteListAdapter(ViewPlants.this,

                 uid,  botanicalname,englishname,nepaliname,location,description
            );

            listView.setAdapter(ListAdapter);

            cursor.close();
        }


        StringBuffer buffer=new StringBuffer();
            while(res.moveToNext()){
                buffer.append("Id:"+ res.getString(0)+"\n");
                buffer.append("Botanical Name:"+ res.getString(1)+"\n");
                buffer.append("English Name:"+ res.getString(2)+"\n");
                buffer.append("Nepali Name:"+ res.getString(3)+"\n ");
                buffer.append("Location:"+ res.getString(4)+"\n ");
                buffer.append("Description:"+ res.getString(5)+"\n\n ");
        }

             showMessage("Data",buffer.toString());


          */






