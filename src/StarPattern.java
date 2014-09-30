
public class StarPattern extends Pattern  {

	 public void recognizeInPattern() 
	{
		if(canCrossDirectories)
		{numberOfPattern+=4;}
		if(collectedWordsArray.length==1)
		{
			if(matchInput.indexOf('*')==0)
				 {numberOfPattern+=2;  return;}
			else {numberOfPattern+=1; return;}
		}else if(collectedWordsArray.length==2)
		{numberOfPattern+=3; return;}
		
	}

public static boolean match(char ch) {
		if(!itsCrossingDirectories)
		{
			theyMatch=true;
			return true;
		}
		else{ return false;	}
	}
public static boolean match(String str, char ch) 
	{
		if(!itsCrossingDirectories & matchInput.startsWith(collectedWordsArray[0]))
		{
			theyMatch=true;
			return true;
		}
		else {return false;}
	}
public static boolean match(char ch , String str)
{
if(!itsCrossingDirectories & matchInput.startsWith(collectedWordsArray[0])&matchInput.endsWith(collectedWordsArray[1]))
	{	return true;	}	
else {return false;}
}
public static boolean match(String str1  , char ch1  , String str2)
{   if(!itsCrossingDirectories)
	{
		if(matchInput.startsWith(collectedWordsArray[0])&matchInput.endsWith(collectedWordsArray[1])& matchInput.length()>=lenghtOfAllCollectedWords)
		{
		theyMatch=true;
		return true;
		}
		else{return false;}
	}else {return false;}
}
public static boolean match(char ch1,char ch2)
 {
		theyMatch=true;
		return true;
	}
public static boolean match(String str, char ch1,char ch2)
{
if(matchInput.startsWith(collectedWordsArray[0]))
{
	theyMatch=true;
	return true;
}
else {return false;}
}
public static boolean match(char ch1 , char ch2 , String str){
	if(matchInput.endsWith(collectedWordsArray[0]))
	{
		theyMatch=true;
		return true;
	}
	else{return false;}
}
public static boolean match(String str1  , char ch1  , char ch2, String str2)
{
	if(matchInput.startsWith(collectedWordsArray[0])&matchInput.endsWith(collectedWordsArray[1])& matchInput.length()>=lenghtOfAllCollectedWords)
	{
		theyMatch=true;
		return true;
	}
else{return false;}
}




}
