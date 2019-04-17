package com.example.carlos.firebase_test.view;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carlos.firebase_test.R;

public class MainMenuActivity extends AppCompatActivity implements
        View.OnClickListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        // Views

        // Buttons
        findViewById(R.id.presenceMonitoring).setOnClickListener(this);
        findViewById(R.id.waterControl).setOnClickListener(this);
        findViewById(R.id.temperature).setOnClickListener(this);
        findViewById(R.id.planificationCreator).setOnClickListener(this);
        findViewById(R.id.planificationViewer).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.presenceMonitoring) {

//***************************************Revisar Intent*******************************************
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);

        } //else if (i == R.id.emailSignInButton) {
        //signIn(mEmailField.getText().toString(), mPasswordField.getText().toString());
        //}
    }





}
