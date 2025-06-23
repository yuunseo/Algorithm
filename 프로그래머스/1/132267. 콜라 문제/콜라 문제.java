/*
<아이디어>
1. a개 이상 가지고 있을 때, 시작할 수 있음.
2. 가진 병 수 / a -> 몫 * b -> 새로운 병 수 
3. 가진 병 수 / a -> 나머지는 킵
4. 새로운 병 수가 a보다 작아졌을 때, 나머지 병들 다 더해서 한 번 더!
*/

class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while(n >= a){
            int quo = n / a;        // 교환 가능 횟수
            int rem = n % a;        // 교환 후 남은 병
            
            answer += quo * b;      // 받은 새 병 개수 누적
            n = quo * b + rem;      // 새 병 + 남은 병 = 다음 라운드 시작 병 수
        }
        
        return answer;
    }
}