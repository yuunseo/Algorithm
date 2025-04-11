'''
1. 아이디어
- code의 인덱스와 원소를 가져와서, 인덱스를 q로 나눈 값이 r인 것들을 추출한다 -> 문자열로 합쳐서 반환
2. 시간복잡도
- O(N): code 하나씩 돌면서 조건문 확인
3. 변수
- str: r인 나머지를 뽑아서 더할 결과물
'''


def solution(q, r, code):
    answer = ''.join([item for idx,item in enumerate(list(code)) if idx%q == r])
    
    return answer