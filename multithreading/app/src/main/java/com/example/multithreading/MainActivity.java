package com.example.multithreading;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        btnStart = findViewById(R.id.btnStart);

        btnStart.setOnClickListener(v -> {
            // Create new thread
            new Thread(() -> {
                try {
                    for (int i = 1; i <= 5; i++) {
                        Thread.sleep(1000); // delay

                        int finalI = i;

                        // Update UI from main thread
                        runOnUiThread(() -> {
                            textView.setText("Count: " + finalI);
                        });
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        });
    }
}