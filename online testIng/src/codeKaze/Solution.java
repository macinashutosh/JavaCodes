package codeKaze;
import java.util.*;



public class Solution {
	public static boolean checkBalancedExpression(String ques)
	{
		boolean answer = true;
		if(ques.equals(""))return answer;
		Stack <Character>node = new Stack<Character>();
		int length = ques.length();
		int count  = 0;
		while(count<length)
		{	if(ques.charAt(count)=='{'||ques.charAt(count)=='['||ques.charAt(count)==']'||ques.charAt(count)=='}'||ques.charAt(count)=='('||ques.charAt(count)==')')
			node.push(ques.charAt(count));
			count++;
		}
		return answer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Write your code here
        Scanner sn = new Scanner(System.in);
        String s = sn.next();
        Stack<Character> stack = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        int length = 0;
        for(int i=0;i<s.length();++i){
        	String str = "";
        	if(s.charAt(i)=='{'||s.charAt(i)=='('||s.charAt(i)=='[')
        		stack.push(s.charAt(i));
        	if(s.charAt(i)==')')
        	{	while(!stack.empty())
        		{char temp = stack.pop();
        			if(temp=='(')
        			{	stack.push('(');
        				break;
        			}
        			stack2.push(temp);
        		}
        		if(stack.isEmpty())
        		stack.push(stack2.pop());
        		else	
          		stack.push(')');        		
        	}
        	if(s.charAt(i)==']')
        	{	while(!stack.empty())
        		{	char temp = stack.pop();
        			if(temp=='[')
        			{	stack.push('[');
        				
        				break;
        			}
        			if(temp=='('||temp==')')
        				{stack2.push(temp);
        				str = temp + str;}
        		}
        	if(checkBalancedExpression(str))
        	while(!stack2.empty())
        		stack.push(stack2.pop());
        		stack.push(']');
        		
        	
        		
        	}
        	if(s.charAt(i)=='}')
        	{	while(!stack.empty())
        		{	char temp = stack.pop();
        			if(temp=='{')
        			{	stack.push('{');
        				break;
        			}
        			if(temp=='['||temp==']'||temp=='('||temp==')'||temp=='}')
        				{stack2.push(temp);
        				str = temp + str;}
        		}
        	if(checkBalancedExpression(str))
        	while(!stack2.empty())
        		stack.push(stack2.pop());
        		stack.push('}');
        		
        	}
        }
        length = stack.size();
        if(stack.isEmpty()){
        	length = s.length();
        }
        
        System.out.print(length);
		
	}

}
