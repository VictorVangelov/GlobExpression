import java.util.ArrayList;
import java.util.Scanner;

public class GlobeExpression {
	static int Pattern=0;
	String compileInput = null;
	boolean firstCharIsSpecialSymbol = false;
	boolean itsSmileyBracketsPattern = false;
	boolean itsQuestionmarkPattern = false;
	boolean itsStarPattern = false;
	boolean itsDoubleStarPattern = false;
	boolean itsStarQuestionmarkPattern = false;
	boolean itsStarWordQuestionmark = false;
	boolean itsDefaultPattern = false;
	boolean patternStartWithQuestionmark=false;

	ArrayList<String> collectedWards = null;

	public void takingUserInput() {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter your finding pattern");
		compileInput = input.nextLine();
		if (compileInput.length() == 0 || compileInput == null) {
			System.out.println("You must enter some kind of pattern");
			takingUserInput();
		}
		input.close();
	}

	void checkFirstChar() {
		char firstChar = this.compileInput.charAt(0);
		if (itsSmileyBracketsPattern) {
			if (firstChar == '*' || firstChar == '?' || firstChar == '{') {
				firstCharIsSpecialSymbol = true;
			}
		} else if (firstChar == '*' || firstChar == '?') {
			firstCharIsSpecialSymbol = true;
		}

	}

	void recognizePattern() {
		for (int i = 0; i < compileInput.length(); i++) {
			if (compileInput.charAt(i) == '?') 
			{
				if(itsQuestionmarkPattern)
				{
					System.out.println("Your pattern is incorect! At this time pattern with two questionmark symbols \"?\" is not available.");
					takingUserInput();
				} 
				else
				itsQuestionmarkPattern = true;
				if(!patternStartWithQuestionmark)
				patternStartWithQuestionmark = true;
				continue;
			}
			else if (userInput.charAt(i) == '*') 
			{
				if (userInput.charAt(i + 1) == '*'	&& (i+1) < userInput.length()) 
				{
					itsDoubleStarPattern = true;
					
					System.out.println("Its Star Pattern and you can cross directories");
					break;
				} 
				else if (userInput.charAt(i + 1) == '?' && (i+1) < userInput.length()) 
				{
					itsStarQuestionmarkPattern = true;
					System.out.println("Its Star-Questionmark Pattern");
					break;
				} 
				else itsStarPattern = true;

				if (userInput.charAt(i) == '{') {
					int j = i + 2;
					while (userInput.charAt(j) == '}' || j < userInput.length()) {
						j++;
						if (userInput.charAt(j) == '}') {
							itsSmileyBracketsPattern = true;
							break;
						}
					}
					if(itsSmileyBracketsPattern){break;}
				}

			}
		}
		if (itsQuestionmarkPattern && itsStarPattern) {
			itsQuestionmarkPattern = false;
			itsStarPattern = false;
			itsStarQuestionmarkPattern = true;
		}
		if (!(itsSmileyBracketsPattern && itsQuestionmarkPattern
				&& itsStarPattern && itsDoubleStarPattern
				&& itsStarQuestionmarkPattern && itsStarWordQuestionmark)) {
			itsDefaultPattern = true;
		}

	}

	
	public static void main(String args[]) {
QuestionmarkPattern asd= new QuestionmarkWordPattern();
int a=0;
int b=0;
int c=1;
	}

}
