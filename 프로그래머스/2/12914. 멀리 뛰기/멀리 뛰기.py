'''
1. 아이디어
    n번째 칸에 도달하기 위해 1 혹은 2로 이루어진 모든 조합의 개수 % 1234567 을 리턴하기
    1 혹은 2로 이루어진 모든 조합의 개수를 알기 위해서는?
    2가 0개, 2가 1개, 2가 2개, ... 즉, n//2 개까지 2를 가질 수 있음.
    그럼 n//2만큼 개수를 가진다고 했을 때의 조합?
    2를 0개 가진다고 하면, 1을 n-2*0번 가지는 조합
    2를 1개 가진다고 하면, 1을 n-2*1번 가진는 조합
    2를 2개 가진다고 하면, 1을 n-2*2번 가지는 조합
    즉, 2를 i개 가진다고 하면, 1을 n-2*i번 가지는 조합 구하기
    >> 이걸 구현하려면 for문을 써서 2의 개수에 따른 1의 개수를 또 for문을 통해 list를 만들고 여기서 각각의 조합을 구해야 함...
    모두 1인 경우 -> nPn
    맨 첫째 값이 2가 아니라면, 0번+1번 -> 다시 nPn 
'''
'''from itertools import permutations
def solution(n):
    
    # 경우의 수를 구하기 위한 시작 배열: n개의 1로 구성됨
    li = [ 1 for i in range(n)]  
    cnt = 0
    idx = 0
    
    while len(li) > 2:
        p = permutations(li,len(li))
        cnt += len(set(p))
        
        if idx + 1 < len(li) and li[idx] == 1 and li[idx + 1] == 1:
            new_val = li[idx] + li[idx + 1]  # 두 값을 더해 저장
            del li[idx:idx+2]                # idx, idx+1 두 값을 삭제
            li.insert(idx, new_val)  
            idx += 1 # 새로운 값을 그 자리에 삽입
        
    p = permutations(li,len(li))
    cnt += len(set(p))
    
    return cnt'''

import math

def solution(n):
    answer = 0
    for i in range(n // 2 + 1):  # i: 2를 몇 개 쓸지
        ones = n - 2 * i         # 나머지는 모두 1
        total = ones + i         # 총 자리 수
        # 조합 계산: total! / (ones! * i!)
        answer += math.comb(total, i)
    
    return answer % 1234567
