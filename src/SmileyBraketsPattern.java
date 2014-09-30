
public class SmileyBraketsPattern extends Pattern {

	 public void recognizeInPattern() {
		 
		 String braketsWords = compileInput.substring(compileInput.indexOf('{')+1,compileInput.indexOf('}')).toString();
		 collectedWordsBetweenBrackets = braketsWords.split("[\\W\\s .,:]+");
		if(compileInput.indexOf('{')==0)
		{numberOfPattern+=5;}
		if(braketsWords.contains("-"))
		{
			if(collectedWordsBetweenBrackets.length>2)
				{numberOfPattern-=1;return;}
			else numberOfPattern+=3;
		}
		else if(braketsWords.contains(","))
		{numberOfPattern+=2;}
		else if(braketsWords.contains(",")&braketsWords.contains("-"))
		{	numberOfPattern=-1;		}
		else 		{numberOfPattern+=1;}
		
		
			
		}
	

	public static boolean match(char ch) {
		// TODO Auto-generated method stub
		return false;
	}
	public static boolean match(char ch1 , char ch2, char ch3, String str) 
	{
		
		for(int i=0;i<collectedWordsBetweenBrackets.length;i++)
		{
			if(matchInput.startsWith(collectedWordsBetweenBrackets[i])
					& matchInput.endsWith(collectedWordsArray[0])
							& matchInput.length() == collectedWordsArray[0].length()+1)
			{
				theyMatch=true;
				return true;
			}
		}return false;
	}
	public static boolean match(char ch1 , String str1, char ch3, String str2)
	{
		if(matchInput.endsWith(collectedWordsArray[0]))
		{
			for(int i=0;i<collectedWordsBetweenBrackets.length;i++)
			{
				if(matchInput.startsWith(collectedWordsBetweenBrackets[i]) 
						& matchInput.length()==collectedWordsBetweenBrackets[i].length()+collectedWordsArray[0].length())
				{
					theyMatch=true;
					return true;
				}
			}			
		}
		return false;		
	}
	public static boolean match(char ch1 , int ints, char ch3, String str2)
	{   
		if(matchInput.endsWith(collectedWordsArray[0]))
		{
			String firstChar=collectedWordsBetweenBrackets[0].toString();
			int firstInt = Integer.parseInt(firstChar);
			String secoundChar=collectedWordsBetweenBrackets[1].toString();
			int secoundInt = Integer.parseInt(secoundChar);
			if((secoundInt>=firstInt))			
			{
				while(firstInt<=secoundInt)
				{  
					String iStr= Integer.toString(firstInt);
					firstInt++;
					if(matchInput.startsWith( iStr) & matchInput.length()==collectedWordsArray[0].length()+1 )
					{
						theyMatch=true;
						return true;
					}	
					
				}
			}
		}
		return false;
		
	}
	public static boolean match(String str , char ch1 , char ch2, char ch3) 
	{

		for(int i=0;i<collectedWordsBetweenBrackets.length;i++)
		{
			if(matchInput.endsWith(collectedWordsBetweenBrackets[i])
					& matchInput.startsWith(collectedWordsArray[0])
							& matchInput.length() == collectedWordsArray[0].length()+1)
			{return true;}
		}return false;
	}
	public static boolean match(String str  , char ch1 , String str1, char ch3  ) 
	{
		if(matchInput.startsWith(collectedWordsArray[0]))
		{
			for(int i=0;i<collectedWordsBetweenBrackets.length;i++)
			{
				if(matchInput.endsWith(collectedWordsArray[i]) 
						& matchInput.length()==collectedWordsBetweenBrackets[i].length()+collectedWordsArray[0].length())
				{
					theyMatch=true;
					return true;
				}
			}			
		}
		return false;
	}
	public static boolean match(String str , char ch1 , int ints, char ch3) 
	{
		if(matchInput.startsWith(collectedWordsArray[0]))
		{
			String firstChar=collectedWordsBetweenBrackets[0].toString();
			int firstInt = Integer.parseInt(firstChar);
			String secoundChar=collectedWordsBetweenBrackets[1].toString();
			int secoundInt = Integer.parseInt(secoundChar);
			
		
			if(secoundInt>=firstInt)
			{
				while(firstInt<=secoundInt)
				{  
					String iStr= Integer.toString(firstInt);
					firstInt++;
					if(matchInput.endsWith( iStr) & matchInput.length()==collectedWordsArray[0].length()+1 )
					{
						theyMatch=true;
						return true;
					}
					else {return false;}
					
				}
			}
			else {return false;}
		}
		return false;
		
		
		
		
	}
	

}
