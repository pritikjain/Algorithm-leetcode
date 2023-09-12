
/*
 * Given an array of integers nums, return the number of good pairs.

A pair (i, j) is called good if nums[i] == nums[j] and i < j.

Example 1:

Input: nums = [1,2,3,1,1,3]
Output: 4
Explanation: There are 4 good pairs, here are the indices: (0,3), (0,4), (3,4), (2,5).
Example 2:

Input: nums = [1,1,1,1]
Output: 6
Explanation: Each pair in the array is a 'good pair'.
Example 3:

Input: words = nums = [1,2,3]
Output: 0
Explanation: No number is repeating.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NumberOfGoodPairs {
    
    public static void main(String[] args)
    {
        int[] nums = {1,2,3,1,1,3};
        System.out.println(numGoodPairs(nums));
    }

    public static int numGoodPairs(int[] nums) {
        int pairCount = 0;
        // TODO: Write your code here

        int size = nums.length;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

        for(int i =0; i < size; i++)
        {
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            } else {
                map.put(nums[i],1);
            }
        }
        for(Integer value : map.values())
        {
            pairCount = pairCount + (value*(value-1))/2;
        }

        return pairCount;
      }
}
