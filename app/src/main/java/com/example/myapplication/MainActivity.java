package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button dashboardButton;
    private Button addExpenseButton;
    private Button expenseListButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // activity_main.xml layout

        // Initialize buttons
        dashboardButton = findViewById(R.id.dashboardButton);
        addExpenseButton = findViewById(R.id.addExpenseButton);
        expenseListButton = findViewById(R.id.expenseListButton);

        // Set click listeners for each button
        dashboardButton.setOnClickListener(v -> {
            // Navigate to DashboardActivity
            Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
            startActivity(intent);
        });

        addExpenseButton.setOnClickListener(v -> {
            // Navigate to AddEditExpenseActivity
            Intent intent = new Intent(MainActivity.this, AddEditExpenseActivity.class);
            startActivity(intent);
        });

        expenseListButton.setOnClickListener(v -> {
            // Navigate to ExpenseListActivity
            Intent intent = new Intent(MainActivity.this, ExpenseListActivity.class);
            startActivity(intent);
        });
    }
}
