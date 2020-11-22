package com.example.healthnepal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button login;
    EditText email,password;
    TextView register,validation_text;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    final String PREFERENCES_NAME ="user_data";
    final String IS_LOGGED_IN ="Logged In";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = (Button) findViewById(R.id.btn_login);
        register = (TextView) findViewById(R.id.tv_register);
        email = (EditText) findViewById(R.id.et_email);
        password = (EditText) findViewById(R.id.et_pwd);
       register.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
               startActivity(intent);
           }
       });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailString = email.getText().toString();
                String passwordString = password.getText().toString();
                String vaildEmail =
                        "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                                +"((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                                +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                                +"([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                                +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                                +"([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";
                validation_text = (TextView) findViewById(R.id.validation_text);

                if (!(emailString.matches(vaildEmail) && emailString.length() > 0)) {
                    validation_text.setText("Invalid Email Address");
                }
                else if(!(passwordString.equals("1234") && passwordString.length() > 0 ))
                {
                    validation_text.setText("Password & Confirm Password Does Not Match");
                }
                else
                {
                    Toast.makeText(LoginActivity.this,"Login Successful",Toast.LENGTH_LONG).show();
                    editor.putBoolean(IS_LOGGED_IN,true);
                    editor.commit();
                    Intent dashboardIntent = new Intent(LoginActivity.this,DashboardActivity.class);
                    startActivity(dashboardIntent);
                }
//                if(emailString != "admin@admin.com" && emailString)
//                {
//                    validation_text.setText("Invalid Email Address ");
//                }
//                else if(!(passwordString == "1234"))
//                {
//                    validation_text.setText("Wrong Password");
//                }

            }
        });




    }
}