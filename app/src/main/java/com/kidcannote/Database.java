package com.kidcannote;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.kidcannote.model.NoteData;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class Database extends SQLiteAssetHelper {
    public static final String TABLE_NAME = "note.db";
    public static final String Topic = "topic";
    public static final String Content= "content";
    public static final String Time= "time";

    public Database(Context context){
        super(context,TABLE_NAME,null,1);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
    }

    public void  saveNewNote(NoteData noteData) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Topic,"dasd");
        values.put(Content,"dsa");
        values.put(Time,"dsa");
        db.insert(TABLE_NAME,null,values);
        db.close();

    }

    public String check(){
        SQLiteDatabase db = this.getReadableDatabase();
        String s = null;
        Cursor cursor = db.rawQuery("select topic from note",null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            s = cursor.getString(0);
            cursor.moveToNext();
        }

        return s;
    }


}
