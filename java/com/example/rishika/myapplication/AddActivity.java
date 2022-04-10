package com.example.rishika.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

import static com.example.rishika.myapplication.R.id.textView;
import static java.sql.Types.NULL;

public class AddActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    AutoCompleteTextView botanicalname, editfamily;
    EditText englishname, nepaliname, location, description;
    Button btnadddata,btnviewall, btnChoose;
    Boolean CheckEditTextEmpty, Checkpresent;
    ImageView imageView;

    final int REQUEST_CODE_GALLERY = 999;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addplants);

        //Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //set back arrow in toolbar
        toolbar.setNavigationIcon(R.drawable.ic_keyboard_backspace_black_24dp); // Set the icon

        // Icon click listener
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AddActivity.this, AddPlants.class);
                startActivity(i);
                finish();
            }
        });


        //DatabaseHelper.java
        myDb = new DatabaseHelper(this);

        //Edittext and autocompletetextview with their respective id from layout
        botanicalname = (AutoCompleteTextView) findViewById(R.id.botanicalname);
        englishname = (EditText) findViewById(R.id.englishname);
        nepaliname = (EditText) findViewById(R.id.nepaliname);
        editfamily = (AutoCompleteTextView) findViewById(R.id.editfamily);
        description = (EditText) findViewById(R.id.description);
        imageView = (ImageView) findViewById(R.id.imageView);

        //Adding dictionary for autotextview for botanicalname
        String[] countries = getResources().getStringArray(R.array.countries_array);
        ArrayAdapter<String> adapterbotname =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries);
        botanicalname.setAdapter(adapterbotname);

        //Adding dictionary for autotextview for family
        String[] family = getResources().getStringArray(R.array.family_array);
        ArrayAdapter<String> adapterfamily =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, family);
        editfamily.setAdapter(adapterfamily);

        btnChoose = (Button) findViewById(R.id.btnChoose);


        //buttons with their respective id from layout
        btnadddata = (Button) findViewById(R.id.button_add);
        btnviewall=(Button)findViewById(R.id.button_view);

        //Choose image from photo gallery
        btnChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.requestPermissions(
                        AddActivity.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_CODE_GALLERY
                );
            }
        });

        //Add Plants click to insert the plants data into database
        btnadddata.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String name, engname,family;
                        name = botanicalname.getText().toString();
                        engname = englishname.getText().toString();
                        family = editfamily.getText().toString();

                        CheckEditTextIsEmptyOrNot(name, engname,family);

                        if (CheckEditTextEmpty == true) {

                            //read all data from database
                            Cursor res = myDb.getAllData();
                            int c = 0;
                            if (res.moveToFirst()) {
                                c = 0;
                                do {
                                    //To check if the entered botanical name already exist in database or not
                                    if (res.getString(2).equals(name)) {
                                        c = c + 1;
                                    }
                                } while (res.moveToNext());
                            }
                            if (c == 0) {
                                //if the botanical name not exist in database represented by c==0 then insertData inserts data into database ,function called from DatabaseHelper.java
                                myDb.insertData(imageViewToByte(imageView),
                                        name,
                                        engname,
                                        nepaliname.getText().toString(),
                                        family,
                                        description.getText().toString());

                                Toast.makeText(AddActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                                ClearEditTextAfterDoneTask();


                            } else
                                Toast.makeText(AddActivity.this, "Value already exist", Toast.LENGTH_LONG).show();
                            ClearEditTextAfterDoneTask();

                        } else
                            Toast.makeText(AddActivity.this, "Please fill all (*) fields", Toast.LENGTH_LONG).show();

                    }

                    //clears the text in the edittext of the layout after inserted
                    private void ClearEditTextAfterDoneTask() {
                        botanicalname.getText().clear();
                        englishname.getText().clear();
                        nepaliname.getText().clear();
                        editfamily.getText().clear();
                        description.getText().clear();

                    }
                }


        );

        //View Plants click to view list of plants information from database
        btnviewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewplant=new Intent(AddActivity.this,ViewPlants.class);
                startActivity(viewplant);
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

    //Convert image to byte[]
    private byte[] imageViewToByte(ImageView image) {
        Bitmap bitmap = ((BitmapDrawable) image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == REQUEST_CODE_GALLERY) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_CODE_GALLERY);
            } else {
                Toast.makeText(getApplicationContext(), "You don't have permission to access file location!", Toast.LENGTH_SHORT).show();
            }
            return;
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST_CODE_GALLERY && resultCode == RESULT_OK && data != null) {
            Uri uri = data.getData();

            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);

                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imageView.setImageBitmap(bitmap);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }



    //Check if botanicalname,englishname and family is empty or not
    public void CheckEditTextIsEmptyOrNot(String name, String engname,String fam) {

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(engname) || TextUtils.isEmpty(fam)) {

            CheckEditTextEmpty = false;

        } else {
            CheckEditTextEmpty = true;
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

    /**
     * Called when an item in the navigation menu is selected.
     *
     * @param item The selected item
     * @return true to display the item as the selected item
     */

}