package codingNinjas8;
import java.util.*;
public class SubSeq {
	public static int power(int number)
	{	int sum = 1;
		for(int i=0;i<number;++i)
			sum = sum * 2;
		return sum;
	}
	public static String [] subSequence(String input)
	{	
		if(input.length()==0)
		{	String str[] = new String[1];
			str[0] = input;
			return str;
		}
		
		String smallOutput[] = subSequence(input.substring(1));
		String output[] = new String[smallOutput.length*2];
		for(int i=0;i<smallOutput.length;++i)
			output[i] = smallOutput[i];
		for(int i=0;i<smallOutput.length;++i)
			output[smallOutput.length+i] = input.charAt(0) + smallOutput[i];
		
		return output;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sn = new Scanner(System.in);
		String str = sn.next();
		String answer []= subSequence(str);
		for(int i=0;i<answer.length;++i)
			System.out.println(answer[i]);
		sn.close();
	}

}
