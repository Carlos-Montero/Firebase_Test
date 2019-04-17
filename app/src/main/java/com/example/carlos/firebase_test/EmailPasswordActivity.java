package com.example.carlos.firebase_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
//QUÉ IMPORT HAY QUE HACER????????
//*********************import com.google.firebase.quickstart.auth.R;


public class EmailPasswordActivity extends AppCompatActivity implements
        View.OnClickListener{


    private static final String TAG = "EmailPassword";

    //DECLARACIÓN VARIABLES
    private TextView mStatusTextView;
    private TextView mDetailTextView;
    private EditText mEmailField;
    private EditText mPasswordField;


    //DECLARAMOS UNA INSTANCIA DE FirebaseAuth
    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emailpassword);

        // Views
        mStatusTextView = findViewById(R.id.status);
        mDetailTextView = findViewById(R.id.detail);
        mEmailField = findViewById(R.id.fieldEmail);
        mPasswordField = findViewById(R.id.fieldPassword);

        // Buttons
        findViewById(R.id.emailSignInButton).setOnClickListener(this);
        findViewById(R.id.emailCreateAccountButton).setOnClickListener(this);
        findViewById(R.id.signOutButton).setOnClickListener(this);
        findViewById(R.id.verifyEmailButton).setOnClickListener(this);

        //INICIALIZAMOS LA INSTANCIA DE FirebaseAuth
        mAuth=FirebaseAuth.getInstance();
    }


    //AL INICIAR LA ACTIVIDAD, VERIFICAR QUE EL USUARIO HAYA ACCEDIDO
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }



    //REGISTRAR NUEVOS USUARIOS
    //PRIMERO, MÉTODO createAccount QUE RECIBE MAIL Y PASSWORD
    private void createAccount(String email, String password) {
        Log.d(TAG, "createAccount:" + email);
        if (!validateForm()) {
            return;
        }

        //showProgressDialog();

        //SEGUNDO, MÉTODO createUserWithEmailAndPassword PARA CREAR EL USUARIO
        // [START create_user_with_email]
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                        // [START_EXCLUDE]
                        //hideProgressDialog();
                        // [END_EXCLUDE]
                    }
                });
    }



    //MÉTODO signIn QUE RECIBA MAIL Y PASSWORD, LO VALIDE Y PERMITA AL USUARIO ACCEDER CON EL MÉTODO signInWithEmailPassword
    private void signIn(String email, String password) {
        Log.d(TAG, "signIn:" + email);
        if (!validateForm()) {
            return;
        }
        //showProgressDialog();

        // [START sign_in_with_email]
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        // [START_EXCLUDE]
                        //if (!task.isSuccessful()) {
                          //  mStatusTextView.setText(R.string.auth_failed);
                        //}
                        //hideProgressDialog();
                        // [END_EXCLUDE]
                    }
                });
        // [END sign_in_with_email]
    }





        //MÉTODO PARA HACER EL SIGN OUT
        private void signOut() {
                mAuth.signOut();
                updateUI(null);
            }



        //MÉTODO PARA ENVIAR EL EMAIL DE VERIFICACIÓN****************
    //**************DE MOMENTO NO LO PONEMOS**********************+





    //*************************************************************















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





    private void updateUI(FirebaseUser user) {
        //hideProgressDialog();
        if (user != null) {
            //mStatusTextView.setText(getString(R.string.emailpassword_status_fmt,
              //      user.getEmail(), user.isEmailVerified()));
            //mDetailTextView.setText(getString(R.string.firebase_status_fmt, user.getUid()));

            findViewById(R.id.emailPasswordButtons).setVisibility(View.GONE);
            findViewById(R.id.emailPasswordFields).setVisibility(View.GONE);
            findViewById(R.id.signedInButtons).setVisibility(View.VISIBLE);

            findViewById(R.id.verifyEmailButton).setEnabled(!user.isEmailVerified());
        } else {
            //mStatusTextView.setText(R.string.signed_out);
            mDetailTextView.setText(null);

            findViewById(R.id.emailPasswordButtons).setVisibility(View.VISIBLE);
            findViewById(R.id.emailPasswordFields).setVisibility(View.VISIBLE);
            findViewById(R.id.signedInButtons).setVisibility(View.GONE);
        }
    }




    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.emailCreateAccountButton) {
            createAccount(mEmailField.getText().toString(), mPasswordField.getText().toString());
        } else if (i == R.id.emailSignInButton) {
            signIn(mEmailField.getText().toString(), mPasswordField.getText().toString());
        } else if (i == R.id.signOutButton) {
            signOut();
        } //else if (i == R.id.verifyEmailButton) {
          //  sendEmailVerification();
        //}
    }




}



