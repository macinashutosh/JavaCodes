package codingNinjas;
import java.util.*;
public class Test {

	public static int maximum(int a,int b)
	{   int max=0;
	    if(a>b)max=a;
	    else return max=b;
	    return (max);
	}
	public static int[] sumOfTwoArrays(int[] arr1, int[] arr2){
		//write your code here
	   	int size = maximum(arr1.length,arr2.length)+1;
	   	int [] result = new int[size];
	   	
	   	
	    int i=arr1.length-1,j=arr2.length,k=size-1;
	    for(;i>=0&&j>=0;i--,--j,--k)
	    {   int digit=0,carry=0;
	        int sum = arr1[i]+arr2[j];
	        if(sum>=10)
	        {
	            digit = sum%10;
	            carry = sum/10;
	        }
	        else
	        {
	            carry=0;
	            digit = sum%10;
	        }
	        result[k] = result[k]+digit;
	        if(result[k]>=10){carry = carry + result[k]/10;
	            result[k] = result[k]%10;
	        }
	        
	        result[k-1] = result[k-1]+carry;
	    }
	    
	   	
	   	return result;
	}
	public static void print(int[] arr)
	{
		int size = arr.length;
		for(int i=0;i<size;++i)
			System.out.print(arr[i]);
	}
	public static void main(String args[])
	{
		Scanner sn = new Scanner(System.in);
		int size1 = sn.nextInt();
		int [] arr1 = new int[size1];
		for(int i=0;i<size1;++i)
			arr1[i] = sn.nextInt();
		int size2 = sn.nextInt();
		int [] arr2 = new int[size2];
		for(int i=0;i<size2;++i)
			arr2[i] = sn.nextInt();
		print(sumOfTwoArrays(arr1,arr2));
	}

}
