package com.example.eva3_5_interrupt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Runnable Rrun= new Runnable() {
        @Override
        public void run() {
            int i = 0;
            while (true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
                Log.wtf("TareaRunnable",  i + "segundo plano");
                i++;
            }
        }
    };
    Thread thilo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        thilo = new Thread(Rrun);
        Toast.makeText(this, "estado: "+ thilo.getState(),Toast.LENGTH_LONG).show();
        Log.wtf("TareaRunnable",  "estado: "+ thilo.getState());
        thilo.start();
        Toast.makeText(this, "estado: "+ thilo.getState(),Toast.LENGTH_LONG).show();
        Log.wtf("TareaRunnable",  "estado: "+ thilo.getState());


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        thilo.interrupt();
    }
}

