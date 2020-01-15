package com.kidcannote;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.github.clans.fab.FloatingActionButton;
import com.kidcannote.model.NoteHelper;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import static com.kidcannote.model.NoteData.TABLE_NAME;
import static com.kidcannote.model.NoteData.COL_TOPIC;
import static com.kidcannote.model.NoteData.COL_CONTENT;
import static com.kidcannote.model.NoteData.COL_TIME;


public class Note extends AppCompatActivity {
    Dialog myDialog;
    EditText topic,content;
    NoteHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        topic = findViewById(R.id.topic);
        content = findViewById(R.id.content);
        myDialog =new Dialog(this);
        helper =new NoteHelper(this);


//        final Database database = new Database(this);
//        final NoteData noteData = new NoteData();
//
//        noteData.setId(1);
//        noteData.setTopic("topic");
//        noteData.setContent("content");
//        noteData.setTime("time");

        FloatingActionButton F = findViewById(R.id.fab1);
        F.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent F =new Intent(Note.this,Pop.class);
//                startActivity(F);
                ClosePopup();
            }
        });
        ImageView Img = findViewById(R.id.imgBack);
        Img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Img = new Intent(Note.this,MainActivity.class);
                startActivity(Img);
            }
        });
        TextView sa = findViewById(R.id.txtSave);
        sa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sa = new Intent(Note.this,SelectC.class);
                startActivity(sa);
//                database.saveNewNote(noteData);

            }
        });

    }
    public void ClosePopup(){
        myDialog.setContentView(R.layout.pop);
        myDialog.show();
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        ImageView imgClose = myDialog.findViewById(R.id.imgClose);
        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
    }
}
