package _10_com.interview.graph;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a directed graph clone it in O(n) time where n is total number of edges
 * Test cases
 * _1_Graph is directed/non directed
 * _1_Graph has 0 edges
 * _1_Graph has cycle
 * _1_Graph is linear
 * _1_Graph is dense
 * _1_Graph is sparse
 */
public class _28_CloneDirectedGraph<T> {

    public _1_Graph<T> clone(_1_Graph<T> graph){
        if(graph == null){
            return null;
        }
        if(!graph.isDirected){
            throw new IllegalArgumentException("Cloning non directed graph");
        }
        if(graph.getAllVertex().size() == 0){
            throw new IllegalArgumentException("No vertex in the graph");
        }
        //Map contains original vertex and cloned vertex
        Map<Vertex<T>,Vertex<T>> cloneMap = new HashMap<Vertex<T>,Vertex<T>>();
        for(Vertex<T> vertex : graph.getAllVertex()){
            clone(vertex,cloneMap);
        }
        _1_Graph<T> clonedGraph = new _1_Graph<>(true);
        for(Vertex<T> vertex : cloneMap.values()){
            clonedGraph.addVertex(vertex);
        }
        return clonedGraph;
    }
    
    private void clone(Vertex<T> origVertex,Map<Vertex<T>,Vertex<T>> cloneMap){
        Vertex<T> cloneVertex = null;
        if(cloneMap.containsKey(origVertex)){
            cloneVertex = cloneMap.get(origVertex);
        }else{
            cloneVertex = new Vertex<T>(origVertex.getId()*10);
            cloneMap.put(origVertex, cloneVertex);
        }
        for(Edge<T> edge : origVertex.getEdges()){
            if(edge.getVertex1().equals(origVertex)){
                Vertex<T> adjVertex = edge.getVertex2();
                updateMap(cloneMap,cloneVertex,adjVertex,edge);
            }else{
                Vertex<T> adjVertex = edge.getVertex1();
                updateMap(cloneMap,cloneVertex,adjVertex,edge);
            }
        }
    }
    
    private void updateMap(Map<Vertex<T>,Vertex<T>> cloneMap, Vertex<T> cloneVertex, Vertex<T> adjVertex, Edge<T> edge){
        if(cloneMap.containsKey(adjVertex)){
            Vertex<T> adjVertexClone = cloneMap.get(adjVertex);
            Edge<T> newEdge = new Edge<T>(cloneVertex, adjVertexClone, edge.isDirected(), edge.getWeight());
            cloneVertex.addAdjacentVertex(newEdge, adjVertexClone);
        }else{
            Vertex<T> adjVertexClone = new Vertex<T>(adjVertex.getId());
            cloneMap.put(adjVertex, adjVertexClone);
            Edge<T> newEdge = new Edge<T>(cloneVertex, adjVertexClone, edge.isDirected(), edge.getWeight());
            cloneVertex.addAdjacentVertex(newEdge, adjVertexClone);
        }
    }
    
    public static void main(String args[]){
        _1_Graph<Integer> graph = new _1_Graph<Integer>(true);
        graph.addEdge(0, 3);
        graph.addEdge(0, 2);
        graph.addEdge(0, 4);
        graph.addEdge(3, 2);
        graph.addEdge(2, 0);
        graph.addEdge(4, 3);
        graph.addEdge(4, 1);
        graph.addEdge(1, 2);
        
        _28_CloneDirectedGraph<Integer> cg = new _28_CloneDirectedGraph<>();
        _1_Graph<Integer> clonedGraph = cg.clone(graph);
        System.out.println(clonedGraph);
   }
}
