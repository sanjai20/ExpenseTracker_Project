package com.example.myapplication;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddEditExpenseActivity extends AppCompatActivity {
    private EditText expenseNameEditText, expenseAmountEditText;
    private Spinner categorySpinner;
    private Button saveExpenseButton;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_expense); // activity_add_edit_expense.xml

        // Initialize Firebase reference
        databaseReference = FirebaseDatabase.getInstance().getReference("expenses");

        // Initialize UI elements
        expenseNameEditText = findViewById(R.id.expenseNameEditText);
        expenseAmountEditText = findViewById(R.id.expenseAmountEditText);
        categorySpinner = findViewById(R.id.categorySpinner);
        saveExpenseButton = findViewById(R.id.saveExpenseButton);

        saveExpenseButton.setOnClickListener(v -> saveExpense());
    }

    private void saveExpense() {
        // Get data from input fields
        String name = expenseNameEditText.getText().toString().trim();
        String amountStr = expenseAmountEditText.getText().toString().trim();
        String category = categorySpinner.getSelectedItem().toString();

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(amountStr)) {
            Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        double amount = Double.parseDouble(amountStr);

        // Generate a unique ID for the expense
        String expenseId = databaseReference.push().getKey();

        // Create an Expense object
        Expense expense = new Expense(name, amount, category, expenseId);

        // Save the expense to Firebase
        if (expenseId != null) {
            databaseReference.child(expenseId).setValue(expense)
                    .addOnSuccessListener(aVoid -> {
                        Toast.makeText(AddEditExpenseActivity.this, "Expense saved", Toast.LENGTH_SHORT).show();
                        finish(); // Close the activity after saving
                    })
                    .addOnFailureListener(e -> Toast.makeText(AddEditExpenseActivity.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show());
        }
    }
}
