package com.example.danielmachadojustodasilva_comp304sec003_lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.danielmachadojustodasilva_comp304sec003_lab3.R;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    TextView textView;

    String tutorials[]
            = {"Exercise 1", "Exercise 2", "Exercise 3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView =(TextView)findViewById(R.id.textView);
        listView = (ListView) findViewById(R.id.list_view1);

        final ArrayAdapter<String> arr = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, tutorials);
        listView.setAdapter(arr);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // TODO Auto-generated method stub
                String value = arr.getItem(position);
                Toast.makeText(getApplicationContext(), value, Toast.LENGTH_SHORT).show();
                switch (position) {
                    case 0:
                        startActivity(new Intent(MainActivity.this, DrawLinesActivity.class));break;

                    case 1:
                        startActivity(new Intent(MainActivity.this, FrameByFrameActivity.class));break;
                    case 2:
                        startActivity(new Intent(MainActivity.this, TweenedAnimationActivity.class));break;

                }
            }
        });
    }
}
