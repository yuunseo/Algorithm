/*
1) split으로 공백 구분 후, 각 단어에서 짝/홀 판단하기
2) for문으로 s index로 가져와서, 공백일 때 인덱스 초기화하기
*/
class Solution {
    public String solution(String s) {
        
        StringBuilder sb = new StringBuilder();
        
        int initIndex = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == ' '){
                initIndex = 0;
                sb.append(' ');
                continue;
            }
            
            if(initIndex % 2 == 0){
                sb.append(Character.toUpperCase(s.charAt(i)));
            }else{
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
            
            initIndex++;
            
        }
        
        return sb.toString();
    }
}