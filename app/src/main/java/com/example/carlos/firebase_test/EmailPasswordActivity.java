package com.example.carlos.firebase_test;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carlos.firebase_test.model.User;
import com.example.carlos.firebase_test.view.MainMenuActivity;
import com.example.carlos.firebase_test.view.TemperatureMonitoringActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;
//import com.google.firebase.quickstart.auth.R;


public class EmailPasswordActivity extends AppCompatActivity {

    //DECLARACIÓN VARIABLES
    private TextView mStatusTextView, mDetailTextView;
    private EditText mEmailField, mPasswordField;
    private Button emailSignInButton, emailCreateAccountButton;

    private ProgressDialog progressDialog;

    //Firebase instances
    private FirebaseAuth mAuth;
    private FirebaseDatabase mDatabase;
    private DatabaseReference mDbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emailpassword);

        //Firebase
        mAuth=FirebaseAuth.getInstance();

        //Progress dialog
        progressDialog = new ProgressDialog(this);

        // Views
        mEmailField = findViewById(R.id.fieldEmail);
        mPasswordField = findViewById(R.id.fieldPassword);

        // Buttons
        emailSignInButton = (Button) findViewById(R.id.emailSignInButton);
        emailCreateAccountButton = (Button) findViewById(R.id.emailCreateAccountButton);



        //Register listener
        emailCreateAccountButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                registerUser();
            }

        });

        //Login listener
        emailSignInButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                loginUser();
            }

        });


    }

    private void loginUser() {
        final String email = mEmailField.getText().toString().trim();
        final String password= mPasswordField.getText().toString().trim();

        progressDialog.setMessage("Login ...");
        progressDialog.show();

        if(TextUtils.isEmpty(email)){

            Toast.makeText(this,"Please enter email",Toast.LENGTH_SHORT);

            //Stopping the function execution
            return;
        }

        if(TextUtils.isEmpty(password)){


            //Stopping the function execution
            return;
        }
        Toast.makeText(this,"Please enter password",Toast.LENGTH_SHORT);


        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()) {
                            Intent intent =new Intent (getApplicationContext(),MainMenuActivity.class);
                            startActivity(intent);

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(EmailPasswordActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();

                        }
                    }
                });

    }

    private void registerUser() {
        final String email = mEmailField.getText().toString().trim();
        final String password= mPasswordField.getText().toString().trim();
        final String hardware = "ESP32_0001";


        if(TextUtils.isEmpty(email)){

            Toast.makeText(this,"Please enter email",Toast.LENGTH_SHORT);

            //Stopping the function execution
            return;
        }

        if(TextUtils.isEmpty(password)){

            Toast.makeText(this,"Please enter password",Toast.LENGTH_SHORT);

            //Stopping the function execution
            return;
        }

        //If validations are ok, we will show a progress bar
        progressDialog.setMessage("Registering User ...");
        progressDialog.show();

        //Authenticating an User

        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();

                if(task.isSuccessful()) {
                    //if registration is successful, we will add the user to the database
                    Toast.makeText(getApplicationContext(), "successful",Toast.LENGTH_SHORT).show();

                    //the logic for adding a user still need to be decided( user auth and not already exist,etc). Meanwhile we test if it works here.
                    String user_id;
                    user_id=mAuth.getUid();
                    addUsertoDatabase(user_id,email,password,hardware);

                }

                else{
                    Toast.makeText(EmailPasswordActivity.this, "Could not register. Please try again", Toast.LENGTH_SHORT).show();
                }


            }

        });
    }

    private void addUsertoDatabase(String user_id, String email, String password, String hardware) {
        mDatabase = FirebaseDatabase.getInstance();
        mDbRef = mDatabase.getReference("User");

        //RealDataBase Structure design

        //User Details
        User user = new User(email, password, hardware);

        mDbRef.child(user_id).child("user_details").setValue(user).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                //Write was successful
                Toast.makeText(EmailPasswordActivity.this, "User data added to the database", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                //Write failed
                Toast.makeText(EmailPasswordActivity.this, "Could not add the user data on the database", Toast.LENGTH_SHORT).show();
            }
        });

        //Writing Hashmap for the rest of elements in DB
        Map<String, Object> mHashmap = new HashMap<>();

        mHashmap.put("Presence/up", "No");
        mHashmap.put("Presence/down", "No");
        mHashmap.put("Temperature/temperature", "15 ºC");
        mHashmap.put("Tap/tap_state", "Close");
        mHashmap.put("Medication/monday/name", "N/A");
        mHashmap.put("Medication/monday/taken", "Not taked");
        mHashmap.put("Medication/monday/time_taken", "No time");
        mHashmap.put("Medication/tuesday/name", "N/A");
        mHashmap.put("Medication/tuesday/taken", "Not taked");
        mHashmap.put("Medication/tuesday/time_taken", "No time");
        mHashmap.put("Medication/wenesday/name", "N/A");
        mHashmap.put("Medication/wenesday/taken", "Not taked");
        mHashmap.put("Medication/wenesday/time_taken", "No time");
        mHashmap.put("Medication/thursday/name", "N/A");
        mHashmap.put("Medication/thursday/taken", "Not taked");
        mHashmap.put("Medication/thursday/time_taken", "No time");
        mHashmap.put("Medication/friday/name", "N/A");
        mHashmap.put("Medication/friday/taken", "Not taked");
        mHashmap.put("Medication/friday/time_taken", "No time");
        mHashmap.put("Medication/saturday/name", "N/A");
        mHashmap.put("Medication/saturday/taken", "Not taked");
        mHashmap.put("Medication/saturday/time_taken", "No time");
        mHashmap.put("Medication/sunday/name", "N/A");
        mHashmap.put("Medication/sunday/taken", "Not taked");
        mHashmap.put("Medication/sunday/time_taken", "No time");

       // mDbRef.child(user_id).updateChildren(mHashmap);

        mDbRef.child(user_id).child("hardware details").updateChildren(mHashmap).addOnSuccessListener(new OnSuccessListener<Void>() {

            @Override
            public void onSuccess(Void aVoid) {
                //Write was successful
                Toast.makeText(EmailPasswordActivity.this, "User data added to the database", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                //Write failed
                Toast.makeText(EmailPasswordActivity.this, "Could not add the user data on the database", Toast.LENGTH_SHORT).show();
            }
        });

        Intent intent =new Intent (getApplicationContext(),MainMenuActivity.class);
        startActivity(intent);

    }


}




