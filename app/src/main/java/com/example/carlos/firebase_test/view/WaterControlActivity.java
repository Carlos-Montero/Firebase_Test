package com.example.carlos.firebase_test.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.carlos.firebase_test.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class WaterControlActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    //Buttons
    private Button lessWater;
    private Button moreWater;

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



    }
}
