package _12_namrata.self.practice_3;

import java.util.Arrays;

public class Sort012 {

	private void sort012(int[] inputs) {

		int zero = 0;
		int one = 0;
		int two = inputs.length - 1;

		while (one <= two) {
			switch (inputs[one]) {
			case 0:
				swap(inputs, zero, one);
				zero++;
				one++;
				break;
			case 1:
				
				one++;
				break;

			case 2:
				swap(inputs, one, two);
				two--;
				break;

			default:
				throw new IllegalArgumentException("ONly zero, one and two are supported");

			}
		}

	}

	private void swap(int[] inputs, int i, int j) {
     int temp = inputs[i];
     inputs[i]=inputs[j];
     inputs[j]=temp;
	}

	public static void main(String[] args) {
		Sort012 sort012 = new Sort012();
		int[] input = new int[] {1,2,2,2,0,0,0,1};
		
		sort012.sort012(input);
		
		Arrays.stream(input).forEach(System.out::println);
		
		  

	}

}
