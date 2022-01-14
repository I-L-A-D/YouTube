package com.ioad.timepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    TimePicker time_picker;
    TextView tv_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        time_picker = findViewById(R.id.time_picker);
        tv_text = findViewById(R.id.tv_text);

        time_picker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int hour, int minute) {
                if (hour > 12) {
                    hour -= 12;
                    tv_text.setText("오후 " + hour + "시 " + minute + "분 선택");
                } else {
                    tv_text.setText("오전 " + hour + "시 " + minute + "분 선택");
                }
            }
        });

    }
}