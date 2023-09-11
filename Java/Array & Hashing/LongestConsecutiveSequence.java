import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class LongestConsecutiveSequence {


    public static void main(String args[])
    {
        //int array[] = {100,4,200,1,3,2};
        //int array[] = {0,3,7,2,5,8,4,6,0,1};
        //int array[] ={};
        int array[] = {1,2,0,1};
        System.out.println("length : "+ longestConsecutive(array));
    }
    public static int longestConsecutive(int[] nums) {
        
        int size = nums.length;
        if(size <= 1){
            return size;
        }
        
        
        HashSet<Integer> set = new HashSet<Integer>();
        int longest = 0;

        // hash all the array elements 
        for(int j = 0; j< size; j++)
        {
            set.add(nums[j]);
        }

        // check each possible sequence fro the start and then update optimal length
        for(int i = 0; i<size; i++ )
        {
            //the current element is the starting element of a sequence or not 
            if(!set.contains(nums[i]-1)){
                //num[i] is the start of the seq 
                // then check for the next element 
                int length = 0;
                int value = nums[i];
                while(set.contains(value)){
                    length++;
                    value++;
                }
                if(longest < length )
                {
                    longest = length;
                }
            } else{
                // it is not a start of the seq 
            }
        }
        return longest;
    }
}
