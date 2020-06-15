package com.example.eva3_2_threads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*for (int i = 0; i< 10; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        Thread tHilo = new Thread(){
            @Override
            public void run() {//Trabajo en segundo plano
                super.run();
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(1000);
                        Log.wtf("Hilo", "Tarea Activa" + i + "Segundos pasados");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        tHilo.start();//crea un nuevo hilo

    }
}
