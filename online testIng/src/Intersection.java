package online testing;
import java.util.*;
public class Intersection{	
	//arr1 and arr2 are the arrays of which you need to print the intersection
	public static void intersection(int[] arr1, int[] arr2){
		//write your code here
		int size1 = arr1.length;
		int size2 = arr2.length;
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		int index,countIn1=0,countIn2,count;
		for(int i=0;i<size1;)
		{
		    index = Arrays.binarySearch(arr2,arr1[i]);
		    if(index==-1)i++;
		    else{countIn1=0;
		        countIn2=0;
		        for(int j=0;arr1[j]==arr1[i];j++)
		        countIn1++;
		        for(int j=index;arr2[j]==arr2[index];j++)
		        countIn2++;
		        if(countIn1>countIn2)count=countIn2;
		        else count=countIn1;
		        for(int j=0;j<count;++j)
		        System.out.println(arr1[i]);
		        i=i+countIn1;
		    }
		}
	}
	public static int[] input()
	{
	    Scanner sn = new Scanner(System.in);
	    int size = sn.nextInt();
	    int []array = new int[size];
	    for(int i=0;i<size;++i)
	    array[i] = sn.nextInt();
	    return array;
	}
	public static void main(String args[])
	{
	    intersection(input(),input());
	}
}
