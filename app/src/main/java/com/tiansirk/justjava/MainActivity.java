package com.tiansirk.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
    public void increment(View v){
        if(numOfCoffes == 100) {
            Toast.makeText(getApplicationContext(), R.string.message_above_hundred,
                    Toast.LENGTH_LONG).show();
            return;
        }
        numOfCoffes++;
        display(numOfCoffes);
    }
    // This method is called when the minus  button is clicked.
    public void decrement(View v){
        if(numOfCoffes == 1){
            Toast.makeText(getApplicationContext(), R.string.message_below_one,
                    Toast.LENGTH_LONG).show();
            return;
        }
        numOfCoffes--;
        display(numOfCoffes);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        String name = ((EditText)findViewById(R.id.name_text_view)).getText().toString();
        boolean hasWhippedCream = ((CheckBox)findViewById(R.id.checkBox_whipped_cream)).isChecked();
        boolean hasChocolate = ((CheckBox)findViewById(R.id.checkBox_chocolate)).isChecked();

        int totalPrice = calculatePrice(hasChocolate, hasWhippedCream);

        String endMessage = createOrderSummary(name, totalPrice, hasWhippedCream, hasChocolate);
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
     * @param user is the name the user typed in
     * @param addWhippedCream is whether or not the user wants whipped cream topping
     * @param addChocolate is whether or not the user wants chocolate topping
     * @param price of the order
     * @return text summary
     */
    public String createOrderSummary(String user, int price, boolean whipped, boolean choco){
        return "Name: " + user +
                "Add whipped cream?: " + whipped +
                "Add chocolate?: " + choco +
                "\nQuantity: " + numOfCoffes +
                "\nTotal: " + NumberFormat.getCurrencyInstance().format(price) +
                "\nTnak you!";
    }

    private int calculatePrice(boolean hasChocolate, boolean hasWhippedCream){
        int toppings = 0;
        if(hasChocolate) toppings += 2;
        if(hasWhippedCream) toppings += 1;
        price = (price + toppings) * numOfCoffes;
        return price;
    }
}
