package com.example.eva3_6_ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView Datos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Datos = findViewById(R.id.VwDatos);

        Thread Hilo = new Thread(){
            @Override
            public void run() {
                super.run();
                int i = 0;
                while (true){
                    try {
                        Thread.sleep(1000);
                        Datos.append(i + "\n");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Log.wtf("TareaRunnable",  i + "segundo plano");
                    i++;
                }
            }
        };
        Hilo.start();

    }
}
