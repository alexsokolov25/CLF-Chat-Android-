package com.clf.chat.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.clf.chat.R;

public class SplashActivity extends AppCompatActivity {

    Context context;
    protected boolean _active = true;
    protected int _splashTime = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final SplashActivity sPlashScreen = this;

        context = this;

        final Thread splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    while (_active && waited < _splashTime) {
                        sleep(100);
                        if (_active) {
                            waited += 100;
                        }
                    }
                } catch (final InterruptedException e) {
                    // do nothing
                } finally {

                    runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            // TODO Auto-generated method stub

                            Intent intent = new Intent(sPlashScreen, LoginActivity.class);
                            startActivity(intent);
                        }
                    });
                }
            }
        };

        splashTread.start();
    }
}
