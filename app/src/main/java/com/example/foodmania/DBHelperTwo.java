package com.example.foodmania;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBHelperTwo extends SQLiteOpenHelper {

    public DBHelperTwo(Context context) {
        super(context,"food.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE USERS(\n" +
                "   ID INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "   UNAME           TEXT      NOT NULL,\n" +
                "   RNAME\t\t\tTEXT     NOT NULL,\n" +
                "   PASSWORD\t\t\tTEXT\tNOT NULL,\n" +
                "   PHONE \t\t\tTEXT(12)\tNOT NULL\n" +
                ");";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists USERS");

    }

    public boolean insertData (String UNAME,String RNAME,String PASSWORD,String PHONE) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("UNAME",UNAME);
        contentValues.put("RNAME",RNAME);
        contentValues.put("PASSWORD",PASSWORD);
        contentValues.put("PHONE",PHONE);

        long result = myDB.insert("USERS",null,contentValues);
        if(result ==-1) {
            return false;
        }
        else {
            return true;
        }
    }

    public boolean checkUser (String UNAME) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT * FROM USERS WHERE UNAME = ?",new String[] {UNAME});

        if (cursor.getCount()>0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkUserNamePassWord (String UNAME,String PASSWORD) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("SELECT * FROM USERS WHERE UNAME = ? AND PASSWORD = ?",new String[] {UNAME,PASSWORD});
        if(cursor.getCount()>0) {
            return  true;
        } else {
            return false;
        }
    }
}