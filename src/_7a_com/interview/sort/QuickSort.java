package _7a_com.interview.sort;

public class QuickSort {

	private void swap(int A[], int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	private int split1(int A[], int low, int high) {

		int pivot = low;
		int i = low + 1;
		int j = high;
		while (i <= j) {

			if (A[i] <= A[pivot]) {
				i++;
				continue;
			}
			if (A[j] > A[pivot]) {
				j--;
				continue;
			}
			//why i++ swap
			swap(A, i++, j--);
		}
		//todo check the logic here, pivot is swapped with j, pivot = 9 and j=8 then swap them, else return pivot
		if (A[pivot] > A[j]) {
			swap(A, pivot, j);
			return j;
		}
		// todo check the logic here
		return pivot;

	}

	public void sort(int A[], int low, int high) {
		if (low >= high) {
			return;
		}
		int pos = split1(A, low, high);
		sort(A, low, pos - 1);
		sort(A, pos + 1, high);
	}

	private void printArray(int arr[]) {
		for (int a : arr) {
			System.out.println(a);
		}
	}

	public static void main(String args[]) {
		QuickSort qs = new QuickSort();
		int A[] = { 11, 19, 0, -1, 5, 6, 16, -3, 6, 0, 14, 18, 7, 21, 18, -6, -8 };
		qs.sort(A, 0, A.length - 1);
		qs.printArray(A);

	}
}
