package _11_com.ds.dynamic;

/**
 * @Date 08/01/2014
 * @author Tushar Roy
 *
 * Given a total and coins of certain denominations find number of ways total
 * can be formed from coins assuming infinity supply of coins
 *
 * References:
 * http://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/
 */
public class _22_CoinChanging {


    /**
     * Space efficient DP solution
     */
    public int numberOfSolutionsOnSpace(int total, int arr[]){

        int temp[] = new int[total+1];
        //TODO Remember the total is 1D array
        temp[0] = 1;
        for(int i=0; i < arr.length; i++){
            for(int j=1; j <= total ; j++){
                //TODO Formula is T[i]= T[i]+T[j-arr[i]]
                if(j >= arr[i]){
                	 System.out.println("##"+temp[j]);
                    temp[j] += temp[j-arr[i]];
                   
                }
                System.out.println("###"+temp[j]);
            }
        }
        return temp[total];
    }

  

    public static void main(String args[]){
        _22_CoinChanging cc = new _22_CoinChanging();
        int total = 15;
        int coins[] = {3,4,6,7,9};
        //System.out.println(cc.numberOfSolutions(total, coins));
        System.out.println(cc.numberOfSolutionsOnSpace(total, coins));
       // cc.printCoinChangingSolution(total, coins);
    }
}
