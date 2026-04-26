package com.example.filehandling;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    EditText etData;
    Button btnSave, btnRead;
    TextView tvResult;

    String fileName = "myfile.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etData = findViewById(R.id.etData);
        btnSave = findViewById(R.id.btnSave);
        btnRead = findViewById(R.id.btnRead);
        tvResult = findViewById(R.id.tvResult);

        // Save File
        btnSave.setOnClickListener(v -> {
            try {
                String data = etData.getText().toString();
                FileOutputStream fos = openFileOutput(fileName, MODE_PRIVATE);
                fos.write(data.getBytes());
                fos.close();
                tvResult.setText("Data Saved");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Read File
        btnRead.setOnClickListener(v -> {
            try {
                FileInputStream fis = openFileInput(fileName);
                int c;
                String temp = "";

                while ((c = fis.read()) != -1) {
                    temp += Character.toString((char) c);
                }

                fis.close();
                tvResult.setText("Data: " + temp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}