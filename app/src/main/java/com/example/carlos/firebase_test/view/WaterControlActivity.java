package com.example.carlos.firebase_test.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.carlos.firebase_test.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * The WaterControlActivity indicates the current state of the tap
 * and lets to order for more or less water.
 */
public class WaterControlActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    //Buttons
    private Button lessWater;
    private Button moreWater;
    private TextView state;

    // [START declare_database_ref]
    private DatabaseReference mDatabase;
    // [END declare_database_ref]

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_control);

        // [START initialize_database_ref]
        mDatabase = FirebaseDatabase.getInstance().getReference();
        // [END initialize_database_ref]

        //Firebase
        mAuth=FirebaseAuth.getInstance();
        String user_id;
        user_id=mAuth.getUid();

        //Buttons
        lessWater = (Button) findViewById(R.id.lessWater);
        moreWater = (Button) findViewById(R.id.moreWater);

        //TextView
        state = findViewById(R.id.state);

        //onClickListeners
        lessWater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String current = String.valueOf(state.getText());
                String next=nextLessState(current);
                mDatabase.child("User").child(user_id).child("hardware details").child("Tap").child("tap_state").setValue(next);
            }
        });

        moreWater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String current = String.valueOf(state.getText());
                String next=nextMoreState(current);
                mDatabase.child("User").child(user_id).child("hardware details").child("Tap").child("tap_state").setValue(next);
            }
        });


        //Listener Tap Current State
        //**************************************************************************************
        ValueEventListener postListenerState = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                state.setText(value);
                //Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException());
            }

        };

        mDatabase.child("User").child(user_id).child("hardware details").child("Tap").child("tap_state").addValueEventListener(postListenerState);
        //***************************************************************************************

    }



    /**
     * nextMoreState return the next state when moreWater button is pressed
     */
    public String nextMoreState(String current_state){
        if (current_state.equals("Cerrado")) {
            return "1";
        }
        if (current_state.equals("1")) {
            return "2";
        }
        if (current_state.equals("2")) {
            return "3";
        }
        else
            return "4";
    }


    /**
     * nextLessState return the next state when lessWater button is pressed
     */
    public String nextLessState(String current_state){
        if (current_state.equals("4")) {
            return "3";
        }
        if (current_state.equals("3")) {
            return "2";
        }
        if (current_state.equals("2")) {
            return "1";
        }
        else
            return "Cerrado";
    }



}
