package com.ioad.radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg_group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg_group = findViewById(R.id.rg_group); // xml 과 MainActivity 연결 끝!

        rg_group.setOnCheckedChangeListener(checkChangeListener);

    } // onCreate end

    RadioGroup.OnCheckedChangeListener checkChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int checkId) {
            String str = "";
            RadioButton radioButton = findViewById(checkId);
            str = radioButton.getText().toString();
            Toast.makeText(MainActivity.this, str + " 주세요!!!", Toast.LENGTH_SHORT).show();
        }
    };
}