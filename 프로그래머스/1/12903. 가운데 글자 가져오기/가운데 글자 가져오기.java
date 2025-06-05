class Solution {
    public String solution(String s) {
        int len = s.length();
        int center = len/2;
        
        StringBuilder sb = new StringBuilder("");
        
        if(len%2==0){
            sb.append(s.charAt(center-1));
            sb.append(s.charAt(center));
        }else{
            sb.append(s.charAt(center));
        }
        
        return sb.toString();
    }
}