
package codingNinjas7;
import java.util.*;
public class Recursion {
	public static int power(int x,int n)
	{
		if(n==0)return 1;
		else return x*power(x,n-1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sn = new Scanner(System.in);
		System.out.println("enter the number:");
		int x = sn.nextInt();
		System.out.println("enter the power:");
		int n = sn.nextInt();
		System.out.println("answer:" + power(x,n));
		
	}

}
