package codingNinjas20;
import java.util.*;

public class Heap{
private ArrayList<Integer>  data;
	public Heap()
	{
		data.add(null);
	}
private int length = 1;
	public int size()
	{
		return length-1;
	}
	public boolean isEmpty()
	{
		return length==1;
	}
	
	public void insert(int priorty)
	{
		data.add(priorty);
		int temp = length;
		while(temp>=1 && priorty<data.get(temp))
		{	
			temp = temp/2;
		}
		length++;
	}
	
}
