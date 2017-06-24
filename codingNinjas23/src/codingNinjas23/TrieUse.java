package codingNinjas23;

import java.util.ArrayList;

public class TrieUse {

	public static void main(String[] args) {
		Trie data = new Trie();
		data.add("coder");
		data.add("code");
		data.add("cof");
	    ArrayList<String>anwer = allWords(data.root);
	    
	}

}
