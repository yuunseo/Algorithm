import java.util.*;
class Solution {
    public String solution(String s) {
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        for(String str: s.split(" ")){
            list.add(Integer.parseInt(str));
        }
        
        Collections.sort(list);
        
        sb.append(list.get(0)).append(" ").append(list.get(list.size()-1));
        
        return sb.toString();
    }
}