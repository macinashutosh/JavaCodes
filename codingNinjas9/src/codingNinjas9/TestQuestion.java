package codingNinjas9;
import java.util.*;
public class TestQuestion {
	
	public static void subSequence(String input,int len,String outputSoFar)
	{	
		if(len==1)
		{	for(int i=0;i<input.length();++i)
			System.out.println(outputSoFar+input.charAt(i));
			return;
		}
		for(int i=0;i<input.length();++i)
		subSequence(input,len-1,input.charAt(i)+"");
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sn = new Scanner(System.in);
		String k = sn.next();
		int len = sn.nextInt();
		subSequence(k, len,"");
		sn.close();

	}

}
