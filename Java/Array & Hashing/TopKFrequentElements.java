
import java.util.HashMap;

class TopKFrequentElements{
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int[] result = new int[k];
        int size = nums.length;
        // put count of all the distinct elements in the Map 
        //with elements as the key & count as the value 
        for(int i = 0; i < size; i ++)
        {
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            } else {
                map.put(nums[i],1);
            }
        }

        List<Map.Entry<Integer, Integer> > list
            = new ArrayList<Map.Entry<Integer, Integer> >(
                map.entrySet());
        System.out.println(list);

        for(int j=0 ; j<k; j++){
            Integer max = Collections.max(map.values());
            
        }
        
        
    }
}
