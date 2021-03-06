package com.example.carlos.firebase_test.view;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.carlos.firebase_test.EmailPasswordActivity;
import com.example.carlos.firebase_test.R;
import com.google.firebase.auth.FirebaseAuth;

/**
 * The MainMenuActivity is the responsible to show to the user
 * all the functionalities that has our service.
 * Is the first activity showed after the Registration or LogIn process.
 * It also implements the LogOut functionality.
 */
public class MainMenuActivity extends AppCompatActivity {

    private Button presenceMontoring;
    private Button waterControl;
    private Button temperature;
    private Button planificationCreator;
    private Button planificationViewer;
    private Button logout;

    //Firebase instances
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        //Firebase
        mAuth=FirebaseAuth.getInstance();

        //Buttons
        presenceMontoring = (Button) findViewById(R.id.presenceMonitoring);
        waterControl = (Button) findViewById(R.id.waterControl);
        temperature = (Button) findViewById(R.id.temperature);
        planificationCreator = (Button) findViewById(R.id.planificationCreator);
        planificationViewer = (Button) findViewById(R.id.planificationViewer);
        logout = (Button) findViewById(R.id.logout);

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

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                Intent intent =new Intent (getApplicationContext(),EmailPasswordActivity.class);
                startActivity(intent);
            }
        });
    }


    //Intents

    /**
     * openCreatePlanning() sends us to CreatePlanningActivity
     *
     */
    public void openCreatePlanning(){
        Intent intent =new Intent (this,CreatePlanningActivity.class);
        startActivity(intent);
    }

    /**
     * openPlanningMonitoring() sends us to PlanningMonitoringActivity
     *
     */
    public void openPlanningMonitoring(){
        Intent intent =new Intent (this,PlanningMonitoringActivity.class);
        startActivity(intent);
    }

    /**
     * openPresenceMonitoring() sends us to PresenceMonitoringActivity
     *
     */
    public void openPresenceMonitoring(){
        Intent intent =new Intent (this,PresenceMonitoringActivity.class);
        startActivity(intent);
    }

    /**
     * openTemperatureMonitoring() sends us to TemperatureMonitoringActivity
     *
     */
    public void openTemperatureMonitoring(){
        Intent intent =new Intent (this,TemperatureMonitoringActivity.class);
        startActivity(intent);
    }

    /**
     * openWaterControl() sends us to WaterControlActivity
     *
     */
    public void openWaterControl(){
        Intent intent =new Intent (this,WaterControlActivity.class);
        startActivity(intent);
    }

}
