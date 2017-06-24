package codingNinjas9;

import java.util.Scanner;

public class PrintSub2 {
	public static String getString(char c)
	{
		String answer = "";
		if(c=='2')answer = "abc";
		else if(c=='3')answer = "def";
		else if(c=='4')answer = "ghi";
		else if(c=='5')answer = "jkl";
		else if(c=='6')answer = "mno";
		else if(c=='7')answer = "pqrs";
		else if(c=='8')answer = "tuv";
		else if(c=='9')answer = "wxyz";
		return answer;
	}
	public static void subSequence(String input,String outputSoFar)
	{	
		if(input.length()==1)
		{	String out = getString(input.charAt(0));
			for(int i=0;i<out.length();++i)
				System.out.println(outputSoFar+out.charAt(i));
			return;
		}
		String s = getString(input.charAt(0));
		for(int i=0;i<s.length();++i)
		subSequence(input.substring(1), outputSoFar+s.charAt(i));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sn = new Scanner(System.in);
		String str = sn.next();
		subSequence(str,"");
		sn.close();

	}

}
