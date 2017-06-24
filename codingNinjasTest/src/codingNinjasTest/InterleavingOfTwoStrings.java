package codingNinjasTest;

public class InterleavingOfTwoStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printinter("bc","ef","");
	}
	public static void printinter(String s1, String s2, String outTillNow){
		  if(s1 == null){
		   System.out.println(s2);
		   return;
		                }
		  if(s2 == null){
		   System.out.println(s1);
		   return;
		 }
		  if(s1.length()==0 && s2.length()==0){
		   System.out.println(outTillNow);
		}
		  if(s2.length() != 0){
	  		   printinter(s1, s2.substring(1), outTillNow + s2.charAt(0));
	  }
		  if(s1.length() != 0){
		  		   printinter(s1.substring(1), s2, outTillNow + s1.charAt(0));
		     }
		             }
}
