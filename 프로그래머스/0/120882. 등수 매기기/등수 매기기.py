'''
1. 아이디어
    - 각 list의 평균을 등수로 나타내야 하니까, 우선 각 학생별로 평균을 내어 저장한다
    - 평균 값에서 등수를 매긴다
'''

def solution(score):
    a = sorted([sum(i) for i in score], reverse = True)
    
    return [a.index(sum(i))+1 for i in score]