package codingNinjas14;

import java.util.Scanner;

public class StackUse {

	public static void main(String[] args) throws StackEmptyException {
		// TODO Auto-generated method stub
//		StackUsingLinkedList list = new StackUsingLinkedList();
//		try {
//			list.pop();
//		} catch (StackEmptyException e) {
//			// TODO: handle exception
//		}
//		list.push(10);
//		list.push(9);
//		list.push(8);
//		list.push(7);
//		list.push(6);
//		list.push(5);
//		list.push(4);
//		list.print();
//		while(!list.isEmpty())
//		{
//		try {
//			list.pop();
//		} catch (StackEmptyException e) {
//			// TODO: handle exception
//		}
//		}
		Scanner sn = new Scanner(System.in);
//		String input = sn.next();
//		checkBalancedExpression(input);
		StackUsingLinkedList<Integer> s1 = new StackUsingLinkedList<Integer>();
		StackUsingLinkedList<Integer> s2 = new StackUsingLinkedList<Integer>();
		int s = sn.nextInt();
		for(int i=0;i<s;++i)
			s1.push(sn.nextInt());
		reverseOfAStack(s1, s2);
		while(!s2.isEmpty())
		{
			s1.push(s2.top());
			s2.pop();
		}
		s1.print();
		//s2.print();
			
	}
	
	public static boolean checkBalancedExpression(String ques)
	{
		boolean answer = true;
		if(ques.equals(""))return answer;
		StackUsingLinkedList <Character>node = new StackUsingLinkedList<Character>();
		int length = ques.length();
		int count  = 0;
		while(count<length)
		{	if(ques.charAt(count)=='{'||ques.charAt(count)=='['||ques.charAt(count)==']'||ques.charAt(count)=='}'||ques.charAt(count)=='('||ques.charAt(count)==')')
			node.push(ques.charAt(count));
			count++;
		}
		node.print();
		
		
		return answer;
	}
	
	public static void reverseOfAStack(StackUsingLinkedList<Integer> s1,StackUsingLinkedList<Integer> s2) throws StackEmptyException
	{
		if(s1.isEmpty()){	
			
			return;
		}
		int data =s1.top();
		s1.pop();
		reverseOfAStack(s1, s2);
		s2.push(data);
	}
	
}

