package com.example.registerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {

    FirebaseAuth auth;
    Button signup;
    EditText name , email , password;
    TextView log , textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        auth = FirebaseAuth.getInstance();
        signup = findViewById(R.id.buttonLogin);
        name = findViewById(R.id.editTextTextName);
        email = findViewById(R.id.editTextTextEmailAddress);
        password = findViewById(R.id.editTextTextPassword);
        textView2 = findViewById(R.id.textView2);
        log = findViewById(R.id.textSignUp);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(login.this,MainActivity.class));
                finish();            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loginUser();
         }
        });

    }
    private void loginUser() {
        String userEmail = email.getText().toString();
        String userPassword = password.getText().toString();



        if(TextUtils.isEmpty(userEmail)){
            Toast.makeText(this,"Email is Empty",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(userPassword)){
            Toast.makeText(this,"Password is Empty",Toast.LENGTH_LONG).show();
            return;
        }
        if(userPassword.length()<6){
            Toast.makeText(this,"Password must be greater than 6 letters",Toast.LENGTH_LONG).show();
            return;
        }
        else
            textView2.setText("Please Wait ......");

        auth.signInWithEmailAndPassword(userEmail,userPassword)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(login.this,"Login Successfully",Toast.LENGTH_LONG).show();
                            startActivity(new Intent(login.this,welcome.class));
                            finish();                }
                        else
                            Toast.makeText(login.this,"Your Email or Password is invalid, please try again",Toast.LENGTH_LONG).show();
                    }
                });
        }
}
