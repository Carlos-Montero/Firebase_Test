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

                mDatabase.child("User").child(user_id).child("hardware details").child("Tap").child("tap_state").setValue("Less Water");
            }
        });

        moreWater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabase.child("User").child(user_id).child("hardware details").child("Tap").child("tap_state").setValue("More Water");
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
}
