package _10_com.interview.graph;

import java.util.HashSet;
import java.util.Set;

/**
 * Date 10/11/2014
 * @author Tushar Roy
 *
 * Given an undirected graph find cycle in this graph.
 *
 * Solution
 * This can be solved in many ways.
 * Below is the code to solve it using disjoint sets and DFS.
 *
 * Runtime and space complexity for both the techniques is O(v)
 * where v is total number of vertices in the graph.
 * https://www.youtube.com/watch?v=n_t0a_8H8VY
 */
public class _20_CycleUndirectedGraph<T> {

    public boolean hasCycleUsingDisjointSets(_1_Graph<T> graph){
        _3da_A_DisjointSet disjointSet = new _3da_A_DisjointSet();
        
        for(Vertex<T> vertex : graph.getAllVertex()){
            disjointSet.makeSet(vertex.getId());
        }
        //TODO for every edges traverse the graph
        for(Edge<T> edge : graph.getAllEdges()){
            //TODO finset returns parent
            long parent1 = disjointSet.findSet(edge.getVertex1().getId());
            long parent2 = disjointSet.findSet(edge.getVertex2().getId());
            //TODO parent of two nodes are equal, so the nodes are same
            if(parent1 == parent2){
                return true;
            }
            //TODO union add parent nodes
            disjointSet.union(edge.getVertex1().getId(), edge.getVertex2().getId());
        }
        return false;
    }
    
    public boolean hasCycleDFS(_1_Graph<T> graph){
        Set<Vertex<T>> visited = new HashSet<Vertex<T>>();
        for(Vertex<T> vertex : graph.getAllVertex()){
            if(visited.contains(vertex)){
                continue;
            }
            boolean flag = hasCycleDFSUtil(vertex, visited, null);
            if(flag){
                return true;
            }
        }
        return false;
    }
    
    public boolean hasCycleDFSUtil(Vertex<T> vertex, Set<Vertex<T>> visited,Vertex<T> parent){
        visited.add(vertex);
        for(Vertex<T> child : vertex.getAdjacentVertexes()){
            //TODO if child is same as parent then return
            if(child.equals(parent)){
                continue;
            }
            if(visited.contains(child)){
                return true;
            }
            //TODO return
           return hasCycleDFSUtil(child,visited,vertex);

        }
        return false;
    }
    
    public static void main(String args[]){
        
        _20_CycleUndirectedGraph<Integer> cycle = new _20_CycleUndirectedGraph<Integer>();
        _1_Graph<Integer> graph = new _1_Graph<Integer>(false);
        
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 1);
        boolean isCycle = cycle.hasCycleDFS(graph);
        System.out.println(isCycle);
        isCycle = cycle.hasCycleUsingDisjointSets(graph);
        System.out.print(isCycle);
        
    }
    
}
