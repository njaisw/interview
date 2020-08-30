package _13_com.ds.multithreaded;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class _4a_FixedThreadPoolExample1 {

	private final PoolWorker1[] threads;
	//TODO BlockingQueue takes Object of type Runnable
	private final LinkedBlockingQueue<Runnable> queue;
	private final Lock lock;
	private final Condition nonEmpty;

	public _4a_FixedThreadPoolExample1(int nThreads) {
		queue = new LinkedBlockingQueue<>();
		threads = new PoolWorker1[nThreads];
		lock = new ReentrantLock();
		nonEmpty = lock.newCondition();

		for (int i = 0; i < nThreads; i++) {
			threads[i] = new PoolWorker1();
			threads[i].start();
		}
	}

	public void execute(Runnable task) {
		try {
			lock.lockInterruptibly();
			queue.add(task);
			nonEmpty.signal();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	private class PoolWorker1 extends Thread {
		public void run() {
			Runnable task = null;
           //TODO Thread run in while true loop
			while (true) {
				try {
					lock.lockInterruptibly();
					//TODO while again second time
					while (queue.isEmpty()) {
						nonEmpty.await();
					}
					task = queue.poll();
				} catch (InterruptedException e) {
					System.out.println("An error occurred while queue is waiting: " + e.getMessage());
				}finally {
					lock.unlock();
				}
				// TODO If we don't catch RuntimeException,
				// TODO the pool could leak threads
				//TODO lock is released before the run
				try {
					task.run();
				} catch (RuntimeException e) {
					System.out.println("Thread pool is interrupted due to an issue: " + e.getMessage());
				}
			}
		}
	}

}
