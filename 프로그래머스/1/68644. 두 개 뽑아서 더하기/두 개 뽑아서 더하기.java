/*
<아이디어>
- 정수 배열에서 서로 다른 두 수를 뽑아서 더해서 오름차 순으로 담기
- 주의할 점: 서로 다른 두 인덱스, 더한 값이 중복이면 추가 XX
-

*/
import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Set <Integer> answer = new HashSet <Integer> ();
        
        for(int i=0; i<numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                answer.add(numbers[i]+numbers[j]);
            }
            System.out.println(answer);
        }
        
        int[] result = new int[answer.size()];
        int i=0;
        for(int n: answer){
            result[i++] = n;
        }
        
        Arrays.sort(result);
        
        return result;
        
    }
}