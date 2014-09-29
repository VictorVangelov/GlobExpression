
import java.util.Scanner;

public class GlobeExpression implements ICompileAndMatch {
	static int numberOfPattern= 0;
	static String compileInput = null;
	static String matchInput = null;
	boolean itsValidPattern=false;
	boolean canCrossDirectories=false;
	boolean itsCrossingDirectories=false;
	static int numberOfSpecialChars=0;
	
	boolean patternStartWithStar=false;
	boolean patternStartWithQuestionmark=false;
	static int lenghtOfAllCollectedWords=0;

	static String[] collectedWordsArray = null;
	static String[] collectedSeparatorsArray = null;
	static String[] collectedWordsBetweenBrackets=null;
	public void takeCompileInput() {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter your finding pattern");
		compileInput = input.nextLine();
		if (compileInput.length() == 0 || compileInput == null) 
		{
			System.out.println("You must enter some kind of pattern");
			takeCompileInput();
		}
		input.close();
	}
	public void takeMatchInput ()
	{
			Scanner input = new Scanner(System.in);
			System.out.println("Please enter the word you want to check ");
			matchInput = input.nextLine();
			if (matchInput.length() == 0 || matchInput == null)
			{
				System.out.println("You must enter some word to match. /n Please try again or type \"alt+f4\" to stop the program");
				takeMatchInput();
				if(matchInput.equals("alt+f4"))
				{
				System.exit(0);
				}
				else matchInput=input.nextLine();
			}
			input.close();
		
	}
	void checkForSmileyBracketsPattern(int i)
{
	
	for (int j=i;j<compileInput.length();j++)
	{
		while ( j < compileInput.length()) 
			{				
				if (compileInput.charAt(j)== '}')
				{
					numberOfPattern = 60;
					break;
				}				
			}			
	}	
}
	public void recognizePattern()
	{
		char[] compileInputCharArray= compileInput.toCharArray();

		for(int i=0;i<compileInput.length();i++)
		{
			if (compileInputCharArray[i] == '{') 
			{
				checkForSmileyBracketsPattern(i);	
			}
			else if(compileInputCharArray[i]=='?' | compileInputCharArray[i]=='*')
			{
				numberOfSpecialChars++;
			}
		}
		if(numberOfPattern==60)
		{
			if(numberOfSpecialChars!=0)
			{
				numberOfPattern = (-1);	
				return;
			}
			return;
		}
		else if(numberOfSpecialChars>2)
		{
			numberOfPattern=-1;
			return;
		}
		else if(numberOfSpecialChars==0)
		{
			numberOfPattern=0;
			return;
		}
		else
		{
			for (int i = 0; i < compileInput.length(); i++)		
		 {
			if (compileInputCharArray[i] == '?') 
			{
				if(!patternStartWithQuestionmark)
				{
					patternStartWithQuestionmark=true;
					numberOfPattern+=10;					
				}
				else if(patternStartWithStar)
				{
					numberOfPattern+=10;
				}
				else
				{
					numberOfPattern=-1;
					return;
				}
			}
			else if (compileInputCharArray[i] == '*') 
			{
				if (compileInputCharArray[i + 1] == '*'	&& (i+1) < compileInput.length()) 
				{
					numberOfPattern=20;
					canCrossDirectories=true;
					return;
				} 
				else if (compileInputCharArray[i + 1] == '?' && (i+1) < compileInput.length()) 
				{
					numberOfPattern=40;
					return;
				} 
				else
				{ 
					if(patternStartWithQuestionmark)
					{
						numberOfPattern+=20;
						return;
					}
					else if(patternStartWithStar)
					{
						numberOfPattern=50;
						return;
					}
					else
					{ 
					patternStartWithStar=true;
					numberOfPattern+=20;
					return;
					
					}	
				}

			}
		 }
		}
	
	}
   static  void collectWordsAndSeparators()
    {
    	collectedWordsArray = compileInput.split("[\\W\\s {}.,:]+");
    	collectedWordsArray = compileInput.split("[\\w\\s{}.:]+");
    }


	void printPatternName(int numberOfPattern)
	{
		switch (numberOfPattern)
		{
			case -1 : System.out.println("Sorry but this pattern is not available on this version. Please select one of our other search patterns");break;
			case 0  : System.out.println("You choice our defaut search pattern");break;
			case 10 : System.out.println("You choose ? pattern");break;
			case 11 : System.out.println("You choose Word? pattern");break;
			case 12 : System.out.println("You choose ?Word pattern");break;
			case 13 : System.out.println("You choose Word?Word pattern");break;
			case 20 : System.out.println("You choose * pattern");break;
			case 21 : System.out.println("You choose Word* pattern");break;
			case 22 : System.out.println("You choose *Word pattern");break;
			case 23 : System.out.println("You choose Word*Word pattern");break;
			case 30 : System.out.println("You choose ?and* pattern");break;
			case 31 : System.out.println("You choose ?word* pattern");break;
			case 32 : System.out.println("You choose *word? pattern");break;
			case 33 : System.out.println("You choose word*word? pattern");break;
			case 34 : System.out.println("You choose word?word* pattern");break;
			case 35 : System.out.println("You choose word*word?word pattern");break;
			case 36 : System.out.println("You choose word?word*word pattern");break;
			case 40 : System.out.println("You choose *? pattern");break;
			case 41 : System.out.println("You choose *?word pattern");break;
			case 42 : System.out.println("You choose word*? pattern");break;
			case 43 : System.out.println("You choose word*?word  pattern");break;			
			case 50 : System.out.println("You choose *and* pattern");break;
			case 51 : System.out.println("You choose *word* pattern");break;
			case 52 : System.out.println("You choose word*word* pattern");break;
			case 53 : System.out.println("You choose *word*word pattern");break;
			case 54 : System.out.println("You choose word*word*word pattern");break;			
			case 60 : System.out.println("You choose {} pattern");break;
			case 61 : System.out.println("You choose word{word} pattern");break;
			case 62 : System.out.println("You choose word{words} pattern");break;
			case 63 : System.out.println("You choose word{ints} pattern");break;
			case 65 : System.out.println("You choose {}word pattern");break;
			case 66 : System.out.println("You choose {word}word pattern");break;
			case 67 : System.out.println("You choose {words}word pattern");break;
			case 68 : System.out.println("You choose {ints}word pattern");break;
							
		}
		
	}
	
	void calculateLenghtOfAllCollectedWords()
	{
		for(int i=0;i<collectedWordsArray.length;i++)
		{
			lenghtOfAllCollectedWords+=collectedWordsArray[i].length();
		}
	}
	
	Object returnSomePattern(){
	return new QuestionmarkPattern();	
	}
	
	public static void main(String args[])
	{
		
		
		
		
		
		
		
		
		char ascending='A';
		char descending='z';
		while (ascending<='Z')
		{
		System.out.println (ascending + " " + descending);
		ascending++;
		descending--;
		}
		
	
		/*int code ='97';
		int code = (int) ch;
		char dsa = (char) code;
		System.out.println("code : " +dsa);*/
		
		/*compileInput= "aide?aide";
		matchInput = "aidehaide";
		collectedSeparatorsArray = compileInput.split("[\\w\\s{}.:]+");
		collectedWordsArray = compileInput.split("[\\W\\s{}.,:]+");
		
		
		for(String collectedWord : collectedWordsArray) {
			System.out.println(collectedWord);	
			
		}*/
		//System.out.println(collectedWordsArray.length);

	}
	public boolean match(char ch) {
		// TODO Auto-generated method stub
		return false;
	}


}
