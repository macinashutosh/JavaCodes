package BinarySearchTreefunctions;

import java.util.Scanner;

import codingNinjas16.EmptyQueueException;
import codingNinjas16.QueueUsingLL;
import codingNinjas16.TreeNode;
import codingNinjas16.Pair;

class quad<a, b, c, d> {
	public a min;
	public b max;
	public c node;
	public d height;

	public quad(a min, b max, c node, d height) {
		this.min = min;
		this.max = max;
		this.node = node;
		this.height = height;

	}
}

public class Solution {
	public static quad<Integer, Integer, TreeNode<Integer>, Integer> helper(
			TreeNode<Integer> root) {
		if (root == null) {
			return new quad<Integer, Integer, TreeNode<Integer>, Integer>(
					Integer.MAX_VALUE, Integer.MIN_VALUE, null, 0);
		}
		if (root.left == null && root.right == null) {
			return new quad<Integer, Integer, TreeNode<Integer>, Integer>(
					root.data, root.data, root, 1);
		}
		quad<Integer, Integer, TreeNode<Integer>, Integer> leftAns = helper(root.left);
		quad<Integer, Integer, TreeNode<Integer>, Integer> rightAns = helper(root.right);
		if (root.data > leftAns.max && root.data <= rightAns.min
				&& leftAns.node == root.left && rightAns.node == root.right)
			return new quad<Integer, Integer, TreeNode<Integer>, Integer>(
					leftAns.min, rightAns.max, root, 1 + Math.max(
							leftAns.height, rightAns.height));
		int h = Math.max(leftAns.height, rightAns.height);
		if (h == leftAns.height)
			return leftAns;
		else
			return rightAns;

	}

	public static int largestWeirdSum(TreeNode<Integer> root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return root.data;
		int sum = root.data + largestWeirdSum(root.left.left)
				+ largestWeirdSum(root.left.right)
				+ largestWeirdSum(root.right.left)
				+ largestWeirdSum(root.right.right);
		int sum2 = largestWeirdSum(root.left);
		int sum3 = largestWeirdSum(root.right);
		int max = Math.max(sum, sum2);
		return Math.max(max, sum3);
	}

	public static void main(String args[]) {
//		TreeNode<Integer> root = takeTreeInputLevelWise();
//		TreeNode<Integer> head = buildSortedDLLWithoutUsingNewNodeOfBST(root);
//		while (head != null) {
//			System.out.print(head.data + "->");
//			head = head.right;
//		}
		int [] pre = {10,5,4,6,15,30,20};
		TreeNode<Integer> root = buildBstUsingPreOrderOnly(pre,Integer.MIN_VALUE,Integer.MAX_VALUE);
		print(root);
//		System.out.println(numberOfBSTs(3));
	}

	public static TreeNode<Integer> buildSortedDLLWithoutUsingNewNodeOfBST(
			TreeNode<Integer> root) {
		if (root == null)
			return null;
		if (root.left == null && root.right == null)
			return root;
		TreeNode<Integer> leftHead = buildSortedDLLWithoutUsingNewNodeOfBST(root.left);
		if (leftHead == null)
			leftHead = root;
		TreeNode<Integer> temp = leftHead;
		if (temp != root) {
			while (temp.right != root && temp.right != null) {
				temp = temp.right;
			}
			temp.right = root;
			root.left = temp;
		}
		TreeNode<Integer> rightHead = buildSortedDLLWithoutUsingNewNodeOfBST(root.right);
		if (root != null)
			root.right = rightHead;
		return leftHead;
	}

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
	// BST input : 10 5 20 1 -1 11 21 -1 -1 -1 -1 -1 -1 
	
//	public static TreeNode<Integer> buildBstUsingPreOrderOnly(int pre[],int start,int end)
//	{
//		if(start>=end)return null;
//		if(end-start==1) return new TreeNode<Integer>(pre[start]);
//		TreeNode<Integer> root = new TreeNode<Integer>(pre[start]);
//		int index = start+1;
//		while(index<end && pre[index]<root.data)
//			index++;
//		root.left = buildBstUsingPreOrderOnly(pre, start+1,index);
//		root.right = buildBstUsingPreOrderOnly(pre,index, end);
//		return root;
//	}
	public static int index=0;
	public static TreeNode<Integer> buildBstUsingPreOrderOnly(int pre[],int min,int max)
	{
		if(index>=pre.length)return null;
		if(pre[index]<min||pre[index]>max)return null;
		TreeNode<Integer> root = new TreeNode<Integer>(pre[index]);
		index++;
		
			root.left = buildBstUsingPreOrderOnly(pre, min, root.data-1);
		
		
			root.right = buildBstUsingPreOrderOnly(pre,root.data + 1, max);
		
		return root;
	}
	
	public static int numberOfBSTs(int n)
	{
		if(n<=1)return 1;
		int count = 0;
		for(int i=0;i<n;++i)
		count  = count + numberOfBSTs(n-i-1)*numberOfBSTs(i);
		return count;
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

	
}
