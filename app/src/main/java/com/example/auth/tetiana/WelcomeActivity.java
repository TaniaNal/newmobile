package com.example.auth.tetiana;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class WelcomeActivity extends AppCompatActivity {
    TextView Email;
    FirebaseUser User;
    Button LogOut ;

    public static final String TAG="LOGIN";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Email = (TextView)findViewById(R.id.welcome);
        LogOut = (Button)findViewById(R.id.buttonLogOut);
        User = FirebaseAuth.getInstance().getCurrentUser();
        Email.setText(Email.getText().toString()+ User.getDisplayName());

        LogOut.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
                Intent intent=new Intent(WelcomeActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

    }


    @Override
    public void onBackPressed() {
        Intent setIntent = new Intent(Intent.ACTION_MAIN);
        setIntent.addCategory(Intent.CATEGORY_HOME);
        setIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(setIntent);
    }

}