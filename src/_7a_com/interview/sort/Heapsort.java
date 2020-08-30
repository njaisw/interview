package _7a_com.interview.sort_done;

public class Heapsort {
	
	public void heapsort(int[] inputs) {
	
		buildheap(inputs);
			
		for (int i = inputs.length-1; i>0 ; i--) {
			int temp =inputs[i];
			inputs[i]=inputs[0];
			inputs[0]=temp;
			percolateDown(inputs, 0, i-1);
			
		}
		
		for (int i = 0; i < inputs.length; i++) {
			System.out.print(inputs[i]);
			}
		
	}
	
	
	private void buildheap(int[] inputs) {
		
		int firstParent=(inputs.length-1)/2;
		
		for (int i=firstParent; i>=0;i--) {
			percolateDown(inputs, i, inputs.length-1);
		}
		
	}


	private void percolateDown(int[] inputs, int x, int end) {
		if(x>end) return;

		int rightchild= 2*x+1;
		int leftchild=2*x+2;
		int max=x;
		if (leftchild<=end && inputs[leftchild]>inputs[max]) {
			max=leftchild;
		}
		if (rightchild<=end &&inputs[rightchild]>inputs[max]) {
			max=rightchild;
		}	
		
		if(max!=x) {
			int temp= inputs[x];
			inputs[x]=inputs[max];
			inputs[max]=temp;
			//TODO check the logic here
			percolateDown(inputs, max, end);
		}
	}
	
	public static void main(String[] args) {
		Heapsort heapsort= new Heapsort();
		heapsort.heapsort(new int[] {5,6,7,1,8, 9});
	}
	


}
