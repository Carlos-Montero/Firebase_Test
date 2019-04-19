package com.example.carlos.firebase_test.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.carlos.firebase_test.R;

public class WaterControlActivity extends AppCompatActivity {

    //Buttons
    private Button lessWater;
    private Button moreWater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_control);
    }
}
