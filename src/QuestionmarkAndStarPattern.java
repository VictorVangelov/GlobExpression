
public class QuestionmarkAndStarPattern extends Pattern {

	  public void recognizeInPattern() {
	if(collectedWordsArray.length==1)
	{
		if(patternStartWithStar)
		{numberOfPattern+=1;}
		else {numberOfPattern+=2;}
	}else if(collectedWordsArray.length==2)
		{
		if(patternStartWithStar)
		{numberOfPattern+=3;}
		else{numberOfPattern+=4;}
		}
	else 
		{
		if(patternStartWithStar)
		{numberOfPattern+=5;}
		else {numberOfPattern+=6;}
			
		}
	}

	public static boolean match(char ch) {
		if(matchInput.length()>0)
		{
			theyMatch=true;
			return true;
		}
		else {return false; }
		
	}
	public static boolean match(boolean bool , String str , char ch) 
	{
		if(matchInput.indexOf(collectedWordsArray[0])==(matchInput.length()-lenghtOfAllCollectedWords))
		{
			theyMatch=true;
			return true;
		}
		else {return false;}
	}
	public static boolean match(char ch,String str,boolean bool) {
		if(matchInput.indexOf(collectedWordsArray[0])==1)
		{
			theyMatch=true;
			return true;
		}
		else { return false;}
	}
	public static boolean match(String str1, boolean bool , String str2, char ch) 
	{
		if(matchInput.startsWith(collectedWordsArray[0]) & matchInput.indexOf(collectedWordsArray[1])==matchInput.length()-lenghtOfAllCollectedWords-1)
		{
			theyMatch=true;
			return true;
		}
		else { return false;}
	}
	public static boolean match(String str1, char ch , String str2, boolean bool) {
		if(matchInput.startsWith(collectedWordsArray[0])&matchInput.indexOf(collectedWordsArray[1])==collectedWordsArray[1].length()+1)
		{
			theyMatch=true;
			return true;
		}
		else{return false;}
	}
	public static boolean match(String str1, boolean bool ,String str2,  char ch, String str3  )
	{
		if(matchInput.startsWith(collectedWordsArray[0]) & matchInput.indexOf(collectedWordsArray[1])==matchInput.length()-lenghtOfAllCollectedWords-1)
		{
			theyMatch=true;
			return true;
		}
		else {return false;}
	}
	public static boolean match(String str1 , char ch , String str2 , boolean bool , String str3) 
	{
		if(matchInput.startsWith(collectedWordsArray[0]) & matchInput.endsWith(collectedWordsArray[3])
				& matchInput.indexOf(collectedWordsArray[1]) == collectedWordsArray[0].length()+1 & matchInput.length()>lenghtOfAllCollectedWords)
		{
			theyMatch=true;
			return true;
		}
		else {return false;}
	}
	
	

}
