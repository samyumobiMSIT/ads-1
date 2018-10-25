import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
*Solution class
**/
public class Solution {

    /**
     * Check if we have sufficient words in the magazine for the ransom note.
     */
    static String sufficientWords(String[] magazine, String[] ransom) { 
        // **** build magazine map ****         
        HashMap<String, Integer> magMap = new HashMap<String, Integer>();         
        for (String word : magazine) {
            if (magMap.containsKey(word)) {
                int count = magMap.get(word);
                count++;
                magMap.put(word,  count);
            } else {
                magMap.put(word, 1);
            }
        }
 
        // **** build ransom map ****
         
        HashMap<String, Integer> ransomMap = new HashMap<String, Integer>();         
        for (String word : ransom) {
            if (ransomMap.containsKey(word)) {
                int count = ransomMap.get(word);
                count++;
                ransomMap.put(word, count);
            } else {
                ransomMap.put(word, 1);
            }
        }
         
        // **** compare words and counts ****
         
        Iterator iter = ransomMap.entrySet().iterator();         
        while (iter.hasNext()) {
            Map.Entry<String, Integer> pair = (Map.Entry<String, Integer>)iter.next();
            String word = pair.getKey();
            int count   = pair.getValue();             
            if (!magMap.containsKey(word)) {
                return "No";
            } else {
                if (count > magMap.get(word)) {
                    return "No";
                }
            }
        }
        return "Yes";
    }
 
    /**
     * Test code.
     */
    public static void main(String[] args) {

        // **** open scanner ****         
        Scanner in  = new Scanner(System.in);         
        // **** read parameters ****         
        int m       = in.nextInt();
        int n       = in.nextInt();         
        // **** read words from the magazine ****         
        String magazine[] = new String[m];
        for (int i = 0; i < m; i++){
            magazine[i] = in.next();
        }
        // **** read words for ransom note ****         
        String ransom[]= new String[n];
        for (int i = 0; i < n; i++) {
            ransom[i] = in.next();
        }         
        // **** close scanner ****         
        in.close();         
        // **** determine if there are sufficient words for the ransom note ****
        System.out.println(sufficientWords(magazine, ransom));
    }
}
