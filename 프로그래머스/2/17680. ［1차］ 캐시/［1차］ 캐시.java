import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        // 0. 캐시 크기가 0인 경우,
        if(cacheSize == 0){
            answer = 5 * cities.length;
            return answer;
        }
        
        // 1. 캐시 메모리 큐 초기화
        Queue<String> cache = new LinkedList<>();
        
        // 2. cities 돌면서 점검
        for(String city: cities){
            String cityStr = city.toLowerCase(); // 대소문자 구분 제거
            if(cache.contains(cityStr)){
                // (1) cache에 도시가 존재하면,
                answer += 1;
                cache.remove(cityStr);
                cache.add(cityStr); // 원래 있던 값 제거 후, 맨 뒤로 삽입
            }else{
                // (2) cache에 도시가 존재하지 않으면,
                answer += 5;
                if(cache.size() < cacheSize){ // 캐시 자리가 남았으면, 그냥 삽입
                    cache.add(cityStr);
                }else{ // 캐시가 꽉 차면, 맨 앞 도시 제거 후 삽입
                    cache.poll();
                    cache.add(cityStr);
                }
            }
            
        }
        
        return answer;
    }
}