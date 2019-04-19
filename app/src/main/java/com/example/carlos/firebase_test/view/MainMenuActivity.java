package com.example.carlos.firebase_test.view;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.carlos.firebase_test.R;

public class MainMenuActivity extends AppCompatActivity {

    private Button presenceMontoring;
    private Button waterControl;
    private Button temperature;
    private Button planificationCreator;
    private Button planificationViewer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        //Buttons
        presenceMontoring = (Button) findViewById(R.id.presenceMonitoring);
        waterControl = (Button) findViewById(R.id.waterControl);
        temperature = (Button) findViewById(R.id.temperature);
        planificationCreator = (Button) findViewById(R.id.planificationCreator);
        planificationViewer = (Button) findViewById(R.id.planificationViewer);


        //onClickListeners
        presenceMontoring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPresenceMonitoring();
            }
        });

        waterControl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWaterControl();
            }
        });

        temperature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTemperatureMonitoring();
            }
        });

        planificationCreator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCreatePlanning();
            }
        });

        planificationViewer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPlanningMonitoring();
            }
        });
    }

    //Intents
    public void openCreatePlanning(){
        Intent intent =new Intent (this,CreatePlanningActivity.class);
        startActivity(intent);
    }

    public void openPlanningMonitoring(){
        Intent intent =new Intent (this,PlanningMonitoringActivity.class);
        startActivity(intent);
    }

    public void openPresenceMonitoring(){
        Intent intent =new Intent (this,PresenceMonitoringActivity.class);
        startActivity(intent);
    }

    public void openTemperatureMonitoring(){
        Intent intent =new Intent (this,TemperatureMonitoringActivity.class);
        startActivity(intent);
    }

    public void openWaterControl(){
        Intent intent =new Intent (this,WaterControlActivity.class);
        startActivity(intent);
    }

}
