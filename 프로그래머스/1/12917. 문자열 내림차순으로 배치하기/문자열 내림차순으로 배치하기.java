import java.util.Arrays;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder(s);
        
        // String를 char[] 배열로 변환
        char[] charArray = s.toCharArray();

        // 배열을 정렬
        Arrays.sort(charArray);

        // 배열을 반대로 뒤집기 (내림차순으로 변환)
        for (int i = 0; i < charArray.length / 2; i++) {
            char temp = charArray[i];
            charArray[i] = charArray[charArray.length - 1 - i];
            charArray[charArray.length - 1 - i] = temp;
        }
        
        // 정렬된 배열을 다시 StringBuilder로 변환
        sb = new StringBuilder(new String(charArray));

        return (sb.toString());
    }
    
}