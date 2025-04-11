'''
1. 아이디어
- 각 원소를 문자열로 바꿔서 count 사용하기
- count한 개수를 토탈해서 리턴하기
2. 시간복잡도
- count 함수 시간 복잡도 O(N)
- 원소 모두 둘러보기 O(N)
3.  변수
- 토탈 값 int
'''

def solution(array):
    total = 0
    
    for i in array:
        total += str(i).count("7")
    
    return total