/*
- 총 N마리 중 N/2마리 가져도 좋아 - 이때 종류의 개수가 많을 수록 좋음 ! 

1. 총 마릿수 N, 가질 수 있는 마릿수 M = N/2
2. nums를 돌면서 M개씩 조합을 구하기에는 시간 복잡도 매우 큼 !
3. nums의 폰켓몬 종류를 key로하고 개수를 value로 해서 hashmap에 넣자
4. 그 담에 map의 길이 >= M이라면, M 반환
5. map 길이 < M이라면, map 길이 반환

*/
import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(int[] nums) {
        
        // 1. N과 M 초기화하기
        int N = nums.length;
        int M = N/2;
        
        // 2. nums를 hashmap으로 변환하기
        Map<Integer, Integer> numsMap = new HashMap<>();
        for(int i: nums){
            numsMap.put(i, numsMap.getOrDefault(i,0)+1);
        }
        
        // 3. map의 길이와 M 비교
        return (numsMap.size() >= M) ? M : numsMap.size();
        
    }
}