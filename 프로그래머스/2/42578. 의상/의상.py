'''
1.아이디어
    - clothes[i][1]을 key로 딕셔너리를 생성한다
    - key값 별로 나누어서 조합의 개수 추가한다
        - 조합의 종류
        1) for k in key 여기서 1개씩, 2개씩, ... , len(key)개씩 고르는 조합
'''
from collections import defaultdict

def solution(clothes):
    
    d = defaultdict(list) # list를 value값으로 갖는 빈 딕셔너리를 만듦

    for i in clothes:
        d[i[1]].append(i[0]) # 초기화 없이 바로 값을 추가할 수 있음
        
    result = 1
    for i in d.values(): #key의 개수만큼 서로다른 조합을 가질 수 있음 -> len(keys())를 모두 곱함
        result *= (len(i)+1) #각각 하나씩 모두 입는 경우 + 안입는 경우
        
    return result -1