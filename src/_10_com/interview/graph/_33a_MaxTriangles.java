package _10_com.interview.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _33a_MaxTriangles {

	private int findMaxTriangles(int[][] edges) {
		
		int count = 0;

		Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();

		for (int[] edge : edges) {
			graph.compute(edge[0], (key, val) -> {
				if (val == null) {
					val = new HashSet<Integer>();
				}
				val.add(edge[1]);
				return val;
			});

			graph.compute(edge[1], (key, val) -> {
				if (val == null) {
					val = new HashSet<Integer>();
				}
				val.add(edge[0]);
				return val;
			});
		}

		Set<Integer> visited = new HashSet<Integer>();

		for (Integer vertex : graph.keySet()) {
			if (!visited.contains(vertex)) {
				count += dfsUtils(vertex, visited, -1, graph);
			}
		}
		return count;
	}

	private int dfsUtils(Integer v, Set<Integer> visited, Integer parent, Map<Integer, Set<Integer>> graph) {
		visited.add(v);
		int count = 0;

		for (Integer child : graph.get(v)) {
			if (child == parent) {
				continue;
			}
			if (visited.contains(child)) {
				count+=isNeighbor(parent, child, graph)?1:0;
			} else {
				count += dfsUtils(child, visited, v, graph);
			}
		}
		return count;
	}
	
	private boolean isNeighbor(Integer u , Integer v, Map<Integer, Set<Integer>> graph) {
		return graph.get(v).contains(u);
	}

	public static void main(String[] args) {
		
		_33a_MaxTriangles maxTrianges = new _33a_MaxTriangles();
		int count = maxTrianges.findMaxTriangles(new int[][] {{0,1},{1,4},{1,3},{0,4},{0,3},{3,4}});
		System.out.println(count);

	}

}
