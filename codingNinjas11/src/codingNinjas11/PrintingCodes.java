package codingNinjas11;

import java.util.Scanner;

public class PrintingCodes {
	
	 public static String code(String ch)
	    {	String str = "";
	        if(ch.equals("1"))str = "a";
	        else if(ch.equals("2"))str = "b";
	        else if(ch.equals("3"))str = "c";
	        else if(ch.equals("4"))str = "d";
	        else if(ch.equals("5"))str = "e";
	        else if(ch.equals("6"))str = "f";
	        else if(ch.equals("7"))str = "g";
	        else if(ch.equals("8"))str = "h";
	        else if(ch.equals("9"))str = "i";
	        else if(ch.equals("10"))str = "j";
	        else if(ch.equals("11"))str = "k";
	        else if(ch.equals("12"))str = "l";
	        else if(ch.equals("13"))str = "m";
	        else if(ch.equals("14"))str = "n";
	        else if(ch.equals("15"))str = "o";
	        else if(ch.equals("16"))str = "p";
	        else if(ch.equals("17"))str = "q";
	        else if(ch.equals("18"))str = "r";
	        else if(ch.equals("19"))str = "s";
	        else if(ch.equals("20"))str = "t";
	        else if(ch.equals("21"))str = "u";
	        else if(ch.equals("22"))str = "v";
	        else if(ch.equals("23"))str = "w";
	        else if(ch.equals("24"))str = "x";
	        else if(ch.equals("25"))str = "y";
	        else if(ch.equals("26"))str = "z";
	        
	        return str;
	    }
		public static void printAllPossibleCodes(String input) {
			// Write your code here
	        printAllPossibleCodesHelper(input, "");
		}
		public static void printAllPossibleCodesHelper(String input,String outputSoFar){
			if(input.length()==0)
			{
				System.out.println(outputSoFar);
				return;
			}
			if(input.length()==1)
			{
				System.out.println(code(input)+outputSoFar);
				return;
			}
			
				
				String str = code(input.substring(input.length()-1));
				printAllPossibleCodesHelper(input.substring(0,input.length()-1), str+outputSoFar);
				String str2 = code(input.substring(input.length()-2));
				printAllPossibleCodesHelper(input.substring(0,input.length()-2), str2+outputSoFar);
			
			
			}
			
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sn = new Scanner(System.in);
		String str = sn.next();
		printAllPossibleCodes(str);
	}

}
