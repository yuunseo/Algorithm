import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {

        // 1. 장르별 총 재생 횟수 구하기
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < genres.length; i++){
            map.put(genres[i],
                map.getOrDefault(genres[i], 0) + plays[i]);
        }

        // 2. 총 재생 횟수 기준 장르 내림차순 정렬
        List<String> genresList = new ArrayList<>(map.keySet());

        genresList.sort((a, b) -> {
            return Integer.compare(map.get(b), map.get(a));
        });

        // 3. 장르별 노래 정보 저장
        // int[] = {재생 횟수, 고유 번호}
        Map<String, List<int[]>> genreGroup = new HashMap<>();

        for(int i = 0; i < genres.length; i++){
            genreGroup.computeIfAbsent(
                genres[i],
                k -> new ArrayList<>()
            ).add(new int[]{plays[i], i});
        }

        // 4. 장르별로 최대 2곡 선택
        List<Integer> result = new ArrayList<>();

        for(String genre : genresList){
            List<int[]> songs = genreGroup.get(genre);

            // 재생 횟수 내림차순
            // 재생 횟수가 같으면 고유 번호 오름차순
            songs.sort((a, b) -> {
                if(a[0] == b[0]){
                    return Integer.compare(a[1], b[1]);
                }
                return Integer.compare(b[0], a[0]);
            });

            // 최대 2곡 선택
            for(int j = 0; j < Math.min(2, songs.size()); j++){
                result.add(songs.get(j)[1]);
            }
        }

        // 5. List<Integer> → int[] 변환
        return result.stream()
                     .mapToInt(Integer::intValue)
                     .toArray();
    }
}