package com.kidcannote.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import static com.kidcannote.model.NoteData._ID;
import static com.kidcannote.model.NoteData.TABLE_NAME;
import static com.kidcannote.model.NoteData.COL_TOPIC;
import static com.kidcannote.model.NoteData.COL_CONTENT;
import static com.kidcannote.model.NoteData.COL_TIME;

public class NoteHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "note.db";
    private static final int DB_VERSION = 1;

    public NoteHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(" + _ID + "INTEGEN PRIMARY KEY AUTOINCREMENT, " + COL_TOPIC + " VACHAR(50), "
                + COL_CONTENT + "TEXT NOT NULL," + COL_TIME + " INTEGEN);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " +TABLE_NAME);
        onCreate((db));
    }

}