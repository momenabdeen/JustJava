package com.example.android.justjava; /**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava;
 */

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.justjava.R;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 1 ;

String Value ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {

        // if quantity = 100 that means if the quantity = 100 go out of this method and the user can not increase the amount of coffees
        if (quantity==100) {
            // show an error message as a Toast
            Toast.makeText(this, "You can not have more than 100 coffees ", Toast.LENGTH_SHORT).show();
            //exit this method early beacuse there is nothing left to do .
            return;
        }
        quantity = quantity + 1 ;

    displayquantity(quantity);

    }

    /**
     * This method is called when the minus button is clicked.
     */

    public void decrement(View view) {
        // if quantity = 1 that means if the quantity = 1 go out of this method and the user cant decrease the amount of coffees
        if (quantity==1) {
            // show an error message as a Toast
            Toast.makeText(this, "You can not have less than 1 coffee ", Toast.LENGTH_SHORT).show();
            //exit this method early beacuse there is nothing left to do .

            return;
        }
        quantity = quantity - 1 ;

        displayquantity( quantity);

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayquantity(int number) {
        TextView quantityText = (TextView) findViewById(R.id.quantity_text_view);
        quantityText.setText("" + number );

    }

    /**
     * This method displays the given price on the screen.
     */


    private void displayprice(String i) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText( i );
    }

    public void submitOrder(View View) {
        /* this code to show the name when you clicked on order
         notice that you can call another method .toString after getText method is finished
         and its called chaining call methods and we use it here because the return value of gettext method is Editable and it can not be stored
         in a String Variable so we add toString method to take the return value of GetText method and put in it as a string variable
        */
        EditText nameField = (EditText)findViewById(R.id.Name_Field);
        String Value = nameField.getText().toString();

        // This variable to figure out if the user want Wipped Cream
        CheckBox whippedCreamCheckBox = (CheckBox ) findViewById(R.id.whipped_cream_checkbox);
        //notice that I use ischecked() method to check the state of the CheckBox if true or false
        boolean hasWippedCream = whippedCreamCheckBox.isChecked();

        // This new object to figure out if the user want Cocolate
        CheckBox chocolateBox = (CheckBox ) findViewById(R.id.chocolate_checkbox);
        boolean Chocolate =chocolateBox.isChecked();



       int Price = calculatePrice(quantity,hasWippedCream , Chocolate  ) ;
        String name = "Name:" ;
       String PriceMessage ="Total: $"+ Price ;
        PriceMessage = name+ Value +"\nAdd Wipped Cream ?"+hasWippedCream +"\nAdd Chocolate ?"+Chocolate+ "\n" + "Quantity"  + " : " +  quantity + "\n" + PriceMessage + "\n Thank you ";
        displayprice(PriceMessage );

       // calculatePrice(quantity,10,hasWippedCream) ;
    }

    /**
     * Calculates the price of the order.
     * @pram addWippedCream is Weather or not the user wants Wipped cream topping
     *@pram addChocolate is Weather or not the user wants Chocolate topping
     * @param quantity is the number of cups of coffee ordered
     */
    private int calculatePrice(int quantity ,boolean addWippedCream, boolean addChocolate) {

        int basePrice = 5;
        if( addWippedCream ) {
            basePrice = basePrice + 1 ;
        }
        if( addChocolate ) {
            basePrice = basePrice + 2 ;
        }

        int cons = quantity * basePrice  ;
        return cons ;
    }
}