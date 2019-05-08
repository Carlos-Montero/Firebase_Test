package com.example.carlos.firebase_test.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

public class TemperatureMonitoringViewmodel extends ViewModel {

    //LiveData for temperature value
    private LiveData<String> temperature;
    public LiveData<String> getTemperature(){
        return temperature;
    }


    public TemperatureMonitoringViewmodel() {
        // trigger user load.
    }

    void doAction() {
        // depending on the action, do necessary business logic calls and update the
        // userLiveData.
    }


}
