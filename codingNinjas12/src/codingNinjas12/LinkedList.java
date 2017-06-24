package codingNinjas12;
import java.util.*;
public class LinkedList {
	//function to take input of head
	public static Node takeInput()
	{
		Node head = null;
		Scanner sn = new Scanner(System.in);
		int nextData = sn.nextInt();
		while(nextData!=-1)
		{	
			Node nextNode = new Node(nextData);
			if(head == null){
				head = nextNode;
			}
			else{
				Node tail = head;
				while(tail.next!=null)
				{
					tail = tail.next;
				}
				tail.next = nextNode;
			}
			nextData = sn.nextInt();
		}
		return head;
	}
	public static void print(Node head)
	{	
		while(head!=null)
		{
			System.out.print(head.data + "-->");
			head = head.next;
		}
		System.out.println("null");
	}
	public static int lengthOfList(Node head)
	{	int length = 0;
		while(head!=null)
		{
			length++;
			head = head.next;
		}
		return length;
	}
	public static void printAtPos(Node head,int pos)
	{
		int count = 0;
		while(head!=null)
		{
			if(count==pos)
			{
				System.out.println("element At "+pos+" is "+head.data);
				break;
			}
			count++;
			head = head.next;
		}
		if(count>pos||count<pos)
			System.out.println("element Not present");
	}
	public static Node insertAtI(Node head,int position,int element)
	{	int count = 0;
		Node newNode = new Node(element);
		Node Next = head;
		
		while(Next!=null)
		{
		if(count+1==position)
		{	
			Node next = Next.next;
			Next.next = newNode;
			newNode.next = next;
			
		}
		
		count++;
		
		Next = Next.next;
		}
		
		return head;
	}
	public static Node deleteAtI(Node head,int position)
	{
		int element = -1,count=0;
		Node newNode = head,prevNode=null;
		if(position==1){
			element = head.data;
			head = newNode.next;
			return head;
		}
		
		while(newNode!=null)
		{	
			if(count+1==position)
			{
				element = newNode.data;
				prevNode.next = newNode.next;
			}
			count++;
			prevNode = newNode;
			newNode = newNode.next;
		}
		if(element==-1)
			System.out.println("nithing is deleted");
		else 
			System.out.println(element +" is deleted at " + position);
		return head;
	}
	public static Node insertionAtPositionUsingRecursion(Node head,int position,int element)
	{
		if(head==null&&position>0)
			return head;
		if(position==0)
		{
			Node newNode = new Node(element);
			newNode.next = head;
			return newNode;
		}
		Node newNode = insertionAtPositionUsingRecursion(head.next, position-1, element);
		head.next = newNode;
		return head;
	}
	public static Node DeletionAtPositionUsingRecursion(Node head,int position)
	{
		if(head==null&&position>0)
			return head;
		if(position==0)
		{
			
			head = head.next;
			return head;
		}
		Node newNode = DeletionAtPositionUsingRecursion(head.next, position-1);
		head.next = newNode;
		return head;
	}
	
	//to Return middle element
	public static int middleElement(Node head)
	{
		Node fast = head, slow = head;
		int element = -1;
		while(fast.next!=null&&fast.next.next!=null)
		{
			slow = slow.next;
			fast=fast.next.next;
		}
		element = slow.data;
		return element;
	}
	
	public static Node middleElementNode(Node head)
	{
		Node fast = head, slow = head;
		
		while(fast.next!=null&&fast.next.next!=null)
		{
			slow = slow.next;
			fast=fast.next.next;
		}
		
		return slow;
	}
	
	public static Node mergeSort(Node head)
	{	if(head==null||head.next==null)return head;
		Node mid = middleElementNode(head);
		Node head2 = mid.next;
		mid.next = null;
//		print(head);
//		print(head2);
		head = mergeSort(head);
		head2 = mergeSort(head2);
		head = mergeTwoSorted(head,head2);
		return head;
	}
	
	
	public static Node removeDuplicates(Node head) {
	    
	    Node newNode = head;
	    Node prevNode = head;
	    while(newNode!=null)
	    {   newNode = newNode.next;
	        while(newNode!=null&&newNode.data==prevNode.data)
	        newNode = newNode.next;
	        prevNode.next = newNode;
	        prevNode = prevNode.next;
	    }
	    return head;
	}
	//reversing a linked list using Node
	public static Node reverseR(Node head)
	{
		if(head==null||head.next==null)
			return head;
		Node newNode = reverseR(head.next);
		head.next.next = head;
		head.next = null;
		return newNode;
	}
	
	public static Node mergeTwoSorted(Node head1,Node head2)
	{	if(head1==null)return head2;
		if(head2==null)return head1;
		Node nodeHead1 = head1;
		Node nodeHead2 = head2;
		
		if(nodeHead1.data>=nodeHead2.data)
			{Node temp = nodeHead2.next;
			 nodeHead2.next = nodeHead1;
			 head1 = nodeHead2;
			 nodeHead2 = temp;
			}
		Node prevNode1 = nodeHead1;
		while(nodeHead1!=null && nodeHead2!=null)
		{
			if(nodeHead1.data<nodeHead2.data)
			{	prevNode1 = nodeHead1;
				nodeHead1 = nodeHead1.next;
			}
			else{
				Node temp = nodeHead2.next;
				 nodeHead2.next = nodeHead1;
				 nodeHead1 = nodeHead2;
				 prevNode1.next = nodeHead1;
				 nodeHead2 = temp;
			}
		}
		while(nodeHead1!=null)
		{
			prevNode1.next = nodeHead1;
			prevNode1 = nodeHead1;
			nodeHead1 = nodeHead1.next;
		}
		while(nodeHead2!=null)
		{
			prevNode1.next = nodeHead2;
			prevNode1 = nodeHead2;
			nodeHead2  = nodeHead2.next;
		}
		return head1;
	}
	
	public  static Node bubbleSort(Node head)
	{	if(head==null&&head.next==null)
		return head;
		int length = lengthOfList(head);
		Node currNode = head;
		for(int i=0;i<length;++i)
		{	Node nextNode = currNode.next;
			if(currNode.data>nextNode.data)
			{Node temp = nextNode.next;
			nextNode.next = currNode;
			currNode.next = temp;
			currNode = nextNode;
			}
		}	
		return head;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head1 = takeInput();
//		print(head1);
//		int length = lengthOfList(head);
//		System.out.println("Length of  the list is: " + length);
//		Scanner sn = new Scanner(System.in);
//		int position = sn.nextInt();
//		printAtPos(head, position);
//		head = insertAtI(head, position, 10);
//		print(head);
//		head = deleteAtI(head, position+1);
//		print(head);
//		head = insertionAtPositionUsingRecursion(head, 3, 10);
//		print(head);
//		head = DeletionAtPositionUsingRecursion(head, 4);
//		print(head);
		//System.out.println(middleElement(head));
//		head = removeDuplicates(head);
//		print(head);
//		head = reverseR(head);
//		print(head);
//		Node head2 = takeInput();
		System.out.println("unsorted List :");
		print(head1);
//		System.out.println("List 2");
//		print(head2);
		System.out.println("Sorted list:");
//		print(mergeSort(head1));
		print(bubbleSort(head1));
		//print(mergeSort(head1));
	}

}
