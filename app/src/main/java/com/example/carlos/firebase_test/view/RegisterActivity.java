package com.example.carlos.firebase_test.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.carlos.firebase_test.R;
import com.example.carlos.firebase_test.model.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    private static final String TAG = "RegisterActivity";
    private FirebaseDatabase mDatabase;
    private DatabaseReference mDbRef;
    private DatabaseReference mDbRef2;
    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Write a message to the database
        mDatabase = FirebaseDatabase.getInstance();
        mDbRef = mDatabase.getReference();

        //Setting firebase unique key for Hashmap list
        String userId = mDbRef.push().getKey();
        // creating user object
        User user = new User("Hillary@gmail.com", "1234", "12345678");
        mDbRef.child(userId).setValue(user);
        

    }
}
