package com.taniachin.funfacts;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

import java.util.Random;


public class FunFactsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        // Declare our View variables and assign the Views from the layout file
        final TextView factLabel = (TextView) findViewById(R.id.factTextView);
        Button showFactButton = (Button) findViewById(R.id.showFactbutton);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // The button was clicked, so update the fact label with a new fact
                String fact = "";
                //Randomly select a fact
                Random randomGenerator = new Random(); //Construct a new Random number generator
                int randomNumber = randomGenerator.nextInt(3);
                /* Convert the randomNumber to a text fact
                 * 0 = Ants stretch when they wake up in the morning.
                 * 1 = Ostriches can run faster than horses.
                 * 2 = Olympic gold medals are actually made mostly of silver.
                 */

                // if randomNumber equals 0 then
                if (randomNumber == 0){
                    // set fact equal to ants fact
                    fact = "Ants stretch when they wake up in the morning.";
                }

                // if randomNumber equals to 1 then
                else if (randomNumber == 1){
                    // set fact equal to ostriches fact
                    fact = "Ostriches can run faster than horses.";
                }

                // if randomNumber equals to 2 then
                else if (randomNumber == 2){
                    // set fact equal to olympic fact
                    fact = "Olympic gold medals are actually made mostly of silver.";
                }
                else {
                    fact = "unknown error ";
                }

                //Update the label with our dynamic fact
                factLabel.setText(fact);
            }
        };



        showFactButton.setOnClickListener(listener);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.fun_facts, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
