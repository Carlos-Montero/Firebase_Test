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


public class LoginActivity extends AppCompatActivity  implements
        View.OnClickListener{

    private static final String TAG = "EmailPassword";   //***********ESTO TIENE QUE ESTAR???***********+

    //DECLARACIÓN VARIABLES
    private EditText mEmailField;
    private EditText mPasswordField;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        // Views
        mEmailField = findViewById(R.id.mail);
        mPasswordField = findViewById(R.id.password);

        // Buttons
        findViewById(R.id.login).setOnClickListener(this);
        findViewById(R.id.labelregister).setOnClickListener(this);

    }




    //MÉTODO PARA VALIDAR QUE SE HA RELLENADO EL FORM CORRECTAMENTE
    private boolean validateForm() {
        boolean valid = true;

        String email = mEmailField.getText().toString();
        if (TextUtils.isEmpty(email)) {
            mEmailField.setError("Required.");
            valid = false;
        } else {
            mEmailField.setError(null);
        }

        String password = mPasswordField.getText().toString();
        if (TextUtils.isEmpty(password)) {
            mPasswordField.setError("Required.");
            valid = false;
        } else {
            mPasswordField.setError(null);
        }

        return valid;
    }




    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.login) {

//***************************************Revisar Intent*******************************************
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);

        } //else if (i == R.id.emailSignInButton) {
            //signIn(mEmailField.getText().toString(), mPasswordField.getText().toString());
        //}
    }



}
