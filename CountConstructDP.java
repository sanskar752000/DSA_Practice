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

    public static int countConstruct(String target, String[] wordBank) {
        if(target.equals("")) return 1;
        
        int totalCount = 0;

        for(String word: wordBank) {
            if(target.indexOf(word) == 0) {
                String suffix = target.substring(word.length());
                int numWaysForRest = countConstruct(suffix, wordBank);
                totalCount += numWaysForRest;
            }
        }

        return totalCount;
    }

    public static void main(String[] args) {
        System.out.println(CountConstructDP.countConstruct("abcdef", new String[] {"ab", "abc", "cd", "def", "abcd"})); // true
        System.out.println(CountConstructDP.countConstruct("skateboard", new String[] {"ba", "rd", "ate", "t", "ska", "sk", "boar"})); // false
        System.out.println(CountConstructDP.countConstruct("enterpotentpot", new String[] {"a", "p", "ent", "enter", "ot", "o", "t"})); // true
        System.out.println(CountConstructDP.countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", 
        new String[] {
            "e",
            "ee",
            "eee",
            "eeee",
            "eeeee",
            "eeeeee"
        }));
    }
    
}
