import java.util.ArrayList;
import java.util.HashMap;

public class BestSumDP {
    
    public static ArrayList<Integer> bestSum(int[] arr, int targetSum) {
        return internalSolution(arr, targetSum, new HashMap<>());
    }
    private static ArrayList<Integer> internalSolution(int[] arr, int targetSum, HashMap<Integer, ArrayList<Integer>> memo) {
        if(memo.containsKey(targetSum)) return memo.get(targetSum);
        if(targetSum == 0) return new ArrayList<>();
        if(targetSum < 0) return null;

        ArrayList<Integer> shortestCombination = null;

        for(int x: arr) {
            int remainder = targetSum - x;
            ArrayList<Integer> remainderCombination = internalSolution(arr, remainder, memo);
            if(remainderCombination != null) {
                ArrayList<Integer> combination = new ArrayList<>(remainderCombination);
                combination.add(x);
                if(shortestCombination == null || combination.size() < shortestCombination.size()) {
                    shortestCombination = combination;
                }
            }
        }
        memo.put(targetSum, shortestCombination);
        return memo.get(targetSum);
    }

    public static void main(String[] args) {
        System.out.println(BestSumDP.bestSum(new int[] {5, 3, 4, 7}, 7));
        System.out.println(BestSumDP.bestSum(new int[] {2, 3, 5}, 8));
        System.out.println(BestSumDP.bestSum(new int[] {1, 4, 5}, 8));
        System.out.println(BestSumDP.bestSum(new int[] {1, 2, 5, 25}, 100));
    }
}
