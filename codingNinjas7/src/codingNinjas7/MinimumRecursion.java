package codingNinjas7;
import java.util.*;
public class MinimumRecursion {
	public static int minimumInArray(int [] arr,int size)
	{
		if(size==1)return arr[0];
		int minimum = arr[size-1];
		int minimum2 = minimumInArray(arr,size-1);
		if(minimum>minimum2)return minimum2;
		else return minimum;
			
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sn = new Scanner(System.in);
		System.out.print("enter size:");
		int size = sn.nextInt();
		System.out.println("enter array:");
		int [] arr = new int[size];
		for(int i=0;i<size;++i)
			arr[i] = sn.nextInt();
		System.out.println("minimum:"+minimumInArray(arr,size));
		
	}

}
