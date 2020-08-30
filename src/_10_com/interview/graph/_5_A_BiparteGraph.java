package _10_com.interview.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 http://www.geeksforgeeks.org/bipartite-graph/
 Includes both DFS and BFS method
 */
public class _5_A_BiparteGraph {
    
    public boolean isBiparte(_1_Graph<Integer> graph){
        
        Set<Vertex<Integer>> redSet = new HashSet<Vertex<Integer>>();
        Set<Vertex<Integer>> blueSet = new HashSet<Vertex<Integer>>();

        //TODO Uses BFS not DFS
        Queue<Vertex<Integer>> queue = new LinkedList<Vertex<Integer>>();

        //TODO remember the for loop while traversing
        for(Vertex<Integer> vertex : graph.getAllVertex()){
            //TODO Remember the condition
            if(!redSet.contains(vertex) && !blueSet.contains(vertex)){
                //TODO USES QUEUE
                queue.add(vertex);
                redSet.add(vertex);
                while(!queue.isEmpty()){
                    vertex = queue.poll();
                    for(Vertex<Integer> adj : vertex.getAdjacentVertexes()){
                        if(redSet.contains(vertex)){
                            if(redSet.contains(adj)){
                                //condition 1
                                return false;
                            }if(blueSet.contains(adj)){
                                //codition 2
                                continue;
                            }
                            //condition 3
                            blueSet.add(adj);
                        }
                        else if(blueSet.contains(vertex)){
                            if(blueSet.contains(adj)){
                                return false;
                            }if(redSet.contains(adj)){
                                continue;
                            }
                            redSet.add(adj);
                        }
                        //Adding the element to the queue
                        queue.add(adj);
                    }
                }
            }
        }
        System.out.println(redSet);
        System.out.println(blueSet);
        return true;
    }

    @Deprecated
    public boolean isBiparteDFS(_1_Graph<Integer> graph){
        Set<Vertex<Integer>> redSet = new HashSet<Vertex<Integer>>();
        Set<Vertex<Integer>> blueSet = new HashSet<Vertex<Integer>>();
        for(Vertex<Integer> vertex : graph.getAllVertex()){
            if(redSet.contains(vertex) || blueSet.contains(vertex)){
                continue;
            }
            boolean flag = isBiparteDFS(vertex, redSet, blueSet, true);
            if(!flag){
                return false;
            }
        }
        return true;
    }
    @Deprecated
    private boolean isBiparteDFS(Vertex<Integer> vertex, Set<Vertex<Integer>> redSet, Set<Vertex<Integer>> blueSet,boolean wasRed){
    
        if(wasRed){
            if(redSet.contains(vertex)){
                return false;
            }
            else if(blueSet.contains(vertex)){
                return true;
            }
            blueSet.add(vertex);
        }

        else if(!wasRed){
            if(blueSet.contains(vertex)){
                return false;
            }
            if(redSet.contains(vertex)){
                return true;
            }
            redSet.add(vertex);
        }
        
        for(Vertex<Integer> adj : vertex.getAdjacentVertexes()){
            boolean flag = isBiparteDFS(adj, redSet, blueSet, !wasRed);
            if(!flag){
                return false;
            }
        }
        return true;
        
    }
    
    public static void main(String argsp[]){
        _1_Graph<Integer> graph = new _1_Graph<Integer>(false);
        graph.addEdge(1, 2);
        graph.addEdge(2, 5);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 6);
        graph.addEdge(5, 6);
        graph.addEdge(7, 9);
        graph.addEdge(7, 8);
        _5_A_BiparteGraph bi = new _5_A_BiparteGraph();
        boolean result = bi.isBiparteDFS(graph);
        System.out.print(result);
    }
}
