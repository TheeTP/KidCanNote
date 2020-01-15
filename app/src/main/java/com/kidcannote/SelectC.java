package com.kidcannote;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SelectC extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_c);

        Fragment F = getSupportFragmentManager().findFragmentById(R.id.frag1);
        FragSelect fragSelect= (FragSelect) F;

        ImageView Img = findViewById(R.id.imgBlack);
        Img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Img = new Intent(SelectC.this,Note.class);
                startActivity(Img);
            }
        });
    }
}
