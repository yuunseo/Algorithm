'''
1. 아이디어
    - 최소 피로도, 소모 피로도
    - 유저는 최소 피로도 이상을 갖고 > 던전 > 피로도 - 소모 피로도
    > 이어서 던전을 참가하기 위해서는 (기존 피로도 - 소모 피로도)가 다음 던전의 최소 피로도 이상이어야 한다
    - 최대 던전의 수를 return
    
    - for loop
'''
from itertools import permutations

def solution(k, dungeons):
    
    # 1. 가능한 모든 순서 정하기
    all_case = list(permutations(dungeons))
    
    # 2. 각 case들을 보면서, 얼마나 많이 갈 수 있는지 구하기
    total_count = set()
    
    for case in all_case:
        cnt = 0
        heart = k
        for dungeon in case:
            if heart >= dungeon[0]: # 현재, 최소피로도 이상일 경우 참여 가능
                heart -= dungeon[1]
                cnt += 1
            else:
                break
        total_count.add(cnt)
                
    # 3. 경우의 수 중 가장 큰 값 반환
    return max(total_count)
            
    