package _10_com.interview.graph;

import java.util.*;

//https://leetcode.com/problems/course-schedule/

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

class _31a_CourseSchedule {

    // TODO Same as Valid tree, indgree is  used to find the cycle in the graph
        //TODO idea is to find cycle in graph
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            if(prerequisites == null || prerequisites.length == 0) return true;

            int[] inDegree = new int[numCourses];
            //TODO adjacency matrix
            Map<Integer, List<Integer>> graph = new HashMap<>();

            for(int v = 0; v < prerequisites.length; v++){
                //TODO [1,0] means 1->0, 0th index is the parent and 1st index is the child, 0th column
                //todo check lamda below
                graph.computeIfAbsent(prerequisites[v][0], value -> new ArrayList()).add(prerequisites[v][1]);
                //TODO increment the indegree of the 1st index
                inDegree[prerequisites[v][1]]++;
            }
            //TODO Queue with Linkedlist
            Queue<Integer> queue = new LinkedList<>();
            for(int in = 0; in < inDegree.length; in++){
                //TODO Add all the nodes with indegre 0 in the queue
                if(inDegree[in] == 0){
                    queue.offer(in);
                }
            }

            int coursesPossible = 0;
            while(!queue.isEmpty()){
                int course = queue.poll();
                //TODO increment counter when there is a poll from queue
                coursesPossible++;
                if(graph.containsKey(course)){
                    //TODO for each child of the parent-course
                    for(int i = 0; i < graph.get(course).size(); i++){
                        int prerequisite = graph.get(course).get(i);
                        //TODO decrement the indegree of the child
                        //TODO if the indegree is 0 then add that node to queue
                        if(--inDegree[prerequisite] == 0){
                            queue.offer(prerequisite);
                        }
                    }
                }
            }
            //TODO remember the condition
            return coursesPossible == numCourses;
        }
    }
