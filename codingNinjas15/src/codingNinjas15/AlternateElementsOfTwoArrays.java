package codingNinjas15;

import java.util.ArrayList;
import java.util.Scanner;

public class AlternateElementsOfTwoArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sn = new Scanner(System.in);
		int sizeA = sn.nextInt();
		
		int a[] = new int [sizeA];
		
		for(int i=0;i<sizeA;++i)
			a[i] = sn.nextInt();
		int sizeB = sn.nextInt();
		int b[] = new int [sizeB];
		for(int i=0;i<sizeB;++i)
			b[i] = sn.nextInt();
		
		ArrayList<Integer> s = new ArrayList<Integer>();
		printArraySortedPattern(a, b, 0, 0,s,0);//TODO complete the function 
		int numberofSolutions = countNumberOfPatterns(a,b);
		System.out.println(numberofSolutions);
	}
	public static void print(int a[],int element)
	{
		for(int i=0;i<a.length;++i)
		{	if(a[i]>element)
			System.out.println(element+" "+a[i]);
		}
	}
	public static void printArraySortedPattern(int a[],int b[],int startA,int startB,ArrayList<Integer> output,int lastElementArray)
	{
		if(startA==a.length-1)
		{
			System.out.println(a[startA]);
			print(b,a[startA]);
			return;
		}
	}
	public static int countNumberOfPatterns(int a[] ,int b[])
	{	int empty=1,sola=0,solb=0;
		int i=0,j=0;
		while(i<a.length&&j<b.length)
		{
			if(a[i]<b[j]){
				sola = sola+empty+solb;
				i++;
			}else{
				solb = sola+empty+solb;
				j++;
			}
		}
		while(i<a.length)
		{
			sola = sola+empty+solb;
			i++;
		}
		while(j<b.length)
		{
			solb = sola+empty+solb;
			j++;
		}
		int solutions = sola+solb+empty;
		return solutions;
	}
}
