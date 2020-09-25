package _13_com.ds.multithreaded;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class _9_PrintSorted {

	private static class SequencePrinter implements Runnable {

		private static final int TOTAL_THREADS = 4;

        //Instance variable
		private int threadNum;

		//TODO Static and volatile - as only one thread is modifying it at a time
		private static volatile int currentRunningThread = 0;

		//Instance variable
		private int[] inputs;

        //TODO Instance and volatile variable - as only one thread is modifying it at a time- why volatile here?
		private volatile int index = 0;

        //Static variable
		private static Object lock = new Object();

		public SequencePrinter(int threadnum, int[] input) {
			this.threadNum = threadnum;
			this.inputs = input;
		}

		@Override
		public void run() {
			//TODO  Condition check inside while loop
			while (true) {
				try {
					synchronized (lock) {
						if (currentRunningThread % TOTAL_THREADS == threadNum) {
							System.out.println(inputs[index++]);
							// System.out.println(index);
							currentRunningThread++;
							lock.notifyAll();
						} else {
							Thread.sleep(100);
							lock.wait();
						}
                        //TODO if it is last thread and input is equal size of the array
						if (threadNum == TOTAL_THREADS - 1 && index == inputs.length) {
							break;
						}
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		SequencePrinter sequencePrinter1 = new SequencePrinter(0, new int[] { 0, 4, 8, 12 });
		SequencePrinter sequencePrinter2 = new SequencePrinter(1, new int[] { 1, 5, 9, 13 });
		SequencePrinter sequencePrinter3 = new SequencePrinter(2, new int[] { 2, 6, 10, 14 });
		SequencePrinter sequencePrinter4 = new SequencePrinter(3, new int[] { 3, 7, 11, 15 });

		ExecutorService executorService = Executors.newFixedThreadPool(4);
		executorService.submit(sequencePrinter4);
		executorService.submit(sequencePrinter2);
		executorService.submit(sequencePrinter1);
		executorService.submit(sequencePrinter3);

		executorService.shutdown();

	}

}
