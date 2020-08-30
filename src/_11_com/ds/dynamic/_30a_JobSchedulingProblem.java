package _11_com.ds.dynamic;

import java.util.Arrays;
import java.util.Comparator;

/*
 * Given an array of jobs where every job has a deadline and associated profit if the job is finished before the deadline. 
 * It is also given that every job takes single unit of time, so the minimum possible deadline for any job is 1. 
 * How to maximize total profit if only one job can be scheduled at a time.

Examples:

Input: Four Jobs with following deadlines and profits
  JobID    Deadline      Profit
    a        4            20   
    b        1            10
    c        1            40  
    d        1            30
Output: Following is maximum profit sequence of jobs
        c, a   


Input:  Five Jobs with following deadlines and profits
   JobID     Deadline     Profit
     a         2           100
     b         1           19
     c         2           27
     d         1           25
     e         3           15
Output: Following is maximum profit sequence of jobs
        c, a, e

 */

public class _30a_JobSchedulingProblem {

	static class Job {
		char id; // Job Id
		int dead; // Deadline of job
		int profit; // Profit if job is over before or on deadline

		public Job(char id, int dead, int profit) {
			this.id = id;
			this.dead = dead;
			this.profit = profit;
		}
	};

	// Returns minimum number of platforms reqquired
	static void printJobScheduling(Job arr[], int n) {
		// Sort all jobs according to decreasing order of prfit
		Arrays.sort(arr, new Comparator<Job>() {
			@Override
			public int compare(Job o1, Job o2) {
				return (o2.profit - o1.profit);
			}
		});
		int[] results = new int[n]; // To store result (Sequence of jobs)
		boolean[] slot = new boolean[n]; // To keep track of free time slots

		// Initialize all slots to be free
		for (int i = 0; i < n; i++)
			slot[i] = false;

		for (int i = 0; i < n; i++) {
			// Find a free slot (Note that we start from the last possible slot )
			for (int j = Math.min(n, arr[i].dead) - 1; j >= 0; j--) {
				// Free slot found
				if (slot[j] == false) {
					results[j] = i; // Add this job to result
					slot[j] = true; // Make this slot occupied
					break;
				}
			}
		}
		for (int i = 0; i < n; i++)
			if (slot[i])
				System.out.println(arr[results[i]].id);
	}

	public static void main(String[] args) {
		Job arr[] = { new Job('a', 2, 100), new Job('b', 1, 19), new Job('c', 2, 27), new Job('d', 1, 25),
				new Job('e', 3, 15) };
		printJobScheduling(arr, arr.length);
	}
}