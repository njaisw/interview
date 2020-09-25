package _13_com.ds.multithreaded;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//TODO ExcutorService= incomingQ+workerthread
//TODO CompletionService=incomingQ+workerthread+outgoingQ

public class _11_ThreadPoolExample {

	public static ExecutorService threadPool = Executors.newFixedThreadPool(5);

	public void doWork() throws Exception {
		CompletionService<String> completionService = new ExecutorCompletionService<String>(threadPool);
		List<Future<String>> futureList = new ArrayList<Future<String>>();
		for (int i = 0; i < 20; i++) {
			futureList.add(completionService.submit(new MyCallable(i)));
		}
		for (int i = 0; i < 20; i++) {
			Future<String> future = completionService.take();
			System.out.println(future.get());
		}
	}

	public static void main(String args[]) throws Exception {
		_11_ThreadPoolExample tpe = new _11_ThreadPoolExample();
		tpe.doWork();
	}

}

class MyCallable implements Callable<String> {

	private int index = 0;

	MyCallable(int i) {
		index = i;
	}

	@Override
	public String call() throws Exception {
		int sleepTime = 5000 + 1;
		try {
			System.out.println("Before sleep " + index);
			Thread.sleep(sleepTime);
			System.out.println("After sleep " + index);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Done" + index;
	}

}
