/*
<아이디어>
나머지가 1이 되도록 하는 수들을 모두 구한 후, 최소 값을 반환한다.
나머지가 1이 된다는 의미는?
n-1 값의 의 약수들 중, 1제외 다음으로 큰 수!!

*/

class Solution {
    public int solution(int n) {
        int target = n-1;
        
        for(int i=2; i<=Math.sqrt(target); i++){
            if(target%i==0){ // n-1 값의 약수인가?
                if(n%i==1)   // n에서 나머지 1이 맞는가?
                    return i;
                int another = target/i;
                if(n%another==1)
                    return another;
                
            }
            
        }
        
        return target;
    }
}