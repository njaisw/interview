package _2_com.ds.multiarray;

/**
 * http://www.geeksforgeeks.org/a-boolean-matrix-question/
The matrix
1 0 0 1
0 0 1 0
0 0 0 0

should be changed to following

1 1 1 1
1 1 1 1
1 0 1 1
 */
public class Fill2DMatrixWith1_3 {

	public void fill(int input[][]){
		boolean row[] = new boolean[input.length];
		boolean col[] = new boolean[input[0].length];
		for(int i=0; i < input.length; i++){
			for(int j=0; j < input[i].length; j++){
				if(input[i][j] == 1){
					row[i] = true;
					col[j] = true;
				}
			}
		}
		for(int i=0; i < input.length; i++){
			for(int j=0; j < input[i].length; j++){
				if(row[i] || col[j]){
					input[i][j] = 1;
				}
			}
		}
	}
	
	public static void main(String args[]){
		int input[][] = {{0,0,1,0,0,0},{0,0,0,0,0,0},{1,0,0,0,0,0}};
		Fill2DMatrixWith1_3 fd = new Fill2DMatrixWith1_3();
		fd.fill(input);
		for(int i=0; i < input.length; i++){
			for(int j=0; j < input[i].length; j++){
				System.out.print(input[i][j] + " ");
			}
			System.out.println();
		}
	}
}
