package hangmanPackage;

import java.util.ArrayList;
import java.util.Arrays;

public class HangmanGame 
{
	//Fields//
	private String secretWord;					//The hidden Hangman word that needs to be guessed.
	private boolean[] guessedLetterIndices;		//Whether the user has guessed the letter at each index of secretWord correctly.
	private int numLives=7;						//How many lives the user has.
	
	//Constructors//
	HangmanGame(String theSecretWord)
	{
		secretWord=theSecretWord;
		guessedLetterIndices = new boolean[theSecretWord.length()];
		//Fill the guessedLetterIndices with the value "false".
		Arrays.fill(guessedLetterIndices, false);
	}
	
	//Getters// 
	public String getSecretWord(){return secretWord;}
	public int getLivesLeft(){return numLives;}
	
	//Methods//
	
	/**
	 * This method is used for guessing Hangman letters. If the character provided is in this HangmanGame object's secretWord,
	 * then the corresponding values of guessedLetterIndices get set to true. If the character provided is not in the 
	 * HangmanGameObject's secret word, then a life is lost. Returns whether or not the character provided was in the secretWord.
	 */
	public boolean guess(char guessChar)
	{
		//Assume they've guessed wrong until proven otherwise.
		boolean guessCorrect=false;
		
		//If the string contains the character, they've guessed correctly.
		if (HelperMethods.ContainsIgnoreCase(secretWord, guessChar))
			guessCorrect=true;
		
		//If they guessed correctly, figure out which slots of the word they got.
		if (guessCorrect)
		{
			ArrayList<Integer> correctIndices = HelperMethods.IndicesOfMatchesIgnoreCase(secretWord, guessChar);
			for (int i=0; i<correctIndices.size(); i++)
				guessedLetterIndices[correctIndices.get(i)]=true;
		}
		//Otherwise, they lose a life.
		else
			numLives--;
		
		return guessCorrect;
	}
	
	public boolean gameWon()
	{
		for (int i=0; i<guessedLetterIndices.length; i++)
			if (!guessedLetterIndices[i])
				return false;
		return true;
	}
	
	public String toString()
	{
		String returnString="There are " + numLives + " lives left\n";
		returnString+="Current status: ";
		for (int i=0; i<guessedLetterIndices.length; i++)
			returnString += (guessedLetterIndices[i]? secretWord.charAt(i) : '_');
		return returnString;
	}
	
}
