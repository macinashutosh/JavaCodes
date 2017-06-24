
package codingNinjas;
import java.util.*;
public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sn = new Scanner(System.in);
		int a[] = new int[10];
		int b[] = new int[10];
		int c[] = new int[20];
		System.out.println("enter the size:");
		int sizeA = sn.nextInt();
		System.out.print("enter array 1:");
		for(int i=0;i<sizeA;++i)
			a[i] = sn.nextInt();
		System.out.println("enter the size:");
		int sizeB = sn.nextInt();
		System.out.print("enter array 2:");
		for(int i=0;i<sizeB;++i)
			b[i] = sn.nextInt();
		int i =0,j=0,k=0;
		while(i<sizeA&&j<sizeB)
		{
			if(a[i]<b[j])
			{
				c[k]=a[i];
				i++;
				k++;
			}
			else{
				c[k]=b[j];
				j++;
				k++;
			}
		}
		while(i<sizeA)
		{
			c[k] = a[i];
			i++;
			k++;
		}
		while(i<sizeA)
		{
			c[k] = b[j];
			j++;
			k++;
		}
		for(int m=0;m<k;++m)
			System.out.print(c[m]);
	}

}
