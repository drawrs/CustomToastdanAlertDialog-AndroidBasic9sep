package com.khilman.basicharikedua;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        // buat object handler
        Handler handler = new Handler();
        // delayed function

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // pindah activity
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        }, 3000); // satuan delay dalam Mili Second. 3000 = 3 detik
    }
}
