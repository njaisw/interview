package _10_com.interview.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
https://www.youtube.com/watch?v=xDkaPPso9EA
 */

public class _24_HamiltonianCycle<T> {

    public boolean getHamiltonianCycle(_1_Graph<T> graph, List<Vertex<T>> result){
        
        Vertex<T> startVertex = graph.getAllVertex().iterator().next();
        Set<Vertex<T>> visited = new HashSet<Vertex<T>>();
        return hamiltonianUtil(startVertex,startVertex,result,visited,graph.getAllVertex().size());     
        
    }
    
    private boolean hamiltonianUtil(Vertex<T> startVertex, Vertex<T> currentVertex
            , List<Vertex<T>> result, Set<Vertex<T>> visited, int totalVertex){
        visited.add(currentVertex);
        result.add(currentVertex);
        
        for(Vertex<T> child : currentVertex.getAdjacentVertexes()){
            //TODO check the condition is within the child
            if(startVertex.equals(child) && totalVertex == result.size()){
                result.add(startVertex);
                return true;
            }
            //TODO compare visited with child, not startvertex
            if(!visited.contains(child)){
                boolean isHamil = hamiltonianUtil(startVertex,child,result,visited,totalVertex);
                if(isHamil){
                    return true;
                }
            }
        }
        result.remove(result.size()-1);
        // TODO Visited is removed once all the children are visted so that it can be visited once again from other nodes
        visited.remove(currentVertex);
        return false;
    }
    
    public static void main(String args[]){
        
        _1_Graph<Integer> graph = new _1_Graph<Integer>(false);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 5);
        graph.addEdge(5, 2);
        graph.addEdge(2, 4);
        graph.addEdge(4, 1);
        graph.addEdge(4, 5);
        
        _24_HamiltonianCycle<Integer> hamil = new _24_HamiltonianCycle<Integer>();
        List<Vertex<Integer>> result = new ArrayList<Vertex<Integer>>();
        boolean isHamiltonian = hamil.getHamiltonianCycle(graph, result);
        System.out.println(isHamiltonian);
        if(isHamiltonian){
            System.out.print(result);
        }
        
    }
}
