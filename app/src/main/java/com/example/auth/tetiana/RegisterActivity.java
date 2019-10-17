package com.example.auth.tetiana;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    String UserName;
    String Phone;
    String Email;
    String Password;
    EditText username;
    EditText phone;
    EditText email;
    EditText password;
    TextView mBack;
    FirebaseAuth mAuth;
    DatabaseReference mdatabase;
    ProgressDialog mDialog;
    Button mRegisterbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = findViewById(R.id.editUserName);
        phone = findViewById(R.id.editPhone);
        email = findViewById(R.id.editEmail);
        password = findViewById(R.id.editPassword);
        mRegisterbtn = findViewById(R.id.buttonRegister);
        mBack = findViewById(R.id.buttonLogin);

        mAuth = FirebaseAuth.getInstance();
        mRegisterbtn.setOnClickListener(this);
        mBack.setOnClickListener(this);
        mDialog = new ProgressDialog(this);
        mdatabase = FirebaseDatabase.getInstance().getReference().child("Profile");

    }

    @Override
    public void onBackPressed() {
        Intent setIntent = new Intent(Intent.ACTION_MAIN);
        setIntent.addCategory(Intent.CATEGORY_HOME);
        setIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(setIntent);
    }

    @Override
    public void onClick(View v) {
        if (v == mRegisterbtn) {
            UserRegister();
        } else if (v == mBack) {
            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.FROYO)
    private void UserRegister() {
        UserName = username.getText().toString().trim();
        Phone = phone.getText().toString().trim();
        Email = email.getText().toString().trim();
        Password = password.getText().toString().trim();

        if (TextUtils.isEmpty(UserName)) {
            username.setError("Enter UserName");
            username.setFocusable(true);
            return;
        }
        if (TextUtils.isEmpty(Phone)) {
            phone.setError("Enter Phone");
            phone.setFocusable(true);
            return;
        }
        if (!Patterns.PHONE.matcher(Phone).matches()) {
            phone.setError("Invalid Phone");
            phone.setFocusable(true);
            return;
        }
        if (TextUtils.isEmpty(Email)) {
            email.setError("Enter Email");
            email.setFocusable(true);
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
            email.setError("Invalid Email");
            email.setFocusable(true);
            return;
        }
        if (TextUtils.isEmpty(Password)) {
            password.setError("Enter Password");
            password.setFocusable(true);
            return;
        }
        if (Password.length() < 8) {
            password.setError("Password length at least 8 characters");
            password.setFocusable(true);
            return;
        }


        mDialog.setMessage("Creating User please wait...");
        mDialog.setCanceledOnTouchOutside(false);
        mDialog.show();

        mAuth.createUserWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {


                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                        .setDisplayName(UserName)
                        .build();

                user.updateProfile(profileUpdates)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Intent intent = new Intent(RegisterActivity.this, WelcomeActivity.class);
                                    mDialog.dismiss();
                                    startActivity(intent);

                                }
                            }
                        });


            }
        });
    }

}
