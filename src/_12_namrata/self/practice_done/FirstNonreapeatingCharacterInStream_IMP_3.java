package _12_namrata.self.practice_done;

//A Java program to find first non-repeating character from a stream of characters 

import java.util.HashMap;
import java.util.Map;

public class FirstNonreapeatingCharacterInStream_IMP_3<T> {

	static class Node<T> {

		T data;

		Node<T> next;

		Node<T> prev;

		public Node(T data) {
			this.data = data;
		}

	}

	private T findFirstNonreapeatingCharacterInStream(T[] inputs) {
		Map<T, Node<T> >map = new HashMap<T, Node<T>>();

		Node<T> head = null;

		Node<T>  tail = null;

		for (T t : inputs) {
			if (!map.containsKey(t)) {
				Node<T>  node = new Node<T>(t);
				if (head == null) {
					head = tail = node;
				} else {
					tail.next = node;
					node.prev = tail;
					tail = tail.next;
				}
				map.put(t,node);
			} else {
				Node<T>  node = map.get(t);
				if(node== head) {
					head = head.next;
					if(head!=null)
						head.prev=null;
					node.next=null;
				}else if(node==tail) {
					tail=tail.prev;
					if(tail!=null)
						tail.next=null;
				}else {
					if(node.prev!=null)
						node.prev.next= node.next;
					if(node.next!=null)
						node.next.prev=node.prev;
					node.next=null;
					node.prev=null;

				}
			}

		}

		return head.data;

	}

	public static void main(String[] args) {
		FirstNonreapeatingCharacterInStream_IMP_3<Integer> firstNonreapeatingCharacterInStream = new FirstNonreapeatingCharacterInStream_IMP_3<Integer>();
		System.out.println(firstNonreapeatingCharacterInStream.findFirstNonreapeatingCharacterInStream(new Integer[] {2,3,3,2,3,2,2,3,3,4,5,5,5,6}));


	}

}
