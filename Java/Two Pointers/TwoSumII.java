
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSumII {
    public static void main(String args[])
    {
       // int[] numbers = {2,7,11,15};  int target = 9;
       // int[] numbers = {2,3,4};  int target = 6;

         int[] numbers = {-1,0};  int target = -1;
       
        // int[] result = twoSum(numbers,target);
        // System.out.println("Answer : "+ result[0] + " : "+ result[1]);

        //int[] numbers = {1,3,4,5,7,11}; int target =9;
        int[] resultPointer = twoSumWithPointers(numbers,target);
        System.out.println("Answer using two Pointer : "+ resultPointer[0] + " : "+ resultPointer[1]);
    }

    public static int[] twoSum(int[] numbers, int target) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int size = numbers.length;
        int[] result = new int[2];
        for(int i =0 ; i <size; i++)
        {
            if(map.containsKey(numbers[i]))
            {
                result[0] = map.get(numbers[i]);
                result[1] = i;
                return result;
            } else {
                map.put(target-numbers[i],i);
            }
        }
        return result;
    }

    public static int[] twoSumWithPointers(int[] numbers, int target) {

        int[] result = new int[2];
        int size = numbers.length;
        int left = 0;
        int right = size-1;
        for(int i = 0; i < size; i++)
        {
            if(numbers[left]+numbers[right] > target){
                right--;
            }
            else if(numbers[left]+numbers[right] < target){
                left++;
            }
            else if(numbers[left]+numbers[right] == target){
                result[0]=left+1;
                result[1]= right+1;
                return result;
            }
        }
        return result;
    }
    
}
