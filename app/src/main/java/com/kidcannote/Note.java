package com.kidcannote;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.github.clans.fab.FloatingActionButton;

import java.util.Objects;

public class Note extends AppCompatActivity {
    Dialog myDialog;
    EditText topic,content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        myDialog =new Dialog(this);

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

                database database = new database(getApplicationContext());
                database.insert(topic.getText().toString(),content.getText().toString());
                finish();

            }
        });
    }
    public void ClosePopup(){
        myDialog.setContentView(R.layout.pop);
        myDialog.show();
        Objects.requireNonNull(myDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        ImageView imgClose = myDialog.findViewById(R.id.imgClose);
        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
    }
}
