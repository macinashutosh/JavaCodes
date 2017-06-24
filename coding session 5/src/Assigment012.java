import java.util.*;
public class Assigment012 {

	public static void sort012(int arr[]){
		int i=0,j=0,k=arr.length-1;
		while(j<k)
		{
			if(arr[j]==0)
			{	
				int temp = arr[i];
				arr[i]=arr[j];
				arr[j] = temp;
				i++;
				j++;
			}
			else if(arr[j]==2)
			{	
				int temp =arr[j];
				arr[j]=arr[k];
				arr[k]=temp; 
				k--;
			}
			else{j++;
			}
		
		}
		for(int z=0;z<arr.length;++z)
			System.out.print(arr[z]);
	}
	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		int size = sn.nextInt();
		int [] arr = new int[size];
		for(int i=0;i<size;++i)
		{
			arr[i] = sn.nextInt();
		}
		sort012(arr);
	}

}
