package codingNinjas;
import java.util.*;

public class Reverse {

	public static void printReverse(int a[],int size)
	{	if(a.length==0)System.out.println("empty Array");
		else{
			int initial = size-1;
			for(;initial>=0;initial--)
				System.out.print(a[initial]);
			System.out.println();
		}
	}
	public static void printSum(int a[],int size)
	{
		int sum=0;
		for(int i=0;i<size;++i)
			sum = sum+a[i];
		System.out.println("sum:"+sum);
		
	}
	public static void makeReverse(int a[],int size)
	{	int temp;
		for(int i=0;i<(size+1)/2;++i)
		{
			temp = a[i];
			a[i]=a[size-i-1];
			a[size-i-1]=temp;
		}
		System.out.println("reversed array:");
		for(int i=0;i<size;++i)
			System.out.print(a[i]);
	}
	public static void linearSearch(int a[],int size)
	{
		System.out.println("enter the element to be searched:");
		Scanner sn = new Scanner(System.in);
		int element = sn.nextInt();
		int position=-1;
		for(int i=0;i<size;++i)
			if(a[i]==element){
				position = i+1;
				break;
			}
		System.out.println("position:"+position);
	}
	
	public static void selectionSort(int a[],int size)
	{
		for(int i=0;i<size;++i)
		{ int minimum = a[i];
		int pos = i;
			
			for(int j=i;j<size;++j)
			{
				if(a[j]<minimum)
				{
					minimum = a[j];
					pos = j;
				}
			}
			int temp = a[i];
			a[i] = minimum;
			a[pos] = temp;
		}
		System.out.println("sorted:");
		for(int i=0;i<size;++i)
			System.out.print(a[i]+" ");
	}
	
	public static void binarySearch(int a[],int size)
	{
		int first=0,last=size-1,mid=(first+last)/2;
		System.out.print("enter element to be searched:");
		Scanner sn = new Scanner(System.in);
		int element = sn.nextInt();
		int flag=0;
		while(first<last)
		{ mid = (first+last)/2;
			if(a[mid]==element)
			{
				flag = 1;
				break;
			}
			else if(element >a[mid])
				first = mid+1;
			else last = mid-1;
		}
		if(flag==1)System.out.println("element present:"+(mid+1));
		else System.out.println("element not present");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sn = new Scanner(System.in);
		System.out.print("enter the size :");
		int size  = sn.nextInt();
		int a[] = new int[10];
		System.out.print("enter the Array:");
		for(int i=0;i<size;++i)
			a[i] = sn.nextInt();
		printReverse(a,size);
		printSum(a,size);
		linearSearch(a,size);
		selectionSort(a,size);
		binarySearch(a,size);
		//makeReverse(a,size);
	}

}
