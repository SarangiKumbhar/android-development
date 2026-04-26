package com.example.buttons;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);

        // Button 1 Click
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Button 1 Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        // Button 2 Click
        btn2.setOnClickListener(v ->
                Toast.makeText(MainActivity.this, "Button 2 Clicked", Toast.LENGTH_SHORT).show()
        );
    }
}