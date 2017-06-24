package codingNinjas16;


import java.util.*;
public class TreeUse {

	
	// 1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 8 9 -1 -1 -1 -1
	public static TreeNode<Integer> takeTreeInputLevelWise() {
		System.out.println("Enter root data");
		Scanner s = new Scanner(System.in);
		int rootData = s.nextInt();
		if (rootData == -1) {
			return null;
		}

		TreeNode<Integer> root = new TreeNode<>(rootData);
		QueueUsingLL<TreeNode<Integer>> queue = new QueueUsingLL<>();
		queue.enqueue(root);
		while (!queue.isEmpty()) {
			TreeNode<Integer> parent;
			try {
				parent = queue.dqueue();
			} catch (EmptyQueueException e) {
				return null;
			}
			System.out.println("Enter left child of " + parent.data);
			int leftData = s.nextInt();
			if (leftData != -1) {
				TreeNode<Integer> leftChild = new TreeNode<Integer>(leftData);
				queue.enqueue(leftChild);
				parent.left = leftChild;
			}

			System.out.println("Enter right child of " + parent.data);
			int rightData = s.nextInt();
			if (rightData != -1) {
				TreeNode<Integer> rightChild = new TreeNode<Integer>(rightData);
				queue.enqueue(rightChild);
				parent.right = rightChild;
			}
		}
		return root;
	}

	// 1 2 4 -1 -1 5 -1 -1 3 6 -1 -1 7 -1 -1 
	public static TreeNode<Integer> takeTreeInput(Scanner s) {
		System.out.println("Enter root data");
		int rootData = s.nextInt();
		if (rootData == -1) {
			return null;
		}

		TreeNode<Integer> root = new TreeNode<>(rootData);
		root.left = takeTreeInput(s);
		root.right = takeTreeInput(s);
		return root;
	}

	public static void print(TreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + ":");
		if (root.left != null) {
			System.out.print(root.left.data + ",");
		}
		if (root.right != null) {
			System.out.print(root.right.data + ",");
		}
		System.out.println();

		print(root.left);
		print(root.right);
	}

	public static int sum(TreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		return sum(root.left) + sum(root.right) + root.data;
	}

	public static int numberNodes(TreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		return numberNodes(root.left) + numberNodes(root.right) + 1;
	}

	public static int maximumElement(TreeNode<Integer> root){
		if(root==null){
			return Integer.MIN_VALUE;
		}
		int data = root.data;
		int leftData = maximumElement(root.left);
		int rightData = maximumElement(root.right);
		if(data<leftData)data = leftData;
		if(data<rightData)data = rightData;
		return data;
	}
	
	public static boolean searchElement(TreeNode<Integer> root,int element)
	{
		if(root == null){
			return false;
		}
		boolean answer =false;
		if(root.data == element)return true;
		answer = searchElement(root.left,element);
		if(answer==true)return true;
		answer = searchElement(root.right,element);
		if(answer==true)return true;
		return answer;
	}
	
	public static int heightOfTree(TreeNode<Integer> root){
		if(root==null)return 0;
		int data = heightOfTree(root.left);
		int data2 = heightOfTree(root.right);
		if(data<data2)data = data2;
		return data + 1;
	}
	
	public static int numberOfLeafNodes(TreeNode<Integer>root){
		if(root==null)return 0;
		int numberOfLeafs = 0;
		if(root.left==null&&root.right==null)
			numberOfLeafs++;
		numberOfLeafs = numberOfLeafs + numberOfLeafNodes(root.left);
		numberOfLeafs = numberOfLeafs + numberOfLeafNodes(root.right);
		return numberOfLeafs;
	}
	
	public static void printLevelWise(TreeNode<Integer> root){
		if(root==null)return;
		QueueUsingLL<TreeNode<Integer>> queue = new QueueUsingLL<TreeNode<Integer>>();
		queue.enqueue(root);
		while(!queue.isEmpty())
		{				
			TreeNode<Integer> parent ;
			try {
				parent = queue.dqueue();
			} catch (EmptyQueueException e) {
				return;
			}
			System.out.print(parent.data + ":");
			if (parent.left != null) {
				System.out.print(parent.left.data + ",");
				queue.enqueue(parent.left);
			}
			if (parent.right != null) {
				System.out.print(parent.right.data + ",");
				queue.enqueue(parent.right);
			}
			System.out.println();
		}
		
		
		
	}
	public static void printAtLevelK(TreeNode<Integer>root,int k){
		if(root==null)return;
		if(k==0)
		{
			System.out.print(root.data);
			return;
		}
		printAtLevelK(root.left, k-1);
		printAtLevelK(root.right, k-1);
	}
	public static int maxSum(TreeNode<Integer> root){
		if(root==null)return 0;
		int maxSum = root.data;
		if(root.left!=null)maxSum = maxSum + root.left.data;
		if(root.right!=null)maxSum = maxSum + root.right.data;
		int leftMax = maxSum(root.left);
		int rightMax = maxSum(root.right);
		if(maxSum<leftMax)maxSum=leftMax;
		if(maxSum<rightMax)maxSum=rightMax;
		return maxSum;
	}
	
	public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root){
		if(root==null)return null;
		if(root.left==null && root.right==null)
			return root;

		int rootsum = root.data;
		if(root.left!=null)
			rootsum = rootsum + root.left.data;
		if(root.right!=null)
			rootsum = rootsum + root.right.data;
		
		int leftsum = 0 , rightsum = 0;
		
		TreeNode<Integer> leftNode = maxSumNode(root.left);
		if(leftNode!=null)
		{ leftsum = leftNode.data;
		if(leftNode.left!=null)
			leftsum = leftsum + leftNode.left.data;
		if(leftNode.right!=null)
			leftsum = leftsum + leftNode.right.data;
		}
		
		TreeNode<Integer> rightNode = maxSumNode(root.right);
		if(rightNode!=null)
		{rightsum = rightNode.data;
		if(rightNode.left!=null)
			rightsum = rightsum + rightNode.left.data;
		if(leftNode.right!=null)
			rightsum = rightsum + rightNode.right.data;
		}
		int max = (int) Math.max(leftsum, rightsum);
		int max2 = (int) Math.max(rootsum, max);
		if(max2==leftsum)return leftNode;
		else if(max2==rightsum) return rightNode;
		else return root;
	}
	
	public static boolean isBalanced(TreeNode<Integer> root)
	{	if(root==null)return true;
		boolean answer = true;
		int leftHeight = heightOfTree(root.left);
		int rightHeight = heightOfTree(root.right);
		if(Math.abs(leftHeight-rightHeight)<=1){
			answer = isBalanced(root.left);
			if(!answer)return answer;
			answer = isBalanced(root.right);
		}
		else return false;
		return answer;
	}
	
	public static boolean areIdentical(TreeNode<Integer> root1,TreeNode<Integer> root2)
	{
		if(root1==null&&root2==null)return true;
		if(root1==null)return false;
		if(root2==null)return false;
		
		if(root1.data==root2.data){
		if(areIdentical(root1.left,root2.left)){
			return areIdentical(root1.right, root2.right);
		}
		else return false;
		}
		else return false;
		
	}
	
	public static Pair<Integer,Boolean> balancedAndHeight(TreeNode<Integer> root){
		if(root==null)
		{
			Pair<Integer,Boolean> output = new Pair<Integer, Boolean>(0,true);
			return output;
		}
		Pair<Integer, Boolean> leftOutput = balancedAndHeight(root.left);
		Pair<Integer, Boolean> rightOutput = balancedAndHeight(root.right);
		int height  = 1 + Math.max(leftOutput.first, rightOutput.first);
		boolean isBalanced = leftOutput.second && rightOutput.second;
		Pair<Integer, Boolean> output =  new Pair<>(height,isBalanced);
		return output;
	}
	
	public static TreeNode<Integer> getTree(int pre[],int in[],int preStart,int preEnd,int inStart,int inEnd )
	{	
		if(inEnd-inStart==0)return null;
		if(inEnd-inStart==1)return new TreeNode<Integer>(in[inStart]);
		if(preStart>=preEnd)return null;
		TreeNode<Integer> root = new TreeNode<Integer>(pre[preStart]);
		int position = 0;
		for(int i=inStart;i<inEnd;++i)
			{if(root.data==in[i]){position = i;
			 break;
			 }
			}
		root.left = getTree(pre, in,preStart+1, position,inStart,position);
		root.right = getTree(pre, in, position+1, preEnd, position+1, inEnd);
		
		return root;
	}

	public static int diameterOfATree(TreeNode<Integer> root)
	{
		if(root==null)return 0;
		int height = heightOfTree(root.left) + heightOfTree(root.right);
		int leftDia = diameterOfATree(root.left);
		int rightDia = diameterOfATree(root.right);
		int max = Math.max(leftDia,rightDia);
		int max2 = Math.max(height, max);
		return max2;
	}
	
//	TODO
//	public static Pair<Integer,Integer> diameterOptimized(TreeNode<Integer> root)
//	{}
	
	public static void main(String[] args) {

		TreeNode<Integer> root = takeTreeInputLevelWise();
//		//printLevelWise(root);
//		int [] pre = {1,2,4,5,3,6,7};
//		int [] in = {4,2,5,1,6,3,7};
//		System.out.println("maximum element:" + maximumElement(root));
//		System.out.println(searchElement(root, 7));
//		System.out.println(searchElement(root, 10));
//		System.out.println("height of tree: "+ heightOfTree(root));
//		System.out.println(maxSumNode(root).data);
//		System.out.println(isBalanced(root));
//		System.out.println(areIdentical(root, null));
//		printLevelWise(getTree(pre, in,0, pre.length, 0, in.length));
	
//		printAllAncestors(root,7);
//		ArrayList<Integer> list = returnAllAncestors(root, 7);
//		for(int i=0;i<list.size();++i)
//			System.out.println(list.get(i));
		
//		Triplet<Boolean,Integer,Integer> s = isBST(root);
//		System.out.println(s.first);
//		int input[] = {1,2,3,4,5,6,7};
//		TreeNode<Integer> BST = buildBST(input,0, input.length);
//		TreeNode<Integer> Lca = lowestCommAncestorBst(BST, 1,7);
//		if(Lca!=null)
//		System.out.println(Lca.data);
//		else
//			System.out.println("null");
//		Node<Integer> head = buildLLofBST(BST);
//		while(head!=null)
//			System.out.print(head.data);
//		TreeNode<Integer> answer = lowestCommonAncestor(root, 1, 10);
//		System.out.println(answer.data);
		//System.out.println(diameterOfATree(root));
//		System.out.println( largestWeirdSum(root));
		leftView(root);
	}
	
	public static void printAllAncestors(TreeNode<Integer> root,int data)
	{
		if(root==null){return;}
		if(root.data!=data)
			System.out.println(root.data);
		if(searchElement(root.left, data))
			System.out.println(root.left.data);
		if(searchElement(root.right, data))
			System.out.println(root.right.data);
	}
	public static ArrayList<Integer> returnAllAncestors(TreeNode<Integer> root, int data)
	{
		if(root==null){return new ArrayList<Integer>();}
		if(root.data==data){
			ArrayList<Integer> list = new ArrayList<Integer> ();
			list.add(data);
			return list;
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(searchElement(root.left, data))list = returnAllAncestors(root.left, data);
		else list = returnAllAncestors(root.right, data);
		list.add(root.data);
		return list;
		
	}
	public static TreeNode<Integer> lowestCommonAncestor(TreeNode<Integer>root,int data1,int data2){
		if(root==null){
			return null;
			}
		if(root.data==data1||root.data==data2)
			return root;
		TreeNode<Integer> leftAns,rightAns;
		leftAns = lowestCommonAncestor(root.left, data1, data2);
		rightAns = lowestCommonAncestor(root.right, data1, data2);
		if(leftAns!=null)
		System.out.println(leftAns.data);
		if(rightAns!=null)
		System.out.println(rightAns.data);
		if(leftAns!=null&&rightAns!=null)
			return root;
		if(leftAns==null)return rightAns;
		else return leftAns;
		
	}
	
	public static TreeNode<Integer> lowestCommAncestorBst(TreeNode<Integer> root,int data1,int data2)
	{	if(root==null)return null;
		int max = Math.max(data1,data2);
		int min = Math.min(data1,data2);
		if(root.data<=max&&root.data>min)return root;
		if(root.data<data1&&root.data<data2)return lowestCommAncestorBst(root.right, data1, data2);
		else return lowestCommAncestorBst(root.left, data1, data2);
	}
	
	public  static TreeNode<Integer> buildBST(int [] input,int startIndex,int endIndex)
	{	if(input.length==0)return null;
		if(startIndex>=endIndex)return null;
		if(endIndex-startIndex==1)
		{
			TreeNode<Integer> node = new TreeNode<Integer>(input[startIndex]);
		}
		int mid = (startIndex+endIndex)/2;
		TreeNode<Integer> root = new TreeNode<Integer>(input[mid]);
		root.left = buildBST(input, startIndex,mid);
		root.right = buildBST(input,mid+1, endIndex);
		return root;
	}
	
	public static Node<Integer> buildLLofBST(TreeNode<Integer> root)
	{
		if(root==null)return null;
		if(root.left==null&&root.right==null)
		{
			return new Node<Integer>(root.data);
		}
		Node<Integer> leftAns = buildLLofBST(root.left);
		Node<Integer> rightAns = buildLLofBST(root.right);
		Node<Integer> rootHead = new Node<Integer>(root.data);
		Node<Integer> head = leftAns;
		while(leftAns.next!=null)
			leftAns = leftAns.next;
		leftAns.next = rootHead;
		rootHead.next = rightAns;
		if(rightAns.data==7)rightAns.next=null;
		return leftAns;
	}
	
	public static Triplet<Boolean,Integer,Integer> isBST(TreeNode<Integer> root){

		if(root==null)return new Triplet<Boolean, Integer, Integer>(true, Integer.MAX_VALUE,Integer.MIN_VALUE);
		if(root.left==null&&root.right==null)
			return new Triplet<Boolean,Integer,Integer>(true,root.data,root.data);
		Triplet<Boolean, Integer, Integer> leftAns = isBST(root.left);
		Triplet<Boolean, Integer, Integer> rightAns = isBST(root.right);
		if(!leftAns.first||!rightAns.first)return new Triplet<Boolean, Integer, Integer>(false, leftAns.third,rightAns.second);
		if(root.data<=rightAns.second && root.data>leftAns.third)
		{
			return new Triplet<Boolean, Integer, Integer>(true,leftAns.third,rightAns.second);
		}
		return new Triplet<Boolean, Integer, Integer>(false, leftAns.third,rightAns.second);
		
	}
	public static int largestWeirdSum(TreeNode<Integer> root)
	{
		if(root==null)return 0;
		if(root.left==null&&root.right==null){
			return root.data;
		}
		int sum = root.data + largestWeirdSum(root.left.left) + largestWeirdSum(root.left.right) + largestWeirdSum(root.right.left) + 
				largestWeirdSum(root.right.right);
		int sum2 = largestWeirdSum(root.left);
		int sum3 = largestWeirdSum(root.right);
		int max = Math.max(sum, sum2+sum3);
		
		return max;
	}
	public static void  leftView(TreeNode<Integer> root)
	{
		if(root==null)return ;
		System.out.println(root.data);
		QueueUsingLL<TreeNode<Integer>> list = new QueueUsingLL<TreeNode<Integer>>();
		QueueUsingLL<TreeNode<Integer>> list2 = new QueueUsingLL<TreeNode<Integer>>();
		list.enqueue(root);
		while(!list.isEmpty())
		{
			try {TreeNode<Integer> node = list.dqueue();
			
			if(node.left!=null)	
				list2.enqueue(node.left);
			if(node.right!=null)
				list2.enqueue(node.right);
			} catch (EmptyQueueException e) {
				// TODO Auto-generated catch block
				return;
			}
			if(list.isEmpty()){
				try {
					if(!list2.isEmpty())
					System.out.println(list2.front().data);
				} catch (EmptyQueueException e) {
					// TODO Auto-generated catch block
					return;
				}
				QueueUsingLL<TreeNode<Integer>>  temp = list;
				list = list2;
				list2 = temp;
			}
		}
	}
	
	
}
