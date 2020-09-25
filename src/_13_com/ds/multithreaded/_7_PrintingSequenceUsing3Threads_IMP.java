package _13_com.ds.multithreaded;

/*
 You are given 3 threads. You need to print sequence using these 3 threads.You need to print in natural order up to MAX.

For example:
Let�s say you have 3 threads. T1,T2 and T3.
If MAX is 10, you need to print:
T1 1
T2 2
T3 3
T1 4
T2 5
T3 6
T1 7
T2 8
T3 9
T1 10

Solution: We will use concept of remainder here.

    If number%3==1 then T1 will print the number and increment it else will go in the wait state.
    If number%3==2 then T2 will print the number and increment it else will go in the wait state.
    If number%3==0 then T3 will print the number and increment it else will go in the wait state.

 */
// http://javabypatel.blogspot.com/2017/06/wait-notify-notifyall-example-in-java-thread.html
//TODO implements Runnable
public class _7_PrintingSequenceUsing3Threads_IMP implements Runnable {

	private static final int PRINT_NUMBERS_UPTO = 10;

	//TODO 1: its a static
	private static int number = 1;

	private int remainder;

	//TODO 2: Static lock
	private static Object lock = new Object();

	_7_PrintingSequenceUsing3Threads_IMP(int remainder) {
		this.remainder = remainder;
	}

	@Override
	public void run() {
		while (number < PRINT_NUMBERS_UPTO - 1) {

			//TODO Always synchronize lock
			synchronized (lock) {
				//TODO condition should be always in while
				while (number % 3 != remainder) { // wait for numbers other than remainder
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " " + number);
				number++;
				lock.notifyAll();
			}
		}
	}

	public static void main(String[] args) {

		_7_PrintingSequenceUsing3Threads_IMP runnable1 = new _7_PrintingSequenceUsing3Threads_IMP(1);
		_7_PrintingSequenceUsing3Threads_IMP runnable2 = new _7_PrintingSequenceUsing3Threads_IMP(2);
		_7_PrintingSequenceUsing3Threads_IMP runnable3 = new _7_PrintingSequenceUsing3Threads_IMP(0);

		Thread t1 = new Thread(runnable1, "T1");
		Thread t2 = new Thread(runnable2, "T2");
		Thread t3 = new Thread(runnable3, "T3");

		t1.start();
		t2.start();
		t3.start();
	}
}