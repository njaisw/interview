package _12_namrata.self.practice_done;

public class MajorityWithNby3Elements {


        class Majority{
            int x;
            int y;
        }

        private Majority findMajority (int[] inputs){

            int c1 =0, c2 =0;
            int count1=0,count2 =0;

            for (int input : inputs) {
                if(input == c1){
                    count1++;
                }else if(input==c2){
                    count2++;
                }else if (count1==0){
                    c1=input;
                    count1++;
                }else if(count2==0){
                    c2=input;
                    count2++;
                }else{
                    count1--;
                    count2--;
                }
            }

            for (int i : inputs) {
                if(c1==i){
                    count1++;
                }
                if(c2 == i)
                    count2++;

            }

            Majority majority= new Majority();
            majority.x=c1;
            majority.y=c2;


            return majority;
        }


        public static void main(String args[] ) throws Exception {
            MajorityWithNby3Elements solution = new MajorityWithNby3Elements();
            Majority majority =solution.findMajority(new int[]{1,1,1,1,2,2,2,2,2,2,3,3,3,3,3,3,3,3,3,3,3,3,});

            System.out.println("Data "+majority.x + " Data2: "+majority.y);
        }

}
