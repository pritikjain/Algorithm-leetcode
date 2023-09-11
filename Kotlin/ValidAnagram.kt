class ValidAnagram {


    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val  s: String = "anagram";
            val  t: String = "nagaram";
        
            val result : Boolean  = isAnagram(s,t);
            println(result);
        }
        fun isAnagram(s: String, t: String): Boolean {
            val len1 = s.length;
            val len2 = t.length;
            val map = mutableMapOf<Char,Int?>();
            if(len1 != len2){
                print("why?")
                return false
            }
            
                val sc: CharArray = s.toCharArray()
                val tc: CharArray = t.toCharArray()
            for(i in sc.indices)
            {
                val c = sc.get(i)
                if(map.containsKey(c)){
                    var value : Int? = map.get(c);
                    map.put(c,value?.let { value+1 });
                    println("CCCC adding +1 ${map.get(c)}")
                } else {
                    map.put(c,0);
                    println("CCCC when you put $c ${map.get(c)}")
                }
            }
            for(j in tc.indices)
            {
                val d = tc.get(j)
                if(map.containsKey(d)){
                    // Decrease the count to 1 and if count is 0 then remove it from map 
                    var value : Int? = map.get(d);
                    map.put(d, value?.let { value - 1 })
                    var after = map.get(d);
                    println("DDDD when you sub - 1 ${map.get(d)}")
                    if(after != null && after < 0 )
                    {
                        map.remove(d)
                        println("DDDD remove  ${map.get(d)}")
                    }
                } else {
                    println("DDDD not in map ")
                    return false
                }
            }
            // check the map should be empty 
            if(map.isEmpty())
                return true;
            else 
                return false;
            
        }
    }
}