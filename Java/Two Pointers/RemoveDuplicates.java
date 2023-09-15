import java.util.Arrays;


public class RemoveDuplicates {
    public static void main(String arg[])
    {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println("Anser is : "+ remove(nums));
    }
    public static int remove(int[] arr) {
        // TODO: Write your code here
        int size = arr.length;
        if (size == 1)
            return 1;
        int left = 0;

        for (int i = 1; i < size; i++) {
            if (arr[i] != arr[i - 1]) // the value is unique
            {
                arr[left + 1] = arr[i];
                left++;
            } else {
                continue;
            }
        }
        return left+1;
    }

}
