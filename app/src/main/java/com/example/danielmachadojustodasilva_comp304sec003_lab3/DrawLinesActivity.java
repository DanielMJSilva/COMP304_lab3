package com.example.danielmachadojustodasilva_comp304sec003_lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;


public class DrawLinesActivity extends AppCompatActivity {

    ImageView ImageDrawLine;
    Button btn_clear;
    TextView y_position;
    ImageButton arrow_up;
    ImageButton arrow_down;
    ImageButton arrow_left;
    ImageButton arrow_right;
    Spinner spinner_thickness;
    RadioButton color1;
    RadioButton color2;
    RadioButton color3;

    Paint paint;
    Bitmap bitmap;
    Canvas canvas;

    int startx;
    int starty;
    int endx;
    int endy;

    int addToLine = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_lines);

        spinner_thickness = (Spinner) findViewById(R.id.spinner);
        color1 = (RadioButton) findViewById(R.id.rbColo1);
        color2 = (RadioButton) findViewById(R.id.rbColor2);
        color3 = (RadioButton) findViewById(R.id.rbColor3);
        arrow_up = (ImageButton) findViewById(R.id.imageButton_up);
        arrow_down = (ImageButton) findViewById(R.id.imageButton_down);
        arrow_left = (ImageButton) findViewById(R.id.imageButton_left);
        arrow_right = (ImageButton) findViewById(R.id.imageButton_right);
        y_position = (TextView) findViewById(R.id.textViewY);
        btn_clear = (Button) findViewById(R.id.button_clear);
        ImageDrawLine = (ImageView) findViewById(R.id.Image_draw_lines);

        paint = new Paint();
        bitmap =  Bitmap.createBitmap(400, 488, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        canvas.drawColor(Color.WHITE);
        ImageDrawLine.setImageBitmap(bitmap);

        spinner_thickness.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                paint.setStrokeWidth(Integer.parseInt(getResources().getStringArray(R.array.thickness)[i]));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                canvas.drawColor(Color.WHITE);
                canvas.drawPoint(0,0,paint);
                startx = 0;
                starty = 0;
                endx = 0;
                endy = 0;
            }
        });
        arrow_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lineUp(canvas);
            }
        });
        arrow_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lineLeft(canvas);
            }
        });

        arrow_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lineRight(canvas);
            }
        });

        arrow_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lineDown(canvas);
            }
        });

        color1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint.setColor(Color.RED);
            }
        });
        color2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint.setColor(Color.YELLOW);
            }
        });
        color3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paint.setColor(Color.CYAN);
            }
        });

    }


    // drawing the lines
    public void lineUp (Canvas canvas)
    {
        endy = endy - addToLine;
        drawLine(canvas);
        ImageDrawLine.invalidate();
    }

    public void lineDown(Canvas canvas)
    {
        endy = endy + addToLine;
        drawLine(canvas);
        ImageDrawLine.invalidate();
    }

    public void lineRight(Canvas canvas)
    {
        endx = endx + addToLine;
        drawLine(canvas);
        ImageDrawLine.invalidate();
    }

    public void lineLeft(Canvas canvas)
    {
        endx = endx - addToLine;
        drawLine(canvas);
        ImageDrawLine.invalidate();
    }

    // how to draw the line
    public void drawLine(Canvas canvas)
    {
        canvas.drawLine(startx, starty, endx, endy, paint);
        startx=endx;
        starty=endy;

    }

    // erase all lines and turn back to black
    public void clearLines(View view)
    {
        canvas.drawColor(Color.BLUE);
        canvas.drawPoint(0,0,paint);
        startx = 0;
        starty = 0;
        endx = 0;
        endy = 0;
    }

}