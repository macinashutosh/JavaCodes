
import java.util.*;
public class FactorialOfLargeNumbers {
	public static int maximum(int a,int b)
	{   int max=0;
	    if(a>b)max=a;
	    else max=b;
	    return (max);
	}
	public static String sumOfTwoArrays(String arr1, String arr2){
		//write your code here
	   	int size = maximum(arr1.length(),arr2.length())+1;
	   	String result = "";
	   	int i,j,k;
	   	int carry=0;
	   	for(i=arr1.length()-1,j=arr2.length()-1,k=size-1;i>=0&&j>=0&&k>=0;j--,k--,i--)
	   	{	int a = (arr1.charAt(i) - '0');
	   		int b = (arr2.charAt(j) - '0');
	   	    int digit = (a+b+carry)%10;
	   	    carry = (a+b+carry)/10;
	   	    result = digit+result;
	   	}
	   	result = carry+result;
	   	while(i>=0)
	   	{
	   	    result=arr1.charAt(i)+result;
	   	    k--;
	   	    i--;
	   	}
	   	while(j>=0)
	   	{
	   	    result=arr2.charAt(j)+result;
	   	    k--;
	   	    j--;
	   	}
	   	return result;
	}

	public static String multiplicationOfTwoStrings(String str1,String str2)
	{
		String answer = "0";
		String temp[] = new String[str2.length()];
		
		for(int i=str2.length()-1;i>=0;--i)
			{	
				temp[i] = "";
				int carry = 0;
				int dig = 0;
				for(int j=str1.length()-1;j>=0;--j)
				{	int a = (str1.charAt(j)-'0');
					int b = (str2.charAt(i)-'0');
					int k = a*b;
					dig = k%10;
					temp[i] = Integer.toString(carry + dig) + temp[i];
					carry = k/10;
				}
			}
		for(int i=temp.length-1;i>=0;--i)
			for(int j=0;j<i;++j)
				temp[i] = temp[i] + "0";
		for(int i=temp.length-1;i>=0;--i)
		{	if(temp[i].length()>answer.length())
			while(answer.length()!=temp[i].length())
			answer = "0"+answer;
			if(temp[i].length()<answer.length())
				while(answer.length()!=temp[i].length())
					temp[i] = "0"+temp[i];	
			answer = sumOfTwoArrays(answer, temp[i]);
		}
		return answer;
	}
	public static String factorial(int input)
	{
		String answer = "1";
		for(int i=2;i<=input;++i)
			answer = multiplicationOfTwoStrings(answer,""+i);
		return answer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sn = new Scanner(System.in);
		int input = sn.nextInt();
		String answer = factorial(input);
		int i=0;
		while(answer.charAt(i)=='0'&&i<answer.length())
			i++;
		System.out.println(answer.substring(i));
		sn.close();
	}

}
