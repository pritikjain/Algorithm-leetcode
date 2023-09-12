
/*
 * A pangram is a sentence where every letter of the English alphabet appears at least once.

Given a string sentence containing English letters (lower or upper-case), return true if sentence is a pangram, or false otherwise.

Note: The given sentence might contain other characters like digits or spaces, your solution should handle these too.

Example 1:

Input: sentence = "TheQuickBrownFoxJumpsOverTheLazyDog"
Output: true
Explanation: The sentence contains at least one occurrence of every letter of the English alphabet either in lower or upper case.
Example 2:

Input: sentence = "This is not a pangram"
Output: false
Explanation: The sentence doesn't contain at least one occurrence of every letter of the English alphabet.

 */

import java.util.HashSet;
import java.util.Set;

public class Pangram {

    public static void main(String args[])
    {
        String sentence = "TheQuickBrownFoxJumpsOverTheLazyDog";

        // String sentence = "This is not a pangram";
        System.out.println(checkIfPangram(sentence));

    }
    public static boolean checkIfPangram(String sentence) 
    {
        if(sentence ==null || sentence.length() <= 0)
            return false;
        String st = sentence.trim().toLowerCase();
        int size = st.length();
        
        Set<Character> set = new HashSet<Character>();
        for(char c ='a'; c<='z'; c++)
        {
            set.add(c);
        }

        for(int i =0; i < size; i++)
        {
            char ch = st.charAt(i);
            if(set.contains(ch)){
                set.remove(ch);
            }
        }
        if(set.isEmpty()){
            return true;
        }
        System.out.print(set.toString());
        return false;
  }
}



