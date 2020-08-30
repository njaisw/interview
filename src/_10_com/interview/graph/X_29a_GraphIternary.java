package _10_com.interview.graph;

import java.util.*;

//https://leetcode.com/problems/reconstruct-itinerary/

/**
 * input - [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
 * Output - ["JFK","MUC","LHR","SFO","SJC"]
 */

public class X_29a_GraphIternary {

        public List<String> findItinerary(List<List<String>> tickets) {
            List<String> itinerary = new ArrayList<>();

            HashMap<String, PriorityQueue<String>> graph = new HashMap<>();

            for (List<String> ticket : tickets) {
                String origin = ticket.get(0);
                String destination = ticket.get(1);
                if (graph.get(origin) == null) {
                    graph.put(origin, new PriorityQueue<String>());
                }
                graph.get(origin).offer(destination);
            }

            dfs(graph, itinerary, "JFK");

            //TODO reverse the list using Collections
            Collections.reverse(itinerary);
            return itinerary;
        }

        private void dfs(HashMap<String, PriorityQueue<String>> graph, List<String> itinerary, String origin) {
            PriorityQueue<String> destinations = graph.get(origin);
            if (destinations != null) {
                while (!destinations.isEmpty()) {
                    dfs(graph, itinerary, destinations.poll());
                }
            }
            itinerary.add(origin);
        }

}
