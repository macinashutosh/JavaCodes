import java.lang.Exception;;


public class EmptyQueueException extends Exception {
public EmptyQueueException()
{
	System.out.println("Queue is empty");
}
public EmptyQueueException(String message){
	System.out.println(message);
}
}
