import java.util.Arrays;

public class TripletWithSmallerSum {

    public static void main(String args[]) {

        // int[] numbers = {-3,3,4,-3,1,2};
        // int[] numbers = {-1,0,1,2,-1,-4};
        int[] numbers = { -1, 0, 2, 3 };
        int target = 3;

        int result = searchTriplets(numbers, target);
        System.out.println("Answer : " + result);
        // for(int i = 0; i < result.size(); i++)
        // {
        // List<Integer> list = new ArrayList<>();
        // list = result.get(i);
        // System.out.println(list);
        // }
    }

    public static int searchTriplets(int[] arr, int target) {
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            count += searchPair(arr, target - arr[i], i);
        }
        return count;
    }

    private static int searchPair(int[] arr, int targetSum, int first) {
        int count = 0;
        int left = first + 1, right = arr.length - 1;
        while (left < right) {
            if (arr[left] + arr[right] < targetSum) { // found the triplet
                // since arr[right] >= arr[left], therefore, we can replace arr[right] by any
                // number between left and right to get a sum less than the target sum
                count += right - left;
                left++;
            } else {
                right--; // we need a pair with a smaller sum
            }
        }
        return count;
    }

}
