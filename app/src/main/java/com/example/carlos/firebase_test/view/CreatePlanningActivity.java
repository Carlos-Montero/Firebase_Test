package com.example.carlos.firebase_test.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.carlos.firebase_test.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreatePlanningActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;


    //DECLARACIÓN VARIABLES
    private EditText day1,day2,drug1,drug2;
    private Button saveButton, cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_planning);

        /// [START initialize_database_ref]
        mDatabase = FirebaseDatabase.getInstance().getReference();
        // [END initialize_database_ref]

        //Firebase
        mAuth=FirebaseAuth.getInstance();
        String user_id;
        user_id=mAuth.getUid();

        // Views
        day1 = findViewById(R.id.day1);
        drug1 = findViewById(R.id.drug1);
        day2 = findViewById(R.id.day2);
        drug2 = findViewById(R.id.drug2);



        // Buttons
        saveButton = (Button) findViewById(R.id.saveButton);
        cancelButton = (Button) findViewById(R.id.cancelButton);



        //Register listener
        cancelButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent =new Intent (getApplicationContext(),MainMenuActivity.class);
                startActivity(intent);
            }

        });

        //Register listener
        saveButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                final String day_1 = day1.getText().toString().trim();
                final String day_2= drug1.getText().toString().trim();
                final String drug_1 = day2.getText().toString().trim();
                final String drug_2= drug2.getText().toString().trim();

                mDatabase.child("User").child(user_id).child("hardware details").child("Medication").child("drug1").child("day").setValue(day_1);
                mDatabase.child("User").child(user_id).child("hardware details").child("Medication").child("drug1").child("name").setValue(drug_1);
                mDatabase.child("User").child(user_id).child("hardware details").child("Medication").child("drug2").child("day").setValue(day_2);
                mDatabase.child("User").child(user_id).child("hardware details").child("Medication").child("drug2").child("name").setValue(drug_2);

                Intent intent =new Intent (getApplicationContext(),MainMenuActivity.class);
                startActivity(intent);
            }

        });

    }
}
