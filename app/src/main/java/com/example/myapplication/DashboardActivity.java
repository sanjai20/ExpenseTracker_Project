package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DashboardActivity extends AppCompatActivity {
    private TextView totalExpenseText;
    private RecyclerView categoryBreakdownRecyclerView;
    private FloatingActionButton addExpenseButton;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        totalExpenseText = findViewById(R.id.totalExpenseText);
        categoryBreakdownRecyclerView = findViewById(R.id.categoryBreakdownRecyclerView);
        addExpenseButton = findViewById(R.id.addExpenseButton);

        // Initialize Firebase reference
        databaseReference = FirebaseDatabase.getInstance().getReference("expenses");

        // Set up RecyclerView
        categoryBreakdownRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Load expenses and calculate total and category breakdown
        loadExpenseSummary();

        addExpenseButton.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, AddEditExpenseActivity.class);
            startActivity(intent);
        });
    }

    private void loadExpenseSummary() {
        // Code to retrieve data from Firebase and calculate total expense
    }
}

