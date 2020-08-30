package _4a_com.ds.misc_x;

public class _2_Atoi {

    private static int myAtoi(String str)
    {
        // Initialize result
        int res = 0;

        // Iterate through all characters of
        // input string and update result
        for (int i = 0; i < str.length(); ++i)
            res = res * 10 + str.charAt(i) - '0';

        // return result.
        return res;
    }

    // Driver code
    public static void main(String[] args)
    {
        String str = "89789";
        int val = myAtoi(str);
        System.out.println(val);
    }

}
