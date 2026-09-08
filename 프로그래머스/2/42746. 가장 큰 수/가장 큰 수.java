/*
[아이디어]
1. int를 String으로 변환한다 - O(n)
2. comparator로 정렬한다 - O(nlogn)
*/
import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        String[] stringNumbers = new String[numbers.length];
        for(int i=0; i<numbers.length; i++){
            stringNumbers[i] = numbers[i]+"";
        }
        
        Arrays.sort(stringNumbers,
            (a, b) -> (b + a).compareTo(a + b)
        );
        
        // 모든 숫자가 0인 경우
        if (stringNumbers[0].equals("0")) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(String n: stringNumbers){
            sb.append(n);
        }
            
        return sb.toString();
        
        
        
    }
}