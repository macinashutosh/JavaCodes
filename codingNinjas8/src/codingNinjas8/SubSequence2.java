package codingNinjas8;
import java.util.*;
public class SubSequence2 {//to print keypad operations
	public static String getString(char c)
	{
		String answer = "";
		if(c=='2')answer = "abc";
		else if(c=='3')answer = "def";
		else if(c=='4')answer = "ghi";
		else if(c=='5')answer = "jkl";
		else if(c=='6')answer = "mno";
		else if(c=='7')answer = "pqrs";
		else if(c=='8')answer = "tuv";
		else if(c=='3')answer = "wxyz";
		return answer;
	}
	public static String [] subSequence(String input)
	{	
		if(input.length()==0)
		{	String str[] = new String[1];
			str[0] = input;
			return str;
		}
		
		if(input.length()==1)
		{
			String str = getString(input.charAt(0));
			String s [] = new String[str.length()];
			for(int i=0;i<str.length();++i)
				s[i] = ""+str.charAt(i);
			return s;
		}
		String str = getString(input.charAt(0));
		
		String smallOutput [] = subSequence(input.substring(1));
		String output[] = new String[smallOutput.length*str.length()];
		int k=0;
		for(int i=0;i<str.length();++i)
			for(int j=0;j<smallOutput.length;++j,++k)
				output[k] = ""+str.charAt(i)+smallOutput[j]; 
		return output;
	}
	
	public static void main(String args[])
	{	
		Scanner sn = new Scanner(System.in);
//		String str = sn.next();
//		String output[] = subSequence(str);
//		for(int i=0;i<output.length;++i)
//			System.out.println(output[i]);
		int n = sn.nextInt();
		String input = "";
		while(n!=0)
        {
            input = n%10 + input;
            n = n/10;
        }
		System.out.println(input);
		sn.close();
	}
}
