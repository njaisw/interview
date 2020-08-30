package _10_com.interview.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Date 08/22/2015
 * @author Tushar Roy
 *
 * Find articulation points in connected undirected graph.
 * Articulation points are vertices such that removing any one of them disconnects the graph.
 *
 * We need to do DFS of this graph and keep visitedTime and lowTime for each vertex.
 * lowTime is keeps track of back edges.
 *
 * If any one of following condition meets then vertex is articulation point.
 *
 * 1) If vertex is root of DFS and has atlesat 2 independent children.(By independent it means they are
 * not connected to each other except via this vertex). This condition is needed because if we
 * started from corner vertex it will meet condition 2 but still is not an articulation point. To filter
 * out those vertices we need this condition.
 *
 * 2) It is not root of DFS and if visitedTime of vertex <= lowTime of any adjacent vertex then its articulation point.
 *
 * Time complexity is O(E + V)
 * Space complexity is O(V)
 *
 * References:
 * https://en.wikipedia.org/wiki/Biconnected_component
 * http://www.geeksforgeeks.org/articulation-points-or-cut-vertices-in-a-graph/
 */
public class _10_ArticulationPoint_3X<T> {

    private int time;

    public Set<Vertex<T>> findarticulationPoints(_1_Graph<T> graph) {
        time = 0;
        Set<Vertex<T>> visited = new HashSet<>();
        Set<Vertex<T>> articulationPoints = new HashSet<>();
        Vertex<T> startVertex = graph.getAllVertex().iterator().next();

        Map<Vertex<T>, Integer> visitedTime = new HashMap<>();
        Map<Vertex<T>, Integer> lowTime = new HashMap<>();
        Map<Vertex<T>, Vertex<T>> parent = new HashMap<>();

        DFS(visited,articulationPoints,startVertex, visitedTime, lowTime, parent);
        return articulationPoints;
    }

    private void DFS(Set<Vertex<T>> visited,
            Set<Vertex<T>> articulationPoints, Vertex<T> vertex,
            Map<Vertex<T>, Integer> discoveryTime,
            Map<Vertex<T>, Integer> lowTime, Map<Vertex<T>, Vertex<T>> parent) {
        visited.add(vertex);
        discoveryTime.put(vertex, time);
        lowTime.put(vertex, time);
        time++;
        int childCount =0;
        boolean isArticulationPoint = false;

        for(Vertex<T> child : vertex.getAdjacentVertexes()){
            //if child is same as parent then just ignore this vertex.
            if(child.equals(parent.get(vertex))) {
                continue;
            }
            //if child has not been visited then visit it.
            if(!visited.contains(child)) {
                parent.put(child, vertex);
                childCount++;
                DFS(visited, articulationPoints, child, discoveryTime, lowTime, parent);

                // a(1/1)->b(2/2)->c(3/3), here discovery of b (2) <= low of c (3), so b is an articulation point
                if(discoveryTime.get(vertex) <= lowTime.get(child)) {
                    isArticulationPoint = true;
                } else {
                    // Code will only return here when there is back edge and vertex is not articulation point
                    //below operation basically does lowTime[vertex] = min(lowTime[vertex], lowTime[child]);
                    lowTime.compute(vertex, (currentVertex, time) ->
                        Math.min(time, lowTime.get(child))
                    );
                }

            } else {
                //if child is already visited see if you can get better low time.
                // THIS HAPPENS when there is a back edge from vertex to child
                //below operation basically does lowTime[vertex] = min(lowTime[vertex], discoveryTime[child]);
                lowTime.compute(vertex, (currentVertex, time) ->
                                Math.min(time, discoveryTime.get(child))
                );
            }
        }

        //checks if either condition 1 or condition 2 meets). If yes then it is articulation point.
        if((parent.get(vertex) == null && childCount >= 2) || parent.get(vertex) != null && isArticulationPoint ) {
            articulationPoints.add(vertex);
        }
        
    }

    public static void main(String args[]){
        _1_Graph<Integer> graph = new _1_Graph<>(false);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 7);
        graph.addEdge(7, 5);
        graph.addEdge(6, 8);

        //bigger example
        /*
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(0, 4);
        graph.addEdge(4, 2);
        graph.addEdge(3, 5);
        graph.addEdge(4, 6);
        graph.addEdge(6, 3);
        graph.addEdge(6, 7);
        graph.addEdge(6, 8);
        graph.addEdge(7, 9);
        graph.addEdge(9, 10);
        graph.addEdge(8, 10);*/

        _10_ArticulationPoint_3X<Integer> ap = new _10_ArticulationPoint_3X<Integer>();
        Set<Vertex<Integer>> aPoints = ap.findarticulationPoints(graph);
        aPoints.forEach(point -> System.out.println(point));
    }
    
}
