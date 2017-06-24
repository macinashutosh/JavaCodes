package codingNinjas23;
import java.util.HashMap;
import java.util.ArrayList;

class TrieNode {
	boolean isTerminal;
	char data;
	HashMap<Character, TrieNode> children;

	TrieNode(char data) {
		this.data = data;
		isTerminal = false;
		children = new HashMap<>();
	}
}

public class Trie {

	TrieNode root;
	int numWords;

	public Trie() {
		root = new TrieNode('\0');
	}

	public int size() {
		return numWords;
	}

	public boolean isEmpty() {
		return size() == 0;
	}
	
	public static ArrayList<String> allWords(TrieNode root){
		ArrayList<String> output = new ArrayList<>();
		if(root==null){
			return output;
		}		
		if(root.isTerminal){
			output.add(root.data+"");
		}
		for(Character c: root.children.keySet()){
			ArrayList<String> childOutput = allWords(root.children.get(c));
			output.addAll(childOutput);
		}
		return output;		
	}
	
	

	private static boolean addHelper(String word, TrieNode node) {
		if (word.length() == 0) {
			if (node.isTerminal) {
				return false;
			}
			node.isTerminal = true;
			return true;
		}
		TrieNode child = node.children.get(word.charAt(0));
		if (child == null) {
			child = new TrieNode(word.charAt(0));
			node.children.put(word.charAt(0), child);
		}
		return addHelper(word.substring(1), child);
	}

	public void add(String word) {
		if (addHelper(word, root)) {
			numWords++;
		}
	}

	public boolean hasWord(String word) {
		TrieNode currentNode = root;
		for (int i = 0; i < word.length(); i++) {
			TrieNode child = currentNode.children.get(word.charAt(i));
			if (child == null) {
				return false;
			}
			currentNode = child;
		}
		return currentNode.isTerminal;
	}



	public void remove(String word) {
		if (removeHelper(word, root)) {
			numWords--;
		}
	}

	private boolean removeHelper(String word, TrieNode node) {
		if (word.length() == 0) {
			if (node.isTerminal) {
				// we are actually removing something
				node.isTerminal = false;
				return true;
			} else {
				// we are not removing anything
				return false;
			}
		}

		TrieNode child = node.children.get(word.charAt(0));
		if (child == null) {
			return false;
		}
		boolean output = removeHelper(word.substring(1), child);
		if (!child.isTerminal && child.children.size() == 0) {
			node.children.remove(word.charAt(0));
		}
		return output;
	}








}
