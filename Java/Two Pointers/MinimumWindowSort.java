/*Given an array, find the length of the smallest subarray in it which when sorted will sort the whole array.

Example 1:

Input: [1, 2, 5, 3, 7, 10, 9, 12]
Output: 5
Explanation: We need to sort only the subarray [5, 3, 7, 10, 9] to make the whole array sorted
Example 2:

Input: [1, 3, 2, 0, -1, 7, 10]
Output: 5
Explanation: We need to sort only the subarray [1, 3, 2, 0, -1] to make the whole array sorted
Example 3:

Input: [1, 2, 3]
Output: 0
Explanation: The array is already sorted
Example 4:

Input: [3, 2, 1]
Output: 3
Explanation: The whole array needs to be sorted. */

public class MinimumWindowSort {

    public static void main(String[] args) {
        System.out.println(sort(new int[] { 1, 2, 5, 3, 7, 10, 9, 12 }));
        System.out.println(sort(new int[] { 1, 3, 2, 0, -1, 7, 10 }));
        System.out.println(sort(new int[] { 1, 2, 3 }));
        System.out.println(sort(new int[] { 3, 2, 1 }));
      }

    public static int sort(int[] arr) {
        int size = arr.length;
        int left =0;
        int right =size-1;

        while((left < size - 1) && (arr[left] <= arr[left +1]))
        {
            left++;
        }
        if(left == size-1) // array is sorted
        {
            return 0;
        }
        while(right > 0 && arr[right] >= arr[right-1]){
            right--;
        }

        // find the max and min from subarray 
        int subarrayMax = Integer.MIN_VALUE;
        int subarrayMin = Integer.MAX_VALUE;
        for(int k = left; k <= right; k++)
        {
            subarrayMax = Math.max(subarrayMax, arr[k]);
            subarrayMin = Math.min(subarrayMin, arr[k]);
        }
        while(left > 0 && arr[left-1] > subarrayMin)
            left--;
        
        while((right < size-1) && arr[right+1] < subarrayMax )
            right++;

        return right-left+1;

    }
    
}
