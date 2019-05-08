package com.example.carlos.firebase_test.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carlos.firebase_test.R;
import com.example.carlos.firebase_test.viewmodel.TemperatureMonitoringViewmodel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PresenceMonitoringActivity extends AppCompatActivity {


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
    String upsensorvalue;
    String downsensorvalue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presence_monitoring);


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
                //Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException());
            }

        };
        mDatabase.child("upsensor").addValueEventListener(postListener);
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
                //Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException());
            }

        };
        mDatabase.child("downsensor").addValueEventListener(postListener2);
        //***************************************************************************************

        //TOAST
        if (upsensorvalue=="no" && downsensorvalue=="yes") {
            System.out.println("caida");
            Toast toast = Toast.makeText(getApplicationContext(), "Caída", Toast.LENGTH_LONG);
            //toast.setMargin(50, 50);
            toast.show();
        }
        //

    }

}
