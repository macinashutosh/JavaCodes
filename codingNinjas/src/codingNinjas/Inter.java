package codingNinjas;
import java.util.*;
public class Inter {
	public static void intersection(int[] arr1, int[] arr2){
		//write your code here
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		int size = 0;
		
		if(arr1.length>arr2.length)size = arr1.length;
		else size = arr2.length;
		
		int [] repeatValue = new int[size];
		int k=0;
		for(int i=0;i<arr1.length;++i)
		{
		    int valueToCheck = arr1[i];
		    int first=0,last=arr2.length-1,mid=0,position=-1;
		    while(first<last&&position==-1)
		    {
		        mid = (first+last)/2;
		        if(arr2[mid]==valueToCheck)position=mid;
		        else if(arr2[mid]<valueToCheck)last = mid-1;
		        else first = mid+1;
		    }
		    first =0;
		    last = k-1;
		    mid = 0;
		    boolean valueIsRepeating = false;
		    while(first<last)
		    {
		        mid = (first+last)/2;
		        if(arr2[position]==repeatValue[mid])
		        {valueIsRepeating = true;
		            break;
		        }
		        else if(arr2[position]<repeatValue[mid])last = mid-1;
		        else first = mid+1;
		    }
		    if(valueIsRepeating==false)
		    {
		        repeatValue[k]=arr2[position];
		        k++;
		        System.out.println(arr2[position]);
		    }
		}
		
	}
	public static int[] input()
	{
	    int size;
	    Scanner sn  = new Scanner(System.in);
	    size = sn.nextInt();
	    int []array = new int[size];
	    for(int i=0;i<size;++i)
	    array[i] = sn.nextInt();
	    return array;
	}
	
	public static void main(String [] args)
	{
	    intersection(input(),input());
	}

}
