package com.example.healthnepal;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

        TextView tvHealth;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_splash);

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
                        startActivity(new Intent(SplashActivity.this,LoginActivity.class));
                        finish();
                    }
                }
            };
            timer.run();

        }


}
