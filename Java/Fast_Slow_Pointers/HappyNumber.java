/*
 * Any number will be called a happy number if, after repeatedly replacing it with a number equal to the sum of the square of all of its digits, leads us to the number 1. All other (not-happy) numbers will never reach 1. Instead, they will be stuck in a cycle of numbers that does not include 1.

Given a positive number n, return true if it is a happy number otherwise return false.

Example 1:

Input: 23
Output: true (23 is a happy number)
Explanations: Here are the steps to find out that 23 is a happy number:

 = 4 + 9 = 13
 = 1 + 9 = 10
 = 1 + 0 = 1

Example 2:

Input: 12
Output: false (12 is not a happy number)
Explanations: Here are the steps to find out that 12 is not a happy number:

 = 1 + 4 = 5
= 25
 = 4 + 25 = 29
 = 4 + 81 = 85
 = 64 + 25 = 89
 = 64 + 81 = 145
 = 1 + 16 + 25 = 42
 = 16 + 4 = 20
 = 4 + 0 = 4
 = 16
 = 1 + 36 = 37
 = 9 + 49 = 58
 = 25 + 64 = 89

Please note the cycle from 89 -> 89.
 */

public class HappyNumber {

    public static void main(String arg[])
    {
        System.out.println(find(23));
       // System.out.println(find(12));
    }
    public static boolean find(int num) {
        int slow = num; int fast = num;
        do {
            slow = findSquareSum(slow);
            System.out.println("slow:"+ slow);
            fast = findSquareSum(findSquareSum(fast));
            System.out.println("fast:"+fast);
        } while(slow != fast);// found the cycle 
        return slow == 1;
    }

    private static int findSquareSum(int num){
        System.out.println("At the start num:"+num);
        int sum = 0 ; 
        int digit;
        while (num > 0)
        {
            digit = num % 10;
            System.out.println("digit:"+digit);
            sum += digit * digit;
            System.out.println("sum:"+sum);
            num /= 10;
            System.out.println("num:"+num);
        }
        return sum;
    }
    
}
