package com.example.miriam.tibakwanza;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class AppnActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Button sbmt;
    String[] Courses={"CSE","ECE","EEE","ISNE","CIVIL","MECHANICS","EDUCATION"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appn);
        sbmt = findViewById(R.id.submit);
        //Starting new activity from login button
        sbmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AppnActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
        Spinner spin = findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);

        //ArrayAdapter containing the spinning list
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,Courses);
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
}
