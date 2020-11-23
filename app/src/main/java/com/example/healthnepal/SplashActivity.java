package com.example.healthnepal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
   public static SharedPreferences sharedPreferences;
        final String PREFERENCES_NAME ="user_data";
        final String IS_LOGGED_IN ="Logged In";
        TextView tvHealth;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_splash);
            sharedPreferences = getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE);

            Thread timer = new Thread()
            {
                public void run()
                {
                    try{
                        sleep(3000);
                    }catch(InterruptedException e)
                    {
                        e.printStackTrace();
                    }finally {
                        if(sharedPreferences.getBoolean(IS_LOGGED_IN,false))
                        {
                            startActivity(new Intent(SplashActivity.this,DashboardActivity.class));
                            finish();
                        }
                        else
                        {
                            startActivity(new Intent(SplashActivity.this,LoginActivity.class));
                            finish();
                        }

                    }
                }
            };
            timer.start();

        }


}
