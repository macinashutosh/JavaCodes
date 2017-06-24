package codingNinjas7;
import java.util.*;
public class NumberOfWords {
	static String answer = "";
	public static void words(int n)
	{
		if(n==0)answer = "zero" + answer;
		else if(n==1)answer = "one " + answer;
		else if(n==2)answer = "two " + answer;
		else if(n==3)answer = "three " + answer;
		else if(n==4)answer = "four " + answer;
		else if(n==5)answer = "five " + answer;
		else if(n==6)answer = "six " + answer;
		else if(n==7)answer = "seven " + answer;
		else if(n==8)answer = "eight " + answer;
		else if(n==9)answer = "nine " + answer;
	}
	public static int toWords(int num)
	{
		if(num==0)return 0;
		int dig = num%10;
		words(dig);
		num = num/10;
		return toWords(num);
		
	}
	public static void main(String args[])
	{	Scanner sn = new Scanner(System.in);
		System.out.print("enter the number:");
		int num = sn.nextInt();
		int a = toWords(num);
		System.out.println(answer);
		sn.close();
	}
}
