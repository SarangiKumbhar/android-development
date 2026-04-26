package com.example.layouts;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {

    FrameLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container = findViewById(R.id.container);

        findViewById(R.id.btnLinear).setOnClickListener(v -> showLinear());
        findViewById(R.id.btnRelative).setOnClickListener(v -> showRelative());
        findViewById(R.id.btnFrame).setOnClickListener(v -> showFrame());
        findViewById(R.id.btnList).setOnClickListener(v -> showList());
        findViewById(R.id.btnConstraint).setOnClickListener(v -> showConstraint());
        findViewById(R.id.btnTable).setOnClickListener(v -> showTable());
        findViewById(R.id.btnGrid).setOnClickListener(v -> showGrid());
    }

    void showLinear() {
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        TextView tv = new TextView(this);
        tv.setText("Linear Layout");

        layout.addView(tv);
        container.removeAllViews();
        container.addView(layout);
    }

    void showRelative() {
        RelativeLayout layout = new RelativeLayout(this);

        TextView tv = new TextView(this);
        tv.setText("Relative Layout");

        layout.addView(tv);
        container.removeAllViews();
        container.addView(layout);
    }

    void showFrame() {
        FrameLayout layout = new FrameLayout(this);

        TextView tv = new TextView(this);
        tv.setText("Frame Layout");

        layout.addView(tv);
        container.removeAllViews();
        container.addView(layout);
    }

    void showList() {
        ListView listView = new ListView(this);
        String[] items = {"Item 1", "Item 2", "Item 3"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                items
        );

        listView.setAdapter(adapter);

        container.removeAllViews();
        container.addView(listView);
    }

    void showConstraint() {
        ConstraintLayout layout = new ConstraintLayout(this);

        TextView tv = new TextView(this);
        tv.setText("Constraint Layout");
        tv.setId(View.generateViewId());

        layout.addView(tv);
        container.removeAllViews();
        container.addView(layout);
    }

    void showTable() {
        TableLayout table = new TableLayout(this);

        TableRow row = new TableRow(this);

        TextView t1 = new TextView(this);
        t1.setText("A");

        TextView t2 = new TextView(this);
        t2.setText("B");

        row.addView(t1);
        row.addView(t2);
        table.addView(row);

        container.removeAllViews();
        container.addView(table);
    }

    void showGrid() {
        GridLayout grid = new GridLayout(this);
        grid.setColumnCount(2);

        for (int i = 1; i <= 4; i++) {
            Button btn = new Button(this);
            btn.setText("Btn " + i);
            grid.addView(btn);
        }

        container.removeAllViews();
        container.addView(grid);
    }
}