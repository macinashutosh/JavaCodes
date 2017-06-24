import java.util.Scanner;

public class GenericTreeUse {

	public static int numNodes(GenericTreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		
		int count = 1;
		for (int i = 0; i < root.children.size(); i++) {
			count += numNodes(root.children.get(i));
		}
		return count;
	}
	
	// 1 3 2 3 6 0 7 0 8 0 3 0 4 2 9 0 10 0
	public static GenericTreeNode<Integer> takeInput(Scanner s) {
		System.out.println("Enter root data");
		int rootData = s.nextInt();
		GenericTreeNode<Integer> root = new GenericTreeNode<>(rootData);
		System.out.println("Enter num children for " + rootData);
		int n = s.nextInt();
		for (int i = 0; i < n; i++) {
			GenericTreeNode<Integer> nextChild = takeInput(s);
			root.children.add(nextChild);
		}
		return root;
	}
	
	public static void print(GenericTreeNode<Integer> root) {
		System.out.print(root.data + ":");
		for (int i = 0; i < root.children.size(); i++) {
			System.out.print(root.children.get(i).data + ",");
		}
		System.out.println();
		
		for (int i = 0; i < root.children.size(); i++) {
			print(root.children.get(i));
		}
	}
	
	public static int maximum(GenericTreeNode<Integer> root){
		if(root==null)return Integer.MIN_VALUE;
		int max = root.data,max2=0;
		for(int i = 0;i<root.children.size();++i){
			max2 = root.children.get(i).data;
			max2 = Math.max(max2,maximum(root.children.get(i)) );
		}
		max = Math.max(max, max2);
		return max;
	}
	
	public static boolean areIdentical(GenericTreeNode<Integer> root1,GenericTreeNode<Integer> root2){
		if(root1==null)
	}
	
	public static GenericTreeNode<Integer> takeInputLevelWise(){
		
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		GenericTreeNode<Integer> root = takeInput(s);
		//print(root);
		//System.out.println(maximum(root));
		GenericTreeNode<Integer>answer = findSecondLargest(root);
		if(answer!=null)System.out.println(answer.data);
		else{System.out.println("null");}
	}
	
	public static GenericTreeNode<Integer> findSecondLargest(GenericTreeNode<Integer> root){
	    GenericTreeNode<Integer> max =  helper(root,Integer.MAX_VALUE);
	    System.out.println(max.data);
	    return helper(root,max.data);
		}
		
		public static GenericTreeNode<Integer> helper(GenericTreeNode<Integer> root,int  largest)
		{
		    if(root==null)return null;
		    if(root.children.size()==0) return root;
		    GenericTreeNode<Integer> answer = root;
		    GenericTreeNode<Integer> temp = null;
		    for(int i=0;i<root.children.size();++i)
		    {
		        temp = helper(root.children.get(i),largest);
		        if(temp!=null&&temp.data<largest&&temp.data>answer.data)
		        {answer = temp;}
		    }
		    if(answer.data>largest)return null;
		    return answer;
		}
	
}
