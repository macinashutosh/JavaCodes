package codingNinjas11;

import java.util.Scanner;

public class PrintSubsetSumK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sn =new Scanner(System.in);
		int size  = sn.nextInt();
		int input[] = new int[size];
		for(int i=0;i<size;++i)
			input[i] = sn.nextInt();
		int inputSum = sn.nextInt();
		int ans [][] = subsetsSumK(input, inputSum);
		for(int i=0;i<ans.length;++i)
		{	System.out.println();
			for(int j=0;j<ans[i].length;++j)
				System.out.print(ans[i][j]+" ");
		}
		}
	public static int[][] subsetsSumK(int input[], int inputSum) {
		// Write your code here
    int [][]temp = subsetsHelper(input,input.length);
    int count = 0;
    for(int k=0;k<temp.length;++k)
    {int sum = 0;
        for(int l = 0;l<temp[k].length;++l)
        {
        sum += temp[k][l];
        }
        if(sum==inputSum)count++;
    }
    int [][] ans = new int[count][];
    int i = 0;
    for(int k=0;k<temp.length;++k)
    {int sum = 0;
        for(int l = 0;l<temp[k].length;++l)
        {
        sum += temp[k][l];
        }
        if(sum==inputSum){ans[i] = new int[temp[k].length];
        	              ans[i] =  temp[k];
                          i++;
            }
        }
    return ans;
	}
		public static int[][] subsetsHelper(int input[],int length) {
	     if(length==1)
	        {
	            int str[][] = new int[2][1];
	            str[0] = new int[0];
	            str[1][0] = input[0];
	            return str;
	        }
	        
	        
	        int [][] smallAns = subsetsHelper(input,length-1);
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

}
