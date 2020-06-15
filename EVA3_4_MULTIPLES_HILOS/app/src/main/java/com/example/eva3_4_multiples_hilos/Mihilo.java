package com.example.eva3_4_multiples_hilos;

import android.util.Log;

public class Mihilo extends Thread {
    @Override
    public void run() {
        super.run();
        int i = 0;
        while (true){
            try {
                Thread.sleep(1000);
                Log.wtf("Tarea",  i + "segundo plano");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
