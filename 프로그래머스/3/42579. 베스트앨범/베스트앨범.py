'''
1.아이디어
    1) 장르 선택하기
        - genres들의 재생횟수를 모두 합쳐서 저장한 후, 순서대로 꺼내온다
    2) 고유번호 선택하기
        - 고유번호 i번의 장르의 노래가 plays[i]번 재생되었을 경우, 많이 재생된 장르 먼저 수록한다
    3) 장르별 최대 2개까지 선택 가능 & 재생횟수 순 & 고유번호 오름차 순
'''
from collections import defaultdict

def solution(genres, plays):
    
    # 0. 기본 변수 설정
    genre = defaultdict(int)
    answer = []
    
    # 1. genre 순서 구하기: 전체 재생 횟수가 높은 장르부터 정렬
    for i in range(len(genres)):
        genre[genres[i]] += plays[i]
    
    genreSorted =[ k for k,v in sorted(genre.items(), key=lambda x:x[1],reverse=True)]
    #print(genreSorted)
    
    # 2. genre 순서대로 재생횟수 확인하기
    for name in genreSorted:
        
        # 3. 각 장르별 노래의 재생 횟수 정렬
        name_score = []
        for i in range(len(genres)):
            if name == genres[i]:
                name_score.append([i,plays[i]])
                
        # 4. 각 장르별 노래는 최대 2개까지 수록 가능
        if len(name_score) >= 2:
            name_score = sorted(name_score, key=lambda x:x[1],reverse=True)
            #print(name_score)
            answer.extend([i[0] for i in name_score[:2]])
        else:
            answer.append(name_score[0][0])

    return answer