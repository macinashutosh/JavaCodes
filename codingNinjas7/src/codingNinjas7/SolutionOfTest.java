package codingNinjas7;

import java.util.Scanner;

public class SolutionOfTest {
	public static int power(int num,int k)
	{	int po = 1;
		for(int i=0;i<k;++i)
		{
			po = po * num;
		}
		return po;
	}
	 public static String printAllKLengthRec(String charSet, String prefix, int n, int k) {
         if(k==0)return prefix;
         String newPrefix = "";
         newPrefix = newPrefix + printAllKLengthRec(charSet,Character.toString(charSet.charAt(n-1)), n-1, k-1);
         return newPrefix;
	    }
	public static void numberOfStrings(String input,int k)
	{
		int po = power(input.length(),k);
		String [] str = new String[po];
		for(int i=0;i<po;++i)
		str[i] = printAllKLengthRec(input, "", input.length(), k);
		for(int i=0;i<po;++i)
			System.out.println(str[i]);
	}
	public static void main(String args[])
	{
		Scanner sn = new Scanner(System.in);
		String str = sn.next();
		int k = sn.nextInt();
		numberOfStrings(str, k);
	}
}
