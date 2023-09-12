/*Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

Example 1:

Input: s= "hello"
Output: "holle"
Example 2:

Input: s= "AEIOU"
Output: "UOIEA"
Example 3:

Input: s= "DesignGUrus"
Output: "DusUgnGires"
 */




public class ReverseVowels {

    public static void main(String args[]) {
        String s  = "AEIOU";
        System.out.println("Answer is : "+ reverseVowels(s));
    }

    public static String reverseVowels(String s) {
        // TODO: Write your code here
        int size = s.length();
        if (size == 1) {
            return s;
        }

        int left = 0;
        int right = size - 1;
        char[] chars = s.toCharArray();
        while (left < right) {
            if (!isVowel(chars[left])) {
                left++;
                continue;
            }
            if (!isVowel(chars[right])) {
                right--;
                continue;
            }
            // swap
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;

        }

        String newString = String.copyValueOf(chars);
        return newString;
    }

    public static boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O'
                || c == 'U') {
            return true;
        } else {
            return false;
        }
    }
}
