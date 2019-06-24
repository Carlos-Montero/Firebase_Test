package com.example.carlos.firebase_test.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carlos.firebase_test.R;
import com.example.carlos.firebase_test.viewmodel.TemperatureMonitoringViewmodel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

/**
 * The PresenceMonitoringAActivity indicates the state of the
 * presence sensors.
 */
public class PresenceMonitoringActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    // [START declare_database_ref]
    private DatabaseReference mDatabase;
    // [END declare_database_ref]

    //Textview
    private TextView title;
    private TextView up;
    private TextView upsensor;
    private TextView down;
    private TextView downsensor;

    //Values
    private String upsensorvalue;
    private String downsensorvalue;

    /**
     * In onCreate():
     * postListener is the listener for UpSensor value
     * postListener2 is the listener for DownSensor value
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presence_monitoring);

        //Firebase
        mAuth=FirebaseAuth.getInstance();
        String user_id;
        user_id=mAuth.getUid();

        //Textview
        title = (TextView) findViewById(R.id.title);
        up = (TextView) findViewById(R.id.up);
        upsensor = (TextView) findViewById(R.id.upsensor);
        down= (TextView) findViewById(R.id.down);
        downsensor = (TextView) findViewById(R.id.downsensor);

        // [START initialize_database_ref]
        mDatabase = FirebaseDatabase.getInstance().getReference();
        // [END initialize_database_ref]


        //UpSensor Listener
        //**************************************************************************************
        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                upsensor.setText(value);
                upsensorvalue=value;
                callToast();
                //Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException());
            }

        };
        mDatabase.child(getString(R.string.user)).child(user_id).child(getString(R.string.hardware_details)).child(getString(R.string.presence)).child(getString(R.string.up)).addValueEventListener(postListener);

        //***************************************************************************************

        //DownSensor Listener
        //**************************************************************************************
        ValueEventListener postListener2 = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value2 = dataSnapshot.getValue(String.class);
                downsensor.setText(value2);
                downsensorvalue=value2;
                callToast();
                //Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException());
            }

        };


        mDatabase.child(getString(R.string.user)).child(user_id).child(getString(R.string.hardware_details)).child(getString(R.string.presence)).child(getString(R.string.down)).addValueEventListener(postListener2);

        //***************************************************************************************


    }


    /**
    * callToast() shows a toast if fall is detected
     *
     */
    private void callToast(){
        if (Objects.equals(upsensorvalue,"No")&& Objects.equals(downsensorvalue,"Yes")) {
            Toast toast = Toast.makeText(getApplicationContext(), "Se ha detectado una caída", Toast.LENGTH_LONG);
            toast.show();
            }
        }


}
