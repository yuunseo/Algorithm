'''
1. 아이디어
    - 주어진 정수들을 이용하여 target을 만드는 경우의 수 구하기(조합 탐색: DFS)
    1) 그래프를 그려, 좌로 이동 시에는 음수를 우로 이동 시에는 양수를 표현한다
    2) 모든 그래프의 리프까지 도달한 후, 각 값들이 target과 같다면 cnt += 1
    - graph를 구성해야 한다
'''

def solution(numbers, target):
    
    def dfs(index, current_sum):
        
        if index == len(numbers): # 종료 조건 필요(재귀함수)
            return 1 if current_sum == target else 0
        
        return dfs(index + 1, current_sum + numbers[index]) + \
               dfs(index + 1, current_sum - numbers[index])
    
    return dfs(0, 0)