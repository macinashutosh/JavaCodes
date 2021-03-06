
public class QueueUsingArray {
	private int data[];
	private int nextIndex;
	private int firstIndex;
	private int size;
	
	public QueueUsingArray()
	{
		data = new int[5];
		nextIndex=0;
		size = 0;
		firstIndex = -1;
	}
	private void resize()
	{
		int temp[] = new int[data.length*2];
		int k=0;
		for(int i=firstIndex;i<data.length;i++)
		{
			temp[k] = data[i];
			k++;
		}
		for(int i=0;i<nextIndex;i++)
		{
			temp[k] = data[i];
			k++;
		}
		data = temp;
	}
	public int size()
	{
		return size;
	}
	public boolean isEmpty()
	{
		return size()==0;
	}
	public void enqueue(int element){
	if(size==data.length)
	{
		resize();
	}
	 data[nextIndex] = element;
	 size++;
	 if(size==1)firstIndex = 0;
	 nextIndex = (nextIndex+1)%data.length;
	}
	public int front() throws EmptyQueueException{
		if(size==0){
			throw new EmptyQueueException();
		}
		return data[firstIndex];
	}
	public int dequeu() throws EmptyQueueException {
		if(size==0){
			throw new EmptyQueueException();
		}
		int toBeReturned = data[firstIndex];
		firstIndex = (firstIndex+1)%data.length;
		return toBeReturned;
	}
	public void print()
	{	if(firstIndex!=-1)
		for(int i=firstIndex;i<nextIndex;++i)
		{
			System.out.print(data[i]+"--> ");
		}
		for(int i=0;i<data.length-nextIndex-1;++i)
		{
			System.out.print(data[i]+"--> ");
		}
		System.out.println("null");
	}
}
