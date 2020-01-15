package com.kidcannote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import android.text.format.DateFormat;
import android.view.View;
import android.widget.TextView;


import com.github.clans.fab.FloatingActionButton;

import java.util.Date;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton float_button = findViewById(R.id.fab_button);
        float_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent N = new Intent(MainActivity.this,Note.class);
                startActivity(N);
            }
        });
    }

}
