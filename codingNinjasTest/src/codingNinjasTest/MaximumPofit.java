package codingNinjasTest;

import java.util.*;

public class MaximumPofit {
	public static int maximumProfitOfApp(int [] arr)
	{
		int max = 0;
		Arrays.sort(arr);
		for(int i=0;i<arr.length;++i)
		{
			int sum = arr[i] * (arr.length-i);
			if(sum>max)max=sum;
		}
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sn = new Scanner(System.in);
		int n = sn.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;++i)
			arr[i] = sn.nextInt();
		System.out.println(maximumProfitOfApp(arr));
	}

}
