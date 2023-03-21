package com.example.burgersystem;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DeleteOrderActivity extends AppCompatActivity {

    private TextView orderDetailsTextView;
    private Button deleteOrderButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_order);

        // Get the order to delete from the intent
        OrderActivity orderActivity = (OrderActivity) getIntent().getSerializableExtra("order");

        // Initialize views
        orderDetailsTextView = findViewById(R.id.order_status_textview);
        deleteOrderButton = findViewById(R.id.delete_button);

        // Set order details text
        String orderDetailsText = "Order ID: " + OrderActivity.Order.getId() + "\n" +
                "Customer Name: " + OrderActivity.Order.getCustomerName() + "\n" +
                "Items Ordered: " + OrderActivity.Order.getItemsOrdered() + "\n" +
                "Total Amount: " + OrderActivity.Order.getTotalAmount() + "\n" +
                "Order Status: " + OrderActivity.Order.getOrderStatus();
        orderDetailsTextView.setText(orderDetailsText);

        // Set on click listener for delete order button
        deleteOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(DeleteOrderActivity.this);
                builder.setMessage("Are you sure you want to delete this order?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // Code to delete order from database or API
                                // ...

                                // Set result and finish activity
                                setResult(RESULT_OK);
                                finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User cancelled the dialog
                            }
                        });
                // Create the AlertDialog object and show it
                builder.create().show();
            }
        });
    }
}
