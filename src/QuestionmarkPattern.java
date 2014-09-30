
public class QuestionmarkPattern extends Pattern {

	 public void recognizeInPattern() 
{
	if(collectedWordsArray.length==1)
	{
	if(matchInput.indexOf("?")==0)
		{numberOfPattern+=2;}
	else { numberOfPattern+=1;}
	}
	else if(collectedWordsArray.length==2) { numberOfPattern+=3; }
}

public static boolean match(char ch) 
{ 
	if(matchInput.length()==1)  
	{
		theyMatch=true;
		return true;
	}
	else   {	return false;	}
}

public static boolean match(String str , char ch) 
{
	if(matchInput.startsWith(collectedWordsArray[0]) 
			& matchInput.length()== lenghtOfAllCollectedWords)
	{
		theyMatch=true;
		return true;
	}
	else {return false;}
}
public static boolean match(char ch , String str) 
{
	if(matchInput.endsWith(collectedWordsArray[0])
			&matchInput.length()==lenghtOfAllCollectedWords+1)
	{
		theyMatch=true;
		return true;
	}
	else {return false;}
}
public static boolean match(String str1 , char ch , String str2) 
{
	if(matchInput.startsWith(collectedWordsArray[0])
			& matchInput.endsWith(collectedWordsArray[1]) 
					& matchInput.length()  == lenghtOfAllCollectedWords+1)
	{
		theyMatch=true;
		return true;
	}
	else {return false;}
}



}
