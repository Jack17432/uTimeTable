package com.temprist.utimetable;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class addClass extends AppCompatActivity {

    String nameOfClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_class);

        //Back Arrow
        {
            findViewById(R.id.imageBack).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        }

        findViewById(R.id.buttonAddClass).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveVales();
                Toast.makeText(addClass.this, nameOfClass, Toast.LENGTH_SHORT).show();
                onBackPressed();
            }
        });
    }

    public void saveVales(){
    }
}