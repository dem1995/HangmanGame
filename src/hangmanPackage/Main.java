package hangmanPackage;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		System.out.println("Hello, and welcome to Hangman!");
		System.out.println("Please enter the secret word");
		
		String secretWord=reader.nextLine();
		HangmanGame theGame = new HangmanGame(secretWord);
		
		System.out.println("We are now ready to begin!");
		
		//While there are still lives remaining and the game is not yet won
		while(theGame.getLivesLeft()>0 && !theGame.gameWon())
		{
			System.out.println("Enter your guess!");
			char theGuess=reader.nextLine().charAt(0);
			boolean guessCorrect = theGame.guess(theGuess);
			if (guessCorrect)
				System.out.println("Nice guess!");
			else
				System.out.println("Too bad :(");
			
			System.out.println(theGame.toString());
		}	
		
		if (theGame.getLivesLeft()==0)
			System.out.println("You lose!");
		
		if (theGame.gameWon())
			System.out.println("You win!");
	}
}
