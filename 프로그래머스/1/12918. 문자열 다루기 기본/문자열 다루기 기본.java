class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        
        answer = (s.length()==4 || s.length()==6) ? true: false;
        
        for(int i=0; i<s.length();i ++){
            if(Character.isLetter(s.charAt(i)))
                answer = false;
        }
        
        return answer;
    }
}