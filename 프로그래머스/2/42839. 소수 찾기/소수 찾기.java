/*
- 소수가 몇 개인지: 모든 소수의 조합을 만드세요
- numbers를 한 문자씩 분리하여 하나씩 만들어보기
*/
import java.util.*;

class Solution {
    char[] nums;
    boolean[] visited;
    Set<Integer> primes = new HashSet<>();
    
    public int solution(String numbers) {
        
        // 1. numbers에서 숫자 카드를 하나씩 만들어보기
        nums = numbers.toCharArray();
        // 2. 중복 선택을 막기 위한 자료구조
        visited = new boolean[nums.length];
        // 3. 숫자 카드의 조합으로 가능한 모든 소수 만들기 DFS
        dfs("");
        
        return primes.size();
    }
       
    
    private boolean isPrime(int num){
        if(num <=1) return false;
        
        for(int i=2; i*i <= num; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
    
    private void dfs(String current){
        // 현재 숫자 점검
        if (!current.equals("")) {
            int num = Integer.parseInt(current);
            if (isPrime(num)) {
                primes.add(num);
            }
        }
        
        // 현재 숫자로부터 만들 수 있는 다음 숫자 만들어서 점검
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            dfs(current + nums[i]);
            visited[i] = false;
        }
        
    }
}