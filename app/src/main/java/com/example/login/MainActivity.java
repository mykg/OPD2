package com.example.login;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.example.login.User;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot; // to read data from json of firebase
import com.google.firebase.database.FirebaseDatabase; //for getting DB instance reference
import com.google.firebase.database.DatabaseReference; // same^

//import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    ProgressBar progressBar;
    EditText fullname;
    EditText email;
    EditText password;
    EditText phone;
    EditText address;
    EditText aadharno;
    Button signup;
    Button login;
    Button forgotPass;

    FirebaseAuth firebaseAuth;

    DatabaseReference usrRef; //object of this class for reference creation

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        usrRef = FirebaseDatabase.getInstance().getReference("user"); //instance of database of opd-app


        FirebaseAuth firebaseauth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseauth.getCurrentUser();
        if(firebaseUser != null){
            startActivity(new Intent(MainActivity.this, ProfileActivity.class));
        }
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        progressBar = findViewById(R.id.progressBar);
        fullname = findViewById(R.id.name);
        email = findViewById(R.id.Email);
        password = findViewById(R.id.Password);
        phone = findViewById(R.id.phone);
        address = findViewById(R.id.address);
        aadharno = findViewById(R.id.aadhar);
        signup = findViewById(R.id.signup);
        login = findViewById(R.id.Login);
        forgotPass = findViewById(R.id.UserForgotPass);

        toolbar.setTitle(R.string.app_name);

        firebaseAuth = com.google.firebase.auth.FirebaseAuth.getInstance();
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressBar.setVisibility(View.GONE);
                        if(task.isSuccessful()){

                            // User class object for structure of database
                            User usr = new User(fullname.getText().toString(),email.getText().toString(),password.getText().toString(),phone.getText().toString(),address.getText().toString(),aadharno.getText().toString());

                            //this adds data to json file on firebase
                            usrRef.child(aadharno.getText().toString()).setValue(usr);

                            Toast.makeText(MainActivity.this,"Registered Successfully",
                                    Toast.LENGTH_LONG).show();
                            fullname.getText().clear();
                            email.getText().clear();
                            phone.getText().clear();
                            password.getText().clear();
                            address.getText().clear();
                            aadharno.getText().clear();
                        }else{
                            Toast.makeText(MainActivity.this, task.getException().getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });

        DatabaseReference var;
        var = FirebaseDatabase.getInstance().getReference();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });

        forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ForgotPasswordActivity.class));
            }
        });


    }
}

