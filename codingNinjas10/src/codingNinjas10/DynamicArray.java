package codingNinjas10;



public class DynamicArray {
	private int nextIndex;
	int[] data;
	public DynamicArray()
	{
		data= new int[5];
		nextIndex = 0;
	}
	public boolean isEmpty(){
		if(nextIndex==0)
			return true;
		else return false;
	}
	private void restructure(){
		int temp[] = data;
		data = new int [data.length*2];
		for(int i=0;i<temp.length;++i)
			data[i] = temp[i];
	}
	public void add(int element)
	{
		if(nextIndex>=data.length)
		{
			restructure();
		}
		data[nextIndex] = element;
		nextIndex++;
	}
	public int size()
	{
		return nextIndex;
	}
	public int get(int index)
	{
		if(index>=nextIndex){
			//TODO error out
			return -1;
		}
		return data[index];
	}
	public int removeAtLast()
	{	if(nextIndex==0)
		{	//TODO error out
			return -1;
		}
		int temp = data[nextIndex-1];
		nextIndex--;
		return temp;
	}
	public void set(int index,int element)
	{
		if(index>nextIndex){
			//TODO error out
			return;
		}
		else if(index<nextIndex)
		{
			data[index] = element;
		}
		else{add(element);}
	}
}
