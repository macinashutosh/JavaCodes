package codingninjas6;

import java.util.Scanner;

public class ReverseOfAString {
	public static String reverseOfString(String input)
	{
		String output="";
		for(int i=input.length()-1;i>=0;--i)
		{
			output = output + input.charAt(i);
		}
		return output;
	}
	public static void reverseEachWord(String input)
	{	int beg = 0;
		for(int i=0;i<input.length();++i)
		{
			if(input.charAt(i)==' '||i==input.length()-1)
			{	if(i==input.length()-1)System.out.print(" ");
				System.out.print(reverseOfString(input.substring(beg,i+1)));
				
				beg = i+1;
			}
		}
		System.out.println();
	}
	public static void reverseALine(String input)
	{	int end = input.length();
		for(int i=input.length()-1;i>=0;--i)
		{
			if(input.charAt(i)==' '||i==0)
			{	if(i==0)System.out.print(" ");
				System.out.print(input.substring(i, end));
				end = i;
			}
		}
	}
	public static void maximumOccurence(String input)
	{
		int arr [] = new int[input.length()];
		for(int i=0;i<arr.length;++i)
		{
			arr[i] = input.charAt(i);
		}
		for(int i=0;i<arr.length;++i)
		{
			System.out.print(arr[i]+ " ");
		}
	}
	public static  void main(String args[])
	{
		Scanner sn = new Scanner(System.in);
		String str = sn.nextLine();
		//String output = reverseOfString(str);
		//System.out.println(output);
		//String str2 = sn.nextLine();
		//reverseEachWord(str);
		//reverseALine(str);
		maximumOccurence(str);	
	}
}
