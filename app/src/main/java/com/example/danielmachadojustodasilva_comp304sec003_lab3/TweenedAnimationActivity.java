package com.example.danielmachadojustodasilva_comp304sec003_lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ToggleButton;

public class TweenedAnimationActivity extends AppCompatActivity {

    ToggleButton start_stop2;
    ImageView moonImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweened_animation);
        moonImageView = findViewById(R.id.moon);
        moonImageView.setImageResource(R.drawable.moon);

    start_stop2 = (ToggleButton) findViewById(R.id.toggleButton2);
        start_stop2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if(start_stop2.isChecked()){
                startAnimation();

            } else{
                stopAnimation();
            }
        }
    });
    }
    private void startAnimation() {

        Animation moonAnimation = AnimationUtils.loadAnimation(this, R.anim.moon_animation);
        moonAnimation.setRepeatCount(-1);
        moonAnimation.setRepeatMode(Animation.RESTART);
        moonImageView.startAnimation(moonAnimation);

    }

    private void stopAnimation() {
        this.moonImageView.clearAnimation();
    }
}