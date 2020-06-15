package com.example.eva3_8_handler_runnables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView mensa;
Handler hand = new Handler();
int i;
Runnable bgr = new Runnable() {//Tarea pesada segundo plano
    @Override
    public void run() {
        int i = 0;
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            hand.post(fgr);
            Log.wtf("Hilo",  i + "segundo plano");
            i++;
        }
    }
};
Runnable fgr = new Runnable() {//Modifica ui
    @Override
    public void run() {
        mensa.append("valor de i = " + i + "\n");
    }
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mensa = findViewById(R.id.VwMensa);
        Thread hilo = new Thread(bgr);
        hilo.start();
    }
}
