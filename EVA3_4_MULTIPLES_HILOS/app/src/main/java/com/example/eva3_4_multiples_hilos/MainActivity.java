package com.example.eva3_4_multiples_hilos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Mihilo mihilo = new Mihilo();
        mihilo.start();

        MiRunnable mirun = new MiRunnable();
        Thread trunable = new Thread(mirun);
        trunable.start();
    }
}
