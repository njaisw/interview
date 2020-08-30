package _10_com.interview.graph;

import java.util.*;
//https://www.youtube.com/watch?v=rG2-_lgcZzo
//https://leetcode.com/problems/course-schedule/
//https://github.com/Nideesh1/Algo/blob/master/leetcode/L_207.java

/**
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0. So it is possible.
 *
 * Example 2:
 *
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0, and to take course 0 you should
 *              also have finished course 1. So it is impossible.
 */
public class X_12ab_CourseSchedule {

    //TODO If there is cycle then they cannot be finished
    int n;
    int[] indegree;
    Map<Integer, List<Integer>> adj = new HashMap<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        n = numCourses;
        indegree = new int[n];
        for(int[] pr : prerequisites){
            List<Integer> l =  adj.getOrDefault(pr[1], new ArrayList<>());
            // TODO [1,0] means
            l.add(pr[0]); indegree[pr[0]]++;
            //Not required
            adj.put(pr[1], l);
        }
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        //TODO Put all the elements with indegree 0
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0) q.add(i);
        }
        while(!q.isEmpty()){
            int cur = q.poll();
            if(indegree[cur] == 0)count++;
            if(!adj.containsKey(cur)) continue;
            for(int nei : adj.get(cur)){
                indegree[nei]--;
                if(indegree[nei]== 0) q.add(nei);
            }

        }

        return count == n;
    }

}
