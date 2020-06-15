package com.example.eva3_9_banner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
ImageView Banner;
int [] Img = {R.drawable.f1, R.drawable.f2, R.drawable.f3};
int ind = 0;
Handler Handi = new Handler();

Runnable bgr = new Runnable() {
    @Override
    public void run() {
    while (true){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Handi.post(fgr);
    }
    }
};
Runnable fgr = new Runnable() {
    @Override
    public void run() {
    Banner.setImageResource(Img[ind]);
    if (ind == 2){
        ind = 0;
    }else{
        ind++;
    }


    }
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Banner = findViewById(R.id.IvBan);
        Thread run = new Thread(bgr);
        run.start();
    }
}
