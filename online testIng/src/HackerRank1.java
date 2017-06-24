import java.util.Scanner;


public class HackerRank1 {

	 public static int NumberOfWays(int X,int N,int number)
	    {
	        if(X==0)return 1;
	        if(X<0)return 0;
	        int smallAnswer = 0;
	        smallAnswer =  NumberOfWays(X-(int)Math.pow(number,N),N,number+1);
	        if(X-(int)Math.pow(number,N)==0)smallAnswer++;
	        return smallAnswer;
	    }
	    public static void main(String[] args) {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	        Scanner sn = new Scanner(System.in);
	        int X = sn.nextInt();
	        int N = sn.nextInt();
	        System.out.print(NumberOfWays(X,N,1));
	    }
	
}
