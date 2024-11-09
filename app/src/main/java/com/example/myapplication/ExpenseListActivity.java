package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ExpenseListActivity extends AppCompatActivity {
    private RecyclerView expenseRecyclerView;
    private ExpenseAdapter expenseAdapter;
    private EditText filterEditText;
    private FloatingActionButton addExpenseFab;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);

        expenseRecyclerView = findViewById(R.id.expenseRecyclerView);
        filterEditText = findViewById(R.id.filterEditText);
        addExpenseFab = findViewById(R.id.addExpenseFab);

        expenseRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        databaseReference = FirebaseDatabase.getInstance().getReference("expenses");

        loadExpenses();

        addExpenseFab.setOnClickListener(v -> {
            Intent intent = new Intent(ExpenseListActivity.this, AddEditExpenseActivity.class);
            startActivity(intent);
        });
    }

    private void loadExpenses() {
        // Code to load expenses from Firebase and populate the RecyclerView
    }
}

