
import java.util.Scanner;

public class Pattern implements ICompileAndMatch
{
	static int numberOfPattern= 0;
	static String compileInput ;
	static String matchInput ;
	static boolean itsValidPattern=false;
	static boolean canCrossDirectories=false;
	static boolean itsCrossingDirectories=false;
	static int numberOfSpecialChars=0;
	static boolean theyMatch = false;
	static boolean patternStartWithStar=false;
	static boolean patternStartWithQuestionmark=false;
	static int lenghtOfAllCollectedWords;

	static String[] collectedWordsArray ;

	static String[] collectedWordsBetweenBrackets;
	

	
	static Scanner input; 

	
	
	
	static public void takeCompileInput() {
	input = new Scanner(System.in);
		System.out.println("Please enter your finding pattern");
		compileInput = input.nextLine();
		compileInput.toLowerCase();
		if (compileInput.length() == 0 || compileInput == null) 
		{
			System.out.println("You must enter some kind of pattern");
			takeCompileInput();
		}
		
	}
	
	static public void takeMatchInput ()
	{
			input = new Scanner(System.in);
			System.out.println("Please enter the word you want to check ");
			String minput = input.nextLine();
			matchInput = minput;
			matchInput.toLowerCase();
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
			//input.close();
		
	}
	
	static void checkForSmileyBracketsPattern(int i)
{
	
	int j=i;
	
		while ( j < compileInput.length()) 
			{				
				if (compileInput.charAt(j)== '}')
				{
					numberOfPattern = 60;
					break;
				}
				j++;
			}			
		
}

	public static void recognizePattern()
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
				numberOfPattern=20;
				if (compileInputCharArray[i + 1] == '*'	&& (i+1) < compileInput.length()) 
				{
					numberOfPattern=24;
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
    
    static  void collectWords()
    {
    	
    	if(numberOfPattern==60)
    	{
    		if(compileInput.indexOf("{")==0)
    		{
    			String word = compileInput.substring(compileInput.indexOf("}")+1 , compileInput.length()).toString() ;
    			collectedWordsArray=word.split("[\\W]+");
    		}
    		else
    		{
    			String word2 = compileInput.substring(0,compileInput.indexOf("{") ) ;
    			collectedWordsArray=word2.split("[\\W]+");
    		}
    		
    	}else
    	collectedWordsArray = compileInput.split("[\\W\\s {}.,:]+");
    	
    }

	static void printPatternName()
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
			case 24 : System.out.println("You choose ** pattern");break;
			case 25 : System.out.println("You choose Word** pattern");break;
			case 26 : System.out.println("You choose **Word pattern");break;
			case 27 : System.out.println("You choose Word**Word pattern");break;
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
	
	static void calculateLenghtOfAllCollectedWords()
	{
		lenghtOfAllCollectedWords=0;
		int i=0;
		while (i < collectedWordsArray.length)
		{
			lenghtOfAllCollectedWords+=collectedWordsArray[i].length();
			i++;
		}
	}
	
	static Pattern returnSomePattern(){
		switch(numberOfPattern)
		{
		case 10 : return new QuestionmarkPattern() ; 
		case 20 : return new StarPattern() ; 
		case 30 : return new QuestionmarkAndStarPattern();
		case 40 : return new  StarQuestionmarkPattern();
		case 50 : return new DualStarPattern();
		case 60 : return new SmileyBraketsPattern();	
		case 0  : return new DefaultPattern();
		default : return new DefaultPattern();
		}	
	}
	
	static void checkForCrossingDirectories()
	{
		switch(numberOfPattern)
	 {
		case 20: 
		{
			if(matchInput.contains("\\"))
				{itsCrossingDirectories=true;} ; break;
		}
		case 21 :
		{if( matchInput.substring(collectedWordsArray[0].length(), matchInput.length()).contains("\\"))
		{itsCrossingDirectories=true;} ; break;			
		}
		case 22 :
		{
			if(matchInput.substring(0,matchInput.lastIndexOf(collectedWordsArray[1])+1).contains("\\"))
			{itsCrossingDirectories=true;} ; break;	
		}
		case 23:
		{
			if(matchInput.substring(collectedWordsArray[0].length(),matchInput.lastIndexOf(collectedWordsArray[1])).contains("\\"))
			{itsCrossingDirectories=true;} ; break;	
		}
		case 24: 
		{
			if(matchInput.contains("\\"))
				{itsCrossingDirectories=true;} ; break;
		}
		case 25 :
		{if( matchInput.substring(collectedWordsArray[0].length(), matchInput.length()).contains("\\"))
		{itsCrossingDirectories=true;} ; break;			
		}
		case 26 :
		{
			if(matchInput.substring(0,matchInput.lastIndexOf(collectedWordsArray[1])+1).contains("\\"))
			{itsCrossingDirectories=true;} ; break;	
		}
		case 27:
		{
			if(matchInput.substring(collectedWordsArray[0].length(),matchInput.lastIndexOf(collectedWordsArray[1])).contains("\\"))
			{itsCrossingDirectories=true;} ; break;	
		}
		case 31:
		{
			if(matchInput.substring(0,matchInput.lastIndexOf(collectedWordsArray[0])).contains("\\"))
			{itsCrossingDirectories=true;} ; break;	
		}
		case 32:
		{
			if(matchInput.substring(matchInput.indexOf(collectedWordsArray.length, matchInput.length())).contains("\\"))
			{itsCrossingDirectories=true;} ; break;
		}
		case 33:
		{
			if(matchInput.substring(collectedWordsArray[0].length(),matchInput.lastIndexOf(collectedWordsArray[1]+1)).contains("\\"))
			{itsCrossingDirectories=true;} ; break;
		}
		case 34: 
		{
			if(matchInput.substring	(matchInput.lastIndexOf(collectedWordsArray[1]) + collectedWordsArray[0].length() 
							, matchInput.length()).contains("\\"))
			{itsCrossingDirectories=true;} ; break;
		}
		case 35:
		{
			if(matchInput.substring	(collectedWordsArray[0].length(),matchInput.lastIndexOf(collectedWordsArray[1])).contains("\\"))
			{itsCrossingDirectories=true;} ; break;
		}
		case 36:
		{
			if(matchInput.substring(matchInput.indexOf(collectedWordsArray[1])+collectedWordsArray[1].length(),
					matchInput.lastIndexOf(collectedWordsArray[2])).contains("\\"))
			{itsCrossingDirectories=true;} ; break;
		}
		case 40:
		{
			if(matchInput.contains("\\"))
			{itsCrossingDirectories=true;} ; break;
		}
		case 41:
		{
			if(matchInput.substring	(0,matchInput.lastIndexOf(collectedWordsArray[0])).contains("\\"))
			{itsCrossingDirectories=true;} ; break;
		}
		case 42:
		{
			if(matchInput.substring	(collectedWordsArray[0].length(),matchInput.length()-1).contains("\\"))
			{itsCrossingDirectories=true;} ; break;
		}
		case 43:
		{  
			if(matchInput.substring	(collectedWordsArray[0].length() , matchInput.lastIndexOf(collectedWordsArray[1])).contains("\\"))
			{itsCrossingDirectories=true;} ; break;
		}
		case 51:
		{
			String string2 = matchInput.substring(matchInput.indexOf(collectedWordsArray[0])+collectedWordsArray[0].length() , matchInput.length()); 
			String string1 = matchInput.substring(collectedWordsArray[0].length() , matchInput.lastIndexOf(collectedWordsArray[1]));
			String string3 = string1+string2;
			if(string3.contains("\\"))
			{itsCrossingDirectories=true;} ; break;
		}
		case 52:
		{
			String string2 = matchInput.substring(collectedWordsArray[0].length() , matchInput.lastIndexOf(collectedWordsArray[1]+1)); 
			String string1 = matchInput.substring(matchInput.lastIndexOf(collectedWordsArray[1])+collectedWordsArray[1].length() , matchInput.length());
			String string3 = string1+string2;
			if(string3.contains("\\"))
			{itsCrossingDirectories=true;} ; break;
		}
		case 53:
		{
			String string2 = matchInput.substring(0 , matchInput.indexOf(collectedWordsArray[0])); 
			String string1 = matchInput.substring(matchInput.indexOf(collectedWordsArray[0])+collectedWordsArray[0].length(),matchInput.lastIndexOf(collectedWordsArray[1]));
			String string3 = string1+string2;
			if(string3.contains("\\"))
			{itsCrossingDirectories=true;} ; break;
		}
		case 54:
		{
			String string2 = matchInput.substring(matchInput.indexOf(collectedWordsArray[0])+collectedWordsArray[0].length() , matchInput.indexOf(collectedWordsArray[1])); 
			String string1 = matchInput.substring(matchInput.indexOf(collectedWordsArray[1])+collectedWordsArray[1].length(),matchInput.lastIndexOf(collectedWordsArray[2]));
			String string3 = string1+string2;
			if(string3.contains("\\"))
			{itsCrossingDirectories=true;} ; break;
		}
	}
	 
	}
	 static void compile()
	 {
		 	takeCompileInput();
			takeMatchInput();
			recognizePattern();
			
			printPatternName();
		
			collectWords();
			
			calculateLenghtOfAllCollectedWords();
			returnSomePattern().recognizeInPattern();
			checkForCrossingDirectories();
			printPatternName();
			
			
		
			
			
			
	 }
	static void match()
	{
	switch(numberOfPattern)
		{
	case -1 : System.out.println("Sorry but this pattern is not available on this version. Please select one of our other search patterns");break;
	case 0  : {    DefaultPattern.match('c');   };break;
	case 10 : {    QuestionmarkPattern.match('c' );   };break;
	case 11 : {    QuestionmarkPattern.match("string" , 'c' );   };break;
	case 12 : {    QuestionmarkPattern.match('c' , "string");   };break;
	case 13 : {    QuestionmarkPattern.match("string1",'c' , "string1");   };break;
	case 20 : {    StarPattern.match( 'c');   };break;
	case 21 : {    StarPattern.match("string" , 'c' );   };break;
	case 22 : {    StarPattern.match('c' , "string");   };break;
	case 23 : {    StarPattern.match("string1", 'c' , "string2");   };break;
	case 24 : {    StarPattern.match("string" , 'c'  ,'c');   };break;
	case 25 : {    StarPattern.match('c', 'c' );   };break;
	case 26 : {    StarPattern.match('c', 'c' , "string");   };break;
	case 27 : {    StarPattern.match("string1", 'c' , 'c' , "string2");   };break;
	case 30 : {    QuestionmarkAndStarPattern.match('c');   };break;
	case 31 : {    QuestionmarkAndStarPattern.match(true , "word" , 'c');   };break;
	case 32 : {    QuestionmarkAndStarPattern.match('c',"word",true);   };break;
	case 33 : {    QuestionmarkAndStarPattern.match("word1",true,"word2",'c');   };break;
	case 34 : {    QuestionmarkAndStarPattern.match("word1",'c',"word2",true);   };break;
	case 35 : {    QuestionmarkAndStarPattern.match("word1",true,"word2",'c',"word3");   };break;
	case 36 : {    QuestionmarkAndStarPattern.match("word1",'c',"word2",true,"word3");   };break;
	case 40 : {    StarQuestionmarkPattern.match('c');   };break;
	case 41 : {    StarQuestionmarkPattern.match('c',"word1");   };break;
	case 42 : {    StarQuestionmarkPattern.match("word1",'c');   };break;
	case 43 : {    StarQuestionmarkPattern.match("word1",'c',"word2");   };break;			
	case 50 : {    DualStarPattern.match('c');   };break;
	case 51 : {    DualStarPattern.match('c',"word1",'c');   };break;
	case 52 : {    DualStarPattern.match("word1",'c',"word2",'c');   };break;
	case 53 : {    DualStarPattern.match('c',"word1",'c',"word1");   };break;
	case 54 : {    DualStarPattern.match("word1",'c',"word2",'c',"word3");   };break;			
	case 60 : {    SmileyBraketsPattern.match('c');   };break;
	case 61 : {    SmileyBraketsPattern.match("word",'c','c','c');   };break;
	case 62 : {    SmileyBraketsPattern.match("word",'c',"words",'c');   };break;
	case 63 : {    SmileyBraketsPattern.match("word",'c',1,'c');   };break;
	case 65 : {    SmileyBraketsPattern.match('c');   };break;
	case 66 : {    SmileyBraketsPattern.match('c','c','c',"word");   };break;
	case 67 : {    SmileyBraketsPattern.match('c',"words",'c',"word");   };break;
	case 68 : {    SmileyBraketsPattern.match('c',1,'c',"word");   };break;
	
		}
	System.out.println("Do your two words match : "+theyMatch);
	}
	public static void main(String args[])
	{
		compile();
		match();

		
		
	}

	public void recognizeInPattern() {
		// TODO Auto-generated method stub
		
	}
	
	

}
