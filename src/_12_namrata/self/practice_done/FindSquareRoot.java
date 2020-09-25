package _12_namrata.self.practice_done;

public class FindSquareRoot {
	
	private int squareRoo(int num) {
	  
		int start=0;

		int end=num;

		int mid=-1;

		while (start<end) {
			 mid = (start+end)/2;			
			if (mid*mid== num)
				return mid;
			else if (mid*mid > num)
				end = mid-1;
			else
				start= mid+1;
		}
		return mid;

	}

	public static void main(String[] args) {
		FindSquareRoot findSquareRoot = new FindSquareRoot();
		System.out.println(findSquareRoot.squareRoo(400));

	} 

}
