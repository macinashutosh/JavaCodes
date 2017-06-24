package codingNinjas8;
import java.util.*;

public class MergeSort {
	public static int [] mergeToSort(int a[],int b[])
	{	int i=0,j=0;
		int sizeA = a.length;
		int sizeB = b.length;
		int c[] = new int[sizeA+sizeB];
		int k=0;
		while(i<sizeA&&j<sizeB)
		{
			if(a[i]<b[j])
			{
				c[k]=a[i];
				i++;
				k++;
			}
			else{
				c[k]=b[j];
				j++;
				k++;
			}
		}
		while(i<sizeA)
		{
			c[k] = a[i];
			i++;
			k++;
		}
		while(i<sizeA)
		{
			c[k] = b[j];
			j++;
			k++;
		}
		return c;
}
	
	
	public static void mergeSort(int input[])
{	if(input.length==0)
	return;
	if(input.length==1)
	{	int [] arr = new int[0];
		mergeToSort(arr,input);
		return ;
	}
	int mid  = (input.length+1)/2;
	int b [] = new int[mid];
	int c [] = new int[input.length-mid];
	for(int i=0;i<mid;++i)
	{	b[i] = input[i];
	}
	
	for(int i=0;i<input.length-mid;++i)
	{	c[i] = input[mid+i];
	}  
	mergeSort(b);
	mergeSort(c);
	input = mergeToSort(b,c);
	for(int i=0;i<input.length;++i)
		System.out.print(input[i]+" ");
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sn = new Scanner(System.in);
		int size = sn.nextInt();
		int arr[] = new int[size];
		for(int i=0;i<size;++i)
			arr[i] = sn.nextInt();
		mergeSort(arr);
		sn.close();
	}

}
