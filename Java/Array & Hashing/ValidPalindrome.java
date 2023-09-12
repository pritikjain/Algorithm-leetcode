/*A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

Example 1:

Input: sentence = "A man, a plan, a canal, Panama!"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: sentence = "Was it a car or a cat I saw?"
Output: true
Explanation: Explanation: "wasitacaroracatisaw" is a palindrome. */


public class ValidPalindrome {

    public static void main(String args[])
    {
        String s = "Nitin";
        System.out.println("Answer:"+ isPalindrome(s));
    }

    public static boolean isPalindrome(String s){
        if(s.length() <= 1)
      return true;
    
    String str = s.trim().replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

    int size = str.length();
    int mid = size/2;
    for(int i=0, j = size-1; i < mid; i++ , j--)
    {
       if(str.charAt(i) != str.charAt(j))
        return false;
    }
    return true;
    }
    
}
