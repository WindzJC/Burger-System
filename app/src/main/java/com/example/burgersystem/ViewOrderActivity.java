package com.example.burgersystem;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ViewOrderActivity extends AppCompatActivity {

    private TextView orderDetailsTextView;
    private TextView orderStatusTextView;
    private Button cancelButton;
    private OrderActivity currentOrderActivity;
    private EditText newTotalAmount,newItemsOrdered,customerName;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_order);

        // Get the order object from the previous activity
        currentOrderActivity = getIntent().getParcelableExtra("order");

        // Initialize the views
        orderDetailsTextView = findViewById(R.id.order_status_textview);
        orderStatusTextView = findViewById(R.id.order_status_textview);
        cancelButton = findViewById(R.id.cancel_button);

        // Set the text of the order details text view
        String orderDetailsText = "Order ID: " + OrderActivity.Order.getId() + "\n"
                + "Customer Name: " + OrderActivity.Order.getCustomerName(String.valueOf(customerName)) + "\n"
                + "Items Ordered: " + OrderActivity.Order.getItemsOrdered(String.valueOf(newItemsOrdered)) + "\n"
                + "Total Amount: " + OrderActivity.Order.getTotalAmount(newTotalAmount) + "\n";

        orderDetailsTextView.setText(orderDetailsText);

        // Set the text of the order status text view
        String orderStatusText = "Order Status: " + OrderActivity.Order.getOrderStatus();
        orderStatusTextView.setText(orderStatusText);

        // Set the click listener for the cancel button
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Set the status of the current order to "Cancelled"
                OrderActivity.Order.setOrderStatus("Cancelled");

                // Update the order in the database or API
                updateOrder(currentOrderActivity);

                // Display a toast message to inform the user that the order has been cancelled
                Toast.makeText(ViewOrderActivity.this, "Order Cancelled", Toast.LENGTH_SHORT).show();

                // Finish the activity and go back to the previous activity
                finish();
            }
        });
    }

    // Method to update the order in the database or API
    private void updateOrder(OrderActivity currentOrderActivity) {
        // Code to update the order in the database or API
    }
}
