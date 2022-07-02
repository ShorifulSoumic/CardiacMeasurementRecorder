package com.example.cardiacmeasurementrecorder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class SplashScreenActivity extends AppCompatActivity {

    ProgressBar progressBar;
    private int progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

         progressBar = findViewById(R.id.progress_bar);


         Thread thread = new Thread(new Runnable() {
             @Override
             public void run() {
                 loading();

                 startActivity(new Intent(SplashScreenActivity.this,MainActivity.class));
                 finish();
             }
         });

         thread.start();


    }

    private void loading() {

        for(progress = 1;progress<=100;progress+=1){
            try {
                Thread.sleep(20);
                progressBar.setProgress(progress);
            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

    }
}