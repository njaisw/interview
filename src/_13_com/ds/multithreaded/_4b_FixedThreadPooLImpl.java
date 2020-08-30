package _13_com.ds.multithreaded;

import java.util.concurrent.LinkedBlockingQueue;

public class _4b_FixedThreadPooLImpl {
	private final PoolWorker[] threads;
	private final LinkedBlockingQueue<Runnable> queue;

	public _4b_FixedThreadPooLImpl(int nThreads) {
		queue = new LinkedBlockingQueue<>();
		threads = new PoolWorker[nThreads];

		for (int i = 0; i < nThreads; i++) {
			threads[i] = new PoolWorker();
			threads[i].start();
		}
	}

	public void execute(Runnable task) {
		synchronized (queue) {
			queue.add(task);
			queue.notify();
		}
	}

	private class PoolWorker extends Thread {

		public void run() {
			Runnable task;

			while (true) {
				//TODO synchornozed queue as wait and notify works only if it is being called in the context of the object
				synchronized (queue) {
					while (queue.isEmpty()) {
						try {
							queue.wait();
						} catch (InterruptedException e) {
							System.out.println("An error occurred while queue is waiting: " + e.getMessage());
						}
					}
					task = queue.poll();
				}

				// TODO If we don't catch RuntimeException,
				// TODO the pool could leak threads
				try {
					task.run();
				} catch (RuntimeException e) {
					System.out.println("Thread pool is interrupted due to an issue: " + e.getMessage());
				}
			}
		}
	}
}