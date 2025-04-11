'''
1. 아이디어
- n씩 길이를 잘라서 배열로 만든다
2. 시간복잡도
- O(N): 모든 원소 접근하기
3. 변수
- list: 잘라서 저장할 리스트
'''


def solution(my_str, n):
    answer = [my_str[i:i+n] for i in range(0,len(my_str),n)]
    return answer