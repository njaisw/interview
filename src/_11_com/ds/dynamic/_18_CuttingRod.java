package _11_com.ds.dynamic;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-13-cutting-a-rod/
 *

 length   | 1   2   3   4   5   6   7   8
 --------------------------------------------
 price    | 1   5   8   9  10  17  17  20


 */
public class _18_CuttingRod {
@Deprecated
    public int maxValue(int price[]){
        int max[] = new int[price.length+1];
        for(int i=1; i <= price.length; i++){
            for(int j=i; j <= price.length; j++){
                max[j] = Math.max(max[j], max[j-i] + price[i-1]);
            }
        }
        return max[price.length];
    }


    public int maxValue1(int price[]){

        int max[] = new int[price.length+1];

        for(int i=1; i <= price.length; i++){
            max[i] = price[i-1];
        }
        for(int i=1 ; i <= price.length; i++){
            for(int j=1; j < i ; j++){
                max[i] = Math.max(max[i], max[i-j] + max[j]);
            }
        }
        return max[price.length];
    }

    @Deprecated
    public int recursiveMaxValue(int price[],int len){
        if(len <= 0){
            return 0;
        }
        int maxValue = 0;
        for(int i=0; i < len;i++){
            int val = price[i] + recursiveMaxValue(price, len-i-1);
            if(maxValue < val){
                maxValue = val;
            }
        }
        return maxValue;
    }
    public static void main(String args[]){
        _18_CuttingRod cr =new _18_CuttingRod();
        int[] price = {3,5,8,9,10,20,22,25};
        long t1 = System.currentTimeMillis();
        //int r = cr.recursiveMaxValue(price,8);
        long t2 = System.currentTimeMillis();
        //System.out.println(r);
        System.out.println(t2 - t1);
    }
}
