package com.example.crystalball;

import java.util.Random;

public class CrystalBall {
     // Member variables (properties about the object)
	
	// Methods (abilities: things the object can do)
	public String getAnAnswer() {
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
				
				return answer;
	}
}
