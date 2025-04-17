'''
1. 아이디어
    - a-e-i-o-u 순서대로 트리를 하나씩 추가한다
    - DFS를 이용하여 +1씩 순서가 증가한다
'''
from collections import deque

def dfs(current):
    global answer, found

    if current == word: # 종료조건1. word를 찾았으면 종료
        found = True
        return

    if found or len(current) == 5: # 종료조건2. 단어를 찾았거나 혹은 5개 문자가 생성된 경우
        return

    for char in alphaList: # a-e-i-o-u를 반복하면서, 순서 증가 및 다음 단어로 이동
        answer += 1
        dfs(current + char) # 다음으로 넘겨줄 때, 한 글자씩 추가
        if found:
            return
        
def solution(w):

    # 재귀 함수로 인해, 전역 변수 선언
    global word, answer, found, alphaList
    word = w
    answer = 0
    found = False
    alphaList = ['A', 'E', 'I', 'O', 'U']

    dfs("")
    return answer

