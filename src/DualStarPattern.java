
public class DualStarPattern extends Pattern  {

	  public void recognizeInPattern() 
	{
		if(collectedWordsArray.length==1)
		{numberOfPattern+=1;return;}
		else if (collectedWordsArray.length==2)
		{
			if(compileInput.indexOf(collectedWordsArray[0])==0)
			{numberOfPattern+=2;}
			else numberOfPattern+=3;
		}
		else numberOfPattern+=4;
	}

	public  static boolean match(char ch) {
		// TODO Auto-generated method stub
		return false;
	}
	public static boolean match(char ch1, String str , char ch2) 
	{ if(itsCrossingDirectories){return false;}
		if(matchInput.contains(collectedWordsArray[0]))
		{return true;}
		else {return false;}
	}
	public static boolean match(String str1,char ch1,String str2 , char ch2) {
		if(matchInput.startsWith(collectedWordsArray[0]) & matchInput.lastIndexOf(collectedWordsArray[1])>=collectedWordsArray[0].length() )		
		{
			theyMatch=true;
			return true;
		}
		else {return false;}
	}
	public static boolean match(char ch1 , String str1,char ch2, String str2) {
		if(itsCrossingDirectories){return false;}
		if(matchInput.startsWith(collectedWordsArray[1]) & matchInput.indexOf(collectedWordsArray[0]) <= matchInput.length()-lenghtOfAllCollectedWords)
		{
			theyMatch=true;
			return true;
		}
		else {return false;}}
	public static boolean match(String str1 , char ch1, String str2, char ch2, String str3) 
	{
		if(matchInput.startsWith(collectedWordsArray[0])& matchInput.endsWith(collectedWordsArray[2])& matchInput.length()<=lenghtOfAllCollectedWords)
		{
			String wordBetweenStars = (String) matchInput.subSequence(collectedWordsArray[0].length(), matchInput.length()-collectedWordsArray[2].length());
			if(wordBetweenStars.contains(collectedWordsArray[1]))
			{
				theyMatch=true;
				return true;
			}
			else {return false;}
		}else {	return false; }
	}

}
