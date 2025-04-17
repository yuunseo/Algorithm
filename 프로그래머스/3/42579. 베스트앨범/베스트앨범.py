'''
1.아이디어
    1) 장르 선택하기
        - genres들의 재생횟수를 모두 합쳐서 저장한 후, 순서대로 꺼내온다
    2) 고유번호 선택하기
        - 고유번호 i번의 장르의 노래가 plays[i]번 재생되었을 경우, 많이 재생된 장르 먼저 수록한다
    3) 장르별 최대 2개까지 선택 가능 & 재생횟수 순 & 고유번호 오름차 순
    
    -> 겹치고 반복하는 자료구조를 해시로 활용할 수 있음 : "genre" : (plays, i) > value[0]으로 정렬해서 i를 추가하기.
'''
from collections import defaultdict

def solution(genres, plays):
    # 1. 해시 자료구조 만들기
    genre_total = defaultdict(int)               # 장르별 총 재생 횟수
    genre_songs = defaultdict(list)              # 장르별 노래 리스트: (재생수, 고유번호)

    for i, (g, p) in enumerate(zip(genres, plays)):
        genre_total[g] += p
        genre_songs[g].append((p, i))

    # 2. 장르 정렬 (총 재생 수 기준으로 내림차순)
    sorted_genres = sorted(genre_total.items(), key=lambda x: x[1], reverse=True)

    answer = []
    for genre, _ in sorted_genres:
        # 3. 해당 장르의 노래들 정렬 (재생 수 내림차순, 고유번호 오름차순)
        songs = sorted(genre_songs[genre], key=lambda x: (-x[0], x[1]))
        # 4. 최대 2개 고르기
        answer.extend([i for _, i in songs[:2]])

    return answer