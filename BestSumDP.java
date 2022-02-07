import java.util.ArrayList;

public class BestSumDP {
    
    public static ArrayList<Integer> bestSum(int[] arr, int targetSum) {
        if(targetSum == 0) return new ArrayList<>();
        if(targetSum < 0) return null;

        ArrayList<Integer> shortestCombination = null;

        for(int x: arr) {
            int remainder = targetSum - x;
            ArrayList<Integer> remainderCombination = bestSum(arr, remainder);
            if(remainderCombination != null) {
                remainderCombination.add(x);
                if(shortestCombination == null || remainderCombination.size() < shortestCombination.size()) {
                    shortestCombination = remainderCombination;
                }
            }
        }

        return shortestCombination;
    }


    public static void main(String[] args) {
        System.out.println(BestSumDP.bestSum(new int[] {5, 3, 4, 7}, 7));
        System.out.println(BestSumDP.bestSum(new int[] {2, 3, 5}, 8));
        System.out.println(BestSumDP.bestSum(new int[] {1, 4, 5}, 8));
        System.out.println(BestSumDP.bestSum(new int[] {1, 2, 5, 25}, 100));
    }
}
