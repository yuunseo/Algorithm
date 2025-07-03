import java.util.*;

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        
        List<String> letterList = new ArrayList<>();
        List<String> digitList = new ArrayList<>();

        for(String str : logs){
            if(Character.isDigit(str.split(" ")[1].charAt(0))){
                digitList.add(str);
            } else {
                letterList.add(str);
            }
        }

        // 문자 리스트 정렬
        letterList.sort((s1,s2) -> {
            // 식별자로부터 구분
            String[] s1x = s1.split(" ",2);
            String[] s2x = s2.split(" ",2);

            int compared = s1x[1].compareTo(s2x[1]);
            if(compared == 0){ // 서로 같음 > 식별자로 비교
                return s1x[0].compareTo(s2x[0]);
            }else{ // 서로 다르다면, 결과 반환
                return compared;
            }
        });

        letterList.addAll(digitList);

        return letterList.toArray(new String[0]);
        
    }
}
