/* <아이디아>
1. string에서 한 글자씩 가져온다
2. 이때, 0부터 맨 마지막 -1를 두 개 가져와서 비교한다 (문자/숫자인가? -> 두 글자는 동일한가?)
3. 동일하다면 다음 인덱스로 이동, 다르다면 False return
*/

class Solution {
    public boolean isPalindrome(String s) {
        
        int start = 0;
        int end = s.length()-1;
        s = s.toLowerCase();

        while(start < end){ // 인덱스로 각 글자 불러온 후, 비교
            if(!Character.isLetterOrDigit(s.charAt(start))){
                start ++;
            }else if(!Character.isLetterOrDigit(s.charAt(end))){
                end --;
            }else{
                System.out.println("a is "+s.charAt(start)+" b is "+s.charAt(end));
                if(s.charAt(start) != s.charAt(end)){
                    return false;
                }else{
                    start++; end--;
                }
                
            }
        }

        return true;
    }
}