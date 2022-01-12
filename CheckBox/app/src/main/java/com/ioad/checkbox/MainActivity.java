package com.ioad.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    CheckBox[] checkBoxes;
    Integer[] items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBoxes = new CheckBox[4]; // 0, 1, 2, 3
        items = new Integer[] { R.id.cb_red, R.id.cb_orange, R.id.cb_green, R.id.cb_blue };

        for (int i = 0; i < checkBoxes.length; i++) {
            checkBoxes[i] = findViewById(items[i]); // xml 과 MainActivity 연결 끝!
            checkBoxes[i].setOnCheckedChangeListener(checkChangeListener);
        }

    } // onCreate end

    CompoundButton.OnCheckedChangeListener checkChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
            ArrayList<String> arr = new ArrayList<>();

            for (int i = 0; i < checkBoxes.length; i++) {
                if (checkBoxes[i].isChecked() == true) {
                    arr.add(checkBoxes[i].getText().toString());
                }
            }

            if (!arr.isEmpty()) {
                Toast.makeText(MainActivity.this, arr.toString(), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "아무것도 선택되지 않았습니다.", Toast.LENGTH_SHORT).show();
            }
        }
    };
}