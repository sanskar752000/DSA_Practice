import java.util.*;
public class CanSumDP {

    public static boolean canSum(int targetSum, int[] arr) {
        return internalSolu(targetSum, arr, new HashMap<Integer, Boolean>());
    }

    private static boolean internalSolu(int targetSum, int[] arr, HashMap<Integer, Boolean> memo) {
        if(memo.containsKey(targetSum)) return memo.get(targetSum);
        if(targetSum == 0) return true;
        if(targetSum < 0) return false;
        
        for(int x: arr) {
            int remainder = targetSum - x;
            if(internalSolu(remainder, arr, memo) == true){
                memo.put(targetSum, true);
                return true;
            } 
        }
        memo.put(targetSum, false);
        return false;
    }

    public static void main(String[] args) {
        System.out.println(CanSumDP.canSum(7,new int[] {2, 3}));
        System.out.println(CanSumDP.canSum(7,new int[] {5, 3, 4, 7}));
        System.out.println(CanSumDP.canSum(7,new int[] {2, 4}));
        System.out.println(CanSumDP.canSum(8,new int[] {2, 3, 5}));
        System.out.println(CanSumDP.canSum(10000,new int[] {7, 14}));
    }
}