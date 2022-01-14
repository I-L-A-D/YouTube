package com.ioad.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv_text;
    Chronometer chrono;
    Button btn_start, btn_finish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_text = findViewById(R.id.tv_text);
        chrono = findViewById(R.id.chrono);
        btn_start = findViewById(R.id.btn_start);
        btn_finish = findViewById(R.id.btn_finish);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_text.setText("시간 측정중...");
                tv_text.setTextColor(Color.BLUE);
                chrono.setBase(SystemClock.elapsedRealtime());
                chrono.start();
            }
        });

        btn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_text.setText("FINISH");
                tv_text.setTextColor(Color.RED);
                chrono.stop();
            }
        });
    }
}