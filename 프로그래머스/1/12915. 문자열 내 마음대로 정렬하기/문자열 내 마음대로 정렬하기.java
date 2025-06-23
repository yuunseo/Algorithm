
import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        
        Arrays.sort(strings, 
                    Comparator.comparing((String s) -> s.charAt(n))
                   .thenComparing(Comparator.naturalOrder()));

        return strings;
    }
}