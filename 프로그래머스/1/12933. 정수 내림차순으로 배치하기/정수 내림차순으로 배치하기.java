import java.util.Arrays;

class Solution {
    public long solution(long n) {
        long answer = 0;
        
        // long -> String 형변환
        String s = Long.toString(n);
        int len = s.length();
        long[] arrays = new long[len];
        
        // 정수들이 담긴 배열 arrays 
        for(int i=0; i<len; i++){
            arrays[i] = s.charAt(len-1-i) - '0';
        }
        
        
        // 정수 정렬- 오름차순 정렬
        Arrays.sort(arrays);
        
        // 정수 정렬2 - 내림차순 정렬
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<len; i++){
            sb.append(arrays[len-1-i]);
        }
        
        // 문자열 -> Long 형변환
        return Long.parseLong(sb.toString());
    }
}