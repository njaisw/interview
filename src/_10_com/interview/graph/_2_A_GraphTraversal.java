package _10_com.interview.graph;

import java.util.*;

/**
 * http://www.geeksforgeeks.org/breadth-first-traversal-for-a-graph/
 * http://www.geeksforgeeks.org/depth-first-traversal-for-a-graph/
 */
public class _2_A_GraphTraversal {

    public void DFS(_1_Graph<Integer> graph){
        Set<Long> visited = new HashSet<Long>();
        for(Vertex<Integer> vertex : graph.getAllVertex()){
            //TODO call recursion oly if visited does not contain the vertex
            if(!visited.contains(vertex.getId())){
                DFSUtil(vertex,visited);
            }
        }
        
    }
    
    private void DFSUtil(Vertex<Integer> v,Set<Long> visited){
        visited.add(v.getId());
        System.out.print(v.getId() + " ");
        for(Vertex<Integer> child : v.getAdjacentVertexes()){
            //TODO REMEMBER Condition check before recursion
            if(!visited.contains(child.getId()))
                DFSUtil(child,visited);
        }
    }
    
    public void BFS(_1_Graph<Integer> graph){
        Set<Long> visited = new HashSet<Long>();
        Queue<Vertex<Integer>> q = new LinkedList<Vertex<Integer>>();

        //TODO Remember condition is for loop with vertex
        for(Vertex<Integer> vertex: graph.getAllVertex()){
            if(!visited.contains(vertex.getId())){
                q.add(vertex);
                visited.add(vertex.getId());
                //TODO queue while loop is nested inside outside for loop
                while(q.size() != 0){
                    Vertex<Integer> vq = q.poll();
                    System.out.print(vq.getId()+ " ");
                    for(Vertex<Integer> v : vq.getAdjacentVertexes()){
                        if(!visited.contains(v.getId())){
                            q.add(v);
                            visited.add(v.getId());
                        }
                    }
                }
            }
        }
        
    }
    
    
    public static void main(String args[]){

        _1_Graph<Integer> graph = new _1_Graph<Integer>(true);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(4, 6);
        graph.addEdge(6, 5);
    //  graph.addEdge(5, 1);
        graph.addEdge(5,3);
        
        _2_A_GraphTraversal g = new _2_A_GraphTraversal();
        g.DFS(graph);
    }
}
