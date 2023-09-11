/*
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
 

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
 

Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 */

import java.util.HashMap;
import java.lang.*;
public class ValidAnagram {

    public static void main(String args[])
    {
        String s = "anagram";
        String t = "nagaram";
        //s= "rat"; t ="cat";
        boolean value = isAnagram(s,t);
        System.out.println(value);
    }

    public static boolean isAnagram(String s, String t)
    {
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        int len1 = s.length();
        int len2 = t.length();
        if(len1 != len2)
            return false;

        for(int i = 0; i< len1; i++)
        {
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            } else {
                map.put(c,0);
            }
        }

        for(int j =0; j<len2; j++)
        {
            char d = t.charAt(j);
            if(map.containsKey(d)){
                map.put(d,map.get(d)-1);
                if(map.get(d) < 0 ) {
                    map.remove(d);
                }
            } else {
                return false;
            }
        }

        // check the map should be empty 
        if(map.isEmpty())
            return true;
        else 
            return false;

    }


    
}
