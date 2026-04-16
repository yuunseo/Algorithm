import java.util.*;

class Solution {
    public int[] solution(String s) {

        // 우선순위 체크를 위해 List
        Map<Integer, Integer> numList = new HashMap<>();

        // s의 원소 한 개씩 불러와서 셋에 넣기
        String sListTotal = s.substring(1,s.length()-1); // 맨 앞뒤 괄호 제거
        String[] sList = sListTotal.split("},\\{");
        if (sList[0].startsWith("{")) {
            sList[0] = sList[0].substring(1);
        }
        if (sList[sList.length - 1].endsWith("}")) {
            sList[sList.length - 1] = sList[sList.length - 1].substring(0, sList[sList.length - 1].length() - 1);
        }
        
        for(String str: sList){
            String[] items = str.split(",");
            for(String num: items){
                int n = Integer.parseInt(num);
                numList.put(n, numList.getOrDefault(n,0)+1);
            }
        }

        // value 기준 가장 많이 나온 원소부터 정렬
        int[] answer = new int[numList.size()];
        
        // map 정렬을 위해 list로 변환
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(numList.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());
        int idx=0;
        for(Map.Entry<Integer,Integer> entry: list){
            answer[idx++] = entry.getKey();
        }


        return answer;
}
}