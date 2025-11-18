//Time Complexity: O(n)
//Space complexity: O(n) as we are using an array to store all the strings
//Solved in leetcode: yes
/*
Approach is similar to Isomorphic strings
I split the space separated strings into an array
Maintained a hashmap to store characters of pattern as key and corresponding string in the array as value
we check for each character if the key exists in the map and if the value exists in the hashset
if not we add the pair to map and just the value to hashset
 */
import java.util.HashMap;
import java.util.HashSet;

public class WordPattern {

    public boolean wordPattern(String pattern, String s){
        String[] sArr = s.split(" ");
        int pl = pattern.length();
        int sl = sArr.length;
        if (pl!=sl) return false;

        HashMap<Character, String> patternMap = new HashMap<>();
        HashSet<String> sSet = new HashSet<>();

        for (int i=0;i<pl;i++){
            char pChar = pattern.charAt(i);

            if (patternMap.containsKey(pChar)){
                if (!patternMap.get(pChar).equals(sArr[i])) return false;
            } else {
                if (sSet.contains(sArr[i])) return false;
                patternMap.put(pChar, sArr[i]);
                sSet.add(sArr[i]);
            }
        }
        return true;
    }
    public static void main(String args[]){
        WordPattern wp = new WordPattern();
        System.out.println(wp.wordPattern("abbd", "dog cat cat dog"));
    }
}
