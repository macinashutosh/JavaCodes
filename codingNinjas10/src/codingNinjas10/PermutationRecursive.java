package codingNinjas10;

import java.util.Scanner;

public class PermutationRecursive {
	
	public static void main(String args[]) {
		Scanner sn = new Scanner(System.in);
		String s = sn.next();
		//System.out.println(factorial(s.length()));
		String output[] = permutationOfString(s);
		for(int i=0;i<output.length;++i)
		{
			System.out.println(output[i]);
		}
	}
	
	
	public static int factorial(int length)
	{   int fact =1;
	    for(int i=1;i<=length;++i)
	    fact = fact * i;
	    return fact;
	}
    public static String[] permutationOfString(String input){
		// Write your code here
		if(input.length()==0)
		{
		    String s[] = new String[0];
		    return s;
		}
		if(input.length()==1)
		{
		    String s[] = new String[1];
		    s[0] = input;
		    return s;
		}
		if(input.length()==2)
		{
		    String s[] = new String[2];
		    s[0] = ""+input.charAt(0)+input.charAt(1);
		    s[1] = ""+input.charAt(1)+input.charAt(0);
		    return s;
		}
		 
	    String [] output = new String[factorial(input.length())];
	    int count =0;
        for(int i=0;i<input.length();++i)
        {
            String smallOutput[] = permutationOfString(input.substring(0,i)+input.substring(i+1));
            for(int j=0;j<smallOutput.length;++j,count++)
            output[count] = input.charAt(i)+smallOutput[j];
        }
        return output;
	}
	
}
