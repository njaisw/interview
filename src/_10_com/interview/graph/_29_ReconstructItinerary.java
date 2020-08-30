package _10_com.interview.graph;

import java.util.*;

/**
 *
 * https://happygirlzt.com/codelist.html
 * https://leetcode.com/problems/reconstruct-itinerary/
 *
 *
 *
 * Example 1:
 *
 * Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 *
 * Example 2:
 *
 * Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
 *              But it is larger in lexical order.
 */

public class _29_ReconstructItinerary {

    public List<String> findItinerary(String[][] tickets) {
        // TODO Priority Queue instead of list for adjacents vertex to get the vertex in lexographical order of string
        Map<String, PriorityQueue<String>> flightsMap = new HashMap<>();
        LinkedList<String> res = new LinkedList<>();
        // TODO reads entire row
        for (String[] ticket : tickets) {
            //TODO putIFAbsent
            flightsMap.putIfAbsent(ticket[0], new PriorityQueue<>());
            //TODO insert the adjacent vertex
            flightsMap.get(ticket[0]).add(ticket[1]);
        }

        dfs("JFK", flightsMap, res);
        return res;
    }

    public void dfs(String dep, Map<String, PriorityQueue<String>> flightsMap, LinkedList<String> res) {
        //TODO VERY IMPORTANT that it is PQ, get adjacent vertex from PQ
        PriorityQueue<String> arrivals = flightsMap.get(dep);
        //TODO DFS all arrivals
        while (arrivals != null && !arrivals.isEmpty()) {
            dfs(arrivals.poll(), flightsMap, res);
        }
         //TODO remember the adding the depature
        res.addFirst(dep);
    }

    public static void main(String[] args) {
        _29_ReconstructItinerary reconstructItinerary = new _29_ReconstructItinerary();
        List<String> result= reconstructItinerary.findItinerary(new String[][]{{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}});

        result.stream().forEach(System.out::println);

    }
}