
public class StarQuestionmarkPattern extends Pattern {

	 public void recognizeInPattern() {
if(collectedWordsArray.length==1)
{
if(matchInput.indexOf(collectedWordsArray[0])==0)
	{numberOfPattern+=2;}
else if(collectedWordsArray.length==2)
	{numberOfPattern+=3;}
}
		
	}

	public static boolean match(char ch) 
	{
		if(matchInput.length()>0)
		{
			theyMatch=true;
			return true;
		}
		else {return false;}
	}
	public static boolean match(char ch , String str) 
	{
		if(matchInput.endsWith(collectedWordsArray[0])&matchInput.length()>lenghtOfAllCollectedWords)
		{
			theyMatch=true;
			return true;
		}
		else {return false;}
	}
	public static boolean match(String str , char ch) 
	{
		if(matchInput.endsWith(collectedWordsArray[0])&matchInput.length()>lenghtOfAllCollectedWords)
		{
			theyMatch=true;
			return true;
		}
		else{return false;}
	}
	public static boolean match(String str1 , char ch, String str2) 
	{
		if(matchInput.startsWith(collectedWordsArray[0])&matchInput.endsWith(collectedWordsArray[1])& matchInput.length()>lenghtOfAllCollectedWords)
		{
			theyMatch=true;
			return true;
		}
		else{return false;}
	}
}
