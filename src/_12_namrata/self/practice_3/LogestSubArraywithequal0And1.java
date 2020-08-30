package _12_namrata.self.practice_3;

import java.util.HashMap;
import java.util.Map;

public class LogestSubArraywithequal0And1 {

	int maxLength = Integer.MIN_VALUE;

	private void findLongestSubArray(int[] inputs) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < inputs.length; i++) {
         inputs[i]=inputs[i]==0?-1:1;
		}
		
		int prefixSum= 0;
		
		for (int i = 0; i < inputs.length; i++) {
			prefixSum=prefixSum+inputs[i];
			if (!map.containsKey(prefixSum)) {
				map.put(prefixSum, i);
				
			}else {
				int k= map.get(prefixSum);
				maxLength= Math.max(maxLength,i-k);
			}
			
		}

	}

	public static void main(String[] args) {
		LogestSubArraywithequal0And1 lonAnd1 = new LogestSubArraywithequal0And1();
		lonAnd1.findLongestSubArray(new int[] {1,0,1,0,1,0,1,1,1,1});
        System.out.println(lonAnd1.maxLength);
	}

}
