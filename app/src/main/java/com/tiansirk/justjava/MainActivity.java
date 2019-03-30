package com.tiansirk.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    private int numOfCoffes = 0;
    private int price = 5;
    private String user = "Capt. Kunal";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // This method is called when the plus button is clicked.
    public int increment(){
        numOfCoffes++;
        display(numOfCoffes);
        return numOfCoffes;
    }
    // This method is called when the minus  button is clicked.
    public int decrement(){
        numOfCoffes--;
        display(numOfCoffes);
        return numOfCoffes;
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int totalPrice = price * numOfCoffes;
        boolean isChecked = ((CheckBox)findViewById(R.id.checkBox)).isChecked();

        String endMessage = createOrderSummary(totalPrice, isChecked);

        displayMessage(endMessage);
    }

    /**
     * This method displays the given numOfCoffes value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_amount);
        quantityTextView.setText("" + number);
    }

    /*
     * This method displays the price calculated on the screen
     */
    private void displayMessage(String message){
        TextView orderSummaryTextView = findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    /*
     * Creates the order summary message
     */
    public String createOrderSummary(int price, boolean toppingsAsked){
        return "Name: " + user +
                "Add whipped cream?: " + toppingsAsked +
                "\nQuantity: " + numOfCoffes +
                "\nTotal: " + NumberFormat.getCurrencyInstance().format(price) +
                "\nTnak you!";
    }
}
