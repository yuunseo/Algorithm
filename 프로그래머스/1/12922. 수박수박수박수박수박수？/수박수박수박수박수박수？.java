class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder("");
        String str = "수박";
        
        if(n%2==0){
            sb.append(str.repeat(n/2));
        }else{
            sb.append(str.repeat(n/2));
            sb.append("수");
        }
        return sb.toString();
    }
}