/*
<아이디어>
1. 모든 수의 조합 벗, 순서는 상관없이 구하기 -> 이때 서로 다른 종류의 개수만 알면 됨 -> 집합으로 바꾸면 될 듯?
2. nums.length / 2만큼 조합구하기
>>>> 아니다!
1. 애초에 우린 서로 다른 종류의 개수들 중, 최대의 수만 알면 되니까 모든 조합의 수를 구할 필요가 없다.
2. nums의 중복을 없애고, 이게 length/2보다 작다면, 그 size를 반환하고
3. length/2보다 크다면, length/2를 반환 (그 이상은 안되니까)
*/

import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        Set<Integer> nums_set = new HashSet<Integer>();
        for(int n: nums){
            nums_set.add(n);
        }
        
        return Math.min(nums_set.size(),nums.length/2);
        
    }
}