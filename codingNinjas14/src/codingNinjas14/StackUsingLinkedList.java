package codingNinjas14;

public class StackUsingLinkedList<T>{
	private	 Node<T> top;
	private  int length;
	public  void push(T data){
		if(top==null)
		{
			Node<T> newNode = new Node<T>(data);
			top = newNode;
			top.next = null;
			length = 1;
		}
		else{
			Node<T> newNode = new Node<T>(data);
			newNode.next = top;
			top = newNode;
			length++;
		}
	}
	
	public  int size()
	{	
		return length;
	}
	
	public void pop() throws StackEmptyException
	{	if(this.size()==0)
		throw new StackEmptyException("its Empty Bruh!!");
		top = top.next;
		length--;
	}
	public  void print()
	{
		Node<T> temp = top;
		while(temp!=null)
		{
			System.out.print(temp.data + "-> ");
			temp = temp.next;
		}
		System.out.println();
	}
	public  boolean isEmpty()
	{
		return size()==0;
	}
	public T top() throws StackEmptyException{
		if(isEmpty())
			throw new StackEmptyException();
		return top.data;
	}
}
