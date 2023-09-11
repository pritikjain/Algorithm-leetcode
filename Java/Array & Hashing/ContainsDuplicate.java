/* 
217 : Contains Duplicate

Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

 

Example 1:

Input: nums = [1,2,3,1]
Output: true
Example 2:

Input: nums = [1,2,3,4]
Output: false
Example 3:

Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true
 

Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109 */

import java.util.HashMap;
import java.lang.*;
class ContainsDuplicate {

    public static void main(String args[]){
        //int[] nums = {1,2,3,1};
        int[] nums = {1,2,3,4};
        boolean result = containsDuplicate(nums);
        System.out.println(result);
    }
    public static boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> map  = new HashMap<Integer,Integer>();

        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i]))
            {
                return true;  // we are returning here as we got same integer twice // no need to look for other integers
            } else {
                map.put(nums[i],0);
            }
        }
        return false;
    }
}