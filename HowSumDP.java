import java.util.ArrayList;

public class HowSumDP {
    
    public static ArrayList<Integer> howSum(int targetSum, int[] arr) {
        if(targetSum == 0) return new ArrayList<Integer>();
        if(targetSum < 0) return null;

        for(int num: arr ){
            int remainder = targetSum - num;
            ArrayList<Integer> remainderResult = howSum(remainder, arr);
            if(remainderResult != null) {
                remainderResult.add(num);
                return remainderResult;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(HowSumDP.howSum(7, new int[] {2, 3}));
        System.out.println(HowSumDP.howSum(7, new int[] {5, 3, 4, 7}));
        System.out.println(HowSumDP.howSum(7, new int[] {2, 4}));
        System.out.println(HowSumDP.howSum(8, new int[] {2, 3, 5}));
        System.out.println(HowSumDP.howSum(300, new int[] {7, 14}));
    }
}
