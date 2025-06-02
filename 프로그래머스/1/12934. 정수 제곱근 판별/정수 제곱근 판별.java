class Solution {
    public long solution(long n) {
        double x = Math.sqrt(n);
        if(x%1==0) return (long)Math.pow(x+1,2);
        else return -1;
    }
}