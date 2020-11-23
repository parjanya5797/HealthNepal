package com.example.healthnepal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button login_button;
    String[] blood_group = {"A","A+","A-","B+","B-","O+","0-","AB+","AB-"};

    EditText email,password;

    Button register_button;

    SharedPreferences sharedPreferences;

    SharedPreferences.Editor editor;

    final String PREFERENCES_NAME ="user_email";
    final String USER_EMAIL ="user_email";
    final String USER_PASSWORD ="user_email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        register_button = (Button) findViewById(R.id.register_button);
        sharedPreferences = getSharedPreferences(PREFERENCES_NAME,MODE_PRIVATE);
        editor = sharedPreferences.edit();
        email = (EditText) findViewById(R.id.register_email);
        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailString = email.getText().toString();
                editor.putString(USER_EMAIL,emailString);
                editor.apply();
                startActivity(new Intent(RegisterActivity.this,DashboardActivity.class));
                RegisterActivity.this.finish();

            }
        });
        Spinner spin = (Spinner) findViewById(R.id.blood_group);
        spin.setOnItemSelectedListener(this);
        ArrayAdapter spinBGroup = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,blood_group);
        spinBGroup.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(spinBGroup);

        login_button = (Button) findViewById(R.id.login_button1);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });



    }

    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        Toast.makeText(getApplicationContext(),blood_group[position] , Toast.LENGTH_LONG).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}