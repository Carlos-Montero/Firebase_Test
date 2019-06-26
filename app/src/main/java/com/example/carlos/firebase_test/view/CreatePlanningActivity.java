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

/**
 * The CreatePlanningActivity let to create the medical planning
 * for the users.
 * For each day of the week, it lets to indicate what medicine is
 * needed to be taken.
 * In sends this information to the Firebase RealTime DataBase.
 */
public class CreatePlanningActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;


    //DECLARACIÓN VARIABLES
    
    private EditText drug1,drug2,drug3,drug4,drug5,drug6,drug7;
    private TextView day1,day2,day3,day4,day5,day6,day7;
    private Button saveButton, cancelButton;


    /**In onCreate():
     * saveButton listener saves the new planning created. It sends to Firebase the medicines that the user
     * has indicate for each day and reset all the values for "taken" and "time_taken" in Firebase with the default values
     */
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
        day2 = findViewById(R.id.day2);
        day3 = findViewById(R.id.day3);
        day4 = findViewById(R.id.day4);
        day5 = findViewById(R.id.day5);
        day6 = findViewById(R.id.day6);
        day7 = findViewById(R.id.day7);

        drug1 = findViewById(R.id.drug1);
        drug2 = findViewById(R.id.drug2);
        drug3 = findViewById(R.id.drug3);
        drug4 = findViewById(R.id.drug4);
        drug5 = findViewById(R.id.drug5);
        drug6 = findViewById(R.id.drug6);
        drug7 = findViewById(R.id.drug7);




        // Buttons
        saveButton = (Button) findViewById(R.id.saveButton);
        cancelButton = (Button) findViewById(R.id.cancelButton);




        cancelButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent =new Intent (getApplicationContext(),MainMenuActivity.class);
                startActivity(intent);
            }

        });


        saveButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                final String drug_1 = drug1.getText().toString().trim();
                final String drug_2= drug2.getText().toString().trim();
                final String drug_3 = drug3.getText().toString().trim();
                final String drug_4= drug4.getText().toString().trim();
                final String drug_5 = drug5.getText().toString().trim();
                final String drug_6= drug6.getText().toString().trim();
                final String drug_7= drug7.getText().toString().trim();

                mDatabase.child(getString(R.string.user)).child(user_id).child(getString(R.string.hardware_details)).child(getString(R.string.medication)).child(getString(R.string.monday)).child(getString(R.string.name)).setValue(drug_1);
                mDatabase.child(getString(R.string.user)).child(user_id).child(getString(R.string.hardware_details)).child(getString(R.string.medication)).child(getString(R.string.tuesday)).child(getString(R.string.name)).setValue(drug_2);
                mDatabase.child(getString(R.string.user)).child(user_id).child(getString(R.string.hardware_details)).child(getString(R.string.medication)).child(getString(R.string.wenesday)).child(getString(R.string.name)).setValue(drug_3);
                mDatabase.child(getString(R.string.user)).child(user_id).child(getString(R.string.hardware_details)).child(getString(R.string.medication)).child(getString(R.string.thursday)).child(getString(R.string.name)).setValue(drug_4);
                mDatabase.child(getString(R.string.user)).child(user_id).child(getString(R.string.hardware_details)).child(getString(R.string.medication)).child(getString(R.string.friday)).child(getString(R.string.name)).setValue(drug_5);
                mDatabase.child(getString(R.string.user)).child(user_id).child(getString(R.string.hardware_details)).child(getString(R.string.medication)).child(getString(R.string.saturday)).child(getString(R.string.name)).setValue(drug_6);
                mDatabase.child(getString(R.string.user)).child(user_id).child(getString(R.string.hardware_details)).child(getString(R.string.medication)).child(getString(R.string.sunday)).child(getString(R.string.name)).setValue(drug_7);

                //For new planning, all values for taken and time_taken must be reset to default values
                mDatabase.child(getString(R.string.user)).child(user_id).child(getString(R.string.hardware_details)).child(getString(R.string.medication)).child(getString(R.string.monday)).child(getString(R.string.taken)).setValue("Not taked");
                mDatabase.child(getString(R.string.user)).child(user_id).child(getString(R.string.hardware_details)).child(getString(R.string.medication)).child(getString(R.string.tuesday)).child(getString(R.string.taken)).setValue("Not taked");
                mDatabase.child(getString(R.string.user)).child(user_id).child(getString(R.string.hardware_details)).child(getString(R.string.medication)).child(getString(R.string.wenesday)).child(getString(R.string.taken)).setValue("Not taked");
                mDatabase.child(getString(R.string.user)).child(user_id).child(getString(R.string.hardware_details)).child(getString(R.string.medication)).child(getString(R.string.thursday)).child(getString(R.string.taken)).setValue("Not taked");
                mDatabase.child(getString(R.string.user)).child(user_id).child(getString(R.string.hardware_details)).child(getString(R.string.medication)).child(getString(R.string.friday)).child(getString(R.string.taken)).setValue("Not taked");
                mDatabase.child(getString(R.string.user)).child(user_id).child(getString(R.string.hardware_details)).child(getString(R.string.medication)).child(getString(R.string.saturday)).child(getString(R.string.taken)).setValue("Not taked");
                mDatabase.child(getString(R.string.user)).child(user_id).child(getString(R.string.hardware_details)).child(getString(R.string.medication)).child(getString(R.string.sunday)).child(getString(R.string.taken)).setValue("Not taked");

                mDatabase.child(getString(R.string.user)).child(user_id).child(getString(R.string.hardware_details)).child(getString(R.string.medication)).child(getString(R.string.monday)).child(getString(R.string.time_taken)).setValue("No time");
                mDatabase.child(getString(R.string.user)).child(user_id).child(getString(R.string.hardware_details)).child(getString(R.string.medication)).child(getString(R.string.tuesday)).child(getString(R.string.time_taken)).setValue("No time");
                mDatabase.child(getString(R.string.user)).child(user_id).child(getString(R.string.hardware_details)).child(getString(R.string.medication)).child(getString(R.string.wenesday)).child(getString(R.string.time_taken)).setValue("No time");
                mDatabase.child(getString(R.string.user)).child(user_id).child(getString(R.string.hardware_details)).child(getString(R.string.medication)).child(getString(R.string.thursday)).child(getString(R.string.time_taken)).setValue("No time");
                mDatabase.child(getString(R.string.user)).child(user_id).child(getString(R.string.hardware_details)).child(getString(R.string.medication)).child(getString(R.string.friday)).child(getString(R.string.time_taken)).setValue("No time");
                mDatabase.child(getString(R.string.user)).child(user_id).child(getString(R.string.hardware_details)).child(getString(R.string.medication)).child(getString(R.string.saturday)).child(getString(R.string.time_taken)).setValue("No time");
                mDatabase.child(getString(R.string.user)).child(user_id).child(getString(R.string.hardware_details)).child(getString(R.string.medication)).child(getString(R.string.sunday)).child(getString(R.string.time_taken)).setValue("No time");

                Intent intent =new Intent (getApplicationContext(),MainMenuActivity.class);
                startActivity(intent);
            }

        });

    }
}
