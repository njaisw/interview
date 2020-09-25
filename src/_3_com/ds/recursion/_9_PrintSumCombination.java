package _3_com.ds.recursion;

import java.util.ArrayList;
import java.util.List;


public class _9_PrintSumCombination {

	private List<List<Integer>> findSumCombination(int[] input, int sum) {
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		combineSum(input, sum, 0, result, new ArrayList<Integer>());
		
		return result; 
		
	}

	private void combineSum(int[] input, int target, int position, List<List<Integer>> result, List<Integer> current) {
		if (target==0) {
			result.add(new ArrayList<Integer>(current));
			return;
		}
		if (target<0 || position>=input.length) {
			return;
		}
		current.add(input[position]);
		combineSum(input, target-input[position], position, result, current);
		current.remove(current.size()-1);
		combineSum(input, target, position+1, result, current);

	}

	public static void main(String[] args) {
		
		_9_PrintSumCombination printSumCombination = new _9_PrintSumCombination();
		List<List<Integer>> resList= printSumCombination.findSumCombination(new int[]{1,2,3,4,5}, 5);
		
		for (List<Integer> list : resList) {
			System.out.println(list);
		}

	}

}
