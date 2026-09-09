/*
[아이디어]
1. brown+yellow= 전체 카펫의 크기 - O(1)
2. yellow를 모두 가로로 두고, 양 옆에 +1씩 = 가로 길이 - O(1)
3. 전체 카펫의 크기 / 가로길이 == 0 성공 - O(1)
4. 실패면, yellow를 /2로해서 다시 계산 반복~ - O(logN)
*/
class Solution {
    public int[] solution(int brown, int yellow) {
        
        int totalSize = brown + yellow;
        
        int cnt = 1;
        int width = (yellow/cnt) + 2;
        int length = totalSize / width;
        
        
        while(width * length != totalSize){
            cnt += 1;
            if(yellow%cnt != 0) continue;
            width = (yellow/cnt) + 2;
            length = totalSize / width;
        }
        
        
        return new int[] {width, length};
        
    }
}