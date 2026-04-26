package com.example.database;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.database.Cursor;
import androidx.appcompat.app.AlertDialog;


public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editName, editMarks, editId;
    Button btnAddData, btnViewAll, btnUpdate, btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DatabaseHelper(this);

        editName = findViewById(R.id.editName);
        editMarks = findViewById(R.id.editMarks);
        editId = findViewById(R.id.editId);

        btnAddData = findViewById(R.id.btnInsert);
        btnViewAll = findViewById(R.id.btnView);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);

        AddData();
        viewAll();
        UpdateData();
        DeleteData();
    }

    // Insert
    public void AddData() {
        btnAddData.setOnClickListener(view -> {
            boolean isInserted = myDb.insertData(
                    editName.getText().toString(),
                    editMarks.getText().toString()
            );

            Toast.makeText(MainActivity.this,
                    isInserted ? "Data Inserted" : "Error",
                    Toast.LENGTH_SHORT).show();
        });
    }

    // View
    public void viewAll() {
        btnViewAll.setOnClickListener(view -> {
            Cursor res = myDb.getAllData();

            if (res.getCount() == 0) {
                showMessage("Error", "No Data Found");
                return;
            }

            StringBuilder buffer = new StringBuilder();
            while (res.moveToNext()) {
                buffer.append("ID: ").append(res.getString(0)).append("\n");
                buffer.append("Name: ").append(res.getString(1)).append("\n");
                buffer.append("Marks: ").append(res.getString(2)).append("\n\n");
            }

            showMessage("Data", buffer.toString());
        });
    }

    // Update
    public void UpdateData() {
        btnUpdate.setOnClickListener(view -> {
            boolean isUpdate = myDb.updateData(
                    editId.getText().toString(),
                    editName.getText().toString(),
                    editMarks.getText().toString()
            );

            Toast.makeText(MainActivity.this,
                    isUpdate ? "Updated" : "Not Updated",
                    Toast.LENGTH_SHORT).show();
        });
    }

    // Delete
    public void DeleteData() {
        btnDelete.setOnClickListener(view -> {
            Integer deletedRows = myDb.deleteData(editId.getText().toString());

            Toast.makeText(MainActivity.this,
                    deletedRows > 0 ? "Deleted" : "Not Deleted",
                    Toast.LENGTH_SHORT).show();
        });
    }

    // Show Dialog
    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}