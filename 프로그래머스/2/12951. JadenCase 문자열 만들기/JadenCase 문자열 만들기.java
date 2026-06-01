class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        // 공백 다음 문자인지 확인하는 플래그
        boolean isNextUpper = true; // 첫 글자는 대문자여야함
        
        for(char c: s.toCharArray()){
            
            if(c == ' '){
                sb.append(c);
                isNextUpper = true;
            }else{
                if(isNextUpper){ // 대문자로 변환해야 하면, 변환 후 플래그 초기화
                    sb.append(Character.toUpperCase(c));
                    isNextUpper = false;
                }else{ // 소문자로 변환해야 하면, 소문자로 변환
                    sb.append(Character.toLowerCase(c));
                }
            }
        }
        
        return sb.toString();
    }
}