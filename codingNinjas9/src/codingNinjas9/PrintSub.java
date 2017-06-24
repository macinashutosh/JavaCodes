package codingNinjas9;

import java.util.Scanner;

public class PrintSub {
	public static void subSequence(String input,String outputSoFar){
		if(input.length()==0)
		{
			System.out.println(outputSoFar);
			return;
		}
		subSequence(input.substring(1), outputSoFar);
		subSequence(input.substring(1), outputSoFar+input.charAt(0));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sn = new Scanner(System.in);
		String str = sn.next();
		subSequence(str,"");
		sn.close();
	}
}
