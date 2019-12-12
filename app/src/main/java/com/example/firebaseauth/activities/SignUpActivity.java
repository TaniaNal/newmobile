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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

import java.util.Objects;

public class SignUpActivity extends AppCompatActivity {

    private TextInputLayout emailFieldLayout;
    private TextInputLayout passwordFieldLayout;
    private TextInputLayout usernameFieldLayout;
    private TextInputLayout phoneFieldLayout;
    private TextInputEditText emailField;
    private TextInputEditText passwordField;
    private TextInputEditText usernameField;
    private TextInputEditText phoneField;
    private FirebaseAuth auth;
    private Button signupBtn;
    private TextView loginLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        initViews();

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = Objects.requireNonNull(emailField.getText()).toString().trim();
                final String password = Objects.requireNonNull(passwordField.getText()).toString().trim();
                final String username = Objects.requireNonNull(usernameField.getText()).toString().trim();
                final String phone = Objects.requireNonNull(phoneField.getText()).toString().trim();
                signUp(email, password, username, phone);
            }
        });

        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
            }
        });
    }

    private void initViews() {
        emailFieldLayout = findViewById(R.id.signup_layout_email);
        passwordFieldLayout = findViewById(R.id.signup_layout_password);
        usernameFieldLayout = findViewById(R.id.signup_layout_username);
        phoneFieldLayout = findViewById(R.id.signup_layout_phone);
        emailField = findViewById(R.id.signup_activity_email);
        passwordField = findViewById(R.id.signup_activity_password);
        usernameField = findViewById(R.id.signup_activity_username);
        phoneField = findViewById(R.id.signup_activity_phone);
        auth = getApplicationEx().getAuth();
        signupBtn = findViewById(R.id.signup_activity_signupBtn);
        loginLink = findViewById(R.id.signup_activity_loginLink);
    }

    private void signUp(final String email, final String password, final String username, final String phone) {
        if (isDataValid(username, phone, email, password)) {
            auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(SignUpActivity.this, getString(R.string.email_taken), Toast.LENGTH_LONG).show();
                            } else {
                                onCompleteSuccess(username);
                            }
                        }
                    });
        }
    }

    private void onCompleteSuccess(final String username) {
        FirebaseUser user = auth.getCurrentUser();
        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                .setDisplayName(username).build();

        if (user != null) {
            user.updateProfile(profileUpdates).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        SignUpActivity.this.startActivity(new Intent(SignUpActivity.this, MainActivity.class));
                    }
                }
            });
        }
    }

    private boolean isEmailValid(final String email) {
        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailFieldLayout.setError(getString(R.string.enter_valid_email));
            emailFieldLayout.requestFocus();
            return false;
        } else {
            emailFieldLayout.setError(null);
            return true;
        }
    }

    private boolean isPasswordValid(final String password) {
        if (password.isEmpty() || password.length() < 8) {
            passwordFieldLayout.setError(getString(R.string.password_limit));
            passwordFieldLayout.requestFocus();
            return false;
        } else {
            passwordFieldLayout.setError(null);
            return true;
        }
    }

    private boolean isUsernameValid(final String username) {
        if (username.isEmpty()) {
            usernameFieldLayout.setError(getString(R.string.enter_username));
            usernameFieldLayout.requestFocus();
            return false;
        } else {
            usernameFieldLayout.setError(null);
            return true;
        }
    }

    private boolean isPhoneValid(final String phone) {
        if (phone.isEmpty() || (!phone.matches("^[0-9]$") && phone.length() < 10)) {
            phoneFieldLayout.setError(getString(R.string.enter_valid_phone));
            phoneFieldLayout.requestFocus();
            return false;
        } else {
            phoneFieldLayout.setError(null);
            return true;
        }
    }

    private boolean isDataValid(final String username, final String phone, final String email, final String password) {
        boolean usernameValid = isUsernameValid(username);
        boolean phoneValid = isPhoneValid(phone);
        boolean emailValid = isEmailValid(email);
        boolean passwordValid = isPasswordValid(password);

        return usernameValid && phoneValid && emailValid && passwordValid;
    }

    private ApplicationEx getApplicationEx(){
        return ((ApplicationEx) getApplication());
    }
}