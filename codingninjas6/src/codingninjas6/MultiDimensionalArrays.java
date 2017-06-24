package codingninjas6;
import java.util.*;
public class MultiDimensionalArrays {
	public static int[][] takeInput()
	{
		Scanner sn = new Scanner(System.in);
		int m = sn.nextInt();
		int n = sn.nextInt();
		int arr[][] = new int[m][n];
		for(int i=0;i<m;++i)
			for(int j=0;j<n;++j)
				arr[i][j] = sn.nextInt();
		return arr;
	}
	public static void  printWaveForm(int arr[][])
	{	int n = arr[0].length;
		System.out.println("WaveForm:");
		for(int j=0;j<n;++j)
		{
			if(j%2==0)
			{
				for(int i=0;i<arr.length;++i)
					System.out.print(arr[i][j]+" ");
			}
			else
			{
				for(int i=0;i<arr.length;++i)
					System.out.print(arr[arr.length-1-i][j]+" ");
			}
		}
		System.out.println();
	}
	public static void printSpiralForm(int arr[][])
	{
		System.out.println("Spiral Form:");
		boolean right=true;
		boolean down = false;
		boolean left = false;
		boolean up = false;
		int rowEnd = arr.length;
		int colEnd = arr[0].length;
		int rowStart = 0;
		int colStart = 0;
		for(int count = 0;count<arr.length*arr[0].length;)
		{	
			if(right){right = false;
					  down = true;	
					  int i = rowStart;
					for(int j=colStart;j<colEnd;++j)
						{System.out.print(arr[i][j]+ " ");
						count++;}
				colEnd--;
				rowStart++;
			}
			if(down){
				down = false;
				left = true;
				int j = colEnd;
				for(int i=rowStart;i<rowEnd;++i,count++)
					System.out.print(arr[i][j]+ " ");
				rowEnd--;
				colStart++;
			}
			if(left){left = false;
				up = true;
				int i = rowEnd;
				for(int j=colEnd;j>=colStart;j--,count++)
					System.out.print(arr[i][j]+ " ");
				colStart++;
				}
			if(up){up=false;
				right = true;
				int j = colStart;
				for(int i=rowEnd;i>=rowStart;i++,count++)
					System.out.print(arr[i][j]);
				rowStart++;
			}
			
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = takeInput();
		//printWaveForm(arr);
		printSpiralForm(arr);
	}

}
