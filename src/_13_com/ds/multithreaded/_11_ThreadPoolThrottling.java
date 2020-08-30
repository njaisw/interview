package _13_com.ds.multithreaded;

import java.util.LinkedList;
import java.util.Queue;

class ThreadPool {

	public Thread kickstartNewThread(Runnable runnable) {
		Thread t = new Thread(runnable);
		t.start();
		return t;
	}
}

/**
 * Facebook interview question Implement a non block run which takes as many
 * runnables as given but only runs a specified number of threads. You can also
 * update maxSize in between which will change number of threads executing
 * http://tutorials.jenkov.com/java-concurrency/thread-pools.html
 */
public class ThreadPoolThrottling {

	private int maxSize = 0;
	ThreadPool threadPool;

	private int currentSize = 0;
	private Queue<Runnable> linkedlist = new LinkedList<Runnable>();
	private boolean isExecuting = false;
	private Object monitor = new Object();

	public ThreadPoolThrottling(int size, ThreadPool threadPool) {
		maxSize = size;
		this.threadPool = threadPool;
	}

	public void setMax(int size) {
		System.out.print("Setting max size " + size);
		if (maxSize == 0) {
			maxSize = size;
			execute();
		} else {
			maxSize = size;
		}
	}

	public void submit(Runnable task) {
		synchronized (monitor) {
			linkedlist.offer(task);
			execute();
		}
	}

	private void execute() {
		if (!isExecuting) {
			isExecuting = true;
			ExecutingRunnable runnable = new ExecutingRunnable();
			threadPool.kickstartNewThread(runnable);
		}
	}

	class ExecutingRunnable implements Runnable {
		@Override
		public void run() {
			while (true) {
				synchronized (monitor) {
					if (maxSize == 0) {
						isExecuting = false;
						break;
					}
				}
				while (linkedlist.size() > 0) {
					synchronized (monitor) {
						if (maxSize == 0) {
							isExecuting = false;
							break;
						}
					}
					if (currentSize < maxSize) {
						currentSize++;
						Runnable userRunnable = linkedlist.poll();
						// TODO Starting Thread is a wrapper thread so that it can decrement runnable
						WorkerThread worker = new WorkerThread(userRunnable);
						threadPool.kickstartNewThread(worker);
					}
				}
				synchronized (monitor) {
					if (linkedlist.size() == 0) {
						isExecuting = false;
						break;
					}
				}
//              System.out.println("Looping");
			}
		}

	}

	class WorkerThread implements Runnable {
		private Runnable r;

		WorkerThread(Runnable r) {
			this.r = r;
		}

		@Override
		public void run() {
			r.run();
			currentSize--;
		}
	}

	public static void main(String args[]) throws InterruptedException {
		ThreadPool threadPool = new ThreadPool();
		ThreadPoolThrottling impl = new ThreadPoolThrottling(4, threadPool);
		int i;
		for (i = 0; i < 10; i++) {
			MyTask runnable = new MyTask(i);
			impl.submit(runnable);
		}
		Thread.sleep(5000);
		impl.setMax(0);
		Thread.sleep(10000);
		impl.setMax(6);
		for (; i < 15; i++) {
			MyTask runnable = new MyTask(i);
			impl.submit(runnable);
		}
	}
}

class MyTask implements Runnable {
	int index = 0;

	MyTask(int index) {
		this.index = index;
	}

	@Override
	public void run() {
		System.out.println("Start of index " + index);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("Exception " + index + " " + e);
		}
		System.out.println("End of index " + index);
	}

}
