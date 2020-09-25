package _10_com.interview.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _23b_PrintAllPathFromSrcToDes {

	private List<List<Integer>> printAllPathSrcToDestination(int[][] edges, int src, int dest) {
		if (edges == null || edges.length == 0) {
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

			graph.compute(edge[1], (key, val) -> {
				if (val == null)
					val = new ArrayList<Integer>();
				val.add(edge[0]);

				return val;
			});

		}

		Set<Integer> visited = new HashSet<Integer>();

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		dfs(src, graph, dest, new ArrayList<Integer>(), result, visited);
		
		return result;

	}

	private void dfs(int src, Map<Integer, List<Integer>> grapMap, int dest, List<Integer> currrentList,
			List<List<Integer>> result, Set<Integer> visited) {

		visited.add(src);
		currrentList.add(src);

		if (src == dest) {
            currrentList.stream().forEach(System.out::print);
            System.out.println();
            visited.remove(dest);
			currrentList.remove(currrentList.size() - 1);
			result.add(currrentList);
			return;
		}

		for (int child : grapMap.get(src)) {
			if (!visited.contains(child)) {
				dfs(child, grapMap, dest, currrentList, result, visited);
			}
		}
		//TODO remember
		 visited.remove(src);
		 currrentList.remove(currrentList.size()-1);

	}

	public static void main(String[] args) {
		
		/**
		 * graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 6);
        graph.addEdge(5, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);
        graph.addEdge(4, 7);
        graph.addEdge(1, 8);
        graph.addEdge(8, 9);
        graph.addEdge(9, 1);
		 */
		
		_23b_PrintAllPathFromSrcToDes pathFromSrcToDes = new _23b_PrintAllPathFromSrcToDes();
		List<List<Integer>> resList= pathFromSrcToDes.printAllPathSrcToDestination(new int[][] {{1,2},{1,3},{2,4},{2,5},{3,6},{5,6},{5,7},{6,7},{4,7},{1,8},{8,9},{9,1}}, 1, 7);
		
		
		 resList.stream().forEach(x->{ x.stream().forEach(System.out::print); });
		 

	}

}
