package com.example.crystalball;

import java.util.Random;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Declare our View variables and assign them the Views from the layout file
        final TextView answerLabel = (TextView) findViewById(R.id.textView1);
        Button getAnswerButton = (Button) findViewById(R.id.button1);
        
        getAnswerButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				String [] answers = {
				"It is certain",
				"It is decidedly so",
				"All signs say YES",
				"The stars are not aligned",
				"My reply is no",
				"It is doubtful",
				"Better not tell you now",
				"Concentrate and ask again",
				"Unable to answer now" };
				
				// The button was clicked, so update the answer label with an answer
				String answer = "";
				// Randomly select one of three answers: Yes, No or Maybe
				Random randomGenerator = new Random(); // Construct a new Random number generator
				int randomNumber = randomGenerator.nextInt(answers.length);
				/* Convert the randomNumber to a text answer
				 * 0 = Yes
				 * 1 = No
				 * 2 = Maybe
				 */
				answer = answers[randomNumber];
				
				// Update the label with or dynamic answer
				answerLabel.setText(answer);
				
			}
		});
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
