//Brute-force Approach
//Time Complexity: O(n*m*log m)
//Space Complexity: O(n*m)

//Optimized Approach
//Time Complexity: O(n*m)
//Space Complexity: O(n*m)
/*
Approach:
stored first 26 prime numbers in an array
we multiply the characters(prime value at index (ascii - 'a'))
prime product for anagrams is always same
for every prime product as key we will have array of strings as value
 */
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public BigInteger findPrimeProduct(String str){
        int[] primeArray = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
                31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
                73, 79, 83, 89, 97, 101};
        char[] charArr = str.toCharArray();
        BigInteger res=BigInteger.ONE;
        for (char c:charArr){
            res = res.multiply(BigInteger.valueOf(primeArray[c - 'a']));
        }
        return res;
    }
    public List<List<String>> groupAnagrams_optimized(String[] strs) {
        HashMap<BigInteger, List<String>> anagramsMap = new HashMap<>();
        for (String str:strs){
            BigInteger primeProduct = findPrimeProduct(str);
            anagramsMap.putIfAbsent(primeProduct, new ArrayList<>());
            anagramsMap.get(primeProduct).add(str);
        }
        return new ArrayList<>(anagramsMap.values());
    }
    public List<List<String>> groupAnagrams_bruteForce(String[] strs) {
        HashMap<String, List<String>> anagramsMap = new HashMap<>();
        for(String str:strs){  //O(n)
            char[] chars = str.toCharArray();
            Arrays.sort(chars);  //O(mlog m)
            String s = new String(chars);
            anagramsMap.putIfAbsent(s, new ArrayList<>());
            anagramsMap.get(s).add(str);

        }
        return new ArrayList<>(anagramsMap.values());
    }
    public static void main(String args[]) {
        GroupAnagrams ga = new GroupAnagrams();
//        System.out.println(ga.groupAnagrams_bruteForce(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(ga.groupAnagrams_optimized(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));

    }
}
