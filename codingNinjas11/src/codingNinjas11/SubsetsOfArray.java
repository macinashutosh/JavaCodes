package codingNinjas11;
import java.util.*;
public class SubsetsOfArray {
	
	public static void main(String[] args) {
		print(subset(input()));
	}
	public static int[] input(){
		Scanner s=new Scanner(System.in);
		System.out.println("enter n");
		int n =s.nextInt();
		int a[] =new int[n];
		for(int i=0;i<n;i++){
			a[i]=s.nextInt();
		}
		return a;
	}
	public static void print(int a[][])
	{
		for(int i = 0; i <a.length; i++)
		{
			for(int j = 0; j <a[i].length; j++)
			{
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static int[][] subsets(int input[]) {
		// Write your code here
		if(input.length==1)
		{
			int [][]str= new int[2][];
			str[0] = new int[0];
			str[1] = input;
			return str;
		}
		int []a=new int[input.length-1];
		for(int i=0;i<input.length-1;i++){
			a[i]=input[i];	
		}
		int [][]sans=subsets(a);
		int [][]ans=new int[sans.length*2][];
		for(int i=0;i<sans.length;i++){
			ans[i] = new int[sans[i].length];
			for(int j=0;j<sans[i].length;j++){
				ans[i][j]=sans[i][j];
			}
		}
		int j;
		for(int i=0;i<sans.length;i++){
			ans[i+sans.length] = new int[sans[i].length+1];
			for( j=0;j<sans[i].length;j++)
				ans[i+sans.length][j]=sans[i][j];		
			ans[i+sans.length][j]=input[input.length-1];
		}
		return ans;

	}
	
	public static int[][] subset(int input[]) {
		// Write your code here
	 if(input.length==1)
        {
            int str[][] = new int[2][];
            str[0] = new int[0];
            str[1] = input;
            return str;
        }
        int newInput[] = new int[input.length-1];
        for(int i=0;i<input.length-1;++i)
        newInput[i] = input[i];
        int smallAns [][] = subset(newInput);
        int ans [][] = new int[smallAns.length*2][];
        
            for(int i=0;i<smallAns.length;++i)  //This for loop copies the small Answer
            {   ans[i] = new int [smallAns[i].length];
               // for(int j=0;j<smallAns[i].length;++j)
                ans[i] = smallAns[i];
            }
            
            int j;
            for(int i=0;i<smallAns.length;++i)
            {   ans[i+smallAns.length] = new int[smallAns[i].length+1];
                for(j=0;j<smallAns[i].length;++j)
                ans[i+smallAns.length][j] = smallAns[i][j];
                ans[i+smallAns.length][j] = input[input.length-1];
            }
            return ans;
	}
	
}
