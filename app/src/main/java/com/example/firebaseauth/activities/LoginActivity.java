package com.example.firebaseauth.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.firebaseauth.utils.ApplicationEx;
import com.example.firebaseauth.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout emailFieldLayout;
    private TextInputLayout passwordFieldLayout;
    private TextInputEditText emailField;
    private TextInputEditText passwordField;
    private Button loginBtn;
    private TextView loginLink;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = Objects.requireNonNull(emailField.getText()).toString().trim();
                final String password = Objects.requireNonNull(passwordField.getText()).toString().trim();
                logIn(email, password);
            }
        });
        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
            }
        });
    }

    private void initViews() {
        auth = getApplicationEx().getAuth();
        emailField = findViewById(R.id.login_activity_email);
        passwordField = findViewById(R.id.login_activity_password);
        emailFieldLayout = findViewById(R.id.login_layout_email);
        passwordFieldLayout = findViewById(R.id.login_layout_password);
        loginBtn = findViewById(R.id.login_activity_loginBtn);
        loginLink = findViewById(R.id.login_activity_loginLink);
    }

    private void logIn(final String email, final String password) {

        if (isDataValid(email, password)) {
            auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                            } else {
                                loginError();
                            }
                        }
                    });
        }
    }

    private boolean isEmailValid(final String email) {
        if (email.isEmpty()) {
            emailFieldLayout.setError(getString(R.string.enter_email));
            emailFieldLayout.requestFocus();
            return false;
        } else {
            emailFieldLayout.setError(null);
            return true;
        }
    }

    private boolean isPasswordValid(final String password) {
        if (password.isEmpty() || password.length() < 8) {
            passwordFieldLayout.setError(getString(R.string.invalid_password));
            passwordFieldLayout.requestFocus();
            return false;
        } else {
            passwordFieldLayout.setError(null);
            return true;
        }
    }

    private boolean isDataValid(final String email, final String password) {
        boolean emailValid = isEmailValid(email);
        boolean passwordValid = isPasswordValid(password);

        return emailValid && passwordValid;
    }

    private void loginError() {
        Toast.makeText(LoginActivity.this, getString(R.string.login_error), Toast.LENGTH_LONG).show();
    }

    private ApplicationEx getApplicationEx(){
        return ((ApplicationEx) getApplication());
    }
}