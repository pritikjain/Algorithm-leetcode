/*
 * /*A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

    Given a string s, return true if it is a palindrome, or false otherwise.

    Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
 

Constraints:

1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.

 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidPalindrome {
    public static void main(String args[])
    {
        //String s = "A man, a plan, a canal: Panama";
        
        //Explanation: "amanaplanacanalpanama" is a palindrome.
        //String s ="nitin";
        String s = "abcddcba";
        System.out.println("Answer : "+ isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {

        if(s.length() == 1 || s.isEmpty())
        {
            return true;
        }
       
        String sc = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        System.out.println("After trim: " + sc);
        int size = sc.length();
        int mid = size/2;
        for(int i =0 , j =size-1; i < mid &&  j >= mid ; i++ , j--)
        {
            if(sc.charAt(i)!= sc.charAt(j))
            {
                System.out.println("why we came here  " +  sc.charAt(i) + ":::: " + sc.charAt(j));
                return false;
            }
        }
        return true;
        
    }
}