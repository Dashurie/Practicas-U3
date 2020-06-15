package com.example.eva3_10_imagen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
ImageView image;
Bitmap imagen;

Handler hand = new Handler(){
    @Override
    public void handleMessage(@NonNull Message msg) {
        super.handleMessage(msg);
        image.setImageBitmap(imagen);
    }
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = findViewById(R.id.IvImg);
        /*imagen = cargarImagen("https://scontent.fcuu1-1.fna.fbcdn.net/v/t1.0-9/104117350_2481824945371587_7169656257005645349_n.jpg?_nc_cat=102&_nc_sid=8bfeb9&_nc_ohc=oFMvzvVfF6wAX8KJLZx&_nc_ht=scontent.fcuu1-1.fna&oh=208b77280f7c5b261cfc25bbe228da6b&oe=5F0D85E5");
        if (imagen == null){
            image.setImageBitmap(imagen);
        }*/
        Thread hilo = new Thread(){
            @Override
            public void run() {
                super.run();
            imagen = cargarImagen("https://scontent.fcuu1-1.fna.fbcdn.net/v/t1.0-9/104117350_2481824945371587_7169656257005645349_n.jpg?_nc_cat=102&_nc_sid=8bfeb9&_nc_ohc=oFMvzvVfF6wAX8KJLZx&_nc_ht=scontent.fcuu1-1.fna&oh=208b77280f7c5b261cfc25bbe228da6b&oe=5F0D85E5");
            Message msg = hand.obtainMessage();
            hand.sendMessage(msg);
            }
        };
        hilo.start();

    }
    public Bitmap cargarImagen(String url){
        try {
            InputStream Inputstream = (InputStream) new URL(url).getContent();
            Bitmap bitmap = BitmapFactory.decodeStream(Inputstream);
            return bitmap;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
