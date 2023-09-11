
import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args)
    {
        // Solution s = new Solution();
        int[] input = {-3,4,3,90};
        int[] result = twoSum(input,0);
        System.out.println(""+result[0]+ " " + result[1]+"");
    }   

    public static int[] twoSum(int[] nums, int target){
        HashMap<Integer,Integer> check = new HashMap<Integer,Integer>();
        int[] result = {-1,-1};
        int n = nums.length;
        for(int i = 0; i < n ; i++)
        {
            if(check.containsKey(target-nums[i]))
            {
                result[0] = check.get(target-nums[i]);
                result[1] = i;
                return result;
            } 
            check.put(nums[i], i);
            
        }
        
        return result;

    }
}
