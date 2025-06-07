/*
<아이디어>
- 10진법 > 3진법 바꾸는 방법: 
*/
class Solution {
    
    public long turn(int n){
        
        // 10진수 > 3진수
        StringBuilder sb = new StringBuilder("");
        while(n>0){
            sb.append(n%3);
            n /= 3;
        }
        
        // 3진수 > 10진수
        int reverse_idx = sb.length()-1;
        long result = 0;
        for(int i=0; i<sb.length(); i++){
            reverse_idx = sb.length()-1-i;
            result += (sb.charAt(reverse_idx)-'0')*Math.pow(3,i);
        }
        
        return result;
    }
    
    public int solution(int n) {
        return (int)turn(n);
    }
}