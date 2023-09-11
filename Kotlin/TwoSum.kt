/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, a  wice.

You can return the answer in any order.

 
Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 

Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists. 
*/



class TwoSum {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
        val input = arrayOf(-3,4,3,90) 
        val target = 0
        val solution : List<Int?>  = twoSum(input,target)
        println("$solution")

        }
    

    fun twoSum(nums: Array<Int>, target:Int): List<Int?> {
        val map = mutableMapOf<Int,Int>()
        for(i in nums.indices){
            if (map.containsKey(target-nums[i])){
                val j = map.get(target-nums[i])
             
                return listOf(j,i)
            }
            map.put(nums[i], i)
            
        }
        return listOf(-1,-1)
        }
    }
}