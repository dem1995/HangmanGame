package hangmanPackage;

import java.util.ArrayList;

public class HelperMethods {
	
	public static boolean IsLowerCaseLetter(char c)
	{
		if ('a'<=c && c<='z')	//If the ASCII value of c is between that of 'a' and that of 'z'
			return true;		//It is a lowercase letter
		return false;
	}
	
	public static boolean IsUpperCaseLetter(char c)
	{
		if('A'<=c && c<='Z')	//If the ASCII value of c is between that of 'A' and that of 'Z'
			return true;		//It is an uppercase letter
		return false;
	}
	
	public static boolean IsLetter(char c)
	{
		if (IsLowerCaseLetter(c)||IsUpperCaseLetter(c))
			return true;
		return false;
	}
	
	public static char ToLowerCase(char c)
	{
		char returnChar=c;
		if (IsUpperCaseLetter(returnChar))	//If returnChar is a upper case
			c+=('a'-'A');					//Make it lower case ('a'-'A' is the offset between the uppercase and lowercase ASCII values
		return returnChar;
	}
	
	public static boolean ContainsIgnoreCase(String s, char c)
	{
		if (s.toLowerCase().indexOf(ToLowerCase(c))==-1)	//If there are no case-insensitive matches of c in s
		{
			return false;									//s does not have a case-sensitive match of c
		}
		return true;
	}
	
	public static ArrayList<Integer> IndicesOfMatches(String s, char c)
	{
		ArrayList<Integer> returnList = new ArrayList<Integer>();
		for (int i=0; i<s.length(); i++)				//Cycle through the string
		{
			if (s.charAt(i)==c)							//if we've found a match
				returnList.add(new Integer(i));			//Add the match's index to the return list
		}
		return returnList;
	}
	
	public static ArrayList<Integer> IndicesOfMatchesIgnoreCase(String s, char c)
	{
		ArrayList<Integer> returnList = new ArrayList<Integer>();
		//By putting everything into lowercase ahead of time, we can avoid case issues
		String sCompare=s.toLowerCase();
		char cCompare = ToLowerCase(c);
		for (int i=0; i<s.length(); i++)				//Cycle through the string
		{
			if (sCompare.charAt(i)==cCompare)			//if we've found a match
				returnList.add(new Integer(i));			//Add the match's index to the return list
		}
		return returnList;
	}
}

