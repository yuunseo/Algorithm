/*
<약수 구하는 알고리즘: O(n)>
1. 약수란? 1과 나 자신 x가 아닌 숫자들 중, 본인 x와 나누었을 때 나머지가 0인 수 (1과 본인은 포함)
2. for문을 통해 2부터 x-1까지 반복
3. x와의 나머지가 0인 수라면 cnt 에 더해주기
4. for 문 종료 후, cnt 반환
------------------------
<더 효율적인 알고리즘: O(n루트)>
1. 약수들의 규칙 - i가 n의 약수라고 했을 때, n/i 도 n의 약수이다
2. 즉, 약수들은 대칭적이라는 규칙이 존재하므로, 1~루트n까지만 반복해서 2번씩 cnt 세어 주자!
*/

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i=1; i <= Math.sqrt(n); i++){
            if(n%i==0){
                answer += i;       // 약수 i 더해주기
                if(i != n/i)       // i == n/i 인 경우는 i가 중간 값인 경우! 한번 더 안 더해줘도 됨.
                    answer += (int)(n/i); // 약수 n/i 더해주기
            }
        }
        
        return answer;
    }
}