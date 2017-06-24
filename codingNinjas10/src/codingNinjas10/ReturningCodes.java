package codingNinjas10;

import java.util.Scanner;

public class ReturningCodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sn = new Scanner(System.in);
		String input = sn.next();
		String output[] = getCode(input);
		for(int i=0;i<output.length;++i)
		{
			System.out.println(output[i]);
		}
	}

	     public static String code(String ch)
		    {	String str = "";
		        if(ch.equals("1"))str = "a";
		        else if(ch.equals("2"))str = "b";
		        else if(ch.equals("3"))str = "c";
		        else if(ch.equals("4"))str = "d";
		        else if(ch.equals("5"))str = "e";
		        else if(ch.equals("6"))str = "f";
		        else if(ch.equals("7"))str = "g";
		        else if(ch.equals("8"))str = "h";
		        else if(ch.equals("9"))str = "i";
		        else if(ch.equals("10"))str = "j";
		        else if(ch.equals("11"))str = "k";
		        else if(ch.equals("12"))str = "l";
		        else if(ch.equals("13"))str = "m";
		        else if(ch.equals("14"))str = "n";
		        else if(ch.equals("15"))str = "o";
		        else if(ch.equals("16"))str = "p";
		        else if(ch.equals("17"))str = "q";
		        else if(ch.equals("18"))str = "r";
		        else if(ch.equals("19"))str = "s";
		        else if(ch.equals("20"))str = "t";
		        else if(ch.equals("21"))str = "u";
		        else if(ch.equals("22"))str = "v";
		        else if(ch.equals("23"))str = "w";
		        else if(ch.equals("24"))str = "x";
		        else if(ch.equals("25"))str = "y";
		        else if(ch.equals("26"))str = "z";
		        
		        return str;
		    }
		// Return a string array that contains all possible codes
		public static  String[] getCode(String input)
		{   String smallOutput[] = getCodeHelper(input);
		    if(input.length()<=1)return smallOutput;
		    String codes = code(input.substring(0,2));
		    if(!codes.equals(""))
		    {   int count=0;
		        int i;
		        for(i=0;i<smallOutput.length;++i)
		        {
		            if(smallOutput[i].substring(0,2).equals(code(input.substring(0,1))+code(input.substring(1,2))))
		            {count++;
		            }
		        }
		        String output[] = new String [smallOutput.length + count];
		        int j = 0;
		        for(i=0;i<smallOutput.length;++i,j++)
		        {
		            output[j] = smallOutput[i];
		        }
		        for(i=0;i<smallOutput.length;++i)
		        {
		             if(smallOutput[i].substring(0,2).equals(code(input.substring(0,1))+code(input.substring(1,2))))
		            {output[j] = codes + smallOutput[i].substring(2);
		             j++;
		            }
		        }
		        return output;
		    }
		    else
		    {
		        return smallOutput;
		    }
		}
		public static  String[] getCodeHelper(String input){
			// Write your code here
			
			 if(input.length()==0)
			{
			    String s [] =new String[0];
			    return s;
			}
			if(input.length()==1)
			{
			    String s[] = new String[1];
			    s[0] = code(input);
			    return s;
			}
//	 		if(input.length()==2)
//	 		{   String codes = code(input);
//	 		    if(!codes.equals(""))
//	 		    {String s[] = new String[1];
//	 		     s[0] = codes;
//	 		     return s;
//	 		    }
//	 		    else {String s[] = new String[0];
//	         		  return s;
//	 		    }
//	         }
			String smallOutput[] = getCodeHelper(input.substring(0,input.length()-1));
			String code1 = code(input.substring(input.length()-1));
			String smallOutput2[] = new String[0];
			String code2 = code(input.substring(input.length()-2));
			if(!code2.equals(""))
			{   smallOutput2 =  getCodeHelper(input.substring(0,input.length()-2));
			  //  smallOutput2 = new String[s.length];
			  //  smallOutput2 =s;
			  //  System.out.println(code2);
			}
		
			String output[] = new String[smallOutput2.length+smallOutput.length];
			int count = 0;
			for(int i=0;i<smallOutput.length;++i,count++)
			output[count] = smallOutput[i] + code1;
			for(int i=0;i<smallOutput2.length;++i,count++)
			output[count] = smallOutput2[i] + code2;
			return output;
		}

	}

