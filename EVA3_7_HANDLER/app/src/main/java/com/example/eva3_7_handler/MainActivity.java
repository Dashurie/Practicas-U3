package com.example.eva3_7_handler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mensaje;
    Handler mihandler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            //handler para modificar la interfaz grafica
            int valori = (int)msg.obj;
            mensaje.append("hilo "+ msg.what + "valor de i = " + valori + "\n");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mensaje = findViewById(R.id.VwMensa);

        Thread Hilo = new Thread(){
            @Override
            public void run() {
                super.run();
                int i = 0;
                while (true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Message msg = mihandler.obtainMessage(1000, i );
                    mihandler.sendMessage(msg);
                    Log.wtf("Hilo",  i + "segundo plano");
                    i++;
                }
            }
        };
        Hilo.start();
    }
}
