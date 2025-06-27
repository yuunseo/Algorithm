/*
<아이디어>
- 각 기사들은 자신의 번호의 약수의 개수만큼의 공격력인 무기를 구매한다
- 협약에 의해 limit가 있고, limit보다 큰 공격력 무기는 power 무기만 가질 수 있음
1. number로 1~number까지의 약수를 구해서, int[]에 넣는다
2. 하나씩 불러와서 limit보다 큰 수들은 power로 대체
3. 모든 값 더해서 반환
*/
class Solution {
    public int return_num(int n){
        int result = 0;
        for(int i=1; i <= Math.sqrt(n); i++){
            if(n%i == 0)
                if(i == n/i)
                    result += 1;
                else
                    result += 2;
        }
        return result;
    }
    
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for(int i=1; i<=number; i++){
            if(return_num(i) > limit)
                answer += power;
            else
                answer += return_num(i);
        }
        
        
        return answer;
    }
}