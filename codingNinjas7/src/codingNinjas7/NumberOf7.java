package codingNinjas7;
import java.util.*;
public class NumberOf7 {
//	public static int numberOf7(int arr[],int n)
//	{
//		int count = 0;
//		if(n==1){
//			if(arr[0]==7)return 1;
//			else return 0;
//		}
//		if(arr[n-1]==7)count++;
//		count = count + numberOf7(arr,n-1);
//		return count;
//	}
	public static String indexOf7(int arr[],int n)
	{	
		if(n==1)
		{
			if(arr[0]==7){	
				
				return "0 ";
			}
			else{
				
				return "";
			}
		}
		String answer = "";
		if(arr[n-1]==7)answer = answer + Integer.toString(n-1) + " ";
		answer = answer + indexOf7(arr, n-1);
		return answer;
	}
	public static void main(String args[])
	{Scanner s = new Scanner(System.in);
	 int size = s.nextInt();
	 int [] arr = new int[size];
	 System.out.print("enter array:");
	 for(int  i=0;i<size;++i)
		 arr[i] = s.nextInt();
	 String str = indexOf7(arr, size);
	 
	}
}
