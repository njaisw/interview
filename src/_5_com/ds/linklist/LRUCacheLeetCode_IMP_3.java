package _5_com.ds.linklist;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Date 02/11/2016
 * 
 * @author Tushar Roy
 *
 *         Reference https://leetcode.com/problems/lru-cache/
 * 
 *         Design and implement a data structure for Least Recently Used (LRU)
 *         cache. It should support the following operations: get and put.
 * 
 *         get(key) - Get the value (will always be positive) of the key if the
 *         key exists in the cache, otherwise return -1. 
 *         
 *         put(key, value) - Set or insert the value if the key is not already present. When the cache
 *         reached its capacity, it should invalidate the least recently used
 *         item before inserting a new item.
 */
public class LRUCacheLeetCode_IMP_3 {

	private LinkedHashMap<Integer, Integer> map;
	private int capacity;

	public LRUCacheLeetCode_IMP_3(int capacity) {
		this.capacity = capacity;
		this.map = new MyMap(capacity);
	}

	public int get(int key) {
		Integer val = map.get(key);
		return val == null ? -1 : val;
	}

	public void set(int key, int value) {
		map.put(key, value);
	}

	class MyMap extends LinkedHashMap<Integer, Integer> {
		int capacity;

		MyMap(int capacity) {
			super(capacity, 0.75f, true);
			this.capacity = capacity;
		}

		@Override
		//TODO Remember linked hashMap
		protected boolean removeEldestEntry(Map.Entry<Integer, Integer> entry) {
			return size() > capacity;
		}
	}
}
