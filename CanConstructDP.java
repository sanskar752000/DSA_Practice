public class CanConstructDP {
    /*
    Write a function 'canConstruct(target, wordBank)' that accepts a target string and an array of strings.
    The function should return a boolean indicating whether or not the 'target' can be constructed by concatenating
    elements of the 'wordBank' array

    You may reuse elements of 'wordBank' as many time as needed.
    
    Input: 
        target = 'abcdef'
        wordBank = [ab, abc, cd, def, abcd]
    Output: true
    */

    public static boolean canConstruct(String target, String[] wordBank) {
        if(target.equals("")) return true;

        for(String word: wordBank) {
            if(target.indexOf(word) == 0) {
                String suffix = target.substring(word.length());
                if(canConstruct(suffix, wordBank) == true) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(CanConstructDP.canConstruct("abcdef", new String[] {"ab", "abc", "cd", "def", "abcd"})); // true
        System.out.println(CanConstructDP.canConstruct("skateboard", new String[] {"ba", "rd", "ate", "t", "ska", "sk", "boar"})); // false
        System.out.println(CanConstructDP.canConstruct("enterpotentpot", new String[] {"a", "p", "ent", "enter", "ot", "o", "t"})); // true
        System.out.println(CanConstructDP.canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", 
        new String[] {
            "e",
            "ee",
            "eee",
            "eeee",
            "eeeee",
            "eeeeee"
        })); // false
    }
}
