package com.example.carlos.firebase_test.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.carlos.firebase_test.R;
import com.example.carlos.firebase_test.viewmodel.TemperatureMonitoringViewmodel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * The TemperatureMonitoringActivity indicates the current temperature
 * that the sensor has.
 */
public class TemperatureMonitoringActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    // [START declare_database_ref]
    private DatabaseReference mDatabase;
    // [END declare_database_ref]

    //Textview
    private TextView temperature;

    /**
     * In onCreate():
     * postListener is the listener for Temperature value
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature_monitoring);

        //Textview
        temperature = (TextView) findViewById(R.id.temperature);

        // [START initialize_database_ref]
        mDatabase = FirebaseDatabase.getInstance().getReference();
        // [END initialize_database_ref]


        //**************************************************************************************

        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                temperature.setText(value);
                //Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException());
            }

        };
        //Firebase
        mAuth=FirebaseAuth.getInstance();
        String user_id;
        user_id=mAuth.getUid();

       mDatabase.child(getString(R.string.user)).child(user_id).child(getString(R.string.hardware_details)).child(getString(R.string.Temperature)).child(getString(R.string.Temperature_child)).addValueEventListener(postListener);
        //***************************************************************************************

    }
}
