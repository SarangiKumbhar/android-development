package com.example.checkbox;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    CheckBox cb1, cb2, cb3;
    Button btnCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cb1 = findViewById(R.id.cb1);
        cb2 = findViewById(R.id.cb2);
        cb3 = findViewById(R.id.cb3);
        btnCheck = findViewById(R.id.btnCheck);

        btnCheck.setOnClickListener(v -> {
            String result = "";

            if (cb1.isChecked())
                result += "Android ";

            if (cb2.isChecked())
                result += "Java ";

            if (cb3.isChecked())
                result += "Python ";

            Toast.makeText(MainActivity.this,
                    "Selected: " + result,
                    Toast.LENGTH_SHORT).show();
        });
    }
}