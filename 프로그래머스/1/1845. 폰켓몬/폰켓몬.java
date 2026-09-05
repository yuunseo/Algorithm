/*
[아이디어]
1. nums의 길이를 n으로 초기화하고, n/2을 limit으로 초기화한다. 
2. nums에서 고를 수 있는 포켓몬의 종류의 개수 구하기. (Set)
3. Set의 크기 vs limit. 
4. set size가 더 크면, limit 반환. 
5. set size가 더 작으면, set size 반환.
*/
import java.util.*;
class Solution {
    public int solution(int[] nums) {
        
        // 변수 초기화
        int n = nums.length;
        int limit = n/2;
        
        // set으로 개수 구하기
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }
        int size = set.size();
        
        // 비교하기
        if(size >= limit){
            return limit;
        }else{
            return size;
        }
        
    }
}