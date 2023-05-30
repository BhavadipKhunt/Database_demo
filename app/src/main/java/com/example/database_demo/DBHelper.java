package com.example.database_demo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper
{


    public DBHelper(@Nullable Context context) {
        super(context,"ContactBook",null,1);
        Log.d("TTT", "DBHelper: DB Created");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query="create table Contact(id integer primary key autoincrement, name text, number text)";
        sqLiteDatabase.execSQL(query);
        Log.d("TTT", "DBHelper: Table Created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addContact(String name, String number)
    {
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String query="insert into Contact (name,number) values('"+name+"','"+number+"')";
        sqLiteDatabase.execSQL(query);
    }

    public void updateContact(int id, String name, String number) {

        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String query="update Contact set name = '"+name+"',number='"+number+"' where id = '"+id+"'";
        sqLiteDatabase.execSQL(query);
    }

    public void deleteContact(int id)
    {
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String query="delete from Contact where id = '"+id+"'";
        sqLiteDatabase.execSQL(query);
    }

    public Cursor showContact()
    {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String query="select * from Contact";
        Cursor cursor = sqLiteDatabase.rawQuery(query,null);
        return cursor;
    }
}
