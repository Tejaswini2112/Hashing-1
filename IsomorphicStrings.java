//Check if two strings are isomorphic or not
//Time Complexity: O(n) for all the solutions
//Space Complexity: O(1) for all the solutions
//Solved in LeetCode: Yes
/*
Approach:
Solved the problem using 3 approaches
1st - used two hashmaps, 2nd - map and a set, 3rd = two character arrays
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
public class IsomorphicStrings {

    public boolean isIsomorphic_twoMaps(String s, String t){
        HashMap<Character, Character> sMap = new HashMap<>(); // to store s to t mapping
        HashMap<Character, Character> tMap = new HashMap<>(); // to store t to s mapping

        for (int i=0;i<s.length();i++){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            //check if the key already exist in the map and compare it's value with t character
            if (sMap.containsKey(sChar)) {
                if (sMap.get(sChar)!=tChar) return false; //if the value of current key doesnt match with t character
            }else {
                sMap.put(sChar,tChar); // if key is not in the map add it to the map
            }

            //same with tMap
            if (tMap.containsKey(tChar)) {
                if (tMap.get(tChar)!=sChar) return false;
            } else {
                tMap.put(tChar, sChar);
            }
        }

        return true;
    }

    /*
    used one hashmap for 's' string to store the character and its mapped value
    HashSet to store the value of each map key's value
     */
    public boolean isIsomorphic_mapAndSet(String s, String t){
        HashMap<Character, Character> sMap = new HashMap<>();  //store characters
        HashSet<Character> tSet = new HashSet<>();

        //iterating through the length of string
        for (int i=0;i<s.length();i++){
            char sChar = s.charAt(i); // character of 's' array at i
            char tChar = t.charAt(i); // character of 't' array at i

            //check if the key already exist in the map and compare it's value with t character
            if (sMap.containsKey(sChar)){
                if (sMap.get(sChar)!=tChar) return false; //return false if the value doesnt match with t character
            } else {
                if (tSet.contains(tChar)) return false; //if the key already exists in hashset return false
                sMap.put(sChar, tChar); // add key and value to the map
                tSet.add(tChar); //store the value in hashmap, for further checks
            }

        }
        return true;
    }

    public boolean isIsomorphic_usingCharArrays(String s, String t){
        char[] sArr = new char[256];
        char[] tArr = new char[256];

        for (int i=0;i<s.length();i++){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (sArr[sChar]!=0){
                if (sArr[sChar]!=tChar) return false;
            } else {
                sArr[sChar] = tChar;
            }

            if (tArr[tChar]!=0){
                if (tArr[tChar]!=sChar) return false;
            } else {
                tArr[tChar] = sChar;
            }


        }

        return true;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String sString = sc.next();
        String tString = sc.next();

        if (sString.length()!=tString.length()){
            System.out.println(false);
            return;
        }
        IsomorphicStrings is = new IsomorphicStrings();
        System.out.println("using two hashmaps "+is.isIsomorphic_twoMaps(sString, tString));
        System.out.println("using map and a set "+is.isIsomorphic_mapAndSet(sString, tString));
        System.out.println("Using Char Array "+is.isIsomorphic_usingCharArrays(sString, tString));

    }
}
