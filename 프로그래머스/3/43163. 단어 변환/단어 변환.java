import java.util.*;
class Solution {
    
    public static int result = 52;
   
    public int solution(String begin, String target, String[] words) {
        
        // begin과 words 비교
        for(int i=0; i<words.length; i++){
            int diff = getDiffCount(begin, words[i]);
            if(diff == 1){
                boolean[] isVisited = new boolean[words.length];
                isVisited[i] = true;
                dfs(target, words[i], words, isVisited, 1);
            }
        }
        return result == 52 ? 0 : result;
        
        
    }
    
    private void dfs(String target, String str, String[] words, boolean[] isVisited, int depth){
        // 종료 조건
        if(target.equals(str)){
            result = Math.min(result, depth);
            return;
        }
        
        // 탐색
        for(int i=0; i<words.length; i++){
            if(isVisited[i]) continue;
            
            int diff = getDiffCount(str, words[i]);
            if(diff == 1){
                isVisited[i] = true;
                dfs(target, words[i], words, isVisited, depth+1);
            }
            
            isVisited[i] = false;
        }
    }
    
    private int getDiffCount(String str1, String str2){
        int count = 0;
        for(int i=0; i<str1.length(); i++){
            if(str1.charAt(i) != str2.charAt(i)) count++;
        }
        return count;
    }
}