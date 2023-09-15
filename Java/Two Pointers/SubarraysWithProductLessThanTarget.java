/*
 * Problem Statement
Given an array with positive numbers and a positive target number, find all of its contiguous subarrays whose product is less than the target number.

Example 1:

Input: [2, 5, 3, 10], target=30                                              
Output: [2], [5], [2, 5], [3], [5, 3], [10]                           
Explanation: There are six contiguous subarrays whose product is less than the target.
Example 2:

Input: [8, 2, 6, 5], target=50                                              
Output: [8], [2], [8, 2], [6], [2, 6], [5], [6, 5]                         
Explanation: There are seven contiguous subarrays whose product is less than the target.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SubarraysWithProductLessThanTarget {

    public static void main(String arg[]) {
        int[] nums = { 2, 5, 3, 10 };
        int target = 30;

        List<List<Integer>> list = findSubarrays(nums, target);
        for (int i = 0; i < list.size(); i++) {
            List<Integer> innerL = list.get(i);
            System.out.print(" [");
            for (int j = 0; j < innerL.size(); j++) {
                System.out.print(innerL.get(j) + ",");
            }
            System.out.print(" ]");
            System.out.println();
        }

    }

    public static List<List<Integer>> findSubarrays(int[] arr, int target) {
        // Resultant list to store all valid subarrays.
        List<List<Integer>> result = new ArrayList<>();

        // Variable to store the product of elements in the current subarray.
        double product = 1;

        // Left boundary of the current subarray.
        int left = 0;

        // Iterate over the array using 'right' as the right boundary of the current
        // subarray.
        for (int right = 0; right < arr.length; right++) {
            // Update the product with the current element.
            product *= arr[right];

            // If the product is greater than or equal to the target, slide the left
            // boundary to the right until product is less than target.
            while (product >= target && left < arr.length) {
                product /= arr[left++];
            }

            // Create a temporary list to store the current subarray.
            List<Integer> tempList = new LinkedList<>();

            // Iterate from 'right' to 'left' and add all these subarrays to the result.
            for (int i = right; i >= left; i--) {
                // Add the current element at the beginning of the list.
                tempList.add(0, arr[i]);

                // Add the current subarray to the result.
                result.add(new ArrayList<>(tempList));
                System.out.print(tempList);

            }
            System.out.println();
        }

        // Return the result.
        return result;
    }

}
