/*
1. paragraph 문자열을 split하여 hashmap으로 생성한다 value는 0으로 초기화
2. list에서 한 원소씩 가져오며, banned에 포함된 단어라면,pass
3. banned에 없는 단어라면 += 1
4. hashmap 중 value가 최대인 단어 반환
 */

 import java.util.HashSet;
 import java.util.Arrays;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {

        paragraph = paragraph.toLowerCase();

        // 1. hashmap 생성하기
        Map<String, Integer> wordMap = new HashMap<String,Integer> ();
        
        // 2. string을 split하여 list로 생성하기 (, . 는 제외)
        List<String> stringList = new ArrayList<String>(Arrays.asList(paragraph.replaceAll("\\W+"," ").split(" ")));

        // 3. 한 단어씩 확인하며, map에 추가하기
        //  3-1. 이때, banned에 포함되는지 확인을 위해, 집합으로 변경
        HashSet<String> bannedSet = new HashSet<String> (Arrays.asList(banned));
        for(int i=0; i<stringList.size(); i++){
            String item = stringList.get(i);
            if(bannedSet.contains(item)){
                continue;
            }else{
                wordMap.put(item, wordMap.getOrDefault(item,0)+1); // 기존에 없더라도 +1씩 추가되도록
            }
        }

        // 4. hashmap에서 value 순서대로 내림차 정렬
        List<Map.Entry<String,Integer>> wordsList = new ArrayList<>(wordMap.entrySet());
        wordsList.sort((a, b) -> b.getValue() - a.getValue());  // value 내림차순 정렬

        // 5. 가장 빈도 수가 높은 단어 반환
        
        return wordsList.get(0).getKey();
    }
}