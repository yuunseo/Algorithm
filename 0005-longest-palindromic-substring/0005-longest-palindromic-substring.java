class Solution {
    int left, maxLen;

    public void extendPalindrome(String s, int j, int k){
        while(j >=0 && k<s.length() && s.charAt(j) == s.charAt(k)){
            j--; k++;
        }

        if(maxLen < k-j-1){
            left = j+1;
            maxLen = k-j-1;
        }
    }

    public String longestPalindrome(String s) {

        // 문자열이 1글자인 경우, 바로 반환
        int len = s.length();
        if(len < 2) return s;

        // 문자열이 2글자 이상인 경우,
        for(int i=0; i<len-1; i++){
            extendPalindrome(s,i,i+1);
            extendPalindrome(s,i,i+2);
        }

        return s.substring(left,left+maxLen);
        
    }
}