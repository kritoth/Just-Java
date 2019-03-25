package com.tiansirk.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    private int numOfCoffes = 0;
    private int price = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // This method is called when the plus button is clicked.
    public int increment(View v){
        numOfCoffes++;
        display(numOfCoffes);
        return numOfCoffes;
    }
    // This method is called when the minus  button is clicked.
    public int decrement(View v){
        numOfCoffes--;
        display(numOfCoffes);
        return numOfCoffes;
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        displayPrice(price * numOfCoffes);
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
    private void displayPrice(int number){
        TextView priceTextView = findViewById(R.id.price_amount);
        String text = getString(R.string.display_price, NumberFormat.getCurrencyInstance().format(number));

        priceTextView.setText(text);
    }
}
