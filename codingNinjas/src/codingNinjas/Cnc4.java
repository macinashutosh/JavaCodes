package codingNinjas;

public class Cnc4 {
	public static void incrementArr(int a[])
	{
		 a = new int[2];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int s[] = new int[2];
		s[0]=10;
		incrementArr(s);//address is send by the compiler while function call
		System.out.print(s[0]);
	}

}
