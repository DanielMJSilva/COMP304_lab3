package com.example.danielmachadojustodasilva_comp304sec003_lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ToggleButton;

public class FrameByFrameActivity extends AppCompatActivity {

    AnimationDrawable framedAnimation;
    ToggleButton start_stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_by_frame);

        start_stop = (ToggleButton) findViewById(R.id.toggleButton);
        start_stop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(start_stop.isChecked()){
                    startAnimation();
                } else{
                    stopAnimation();
                }
            }
        });
    }
    private void startAnimation()
    {

        ImageView img = (ImageView)findViewById(R.id.image_ex2);

        BitmapDrawable frame1 = (BitmapDrawable)getResources().getDrawable(R.drawable.frame1);
        BitmapDrawable frame2 = (BitmapDrawable)getResources().getDrawable(R.drawable.frame2);
        BitmapDrawable frame3 = (BitmapDrawable)getResources().getDrawable(R.drawable.frame3);
        BitmapDrawable frame4 = (BitmapDrawable)getResources().getDrawable(R.drawable.frame4);
        BitmapDrawable frame5 = (BitmapDrawable)getResources().getDrawable(R.drawable.frame5);
        BitmapDrawable frame6 = (BitmapDrawable)getResources().getDrawable(R.drawable.frame6);
        BitmapDrawable frame7 = (BitmapDrawable)getResources().getDrawable(R.drawable.frame7);
        BitmapDrawable frame8 = (BitmapDrawable)getResources().getDrawable(R.drawable.frame8);
        BitmapDrawable frame9 = (BitmapDrawable)getResources().getDrawable(R.drawable.frame9);
        BitmapDrawable frame10 = (BitmapDrawable)getResources().getDrawable(R.drawable.frame10);
        BitmapDrawable frame11 = (BitmapDrawable)getResources().getDrawable(R.drawable.frame11);

        // Get the background, which has been compiled to an AnimationDrawable object.
        int waitTime = 300;
        framedAnimation = new AnimationDrawable();
        framedAnimation.setOneShot(false);	// loop continuously
        framedAnimation.addFrame(frame1, waitTime);
        framedAnimation.addFrame(frame2, waitTime);
        framedAnimation.addFrame(frame3, waitTime);
        framedAnimation.addFrame(frame4, waitTime);
        framedAnimation.addFrame(frame5, waitTime);
        framedAnimation.addFrame(frame6, waitTime);
        framedAnimation.addFrame(frame7, waitTime);
        framedAnimation.addFrame(frame8, waitTime);
        framedAnimation.addFrame(frame9, waitTime);
        framedAnimation.addFrame(frame10, waitTime);
        framedAnimation.addFrame(frame11, waitTime);

        img.setBackground(framedAnimation);

        framedAnimation.setVisible(true,true);
        framedAnimation.start();
    }
    private void stopAnimation()
    {
        framedAnimation.stop();
        framedAnimation.setVisible(false,false);

    }
}