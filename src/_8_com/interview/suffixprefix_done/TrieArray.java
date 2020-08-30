package _8_com.interview.suffixprefix_done;

import java.util.HashMap;
import java.util.Map;

class TrieNode {

	boolean isLeaf = false;
	TrieNode[] children = new TrieNode[26];

}

public class TrieArray {

	TrieNode root;

	public TrieArray() {
		this.root = new TrieNode();
	}

	private void insert(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			int index = word.charAt(i) - 'a';
			if (current.children[index] == null) {
				TrieNode temp = new TrieNode();
				current.children[index] = temp;
			}
			current = current.children[index];

		}
		current.isLeaf = true;

	}

	private boolean search(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			int index = word.charAt(i) - 'a';
			if (current.children[index] == null)
				return false;
			current = current.children[index];
		}
		if (current.isLeaf)
			return true;
		return false;

	}

	private void printAllNode() {
		TrieNode current = root;
		StringBuffer buffer = new StringBuffer();
		findLeaf(current, buffer);

	}

	private void findLeaf(TrieNode node, StringBuffer buff) {
		if (node.isLeaf) {
			System.out.println(buff);
		}

		for (int i = 0; i < node.children.length; i++) {
			if (node.children[i] != null) {
				//TODO remember the logic
				buff.append((char) (i + 'a'));
				findLeaf(node.children[i], buff);
				//TODO delete
				buff.deleteCharAt(buff.length() - 1);
			}

		}

	}

	public static void main(String[] args) {
		TrieArray trie = new TrieArray();
		trie.insert("cat");

		trie.insert("rat");
		trie.insert("cate");
		System.out.println(trie.search("rat"));

		trie.printAllNode();

	}

}
