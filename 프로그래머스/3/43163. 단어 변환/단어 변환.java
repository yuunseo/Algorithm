/*
idea: begin에서 target으로 변환하는 최단 경로의 길이 구하기
- 각 words 별로 몇 개가 차이나는지 계산하는 함수 필요
- 1개 차이나면, 서로 연결되어 있다는 의미임!
- 그래프로 변환해보자
*/
import java.util.*;
class Solution {
    
    class Word {
        String word;
        int count;

        Word(String word, int count) {
            this.word = word;
            this.count = count;
        }
        
        private String getWord(){
            return this.word;
        }
        
        private int getCount(){
            return this.count;
        }
    }
    
    private boolean isConnected(String a, String b) {
        int diff = 0;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;

                if (diff > 1) {
                    return false;
                }
            }
        }

        return diff == 1;
    }
   
    public int solution(String begin, String target, String[] words) {
        // 자료구조 초기화
        Queue<Word> queue = new ArrayDeque<>();
        queue.offer(new Word(begin, 0));
        boolean[] isVisited = new boolean[words.length];
        
        // 그래프 탐색
        while(!queue.isEmpty()){
            Word current = queue.poll();
            
            if(current.getWord().equals(target)) return current.getCount();
            
            for(int i=0; i<words.length; i++){
                if(isVisited[i]) continue;
                
                boolean result = isConnected(current.getWord(), words[i]);
                if(result){
                    queue.offer(new Word(words[i], current.getCount()+1));
                    isVisited[i] = true;
                }
            }
        }
        
        // 불가능 시 0 반환
        return 0;
    }
}