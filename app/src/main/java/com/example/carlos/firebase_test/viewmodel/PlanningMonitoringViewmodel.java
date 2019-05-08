package com.example.carlos.firebase_test.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PlanningMonitoringViewmodel extends ViewModel {

    private MutableLiveData<String> value;


    public LiveData<String> getValue() {

        if (value == null) {
            value = new MutableLiveData<String>();
            loadValue();
        }
        return value;
    }


    private void loadValue() {
        // Do an asynchronous operation to fetch users.
    }
}