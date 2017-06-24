package codingNinjas11;

public class PrintSubset {
	
	public static void printSubsets(int input[]) {
		// Write your code here
        printSubsetsHelper(input,input.length);
	}
	public static void printSubsetsHelper(int input[],int length)
	{
	    if(length==0)
	    {
	        System.out.print("");
	        return;
	    }
	    if(length==1)
	    {
	        System.out.print(input[0]);
	        return ;
	    }
	    System.out.print(" "+input[length-1]);
	    printSubsetsHelper(input,length-1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
