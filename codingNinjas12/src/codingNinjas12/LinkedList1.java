package codingNinjas12;

import java.util.Scanner;

public class LinkedList1 {
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
	public static Node merge(Node head1, Node head2) {
		   if (head1 == null) return head2;
		   if (head2 == null) return head1;

		   if (head1.data < head2.data) {
		     head1.next = merge(head1.next, head2);
		     return head1;
		   } else {
		     head2.next = merge(head2.next, head1);
		     return head2;
		   }
		 }
	public static Node reverse4(Node head)
	{
		if(head==null||head.next==null)
			return head;
		Node newNode = reverse4(head.next);
		head.next.next = head;
		head.next = null;
		return newNode;
	}
	public static Node kReverse(Node head, int k) {
		Node ans=null;
		Node sans=null;
		if(k>=len(head)){
			return reverse4(head);
		}
		else{
			int c=1;
			Node start =head;
			while(start!=null){
				c=1;
				Node startnext=start;
				Node tail=start;
				
				while( tail!=null&&c!=k){
					c++;
					
					tail=tail.next;	
				}
				if(c!=k&&tail==null){
					sans=reverse4(startnext);
					ans=merge(ans,sans);
					return ans;
				}
				if(tail!=null&&c==k)
				{					
					start=tail.next;
					tail.next=null;
					 sans=reverse4(startnext);
					 ans=merge(ans,sans);	 
				}  				
				
				}	    
			return ans;
		}
	
}   
	public static int len(Node head)
	{	int length = 0;
		while(head!=null)
		{
			length++;
			head = head.next;
		}
		return length;
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   Node head = takeInput();
		   Node head2 = takeInput();
		   print(head);
		   print(head2);
		   //print(kReverse(head,2));
		  //print(merge(head,head2));
		   print(sumOfTwoLinkedListHelper(head, head2));
	}
	public static Node sumOfTwoLinkedListHelper(Node head1,Node head2)
	{
		if(head1.next==null||head2.next==null)
		{
			while(head1.next!=null)
			{
				head1 = head1.next;
			}
			while(head2.next!=null)
			{
				head2 = head2.next;
			}
			Node data  = new Node(head1.data + head2.data);
			data.next = null;
			return data;
		}
		
		Node smallAnswer = sumOfTwoLinkedListHelper(head1.next,head2.next);
		Node data = new Node(head1.data + head2.data);
		data.next = smallAnswer;
		return data;
	}
	
	public static Node sumOfTwoLinkedList(Node head1,Node head2)
	{
		Node answer = null;
		return answer;
	}
	
	
}
