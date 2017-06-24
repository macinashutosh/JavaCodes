package codingNinjas22;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Scanner sn = new Scanner(System.in);
		//System.out.println(maxFreqWord(sn.nextLine()));
		//int [] arr1 = {1,2,2,3,4,0,-1,-2};
		int[] arr1 = {2, 2, -2, -2};
//		int [] arr2 = {2,1,10,6,-1,-2};
//		printIntersectionOfTwoArrays(arr1, arr2);
		printPairsWhichSumToZero(arr1);
	}
	
	public static String maxFreqWord(String input)
	{
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int currentWordStart = 0;
		int maxFreq = 0;
		String maxWord = "";
		for(int i=0;i<input.length();++i)
		{
			if(input.charAt(i)==' '){
				String currentWord = input.substring(currentWordStart, i);
				int currFreq = 0;
				if(map.containsKey(currentWord))
				{
					currFreq = map.get(currentWord);
				}
				map.put(currentWord, currFreq + 1);
				if(maxFreq<currFreq+1)
				{
					maxFreq = currFreq+1;
					maxWord = currentWord;
				}
				currentWordStart = i+1;
			}
			
		}
		return maxWord;
	}
	
	public static void printIntersectionOfTwoArrays(int[] arr1,int [] arr2){
		HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
		for(int i=0;i<arr1.length;++i)
		{	
			map1.put(arr1[i],1);
		}
		for(int i=0;i<arr2.length;++i)
		{
			if(map1.containsKey(arr2[i]))
				System.out.print(arr2[i]+" ");
		}
	}

	public static void printPairsWhichSumToZero(int [] arr)
	{
		HashMap<Integer, Integer> map =  new HashMap<Integer, Integer>();
		for(int i = 0;i<arr.length;++i)
		{	int currfreq = 0;
			if(map.containsKey(arr[i]))
				currfreq = map.get(arr[i]);
			
			map.put(arr[i],currfreq+1);
			if(map.containsKey(-1*arr[i])&&arr[i]!=0)
			{for(int j=0;j<map.get(arr[i])*map.get(-1*arr[i]);j++) 
			 System.out.println(Math.min(arr[i],-1*arr[i])+" "+Math.max(arr[i],-1*arr[i]));
			map.put(arr[i], map.get(arr[i])-1);
			}
		}
		
	}
	
	
	
}
