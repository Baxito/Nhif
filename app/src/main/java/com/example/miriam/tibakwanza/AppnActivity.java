package com.example.miriam.tibakwanza;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.fasterxml.jackson.core.sym.Name;
import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AppnActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Button sbmt;
    String[] Courses={"CSE","ECE","EEE","ISNE","CIVIL","MECHANICS","EDUCATION"};
    EditText fname,pwd,reg,gndr,dBirth,natn,mStatus;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;
    Spinner spinner;
    DatabaseReference databaseReference;
    private Firebase mRootRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appn);
        sbmt = findViewById(R.id.submit);
        fname = findViewById(R.id.user_name);
        pwd = findViewById(R.id.pass);
        reg = findViewById(R.id.regNo);
        gndr =findViewById(R.id.gender);
        dBirth = findViewById(R.id.dob);
        natn = findViewById(R.id.nation);
        mStatus = findViewById(R.id.marital);
        progressBar = findViewById(R.id.progressBar);
        databaseReference = FirebaseDatabase.getInstance().getReference("Registration");

        mAuth = FirebaseAuth.getInstance();
        mRootRef = new Firebase("https://tibakwanza-master.firebaseio.com/Users");

        //Starting new activity from submit button
            sbmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = fname.getText().toString();
                String value1 = pwd.getText().toString();
                String value2 = reg.getText().toString();
                String value3 = gndr.getText().toString();
                String value4 = dBirth.getText().toString();
                String value5 = natn.getText().toString();
                String value6 = mStatus.getText().toString();

                mRootRef.push().setValue(value);
                mRootRef.push().setValue(value1);
                mRootRef.push().setValue(value2);
                mRootRef.push().setValue(value3);
                mRootRef.push().setValue(value4);
                mRootRef.push().setValue(value5);
                mRootRef.push().setValue(value6);


                if (TextUtils.isEmpty(value2)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(value1)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (value1.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }


                progressBar.setVisibility(View.VISIBLE);
                //create user
                mAuth.createUserWithEmailAndPassword(value2, value1)
                        .addOnCompleteListener(AppnActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(AppnActivity.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.GONE);
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                if (!task.isSuccessful()) {
                                    Toast.makeText(AppnActivity.this, "Authentication failed." + task.getException(),
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    startActivity(new Intent(AppnActivity.this, LoginActivity.class));
                                    finish();
                                }
                            }
                        });

                }
        });



        Spinner spin = findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);

        //ArrayAdapter containing the spinning list
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,Courses);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Setting the ArrayAdapter data on the spinner
        spin.setAdapter(arrayAdapter);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplication(),Courses[position],Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        progressBar.setVisibility(View.GONE);
    }

    }
