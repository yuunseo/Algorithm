'''
1.아이디어
    논문 n개 중 h번 이상 인용 -> h개 이상/ 나머지가 -> h번 이하 인용 -> h의 최댓값이 H-INDEX
    즉, 임의의 수 n을 선택
    n 이상인 list 내 원소 개수 구하기 -> n개 이상(m개)이면 통과
        이와 더불어, n 이하인 list 내 원소가 n-m이면 통과
'''

def solution(citations):
    
    # 1. n개 이상인 원소 개수 구하기
    # 최댓값을 구해야 하므로, list에서 젤 큰 값을 기본 값으로 초기화하자
    # 최댓값이 아니면 다음 최댓값으로 -=1 씩 일까? 아니면..
    
    ini = max(citations)
    
    while 1:
        max_cnt = 0
        min_cnt = 0
        for i in citations:
            if i >= ini:
                max_cnt += 1
            elif i <= ini:
                min_cnt += 1
        #print(f"max cnt is {max_cnt}")
        #print(f"min cnt in {min_cnt}")
        if max_cnt + min_cnt == len(citations):
            if (max_cnt) >= ini:
                return ini
        
        ini -= 1
    
    