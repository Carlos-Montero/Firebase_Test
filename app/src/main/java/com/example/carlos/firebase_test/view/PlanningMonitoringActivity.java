package com.example.carlos.firebase_test.view;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.carlos.firebase_test.R;
import com.example.carlos.firebase_test.viewmodel.PlanningMonitoringViewmodel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * The PlanningMonitoringActivity is the responsible
 * to show to the users what is the medical planning.
 * It includes for each day of the week, what medicine is
 * needed to be taken, if has been taked and at what time.
 */
public class PlanningMonitoringActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    //DECLARACIÓN VARIABLES
    private TextView medication1,medication2,medication3,medication4,medication5,medication6,medication7;
    private TextView taken1,taken2,taken3,taken4,taken5,taken6,taken7;
    private TextView time1,time2,time3,time4,time5,time6,time7;

    /**In onCreate():
     * postListenerMed1-7 are the listeners for medication names,
     * postListenerTaken1-7 are the listeners for taken values,
     * postListenerTime1-7 are the listeners for time_taken values
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planning_monitoring);

        /// [START initialize_database_ref]
        mDatabase = FirebaseDatabase.getInstance().getReference();
        // [END initialize_database_ref]

        //Firebase
        mAuth=FirebaseAuth.getInstance();
        String user_id;
        user_id=mAuth.getUid();

        // Views
        medication1 = findViewById(R.id.medication1);
        medication2 = findViewById(R.id.medication2);
        medication3 = findViewById(R.id.medication3);
        medication4 = findViewById(R.id.medication4);
        medication5 = findViewById(R.id.medication5);
        medication6 = findViewById(R.id.medication6);
        medication7 = findViewById(R.id.medication7);

        taken1 = findViewById(R.id.taken1);
        taken2 = findViewById(R.id.taken2);
        taken3 = findViewById(R.id.taken3);
        taken4 = findViewById(R.id.taken4);
        taken5 = findViewById(R.id.taken5);
        taken6 = findViewById(R.id.taken6);
        taken7 = findViewById(R.id.taken7);

        time1 = findViewById(R.id.time1);
        time2 = findViewById(R.id.time2);
        time3 = findViewById(R.id.time3);
        time4 = findViewById(R.id.time4);
        time5 = findViewById(R.id.time5);
        time6 = findViewById(R.id.time6);
        time7 = findViewById(R.id.time7);




        ///**
        //     * postListenerMed1 is the listener for monday medication name value
        //     *
        //     */
        //**************************************************************************************
        ValueEventListener postListenerMed1 = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                medication1.setText(value);
                //Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException());
            }

        };

        mDatabase.child(getString(R.string.user)).child(user_id).child(getString(R.string.hardware_details)).child(getString(R.string.medication)).child(getString(R.string.monday)).child(getString(R.string.name)).addValueEventListener(postListenerMed1);
        //***************************************************************************************

        ///**
        //     * postListenerMed2 is the listener for tuesday medication name value
        //     *
        //     */
        //**************************************************************************************
        ValueEventListener postListenerMed2 = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value2 = dataSnapshot.getValue(String.class);
                medication2.setText(value2);
                //Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException());
            }

        };

       mDatabase.child(getString(R.string.user)).child(user_id).child(getString(R.string.hardware_details)).child(getString(R.string.medication)).child(getString(R.string.tuesday)).child(getString(R.string.name)).addValueEventListener(postListenerMed2);
        //***************************************************************************************

        ///**
        //     * postListenerMed3 is the listener for wenesday medication name value
        //     *
        //     */
        //**************************************************************************************
        ValueEventListener postListenerMed3 = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value3 = dataSnapshot.getValue(String.class);
                medication3.setText(value3);
                //Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException());
            }

        };

        mDatabase.child(getString(R.string.user)).child(user_id).child(getString(R.string.hardware_details)).child(getString(R.string.medication)).child(getString(R.string.wenesday)).child(getString(R.string.name)).addValueEventListener(postListenerMed3);
        //***************************************************************************************

        ///**
        //     * postListenerMed4 is the listener for thursday medication name value
        //     *
        //     */
        //**************************************************************************************
        ValueEventListener postListenerMed4 = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value4 = dataSnapshot.getValue(String.class);
                medication4.setText(value4);
                //Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException());
            }

        };

        mDatabase.child(getString(R.string.user)).child(user_id).child(getString(R.string.hardware_details)).child(getString(R.string.medication)).child(getString(R.string.thursday)).child(getString(R.string.name)).addValueEventListener(postListenerMed4);
        //***************************************************************************************

        ///**
        //     * postListenerMed5 is the listener for friday medication name value
        //     *
        //     */
        //**************************************************************************************
        ValueEventListener postListenerMed5 = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value5 = dataSnapshot.getValue(String.class);
                medication5.setText(value5);
                //Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException());
            }

        };

        mDatabase.child(getString(R.string.user)).child(user_id).child(getString(R.string.hardware_details)).child(getString(R.string.medication)).child(getString(R.string.friday)).child(getString(R.string.name)).addValueEventListener(postListenerMed5);
        //***************************************************************************************

        ///**
        //     * postListenerMed6 is the listener for saturday medication name value
        //     *
        //     */
        //**************************************************************************************
        ValueEventListener postListenerMed6 = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value6 = dataSnapshot.getValue(String.class);
                medication6.setText(value6);
                //Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException());
            }

        };

        mDatabase.child(getString(R.string.user)).child(user_id).child(getString(R.string.hardware_details)).child(getString(R.string.medication)).child(getString(R.string.saturday)).child(getString(R.string.name)).addValueEventListener(postListenerMed6);
        //***************************************************************************************

        ///**
        //     * postListenerMed7 is the listener for sunday medication name value
        //     *
        //     */
        //**************************************************************************************
        ValueEventListener postListenerMed7 = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value7 = dataSnapshot.getValue(String.class);
                medication7.setText(value7);
                //Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException());
            }

        };

        mDatabase.child(getString(R.string.user)).child(user_id).child(getString(R.string.hardware_details)).child(getString(R.string.medication)).child(getString(R.string.sunday)).child(getString(R.string.name)).addValueEventListener(postListenerMed7);
        //***************************************************************************************


        ///**
        //     * postListenerTaken1 is the listener for monday taken value
        //     *
        //     */
        //**************************************************************************************
        ValueEventListener postListenerTaken1 = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value8 = dataSnapshot.getValue(String.class);
                taken1.setText(value8);
                //Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException());
            }

        };

        mDatabase.child(getString(R.string.user)).child(user_id).child(getString(R.string.hardware_details)).child(getString(R.string.medication)).child(getString(R.string.monday)).child(getString(R.string.taken)).addValueEventListener(postListenerTaken1);
        //***************************************************************************************


        ///**
        //     * postListenerTaken2 is the listener for tuesday taken value
        //     *
        //     */
        //**************************************************************************************
        ValueEventListener postListenerTaken2 = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value9 = dataSnapshot.getValue(String.class);
                taken2.setText(value9);
                //Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException());
            }

        };

        mDatabase.child(getString(R.string.user)).child(user_id).child(getString(R.string.hardware_details)).child(getString(R.string.medication)).child(getString(R.string.tuesday)).child(getString(R.string.taken)).addValueEventListener(postListenerTaken2);
        //***************************************************************************************

        ///**
        //     * postListenerTaken3 is the listener for wenesday taken value
        //     *
        //     */
        //**************************************************************************************
        ValueEventListener postListenerTaken3 = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value10 = dataSnapshot.getValue(String.class);
                taken3.setText(value10);
                //Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException());
            }

        };

        mDatabase.child(getString(R.string.user)).child(user_id).child(getString(R.string.hardware_details)).child(getString(R.string.medication)).child(getString(R.string.wenesday)).child(getString(R.string.taken)).addValueEventListener(postListenerTaken3);
        //***************************************************************************************

        ///**
        //     * postListenerTaken4 is the listener for thursday taken value
        //     *
        //     */
        //**************************************************************************************
        ValueEventListener postListenerTaken4 = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value11 = dataSnapshot.getValue(String.class);
                taken4.setText(value11);
                //Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException());
            }

        };

        mDatabase.child(getString(R.string.user)).child(user_id).child(getString(R.string.hardware_details)).child(getString(R.string.medication)).child(getString(R.string.thursday)).child(getString(R.string.taken)).addValueEventListener(postListenerTaken4);
        //***************************************************************************************

        ///**
        //     * postListenerTaken5 is the listener for friday taken value
        //     *
        //     */
        //**************************************************************************************
        ValueEventListener postListenerTaken5 = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value12 = dataSnapshot.getValue(String.class);
                taken5.setText(value12);
                //Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException());
            }

        };

        mDatabase.child(getString(R.string.user)).child(user_id).child(getString(R.string.hardware_details)).child(getString(R.string.medication)).child(getString(R.string.friday)).child(getString(R.string.taken)).addValueEventListener(postListenerTaken5);
        //***************************************************************************************

        ///**
        //     * postListenerTaken6 is the listener for saturday taken value
        //     *
        //     */
        //**************************************************************************************
        ValueEventListener postListenerTaken6 = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value13 = dataSnapshot.getValue(String.class);
                taken6.setText(value13);
                //Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException());
            }

        };

        mDatabase.child(getString(R.string.user)).child(user_id).child(getString(R.string.hardware_details)).child(getString(R.string.medication)).child(getString(R.string.saturday)).child(getString(R.string.taken)).addValueEventListener(postListenerTaken6);
        //***************************************************************************************

        ///**
        //     * postListenerTaken7 is the listener for sunday taken value
        //     *
        //     */
        //**************************************************************************************
        ValueEventListener postListenerTaken7 = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value14 = dataSnapshot.getValue(String.class);
                taken7.setText(value14);
                //Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException());
            }

        };

        mDatabase.child(getString(R.string.user)).child(user_id).child(getString(R.string.hardware_details)).child(getString(R.string.medication)).child(getString(R.string.sunday)).child(getString(R.string.taken)).addValueEventListener(postListenerTaken7);
        //***************************************************************************************




        ///**
        //     * postListenerTime1 is the listener for monday time_taken value
        //     *
        //     */
        //**************************************************************************************
        ValueEventListener postListenerTime1 = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value15 = dataSnapshot.getValue(String.class);
                time1.setText(value15);
                //Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException());
            }

        };

        mDatabase.child(getString(R.string.user)).child(user_id).child(getString(R.string.hardware_details)).child(getString(R.string.medication)).child(getString(R.string.monday)).child(getString(R.string.time_taken)).addValueEventListener(postListenerTime1);
        //***************************************************************************************

        ///**
        //     * postListenerTime2 is the listener for tuesday time_taken value
        //     *
        //     */
        //**************************************************************************************
        ValueEventListener postListenerTime2 = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value16 = dataSnapshot.getValue(String.class);
                time2.setText(value16);
                //Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException());
            }

        };

        mDatabase.child(getString(R.string.user)).child(user_id).child(getString(R.string.hardware_details)).child(getString(R.string.medication)).child(getString(R.string.tuesday)).child(getString(R.string.time_taken)).addValueEventListener(postListenerTime2);
        //***************************************************************************************

        ///**
        //     * postListenerTime3 is the listener for wenesday time_taken value
        //     *
        //     */
        //**************************************************************************************
        ValueEventListener postListenerTime3 = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value17 = dataSnapshot.getValue(String.class);
                time3.setText(value17);
                //Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException());
            }

        };

        mDatabase.child(getString(R.string.user)).child(user_id).child(getString(R.string.hardware_details)).child(getString(R.string.medication)).child(getString(R.string.wenesday)).child(getString(R.string.time_taken)).addValueEventListener(postListenerTime3);
        //***************************************************************************************


        ///**
        //     * postListenerTime4 is the listener for thursday time_taken value
        //     *
        //     */
        //**************************************************************************************
        ValueEventListener postListenerTime4 = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value18 = dataSnapshot.getValue(String.class);
                time4.setText(value18);
                //Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException());
            }

        };

        mDatabase.child(getString(R.string.user)).child(user_id).child(getString(R.string.hardware_details)).child(getString(R.string.medication)).child(getString(R.string.thursday)).child(getString(R.string.time_taken)).addValueEventListener(postListenerTime4);
        //***************************************************************************************

        ///**
        //     * postListenerTime5 is the listener for friday time_taken value
        //     *
        //     */
        //**************************************************************************************
        ValueEventListener postListenerTime5 = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value19 = dataSnapshot.getValue(String.class);
                time5.setText(value19);
                //Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException());
            }

        };

        mDatabase.child(getString(R.string.user)).child(user_id).child(getString(R.string.hardware_details)).child(getString(R.string.medication)).child(getString(R.string.friday)).child(getString(R.string.time_taken)).addValueEventListener(postListenerTime5);
        //***************************************************************************************

        ///**
        //     * postListenerTime6 is the listener for saturday time_taken value
        //     *
        //     */
        //**************************************************************************************
        ValueEventListener postListenerTime6 = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value20 = dataSnapshot.getValue(String.class);
                time6.setText(value20);
                //Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException());
            }

        };

        mDatabase.child(getString(R.string.user)).child(user_id).child(getString(R.string.hardware_details)).child(getString(R.string.medication)).child(getString(R.string.saturday)).child(getString(R.string.time_taken)).addValueEventListener(postListenerTime6);
        //***************************************************************************************

        ///**
        //     * postListenerTime7 is the listener for sunday time_taken value
        //     *
        //     */
        //**************************************************************************************
        ValueEventListener postListenerTime7 = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value21 = dataSnapshot.getValue(String.class);
                time7.setText(value21);
                //Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException());
            }

        };

        mDatabase.child(getString(R.string.user)).child(user_id).child(getString(R.string.hardware_details)).child(getString(R.string.medication)).child(getString(R.string.sunday)).child(getString(R.string.time_taken)).addValueEventListener(postListenerTime7);
        //***************************************************************************************



    }
}
