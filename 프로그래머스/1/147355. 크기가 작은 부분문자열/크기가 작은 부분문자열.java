class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int start = 0;
        int end = p.length();
        String substr;
        long subint;
        long targetint = Long.parseLong(p);
        
        while(end <= t.length()){
            substr = t.substring(start,end);
            subint = Long.parseLong(substr);
            
            if(subint <= targetint) answer++;
            
            start++;
            end++;
        }
        
        return answer;
    }
}