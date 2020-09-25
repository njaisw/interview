package _12_namrata.self.practice_done;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie {

	TNode root;

	public Trie() {
		root = new TNode();
	}

	static class TNode {

		boolean isEnd = false;

		List<String> words;

		Map<Character, TNode> children;

		public TNode() {
			children = new HashMap<>();
			words = new ArrayList<>();
		}
	}

	private void insert(String word) {
		TNode current = root;
		for (Character ch : word.toCharArray()) {
			if (current.children.get(ch) == null) {
				current.children.put(ch, new TNode());
			}
			current = current.children.get(ch);
		}
		current.isEnd = true;
		current.words.add(word);
	}

	private boolean search(String word) {
		TNode current = root;
		for (int i = 0; i < word.length(); i++) {
			if (current.children.get(word.charAt(i)) == null) {
				return false;
			}
			current = current.children.get(word.charAt(i));
		}
		return current.isEnd;
	}

	private void delete(String word) {
		TNode current = root;
		this.deleteUtils(current, word, 0);
	}

	//TODO Important to remember
	private boolean deleteUtils(TNode node, String word, int index) {
		if (word.length() == index) {
			node.isEnd = false;
			node.words.remove(word);
			return node.children.size() == 0;
		}

		if (node.children.get(word.charAt(index))==null) {
			return false;
		}
		
		boolean shoulddlete = deleteUtils(node.children.get(word.charAt(index)), word, index + 1);
		if (shoulddlete) {
			node.children.remove(word.charAt(index));
			return node.children.size() == 0;
		}
		return false;
	}

	class Count {

		int count;
	}

	private int print() {
		TNode current = root;

		Count count = new Count();

		printUtils(current, count);

		return count.count;
	}

	private void printUtils(TNode node, Count count) {

		if (node.isEnd) {
			node.words.forEach(System.out::println);
			count.count++;
		}

		if (node.children.size() == 0) {
			return;
		}

		for (Character ch : node.children.keySet()) {
			if (node.children.get(ch) != null) {
				printUtils(node.children.get(ch), count);
			}

		}

	}

	public static void main(String[] args) {
		
		Trie trie = new Trie();
		trie.insert("abc");
		trie.insert("abcd");
		
		System.out.println("Printing tree");
		int count = trie.print();
		
		System.out.println("Print count");
		System.out.println(count);
		
		System.out.println("Seraching");
		System.out.println(trie.search("abc"));
		System.out.println(trie.search("abcd"));
		
		System.out.println("Deleting abc");
		trie.delete("abc");
		System.out.println(trie.print());
		
		System.out.println("Deleting abcd");
		trie.delete("abcd");
		System.out.println(trie.print());
		
		System.out.println("Printing empty tree");
		System.out.println(trie.print());
		
		
		
		
		
		

	}

}
