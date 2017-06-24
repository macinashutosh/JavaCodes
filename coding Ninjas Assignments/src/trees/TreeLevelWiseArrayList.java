package trees;
import java.util.*;

public class TreeLevelWiseArrayList {

	public static ArrayList<Node<BinaryTreeNode<Integer>>> LLForEachLevel(BinaryTreeNode<Integer> root) {
		
		// Write your code here
		if(root==null)return null;
        ArrayList<BinaryTreeNode<Integer>> list = new ArrayList<BinaryTreeNode<Integer>>();
        list.add(root);
        ArrayList<Node<BinaryTreeNode<Integer>>> answer = new ArrayList<Node<BinaryTreeNode<Integer>>>();
        while(list.size()>0)
        {
            ArrayList<BinaryTreeNode<Integer>> parent = new ArrayList<BinaryTreeNode<Integer>>(); 
            while(list.size()>0)
            {
                parent.add(list.remove(0));
            }
            Node<BinaryTreeNode<Integer>> tempNode = null,tempHead = null;
            if(parent.size()>0){BinaryTreeNode temp = parent.remove(0);
            tempNode = new Node<BinaryTreeNode<Integer>>(temp);
            tempHead = tempNode;
            }
            while(parent.size()>0)
            {
                BinaryTreeNode temp = parent.remove(0);
                if(temp!=null)
                {if(temp.left!=null)list.add(temp.left);
                if(temp.right!=null)list.add(temp.right);
                tempNode.next = new Node<BinaryTreeNode<Integer>>(temp);
                tempNode = tempNode.next;
                }
            }
            answer.add(tempHead);
            
        }
        return answer;

	}

}
