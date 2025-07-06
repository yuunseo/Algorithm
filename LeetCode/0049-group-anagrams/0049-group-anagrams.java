import java.util.*;
import java.util.Map.Entry;


class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String,List<String>> result = new HashMap<String,List<String>> ();

        for(String str: strs){
            char[] strToChar = str.toCharArray();
            Arrays.sort(strToChar);
            String K = new String(strToChar);

            if(!result.containsKey(K)){
                result.put(K,new ArrayList<>());
            }
            result.get(K).add(str);
        }

        return new ArrayList<>(result.values());

        
    }
}
