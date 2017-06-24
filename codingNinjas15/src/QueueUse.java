
public class QueueUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueUsingLL<Integer> q = new QueueUsingLL<Integer>();
		try {
			System.out.println(q.dqueue());
		} catch (EmptyQueueException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		}
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.print();
		try {
			reverse(q);
		} catch (EmptyQueueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		q.print();
	}
	
	public static void reverse(QueueUsingLL<Integer> head) throws EmptyQueueException 
	{
		if(head.size()==1)
		{	
			return ;
		}
		
		int d = head.dqueue();
		reverse(head);
		head.enqueue(d);
	}

}
