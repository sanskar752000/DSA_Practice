import java.util.HashMap;

public class CountConstructDP {
    
    /* 
    Write a functino 'countConstruct(target, wordBank)' that accepts a target string and an array of strings.
    The function should return the number of ways that the 'target' can be constructed by concatenating elements
    of the 'wordBank' array.
    
    You may reuse elemets of 'wordBank' as many times as needed.

    Input: 
        target = 'abcdef'
        wordBank = [ab, abc, cd, def, abcd]
    Output: 1
    */

    public static int countConstruct(String target, String[] wordBank, HashMap<String, Integer> memo) {
        if(memo.containsKey(target)) return memo.get(target);
        if(target.equals("")) return 1;
        
        int totalCount = 0;

        for(String word: wordBank) {
            if(target.indexOf(word) == 0) {
                String suffix = target.substring(word.length());
                int numWaysForRest = countConstruct(suffix, wordBank, memo);
                totalCount += numWaysForRest;
            }
        }
        memo.put(target, totalCount);
        return totalCount;
    }

    public static void main(String[] args) {
        System.out.println(CountConstructDP.countConstruct("purple", new String[] {"purp", "p", "ur", "le", "purpl"}, new HashMap<>())); // true
        System.out.println(CountConstructDP.countConstruct("abcdef", new String[] {"ab", "abc", "cd", "def", "abcd"}, new HashMap<>())); // true
        System.out.println(CountConstructDP.countConstruct("skateboard", new String[] {"ba", "rd", "ate", "t", "ska", "sk", "boar"}, new HashMap<>())); // false
        System.out.println(CountConstructDP.countConstruct("enterpotentpot", new String[] {"a", "p", "ent", "enter", "ot", "o", "t"}, new HashMap<>())); // true
        System.out.println(CountConstructDP.countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", 
        new String[] {
            "e",
            "ee",
            "eee",
            "eeee",
            "eeeee",
            "eeeeee"
        }, new HashMap<>()));
    }

    /*
    m = target.length
    n = wordBank.length

    Brute Force
    O(n^m * m) time
    O(m^2) space

    Optimized (using memoized solution)
    O(n * m^2) time
    O(m^2) space
    */
    
}
