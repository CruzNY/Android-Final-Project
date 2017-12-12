package com.example.consumer.termproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Alexis Cruz on 05/14/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION =1;
    private static final String DATABASE_NAME = "UserInfo.db";
    private static final String TABLE_NAME = "Contacts";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_ADDRESS = "address";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PASS = "pass";

    SQLiteDatabase db;

    private static final String TABLE_CREATE = "create table Contacts(id integer primary key not null, " +
            "name text not null, address text not null, email text not null, pass text not null);";

    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    public void insertUserInfo(UserInfo u){
        db = this.getWritableDatabase();

        String query = "select * from Contacts";
        Cursor cursor = db.rawQuery(query,null);
        int count= cursor.getCount();



        ContentValues values = new ContentValues();
        values.put(COLUMN_ID,u.getId());
        values.put(COLUMN_NAME,u.getName());
        values.put(COLUMN_ADDRESS, u.getAdd());
        values.put(COLUMN_EMAIL,u.getEmail());
        values.put(COLUMN_PASS, u.getPass());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public String searchPass(String uname){
        db = this.getReadableDatabase();
        String query = ("select name,pass from"+TABLE_NAME);
        Cursor cursor = db.rawQuery(query,null);
        String a,b;
        b = "not found";
        if(cursor.moveToFirst()){
            do{
                a= cursor.getString(0);
                if(a.equals(uname)){
                    b= cursor.getString(1);
                    break;
                }
            }

            while(cursor.moveToFirst());
        }
        return b;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS"+TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}
