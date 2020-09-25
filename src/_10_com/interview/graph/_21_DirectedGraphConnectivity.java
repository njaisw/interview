package _10_com.interview.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/*
Given a directed graph G, what is the best way to go about finding a vertex v such that there is a path from v to every other vertex in G?
1: Fills all vertex in the graph to a stack in the depth first search order. Deck will contain elements in the reverse order 1->2->4->3->0
2: Create a new reverse graph by reversing the edges in the graph
3: DFS traversal of the reverse graph from the vertex on the top of the stack and populates visited Map
4: If visited Map does not contain any vertex in the reverse then it is not direct connected
 */

public class _21_DirectedGraphConnectivity {

    public boolean scc(_1_Graph<Integer> graph) {
        Deque<Vertex<Integer>> stack = new ArrayDeque<Vertex<Integer>>();
        Map<Vertex<Integer>, Boolean> visited = new HashMap<Vertex<Integer>, Boolean>();
        for (Vertex<Integer> vertex : graph.getAllVertex()) {
            if (visited.containsKey(vertex)) {
                continue;
            }
            //1: Fills all vertex in the graph to a stack in the depth first search order
            //1: Deck will contain elements in the reverse order 1->2->4->3->0
            DFSUtil(vertex, visited, stack);
        }

        System.out.println(stack);
        
        _1_Graph<Integer> reverseGraph = new _1_Graph<Integer>(true);
        Map<Long, Vertex<Integer>> vertexMap = new HashMap<Long, Vertex<Integer>>();
        // 2: Create a new reverse graph by reversing the edges in the graph
        for (Edge<Integer> edge : graph.getAllEdges()) {
            reverseGraph.addEdge(edge.getVertex2().getId(), edge.getVertex1()
                    .getId(), edge.getWeight());
        }
        //2a: Put all the vertex of the reverse graph in a vetexMap,
        // This is optional and it required only to locate a vertex in the stack front with the reverse graph
        for (Vertex<Integer> vertex : reverseGraph.getAllVertex()) {
            vertexMap.put(vertex.getId(), vertex);
        }
        
        visited.clear();
        Vertex<Integer> vertex = vertexMap.get(stack.poll().getId());
        System.out.println(vertex.getId());
        //3: TODO DFS traversal of the reverse graph and populates visited Map No while loop and done just once
        DFSUtil1(vertex, visited);

        //4: TODO If visited Map does not contain any vertex in the reverse then it is not direct connected
        for(Vertex<Integer> testVertex : reverseGraph.getAllVertex()){
            if(!visited.containsKey(testVertex)){
                return false;
            }
        }
        return true;
    }

    private void DFSUtil(Vertex<Integer> vertex,
            Map<Vertex<Integer>, Boolean> visited, Deque<Vertex<Integer>> stack) {
        visited.put(vertex, true);
        for (Vertex<Integer> v : vertex.getAdjacentVertexes()) {
            if (visited.containsKey(v)) {
                continue;
            }
            DFSUtil(v, visited, stack);
        }
        stack.offerFirst(vertex);
    }
    //3: TODO DFS traversal of the reverse graph and populates visited Map
    private void DFSUtil1(Vertex<Integer> vertex,
            Map<Vertex<Integer>, Boolean> visited) {
        visited.put(vertex, true);
        for (Vertex<Integer> v : vertex.getAdjacentVertexes()) {
            if (visited.containsKey(v)) {
                continue;
            }
            DFSUtil1(v, visited);
        }
    }

    public static void main(String args[]){
        _1_Graph<Integer> graph = new _1_Graph<Integer>(true);
        graph.addEdge(1, 0);
        graph.addEdge(2,1);
        graph.addEdge(0,2);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 2);
        
        _21_DirectedGraphConnectivity scc = new _21_DirectedGraphConnectivity();
        boolean result = scc.scc(graph);
        System.out.println(result);
    }
}
