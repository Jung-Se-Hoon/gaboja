package com.example.gaboja;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class activity_filter extends AppCompatActivity {

    TextView cost_see;// 비용 seekbar 비용 표시

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainfilter);
        getSupportActionBar().setTitle("nologagga");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//뒤로가기 버튼 생성


        //비용 부분
        cost_see = findViewById(R.id.cost_see);

        SeekBar costbar = findViewById(R.id.costbar);
        costbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                int cost = progress * 1000;
                String costText = String.format("비용 0 ~ %d원", cost);
                cost_see.setText(costText);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });



    }


}
