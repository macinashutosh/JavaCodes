package codingNinjas25;

import java.util.Stack;

class StackObjectTOH {
	int n;
	char s;
	char h;
	char d;
	boolean isSingleMove;
	
	public StackObjectTOH(int n, char s, char h, char d, boolean isSingleMove) {
		this.n = n;
		this.s = s;
		this.h = h;
		this.d = d;
		this.isSingleMove = isSingleMove;
	}
}

public class TowerOfHanoi {
	
	public static int tower(int n, char s, char h, char d) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			System.out.println("move 1st disk from " +  s + " to " + d);
			return 1;
		}
		int numSteps = 0;
		Stack<StackObjectTOH> stack = new Stack<>();
		StackObjectTOH first = new StackObjectTOH(n, s, h, d, false);
		stack.push(first);
		while (!stack.isEmpty()) {
			StackObjectTOH top = stack.pop();
			if (top.isSingleMove || top.n == 1) {
				System.out.println("Move " + top.n + "th disk from " + top.s + " to " + top.d);
				numSteps++;
			} else {
				StackObjectTOH obj1 = new StackObjectTOH(n-1, top.h, top.s, top.d, false);
				stack.push(obj1);
				StackObjectTOH obj2 = new StackObjectTOH(n, top.s, top.h, top.d, true);
				stack.push(obj2);
				StackObjectTOH obj3 = new StackObjectTOH(n-1, top.s, top.d, top.h, false);
				stack.push(obj3);
			}
		}
		return numSteps;
	}
	
	public static void main(String[] args) {
		
	}

}
