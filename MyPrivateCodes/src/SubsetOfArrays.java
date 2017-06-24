import java.util.Scanner;


public class SubsetOfArrays {
	public static int[][] subsets(int input[],int length) {
	     if(length==1)
	        {
	            int str[][] = new int[2][1];
	            str[0] = new int[0];
	            str[1][0] = input[0];
	            return str;
	        }
	        
	        
	        int [][] smallAns = subsets(input,length-1);
	        int [][] ans = new int[smallAns.length*2][];
	        for(int i=0;i<smallAns.length;++i)  //This for loop copies the small Answer
            {   
                ans[i] = smallAns[i];
            }
	        
	        int j;
            for(int i=0;i<smallAns.length;++i)
            {   ans[i+smallAns.length] = new int[smallAns[i].length+1];
                for(j=0;j<smallAns[i].length;++j)
                ans[i+smallAns.length][j] = smallAns[i][j];
                ans[i+smallAns.length][j] = input[length-1];
            }
            
	        return ans;
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a = input();
		print(subsets(a,a.length));
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
}
