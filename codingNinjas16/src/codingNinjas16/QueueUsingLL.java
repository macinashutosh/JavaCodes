package codingNinjas16;

public class QueueUsingLL<T> {
private Node <T> head;
private Node <T> tail;
private int length;
public void enqueue(T data){

	if(head==null){
		Node <T> newNode = new Node<T>(data);
		head = newNode;
		tail = newNode;
		length = 1; 
		tail.next = null;
	}
	else{
		Node <T> newNode = new Node<T>(data);
		tail.next = newNode;
		tail = newNode;
		length++;
	}
}
public T dqueue() throws EmptyQueueException{

	if(head==null){
		throw new EmptyQueueException();
	}
	T temp = head.data;
	head = head.next;
	length--;
	return temp;
	}
public T front() throws EmptyQueueException{
	if(head==null){
		throw new EmptyQueueException();
	}
	return head.data;
}
public int size(){
	return length;
}
public void print()
{
	Node temp = head;
	while(temp!=null)
	{
		System.out.print(temp.data+ " --> ");
		temp = temp.next;
	}
	System.out.println("null");
}
public boolean isEmpty(){
	return size()==0;
}
}
