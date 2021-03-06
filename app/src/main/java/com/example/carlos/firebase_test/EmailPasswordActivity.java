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

/**
 * EmailPasswordActivity:
 *
 * This activity is used to Register and LogIn
 * users in our application.
 * One a user is registered, it push to the Firebase
 * RealTime DataBase a HashMap with all the information
 * needed.
 */
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

    /**
     * onCreated() defines the components of the layout
     *
     */
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

    /**
     * loginUser() logs in the user to the Authentication Database in Firebase
     */
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

    /**
     * registerUser() Registers the user to the Authentication Database in Firebase
     *
     */
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

    /**
     * addUsertoDatabase() adds the user to the Firebase Database, with default values for hardware details
     * @param user_id (created automaticaly)
     * @param email
     * @param password
     * @param hardware (ESP32_0001 by default)
     */
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

        mHashmap.put(getString(R.string.presence_up), getString(R.string.default_up));
        mHashmap.put(getString(R.string.presence_down),  getString(R.string.default_down));
        mHashmap.put(getString(R.string.temperature),  getString(R.string.default_temperature));
        mHashmap.put(getString(R.string.tap_state),  getString(R.string.default_tap_state));

        mHashmap.put(getString(R.string.monday_medicine), getString(R.string.defaul_medicine));
        mHashmap.put(getString(R.string.tuesday_medicine), getString(R.string.defaul_medicine));
        mHashmap.put(getString(R.string.wenesday_medicine), getString(R.string.defaul_medicine));
        mHashmap.put(getString(R.string.thursday_medicine), getString(R.string.defaul_medicine));
        mHashmap.put(getString(R.string.friday_medicine), getString(R.string.defaul_medicine));
        mHashmap.put(getString(R.string.saturday_medicine), getString(R.string.defaul_medicine));
        mHashmap.put(getString(R.string.sunday_medicine), getString(R.string.defaul_medicine));

        mHashmap.put(getString(R.string.monday_taken), getString(R.string.defaul_taken));
        mHashmap.put(getString(R.string.tuesday_taken), getString(R.string.defaul_taken));
        mHashmap.put(getString(R.string.wenesday_taken), getString(R.string.defaul_taken));
        mHashmap.put(getString(R.string.thursday_taken), getString(R.string.defaul_taken));
        mHashmap.put(getString(R.string.friday_taken), getString(R.string.defaul_taken));
        mHashmap.put(getString(R.string.saturday_taken), getString(R.string.defaul_taken));
        mHashmap.put(getString(R.string.sunday_taken), getString(R.string.defaul_taken));

        mHashmap.put(getString(R.string.monday_time_taken), getString(R.string.defaul_time_taken));
        mHashmap.put(getString(R.string.tuesday_time_taken), getString(R.string.defaul_time_taken));
        mHashmap.put(getString(R.string.wenesday_time_taken), getString(R.string.defaul_time_taken));
        mHashmap.put(getString(R.string.thursday_time_taken), getString(R.string.defaul_time_taken));
        mHashmap.put(getString(R.string.friday_time_taken), getString(R.string.defaul_time_taken));
        mHashmap.put(getString(R.string.saturday_time_taken), getString(R.string.defaul_time_taken));
        mHashmap.put(getString(R.string.sunday_time_taken), getString(R.string.defaul_time_taken));

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




