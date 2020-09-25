package _10_com.interview.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

class Vert {
    int id;
    List<Vert> adjacent = new ArrayList<Vert>();

}

class Count {
    int size = 0;
}

public class _23a_LongestPathusingDFS {

    int max = 0;

    private int findlongestPath(int[][] edges) {

        Map<Integer, Vert> vertices = buildGraph(edges);
        Set<Vert> visited = new HashSet<Vert>();

        int maxLength = 0;
        for (int i = 0; i < vertices.size(); i++) {
            if (!visited.contains(vertices.get(i))) {
                Count count = new Count();
                dfs(vertices.get(i), visited, count);
                if (count.size > max)
                    max = count.size;
            }
        }
        return max;
    }

    public void dfs(Vert v, Set<Vert> visited, Count c) {
        visited.add(v);
        for (Vert child : v.adjacent) {
            if (!visited.contains(child)) {
                c.size++;
                dfs(child, visited, c);
            }
        }
    }

    private Map<Integer, Vert> buildGraph(int[][] vertices) {
        Map<Integer, Vert> verticesMap = new HashMap<Integer, Vert>();
        for (int[] tuple : vertices) {
            int parent = tuple[0];
            int child = tuple[1];
            if (!verticesMap.containsKey(child)) {
                verticesMap.put(tuple[1], new Vert());
            }
            if (!verticesMap.containsKey(parent)) {
                Vert parentNode = new Vert();
                verticesMap.put(parent, parentNode);
            }
            verticesMap.get(parent).adjacent.add(verticesMap.get(child));
        }
        return verticesMap;
    }

    public static void main(String[] args) {

        int[][] matrix = new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}, {5, 6}, {3, 7}};
        _23a_LongestPathusingDFS longestPathusingDFS = new _23a_LongestPathusingDFS();
        System.out.println(longestPathusingDFS.findlongestPath(matrix));
    }

}
