import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        // 오름차순 정렬 (작은 것부터 확인하며 비율 계산을 단순화)
        Arrays.sort(weights);
        
        // 각 무게별 등장 횟수를 저장할 Map
        // 작은 것부터 확인하니까, 차례대로 저장하면 됨
        Map<Double, Integer> map = new HashMap<>();
        
        for (int w : weights) {
            double weight = (double) w;
            
            // 현재 무게(w)와 짝이 될 수 있는 이전 무게들을 확인
            // w*1.0, w*(2.0/3.0), w*(2.0/4.0), w*(3.0/4.0) 가 map에 있는지 확인
            double[] cases = {
                weight * 1.0, 
                weight * (2.0 / 3.0), 
                weight * (2.0 / 4.0), 
                weight * (3.0 / 4.0)
            };
            
            for (double c : cases) {
                if (map.containsKey(c)) {
                    answer += map.get(c);
                }
            }
            
            // 현재 무게를 Map에 추가/갱신
            map.put(weight, map.getOrDefault(weight, 0) + 1);
        }
        
        return answer;
    }
}