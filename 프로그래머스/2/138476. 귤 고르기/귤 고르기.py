
from collections import defaultdict

def solution(k, tangerine):
    tang = defaultdict(int)
    
    for i in tangerine:
        tang[i] += 1

    result = sorted(tang.values(), reverse=True)  # 개수만 정렬하면 됨
    
    answer = 0
    cnt = 0
    for v in result:
        answer += v
        cnt += 1
        if answer >= k:
            break
    
    return cnt
