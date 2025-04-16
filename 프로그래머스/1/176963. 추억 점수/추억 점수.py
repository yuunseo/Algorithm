'''
1. 아이디어
    - name과 yearing을 dictionary로 만들어서, photo별로 매칭 > 토탈
'''

def solution(name, yearning, photo):
    
    score = dict(zip(name,yearning))
    
    result = []
    for pho in photo:
        cnt = 0
        for person in pho:
            cnt += score.get(person,0)
        result.append(cnt)
        
    return result