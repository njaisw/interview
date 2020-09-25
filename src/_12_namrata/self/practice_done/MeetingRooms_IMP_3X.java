package _12_namrata.self.practice_done;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Date 05/01/2016
 * @author Tushar Roy
 *
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * find the minimum number of conference rooms required.
 *
 *
 * input = [(0,30), (5,10), (15,20)]
 * output = 2
 *
 * Both methods have time comlexity of nlogn
 * Method 1 has space complexity of O(1)
 * 
 * https://leetcode.com/problems/meeting-rooms-ii/
 */
public class MeetingRooms_IMP_3X {

    public static class Interval {
          int start;
          int end;
          Interval() { start = 0; end = 0; }
          Interval(int s, int e) { start = s; end = e; }
    }

    @Deprecated
    public int minMeetingRooms1(Interval[] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }

        //TODO sort the start time
        Arrays.sort(start);

        //TODO sort the end time
        Arrays.sort(end);

        int j = 0;
        int rooms = 0;
        //TODO it iterates over the lenth of the start
        for (int i = 0; i < start.length; i++) {
            // TODO start(i) <end(j) then increment rooms and i
            if (start[i] < end[j]) {
                rooms++;
            } else {
                //TODO else increment i and j both
                j++;
            }
        }
        return rooms;
    }

    public int minMeetingRooms(Interval[] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        //[(0,30), (5,10), (15,20)]
        //TODO LEARN
        Arrays.sort(intervals, (a, b) ->  a.start - b.start);
        //TODO Stores the min end time
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Interval interval: intervals) {
            if(!pq.isEmpty()&& pq.peek()<=interval.start)
                pq.poll();
            pq.offer(interval.end);
        }
        return pq.size();
    }
}
