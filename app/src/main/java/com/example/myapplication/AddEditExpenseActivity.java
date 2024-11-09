package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddEditExpenseActivity extends AppCompatActivity {
    private EditText expenseNameEditText, amountEditText;
    private Spinner categorySpinner;
    private DatePicker expenseDatePicker;
    private Button saveButton;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_expense);

        expenseNameEditText = findViewById(R.id.expenseNameEditText);
        amountEditText = findViewById(R.id.amountEditText);
        categorySpinner = findViewById(R.id.categorySpinner);
        expenseDatePicker = findViewById(R.id.expenseDatePicker);
        saveButton = findViewById(R.id.saveButton);

        // Initialize Firebase reference
        databaseReference = FirebaseDatabase.getInstance().getReference("expenses");

        saveButton.setOnClickListener(v -> saveExpense());
    }

    private void saveExpense() {
        String name = expenseNameEditText.getText().toString();
        String amountStr = amountEditText.getText().toString();
        String category = categorySpinner.getSelectedItem().toString();
        int day = expenseDatePicker.getDayOfMonth();
        int month = expenseDatePicker.getMonth();
        int year = expenseDatePicker.getYear();
        String date = day + "-" + (month + 1) + "-" + year;

        if (name.isEmpty() || amountStr.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        double amount = Double.parseDouble(amountStr);

        String id = databaseReference.push().getKey();
        Expense expense = new Expense(id, name, amount, category, date);
        databaseReference.child(id).setValue(expense);

        Toast.makeText(this, "Expense saved", Toast.LENGTH_SHORT).show();
        finish();
    }
}

