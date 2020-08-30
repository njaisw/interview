package _10_com.interview.graph;

import java.util.HashMap;
import java.util.Map;

/**
 * http://www.careercup.com/question?id=5988741646647296
 * Given an undirected graph find number of triangles in this graph
 * Find cycle of length 3. Pass parent in DFS search.
 * If there is a cycle check if my parent is neighbor of the the node 
 * which caused it to be a cycle.
 */
public class _33_NumberofTriangles {

    public int countTriangles(_1_Graph<Integer> graph){
        Map<Vertex<Integer>,Boolean> visited = new HashMap<Vertex<Integer>,Boolean>();
        int count =0;
        for(Vertex<Integer> vertex : graph.getAllVertex()){
            count += DFS(vertex,visited,null);
        }
        return count;
    }
    
    public int DFS(Vertex<Integer> vertex, Map<Vertex<Integer>,Boolean> visited,Vertex<Integer> parent){

        if(visited.containsKey(vertex)){
            return 0;
        }
        visited.put(vertex, true);
        int count = 0;
        for(Vertex<Integer> child : vertex.getAdjacentVertexes()){
            if(child.equals(parent)){
                continue;
            }
            if(visited.containsKey(child)){
                // TODO checks if child and parent are neibours a-b-c-a, a-d-c-a
                //For vertex c, parent is b and child is a and a and b are neighbors and so it is traingle
                count += isNeighbor(child, parent) ? 1: 0;
            }else{
                //TODO
                count += DFS(child, visited, vertex);
            }
        }
        return count;
    }

    private boolean isNeighbor(Vertex<Integer> vertex, Vertex<Integer> destVertex){
        for(Vertex<Integer> child : vertex.getAdjacentVertexes()){
            if(child.equals(destVertex)){
                return true;
            }
        }
        return false;
    }
    
    public static void main(String args[]){
        _1_Graph<Integer> graph = new _1_Graph<Integer>(false);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.addEdge(0, 4);
        graph.addEdge(0,3);


        _33_NumberofTriangles not = new _33_NumberofTriangles();
        System.out.println(not.countTriangles(graph));
    }
}
