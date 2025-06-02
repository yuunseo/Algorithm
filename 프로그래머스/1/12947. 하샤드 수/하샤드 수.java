class Solution {
    public boolean solution(int x) {
        
        String s = Integer.toString(x);
        int len = s.length();
        int total = 0;
        for(int i=0; i<len; i++)
            total += s.charAt(i)-'0';
        
        return x%total==0;
    }
}