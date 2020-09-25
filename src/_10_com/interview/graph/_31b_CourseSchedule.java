package _10_com.interview.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _31b_CourseSchedule {

	/**
	 * Input: 2, [[1,0]] Output: [0,1] Explanation: There are a total of 2 courses
	 * to take. To take course 1 you should have finished course 0. So the correct
	 * course order is [0,1] .
	 *
	 * Example 2:
	 *
	 * Input: 4, [[1,0],[2,0],[3,1],[3,2]] Output: [0,1,2,3] or [0,2,1,3]
	 * 
	 * @param args
	 */

	private Deque<Integer> findOrder(int numOfCourses, int[][] edges) {

		if (numOfCourses == 0 || edges == null || edges.length == 0) {
			return null;
		}

		Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();

		for (int[] edge : edges) {
			graph.compute(edge[0], (key, val) -> {
				if (val == null)
					val = new ArrayList<Integer>();
				val.add(edge[1]);
				return val;
			});
		}

		Set<Integer> visited = new HashSet<Integer>();
		Deque<Integer> stack = new ArrayDeque<Integer>();

		for (int src : graph.keySet()) {
			if (!visited.contains(src)) {
				dfsUtil(src, graph, visited, stack);
			}

		}

		return stack;

	}

	private void dfsUtil(int vertex, Map<Integer, List<Integer>> map, Set<Integer> visited, Deque<Integer> stack) {

		visited.add(vertex);

		List<Integer> children = map.get(vertex);
		if (children != null) {
			for (int child : children) {
				if (!visited.contains(child)) {
					dfsUtil(child, map, visited, stack);
				}
			}
		}
		stack.offer(vertex);

	}

	public static void main(String[] args) {
		_31b_CourseSchedule courseSchedule = new _31b_CourseSchedule();
		Deque<Integer> stack = courseSchedule.findOrder(4, new int[][] { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } });

		while (!stack.isEmpty()) {
			System.out.println(stack.poll());
		}

	}

}
