class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int p_cnt = 0;
        int y_cnt = 0;
        int len = s.length();
        
        for(int i=0;i <len; i++){
            if(s.charAt(i) == ('p') || s.charAt(i) == ('P'))
                p_cnt ++;
            else if(s.charAt(i) == ('y') || s.charAt(i) == ('Y'))
                y_cnt ++;
        }
        

        return p_cnt==y_cnt;
    }
}