import java.util.*;
class Solution {
    class Block{
        String begin;
        int count;
        
        Block(String begin, int count){
            this.begin = begin;
            this.count = count;
        }
    }
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        Queue<Block> q = new LinkedList<>();
        int len = words.length;
        boolean[] visited = new boolean[len];
        
        q.add(new Block(begin, 0));
        
        while(!q.isEmpty()){
            Block block = q.poll();
            
            if(block.begin.equals(target)){
                return block.count;
            }
                        
            // 한 글자만 다른 단어 찾기
            for(int idx=0; idx<len; idx++){
                
                if(visited[idx]) continue;
                
                String word = words[idx];
                int wordLength = word.length();
                int num = 0;
                for(int i=0; i<wordLength; i++){
                    if(word.charAt(i) != block.begin.charAt(i)) num++;
                    
                    if(num>=2) break;
                }
                
                if(num == 1){
                    q.add(new Block(word, block.count+1));
                    visited[idx] = true;
                }
            }
        }
        
        return 0;
    }
}