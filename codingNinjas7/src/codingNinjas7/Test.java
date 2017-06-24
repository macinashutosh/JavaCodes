package codingNinjas7;
import java.util.*;
public class Test {

//	public static boolean isStringPalindrome(String input) {
//		// Write your code here
//		boolean answer = false ;
//        if(input.length()==1)return true;
//        if(input.length()==2)
//        	{if(input.charAt(0)==input.charAt(1))return true;
//        	else return false;}
//        if(input.charAt(0)==input.charAt(input.length()-1))answer = true;
//        answer = isStringPalindrome(input.substring(1,input.length()-1));
//        return answer;
//	}
//	public static String addStars(String input) {
//		// Write your code here
//        String str = "";
//        if(input.length()==1)return Character.toString(input.charAt(0));
//        str = str + input.charAt(0);
//        if(input.charAt(0)==input.charAt(1)) str = str + "*";
//        str = str + addStars(input.substring(1,input.length()));
//        return str;
//	}
	
//	public static String removeX(String input){
//		// Write your code here
//        String str = "";
//        if(input.length()==1&&input.charAt(0)!='x') return Character.toString(input.charAt(0));
//        if(input.length()==1) return "";
//        if(input.charAt(0)!='x')str = str + input.charAt(0);
//        str = str + removeX(input.substring(1,input.length()));
//        return str;
//	}
//	public static int convertStringToInt(String input){
//		// Write your code here
//    
//    if(input.length()==1) return (input.charAt(0)-'0');
//    int dig = input.charAt(input.length()-1) - '0';
//    int sum =  dig + 10 * convertStringToInt(input.substring(0,input.length()-1));
//    return sum;
//	}
	public static String minLengthWord(String input){
		
		// Write your code here
        int min = Integer.MAX_VALUE;
        String answer = "";
        for(int i=0;i<input.length();i++)
        {   int count = 0;
            String temp = "";
            while(input.charAt(i)!=' ')
            {   
                count ++;
                temp = temp + input.charAt(i);
                i++;
                if(i==input.length())break;
            }
            System.out.print(temp +" " );
            if(count<min){min = count;
            answer = temp;}
        }
        System.out.println();
        return answer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sn = new Scanner(System.in);
		String str = sn.nextLine();
		System.out.println(minLengthWord(str));
		sn.close();
	}

}
