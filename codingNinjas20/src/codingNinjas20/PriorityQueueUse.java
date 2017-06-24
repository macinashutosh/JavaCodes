package codingNinjas20;


import java.util.PriorityQueue;

public class PriorityQueueUse {
	public static void main(String args[]) {
		int [] a = {1,2,5,4,6,10,9,11};
		sortAlmostSorted(a, 2);
//		int k = 4;
//		int [] output = giveKMaximum(a, k);
//		for(int element:output){
//			System.out.println(element);
//		}
		
	}
	
	public static int[] giveKMaximum(int []input,int k)
	{	
		PriorityQueue<Integer> p = new PriorityQueue<Integer>();
		int count = 0;
		for(int element:input)
		{	
			p.add(element);
			if(count>=k)break;
			count++;
		}
		for(;count<input.length;count++){
			int element = p.peek();
			if(input[count]>element)
			{
				p.remove();
				p.add(input[count]);
			}
			
			
		}
		int [] output = new int[k];
		for(int i=0;i<k;++i)
			output[i] = p.remove();
		return output;
	}
	
	public static void sortAlmostSorted(int a[],int k){
		PriorityQueue<Integer> p = new PriorityQueue<Integer>();
		for(int i=1;i<a.length-1;++i)
		{
			if(a[i]>a[i+1])
			{	
				for(int j=i;j<i+k;++j)
				{
					if(j>=0&&j<a.length)
					{
						p.add(a[j]);
					}
				}
				int j;
				for(j = i;j<i+k;++j)
				{
					if(j>=0&&j<a.length)
					{
						a[j] = p.remove();
					}
				}
				i = i + k;
			}
		}
		for(int i=0;i<a.length;++i)
			System.out.println(a[i]);
	}
	
}