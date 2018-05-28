package tech.sobre.caracoroaapp;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    AnimationDrawable imgAnimation;
    ImageView img;
    Button btnPlay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = findViewById(R.id.coinImg);
        btnPlay = findViewById(R.id.btnPlay);

        imgAnimation = (AnimationDrawable) img.getDrawable();

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgAnimation.start();
                delayThread();

            }
        });




    }

    public void delayThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {

               SystemClock.sleep(3000);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        int n = new Random().nextInt(100);
                        showCoin(n);
                    }
                });

            }
        }).start();
    }

    
    public void showCoin(int n) {
        imgAnimation.stop();
        Intent i;
        if(n % 2 == 0){
            //deu cara
            i = new Intent(this,CaraActivity.class);

        }else{
            i = new Intent(this,CoroaActivity.class);
        }

        startActivity(i);
    }
}
