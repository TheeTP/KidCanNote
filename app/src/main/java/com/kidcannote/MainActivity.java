package com.kidcannote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import com.github.clans.fab.FloatingActionButton;
import java.util.ArrayList;



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

        GridView gridView = findViewById(R.id.gridView);
        database database = new database(getApplicationContext());
        ArrayList<String> myNote = database.getAllNote();
        database.getAllNote();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,myNote);
        gridView.setAdapter(adapter);
        database.close();

    }

}
