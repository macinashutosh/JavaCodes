import java.util.*;
public class MergeToSortchallenge {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size1,size2;
		Scanner sn = new Scanner(System.in);
		System.out.print("enter the size of array1:");
		size1 = sn.nextInt();
		
		int [] arr1 = new int[size1];
		
		System.out.println("enter array1:");
		for(int i=0;i<size1;++i)
			arr1[i] = sn.nextInt();
		
		System.out.print("enter the size of array2:");
		size2 = sn.nextInt();
		int [] arr2 = new int[size2];
		System.out.println("enter array2:");
		for(int i=0;i<size2;++i)
			arr2[i] = sn.nextInt();
		getMaxSum(arr1,arr2);
	}
	
	//to find the intersection point
	
	//to get the maximum sum
	public static void getMaxSum(int arr1[],int arr2[])
	{	
		int majorSum = 0,sum1 = 0,sum2 = 0;
		int i=0,j=0;
		while(i<arr1.length&&j<arr2.length)
		{
			if(arr1[i]<arr2[j]){
				sum1  = sum1 + arr1[i];
				i++;
			}
			else if(arr1[i]>arr2[j]){
				sum2 = sum2 + arr2[j];
				j++;
			}
			else{int max;
				if(sum1>sum2)max=sum1;
				else max = sum2;
				majorSum = majorSum + max + arr1[i];
				sum1 = sum2 = 0;
				i++;
				j++;
			}
		}
		
		while(i<arr1.length)sum1 = sum1 + arr1[i++];
		while(j<arr2.length)sum2 = sum2 + arr2[j++];
		int max;
		if(sum1>sum2)max = sum1;
		else max =sum2;
		majorSum = majorSum+max;
		System.out.println("Maximum sum:" + majorSum);
	}
}
