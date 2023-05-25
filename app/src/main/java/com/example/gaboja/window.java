package com.example.gaboja;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class window extends AppCompatActivity {

    private Button filterbutton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_window);

        filterbutton = findViewById(R.id.filterbutton);
        filterbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){Intent intent = new Intent(window.this, activity_filter.class);
                startActivity(intent);}
        });

    }
}