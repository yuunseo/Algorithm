/*
수를 표현하는 방법
1,2,4로만 구성된 자연수만 존재한다 -> 규칙 존재
*/
class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
       
        while(n >0){
            int rem = n%3;
            if(rem == 0){
                sb.append(4);
                n = n/3 -1;
            }else{
                sb.append(rem);
                n /= 3;
            }
        }
        
        return sb.reverse().toString();
    }
}