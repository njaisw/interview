package _12_namrata.self.practice_done;

//Java program to solve nut and bolt problem using Quick Sort

public class NutsNBoltsProblem_IMP_3 {

	private void sortNutsandBolts(char[] nuts, char[] bolts, int low, int high) {
		if (low<high) {
			int pivotBolts = sort(nuts,low,high,bolts[high]);
			sort(bolts, low, high, nuts[pivotBolts]);
			sortNutsandBolts(nuts, bolts, low, pivotBolts-1);
			sortNutsandBolts(nuts, bolts, pivotBolts+1, high);
		}
	}

	private int sort(char[] input,int low, int high, char pivot) {

		while (low<high) {
			if (input[low]< pivot) {
				low++;
			}else if (input[high]>pivot) {
				high--;
			}else {
				char temp = input[low];
				input[low]=input[high];
				input[high]=temp;
			}

		}

		return high;
	}

	public static void main(String[] args) {
		NutsNBoltsProblem_IMP_3 nutsAndBolts = new NutsNBoltsProblem_IMP_3();
		char[] nuts= new char[] {'a', 'b', 'e', 'd', 'c', 'f'};
		char[] bolts= new char[] {'f', 'd', 'a', 'b', 'c', 'e'};
		nutsAndBolts.sortNutsandBolts(nuts, bolts, 0, 5);

		for (int i = 0; i < nuts.length; i++) {
			System.out.print(nuts[i]+" ");
		}

		System.out.println();

		for (int i = 0; i < bolts.length; i++) {
			System.out.print(bolts[i]+" ");
		}

	}

}