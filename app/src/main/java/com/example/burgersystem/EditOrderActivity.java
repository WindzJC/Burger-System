package com.example.burgersystem;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EditOrderActivity extends AppCompatActivity {

    private OrderActivity orderActivity;
    private EditText customerNameEditText;
    private EditText itemsOrderedEditText;
    private EditText totalAmountEditText = findViewById(R.id.total_amount_edittext);
    private EditText orderStatusEditText;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editorder);

        // Get the order object from the previous activity
        orderActivity = getIntent().getParcelableExtra("order");

        // Initialize the views
        customerNameEditText = findViewById(R.id.edit_customer_name);
        itemsOrderedEditText = findViewById(R.id.items_ordered_edittext);
        orderStatusEditText = findViewById(R.id.order_status_edittext);
        saveButton = findViewById(R.id.save_button);

        // Set the text of the edit text fields
        customerNameEditText.setText(OrderActivity.Order.getCustomerName(String.valueOf(customerNameEditText)));
        itemsOrderedEditText.setText((CharSequence) OrderActivity.Order.getItemsOrdered(String.valueOf(itemsOrderedEditText)));
        totalAmountEditText.setText(String.valueOf(OrderActivity.Order.getTotalAmount(totalAmountEditText)));
        orderStatusEditText.setText(OrderActivity.Order.getOrderStatus());

        // Set the click listener for the save button
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the new values from the edit text fields
                String newCustomerName = customerNameEditText.getText().toString();
                String newItemsOrdered = itemsOrderedEditText.getText().toString();
                double newTotalAmount = Double.parseDouble(totalAmountEditText.getText().toString());
                String newOrderStatus = orderStatusEditText.getText().toString();

                // Update the order object
                OrderActivity.Order.getCustomerName(newCustomerName);
                OrderActivity.Order.getItemsOrdered(newItemsOrdered);
                OrderActivity.Order.getTotalAmount(newTotalAmount);
                OrderActivity.Order.setOrderStatus(newOrderStatus);

                // Update the order in the database or API
                updateOrder(orderActivity);

                // Display a toast message to inform the user that the order has been updated
                Toast.makeText(EditOrderActivity.this, "Order Updated", Toast.LENGTH_SHORT).show();

                // Finish the activity and go back to the previous activity
                finish();
            }
        });
    }

    // Method to update the order in the database or API
    private void updateOrder(OrderActivity orderActivity) {
        // Code to update the order in the database or API
    }
}
