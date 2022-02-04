import java.util.*;

public class HowSumDP {
    
    public static ArrayList<Integer> howSum(int targetSum, int[] arr) {
       return internalSolution(targetSum, arr, new HashMap<Integer, ArrayList<Integer>>());
    }

    private static ArrayList<Integer> internalSolution(int targetSum, int[] arr, HashMap<Integer, ArrayList<Integer>> memo) {
        if(memo.containsKey(targetSum)) return memo.get(targetSum);
        if(targetSum == 0) return new ArrayList<Integer>();
        if(targetSum < 0) return null;

        for(int num: arr ){
            int remainder = targetSum - num;
            ArrayList<Integer> remainderResult = internalSolution(remainder, arr, memo);
            if(remainderResult != null) {
                remainderResult.add(num);
                memo.put(targetSum, remainderResult);
                return memo.get(targetSum);
            }
        }
        memo.put(targetSum, null);
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
