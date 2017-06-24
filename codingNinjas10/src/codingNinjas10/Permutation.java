package codingNinjas10;
import java.util.*;
public class Permutation {

	public static void permutations(String input)
	{
		permutationHelper(input,"");
	}
	
	public static void permutationHelper(String input,String outputSoFar)
	{	if(input.length()==1)
		{
			System.out.println(outputSoFar + input.charAt(0));
			return;
		}
		for(int i=0;i<input.length();++i)
		{
			permutationHelper(input.substring(0,i)+input.substring(i+1), outputSoFar+input.charAt(i));
		}
	}
	public  static void main(String args[])
	{
		Scanner sn = new Scanner(System.in);
		String s = sn.nextLine();
		//permutations(s);
		 print(permutationOfStrings(s));
		
		sn.close();
	}
	public static void print(String [] output){
		for(int i=0;i<output.length;++i)
			System.out.println(output[i]);
	}
	
	//function to return a string array of permutations
	public static int factorial(int n)
	{	if(n==1)return 1;
		return n * factorial(n-1);
	}
	
	public static String[]  permutationOfStrings(String input)
	{
		String str[] = new String[factorial(input.length())];
		for(int i=0;i<factorial(input.length());++i)
			str[i] = permutationOfStringHelper(input, "");
		return str;
	}
	
	public static String permutationOfStringHelper(String input,String outputSoFar)
	{
		return input;
	}
		
}
