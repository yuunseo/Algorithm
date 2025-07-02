/* <아이디어> 
1. 방안1: 새로운 배열을 생성해서, 맨 뒤 아이템부터 집어 넣기
*/
class Solution {
    public void reverseString(char[] s) {
        char[] answer = new char[s.length];

        int start = 0;
        int end = s.length-1;
        char temp;

        while(start < end){
            temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++; end--;
        }

    }
}