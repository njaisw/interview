package _10_com.interview.graph;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/network-delay-time/
 *
 * Input: times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
 * Output: 2
 */
public class NetworkDelay {

    public int networkDelayTime(int[][] times, int N, int K) {
        int[] leastTimes = new int[N + 1];
        Arrays.fill(leastTimes, Integer.MAX_VALUE);
        leastTimes[K] = 0;

        for (int i = 0; i < N; i++) { // bellman ford shortest path algorithm
            for (int[] time : times) {
                int u = time[0], v = time[1], t = time[2];
                if (leastTimes[u] != Integer.MAX_VALUE && leastTimes[v] > leastTimes[u] + t) {
                    leastTimes[v] = leastTimes[u] + t;
                }
            }
        }

        int delay = 0;
        for (int i = 1; i <= N; i++) {
            if (leastTimes[i] == Integer.MAX_VALUE) return -1;
            if (delay < leastTimes[i]) delay = leastTimes[i];
        }
        return delay;
    }
}
