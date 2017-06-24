import java.util.*;
public class HackerRank {
	//encryption question
	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        String s = in.next();
	        s.trim();
	        int L = s.length();
	        double l = Math.sqrt(L);
	        int numberOfRows  = (int)l;
	        int numberOfCols = (int)Math.ceil(l);
	       
	        int index = 0;
	        String str[] = new String[numberOfRows];
	        int sn;
	        for(int i=0;index<L;++i)
	            {   sn = index+numberOfCols;
	                if(index+numberOfCols>L)
	                sn = L; 
	                str[i] = s.substring(index,sn);
	                index = index + numberOfCols;
	                
	        }
	        String answer = "";
	        
	        for(int i=0;i<str[0].length();++i)
	        {   int k = i;
	        	for(int j=0;j<str.length;++j) 
	            {if(j<str[i].length())
	                answer = answer + str[i].charAt(j);
	            }
	            answer = answer + " ";
	        }
	        answer = answer.substring(0,answer.length()-1);
	        System.out.println(answer);
	        in.close();
	    }
	
	
}
