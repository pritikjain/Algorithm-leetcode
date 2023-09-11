

/*
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]
 

Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    public static void main(String args[])
    {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> result = groupAnagrams(strs);
        System.out.println(result);

    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<List<String>>();
        int size = strs.length;
        if(size == 1)
        {
            result.add(Arrays.asList(strs[0]));
            return result;
        }

        HashMap<String,List<Integer>> map = new HashMap<String,List<Integer>>();

        for( int i =0 ; i < size ; i++){
           String sortedString = sortString(strs[i]);
           System.out.println("whats the sorted String:" + sortedString);
           if(map.containsKey(sortedString))
           {
             List<Integer> indexArray = map.get(sortedString);
             indexArray.add(i);
             map.put(sortedString,indexArray);
             System.out.println("In If : "+indexArray);
           } else {
             List<Integer> indexArray = new ArrayList<>();
             indexArray.add(i);
             map.put(sortedString,indexArray);
             System.out.println("In else  : "+ indexArray);
           }
        }
        
       
        for (String key : map.keySet()) {
            List<Integer> indexArray = map.get(key);
            List<String> finalStrings = new ArrayList<String>();
            for(int j =0; j < indexArray.size(); j++)
            {
                finalStrings.add(strs[indexArray.get(j)]);
            }
            result.add(finalStrings);
            
        }
        return result;
    }

    public static String sortString(String inputString)
    {
        // Converting input string to character array
        char tempArray[] = inputString.toCharArray();
 
        // Sorting temp array using
        Arrays.sort(tempArray);
 
        // Returning new sorted string
        return new String(tempArray);
    }
}
