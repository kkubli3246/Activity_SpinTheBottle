package com.example.spinthebottle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView iv_bottle;
    Button btn_spin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv_bottle = (ImageView)findViewById(R.id.iv_bottle);
        btn_spin = (Button)findViewById(R.id.btn_spin);



        btn_spin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final int spinDegrees;

                Random r = new Random();

                spinDegrees = r.nextInt(3600);

                RotateAnimation rotateBottle = new RotateAnimation(0, spinDegrees, Animation.RELATIVE_TO_SELF, 0.5f,Animation.RELATIVE_TO_SELF, 0.5f);

                rotateBottle.setDuration(2000);
                rotateBottle.setFillAfter(true);


                rotateBottle.setInterpolator(new AccelerateDecelerateInterpolator());

                iv_bottle.startAnimation(rotateBottle);

                rotateBottle.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        if(spinDegrees % 360 > 180){
                            Toast.makeText(MainActivity.this,"Left has been chosen",Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(MainActivity.this,"Right has been chosen" ,Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

            }
        });
    }
}
