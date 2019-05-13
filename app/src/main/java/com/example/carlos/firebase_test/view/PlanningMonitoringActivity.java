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

public class PlanningMonitoringActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    //DECLARACIÓN VARIABLES
    private TextView medication1,medication2,medication3,medication4,medication5,medication6,medication7;
    private TextView taken1,taken2,taken3,taken4,taken5,taken6,taken7;
    private TextView time1,time2,time3,time4,time5,time6,time7;


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




        //Listener Medication1
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

        mDatabase.child("User").child(user_id).child("hardware details").child("Medication").child("monday").child("name").addValueEventListener(postListenerMed1);
        //***************************************************************************************

        //Listener Medication2
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

       mDatabase.child("User").child(user_id).child("hardware details").child("Medication").child("tuesday").child("name").addValueEventListener(postListenerMed2);
        //***************************************************************************************

        //Listener Medication3
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

        mDatabase.child("User").child(user_id).child("hardware details").child("Medication").child("wenesday").child("name").addValueEventListener(postListenerMed3);
        //***************************************************************************************

        //Listener Medication4
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

        mDatabase.child("User").child(user_id).child("hardware details").child("Medication").child("thursday").child("name").addValueEventListener(postListenerMed4);
        //***************************************************************************************

        //Listener Medication5
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

        mDatabase.child("User").child(user_id).child("hardware details").child("Medication").child("friday").child("name").addValueEventListener(postListenerMed5);
        //***************************************************************************************

        //Listener Medication6
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

        mDatabase.child("User").child(user_id).child("hardware details").child("Medication").child("saturday").child("name").addValueEventListener(postListenerMed6);
        //***************************************************************************************

        //Listener Medication7
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

        mDatabase.child("User").child(user_id).child("hardware details").child("Medication").child("sunday").child("name").addValueEventListener(postListenerMed7);
        //***************************************************************************************


        //Listener Taken1
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

        mDatabase.child("User").child(user_id).child("hardware details").child("Medication").child("monday").child("taken").addValueEventListener(postListenerTaken1);
        //***************************************************************************************


        //Listener Taken2
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

        mDatabase.child("User").child(user_id).child("hardware details").child("Medication").child("tuesday").child("taken").addValueEventListener(postListenerTaken2);
        //***************************************************************************************

        //Listener Taken3
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

        mDatabase.child("User").child(user_id).child("hardware details").child("Medication").child("wenesday").child("taken").addValueEventListener(postListenerTaken3);
        //***************************************************************************************

        //Listener Taken4
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

        mDatabase.child("User").child(user_id).child("hardware details").child("Medication").child("thursday").child("taken").addValueEventListener(postListenerTaken4);
        //***************************************************************************************

        //Listener Taken5
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

        mDatabase.child("User").child(user_id).child("hardware details").child("Medication").child("friday").child("taken").addValueEventListener(postListenerTaken5);
        //***************************************************************************************

        //Listener Taken6
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

        mDatabase.child("User").child(user_id).child("hardware details").child("Medication").child("saturday").child("taken").addValueEventListener(postListenerTaken6);
        //***************************************************************************************

        //Listener Taken7
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

        mDatabase.child("User").child(user_id).child("hardware details").child("Medication").child("sunday").child("taken").addValueEventListener(postListenerTaken7);
        //***************************************************************************************




        //Listener Time1
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

        mDatabase.child("User").child(user_id).child("hardware details").child("Medication").child("monday").child("time_taken").addValueEventListener(postListenerTime1);
        //***************************************************************************************

        //Listener Time2
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

        mDatabase.child("User").child(user_id).child("hardware details").child("Medication").child("tuesday").child("time_taken").addValueEventListener(postListenerTime2);
        //***************************************************************************************

        //Listener Time3
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

        mDatabase.child("User").child(user_id).child("hardware details").child("Medication").child("wenesday").child("time_taken").addValueEventListener(postListenerTime3);
        //***************************************************************************************


        //Listener Time4
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

        mDatabase.child("User").child(user_id).child("hardware details").child("Medication").child("thursday").child("time_taken").addValueEventListener(postListenerTime4);
        //***************************************************************************************

        //Listener Time5
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

        mDatabase.child("User").child(user_id).child("hardware details").child("Medication").child("friday").child("time_taken").addValueEventListener(postListenerTime5);
        //***************************************************************************************

        //Listener Time6
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

        mDatabase.child("User").child(user_id).child("hardware details").child("Medication").child("saturday").child("time_taken").addValueEventListener(postListenerTime6);
        //***************************************************************************************

        //Listener Time7
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

        mDatabase.child("User").child(user_id).child("hardware details").child("Medication").child("sunday").child("time_taken").addValueEventListener(postListenerTime7);
        //***************************************************************************************



    }
}
