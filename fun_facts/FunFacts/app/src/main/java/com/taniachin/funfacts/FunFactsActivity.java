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
                String [] facts = {
                        "Ants stretch when they wake up in the morning.",
                        "Ostriches can run faster than horses.",
                        "Olympic gold medals are actually made mostly of silver",
                        "You are born with 300 bones; by the time you are an adult you will have 206.",
                        "It takes about 8 minutes for light from the sun to reach Earth.",
                        "Some bamboo plants can grow almost a meter in just one day.",
                        "The state of Florida is bigger than England.",
                        "Some penguins can leap 2-3 meters out of the water",
                        "On average, it takes 66 days to form a new habit.",
                        "Mammoths still walked the Earth when the Great Pyramid was being built."
                };
                // The button was clicked, so update the fact label with a new fact
                String fact = "";
                //Randomly select a fact
                Random randomGenerator = new Random(); //Construct a new Random number generator
                int randomNumber = randomGenerator.nextInt(facts.length);

                fact = facts[randomNumber];

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
