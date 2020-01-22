package com.kidcannote;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;
import java.util.ArrayList;


public class database extends SQLiteAssetHelper {

    public database(Context context) {
        super(context, "note.db", null, 1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
    }

    public ArrayList<String> getAllNote(){
        ArrayList<String> myNote = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM note",null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            myNote.add(cursor.getString(1)+"\n"
                    +"\b"+"\b"+cursor.getString(2)+"\n"
                    +"\b"+"\b"+cursor.getString(3));
            cursor.moveToNext();
        }
        db.close();
        return myNote;
    }

    public void insert(String topic,String content){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Topic", topic);
        contentValues.put("Content",content);
        contentValues.put("Time", System.currentTimeMillis());
        db.insert("note", null, contentValues);
        db.close();
    }
}
