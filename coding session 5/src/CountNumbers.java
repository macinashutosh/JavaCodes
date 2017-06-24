import java.util.*;
public class CountNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Scanner sn = new Scanner(System.in);
	sn.useDelimiter("\\$");
	String str = sn.next();
	int numberOfCharacters = 0;
	int numberOfWords = 0;
	int numberOfLines = 1;
	int i=0;

	while(i<str.length())
	{	
		if(str.charAt(i)==' ')numberOfWords++;
		else if(str.charAt(i)=='\n'){numberOfLines++;
		numberOfWords++;
		numberOfCharacters--;}
		else numberOfCharacters++;
		i++;
	}
	System.out.println("number of characters:"+numberOfCharacters);
	System.out.println("number of words:"+numberOfWords);
	System.out.println("number of lines:"+numberOfLines);
	}

}
