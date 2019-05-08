package com.example.carlos.firebase_test.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.carlos.firebase_test.R;
import com.example.carlos.firebase_test.model.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

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
        mDbRef = mDatabase.getReference("User");

        //Setting firebase unique key for Hashmap list
        String userId = mDbRef.push().getKey();
        // creating user object
        User user = new User("Bill@gmail.com", "1234", "12345678");
        mDbRef.child(userId).setValue(user);


        //Writing Hashmap for the rest of elements in DB
        Map<String, Object> mHashmap = new HashMap<>();

        mHashmap.put("Presence/up", "No");
        mHashmap.put("Presence/down", "No");
        mHashmap.put("Temperature/temperature", "15 ºC");
        mHashmap.put("Tap/tap_state", "cerrado");
        mHashmap.put("Medication/drug1/name", "Ibuprofeno");
        mHashmap.put("Medication/drug1/day", "lunes");
        mHashmap.put("Medication/drug1/taken", "no");
        mHashmap.put("Medication/drug1/time_taken", "21h");
        mHashmap.put("Medication/drug2/name", "Ibuprofeno");
        mHashmap.put("Medication/drug2/day", "lunes");
        mHashmap.put("Medication/drug2/taken", "no");
        mHashmap.put("Medication/drug2/time_taken", "21h");


        mDbRef.child(userId).updateChildren(mHashmap);
    }
}
