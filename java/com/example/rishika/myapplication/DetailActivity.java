package com.example.rishika.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static java.sql.Types.NULL;

public class DetailActivity extends AppCompatActivity {
    Button btnupdate,btndelete,btnchange;
    EditText nam,english,nepali,location1,description1;
    DatabaseHelper myDb;
    final int REQUEST_CODE_GALLERY = 999;
    ImageView ima,imageView,image;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        myDb = new DatabaseHelper(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.ic_keyboard_backspace_black_24dp); // Set the icon
        // Icon click listener
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(DetailActivity.this,ViewPlants.class);
                startActivity(i);
                finish();
            }
        });

        btnchange=(Button)findViewById(R.id.button_change) ;
        btnupdate=(Button)findViewById(R.id.button_update);
        btndelete=(Button)findViewById(R.id.button_delete);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



        //get data sent from ViewPlants.java
        Intent i=getIntent();
        final byte[] imag=i.getByteArrayExtra("imagekey");
       // final int imag=i.getExtras().getInt("imagekey");
        final String name=i.getStringExtra("namekey");
        final String engname=i.getExtras().getString("englishkey");
        final String nepname=i.getExtras().getString("nepalikey");
        final String location=i.getExtras().getString("locationkey");
        final String description=i.getExtras().getString("descriptionkey");

        final ImageView ima=(ImageView)findViewById(R.id.imgplant);
        final EditText nam=(EditText) findViewById(R.id.name);
        english=(EditText) findViewById(R.id.engname);
        nepali=(EditText) findViewById(R.id.nepname);
        location1=(EditText) findViewById(R.id.location);
        description1=(EditText) findViewById(R.id.description);

        Bitmap bitmap = BitmapFactory.decodeByteArray(imag, 0, imag.length);
        ima.setImageBitmap(bitmap);
        nam.setText(name);
        english.setText(engname);
        nepali.setText(nepname);
        location1.setText(location);
        description1.setText(description);

        btnchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.requestPermissions(
                        DetailActivity.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_CODE_GALLERY
                );
            }
        });

        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnupdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ImageView imageVie=(ImageView)findViewById(R.id.imgplant);
                        boolean isUpdate = myDb.updateData(imageViewToByte(imageVie),nam.getText().toString(),
                                english.getText().toString(),
                                nepali.getText().toString(),location1.getText().toString(),description1.getText().toString());
                        if(isUpdate == true)
                            Toast.makeText(DetailActivity.this,"Data Update",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(DetailActivity.this,"Data not Updated",Toast.LENGTH_LONG).show();
                        returnHome();
                    }

                    private void returnHome() {
                        Intent home_intent = new Intent(getApplicationContext(), ViewPlants.class);
                        startActivity(home_intent);
                        finish();
                    }

                });
            }
        });


        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer deletedRows = myDb.deleteData(nam.getText().toString());
                if(deletedRows > 0)
                    Toast.makeText(DetailActivity.this,"Data Deleted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(DetailActivity.this,"Data not Deleted",Toast.LENGTH_LONG).show();
                Intent i=new Intent(DetailActivity.this,ViewPlants.class);
                startActivity(i);
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
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(requestCode == REQUEST_CODE_GALLERY){
            if(grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_CODE_GALLERY);
            }
            else {
                Toast.makeText(getApplicationContext(), "You don't have permission to access file location!", Toast.LENGTH_SHORT).show();
            }
            return;
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == REQUEST_CODE_GALLERY && resultCode == RESULT_OK && data != null){
            Uri uri = data.getData();

            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);

                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imageView=(ImageView)findViewById(R.id.imgplant);
                imageView.setImageBitmap(bitmap);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }



}
