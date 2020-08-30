package _6_com.ds.stackqueue;

public class CircularQueue_IMP_2<T> {

	private int QUEUE_LENGTH;
	private T data[] = null;

	@SuppressWarnings("unchecked")
	public CircularQueue_IMP_2(int size) {
		this.QUEUE_LENGTH = size;
		data = (T[]) new Object[QUEUE_LENGTH];
	}

	private int front = -1;
	private int rear = -1;

	// add
	public void offer(T t) {
		if (front == -1) {
			data[0] = t;
			front = 0;
			rear = 0;
		} else if (front == (rear + 1) % QUEUE_LENGTH) {
			// If queue is full
			throw new IllegalArgumentException();
		} else {
			rear = (rear + 1) % QUEUE_LENGTH;
			data[rear] = t;
		}
	}

	public T top() {
		if (front == -1) {
			throw new IllegalArgumentException();
		} else {
			return data[front];
		}
	}

	public T poll() {
		if (front == -1) {
			throw new IllegalArgumentException();
		} else if (front == rear) {
			//Only one element
			T t = data[front];
			front = -1;
			rear = -1;
			return t;
		} else {
			T t = data[front];
			front = (front + 1) % QUEUE_LENGTH;
			return t;
		}

	}

	public boolean isEmpty() {
		if (front == -1) {
			return true;
		}
		return false;
	}

	public boolean isFull() {
		if (front == (rear + 1) % QUEUE_LENGTH) {
			return true;
		}
		return false;
	}

	public static void main(String args[]) {
		CircularQueue_IMP_2<Integer> circularQueue = new CircularQueue_IMP_2<Integer>(5);
		circularQueue.offer(1);
		circularQueue.offer(2);
		circularQueue.offer(3);
		System.out.println(circularQueue.poll());
		circularQueue.offer(4);
		circularQueue.offer(5);
		System.out.print(circularQueue.isFull());
		circularQueue.offer(6);
		System.out.print(circularQueue.isFull());

		while (!circularQueue.isEmpty()) {
			System.out.println(circularQueue.poll());
		}
	}
}
