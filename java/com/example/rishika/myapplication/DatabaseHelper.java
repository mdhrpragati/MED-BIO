package com.example.rishika.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by pragati on 1/19/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private Context context;
    private SQLiteDatabase mDatabase;
    private List<Item> mProductlist;

    public static final String DATABASE_NAME="medbio.db";
    public static final String TABLE_NAME="medbio_table";
    public static final String col_1="ID";
    public static final String col_2="IMAGE";

    public static final String col_3="BOTANICALNAME";
    public static final String col_4="ENGLISHNAME";
    public static final String col_5="NEPALINAME";
    public static final String col_6="LOCATION";
    public static final String col_7="DESCRIPTION";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT ,IMAGE BLOB,BOTANICALNAME TEXT ,ENGLISHNAME TEXT,NEPALINAME TEXT,LOCATION TEXT,DESCRIPTION TEXT,UNIQUE(BOTANICALNAME))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(byte[] image,String botanicalname,String englishname,String nepaliname,String location,String description){
        SQLiteDatabase db=this.getReadableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put(col_2,image);
        contentValues.put(col_3,botanicalname);
        contentValues.put(col_4,englishname);
        contentValues.put(col_5,nepaliname);
        contentValues.put(col_6,location);
        contentValues.put(col_7,description);

        long result = db.insert(TABLE_NAME,null,contentValues);

        if(result== -1)
            return false;
        else
            return true;

    }

    public Cursor getAllData(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery("select * from "+TABLE_NAME,null);
        return res;

    }

    public boolean updateData(byte[] image,String botanicalname, String englishname, String nepaliname, String location, String description) {
      SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(col_2,image);
        contentValues.put(col_3,botanicalname);
        contentValues.put(col_4,englishname);
        contentValues.put(col_5,nepaliname);
        contentValues.put(col_6,location);
        contentValues.put(col_7,description);

        db.update(TABLE_NAME, contentValues, "botanicalname = ?",new String[] {botanicalname});
        return true;

    }

    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "botanicalname = ?",new String[] {id});
    }



}
