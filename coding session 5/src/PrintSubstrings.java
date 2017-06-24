import java.util.*;
public class PrintSubstrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sn = new Scanner(System.in);
		String str = sn.next();
		int size = str.length();
		System.out.println("");
		for(int i=0;i<size;++i)
		{	for(int j=i+1;j<=size;++j)
			System.out.println(str.substring(i,j));
		}
	}

}
