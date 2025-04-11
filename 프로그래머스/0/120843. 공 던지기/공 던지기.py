'''
1. 아이디어
- 원형으로 서 있기 때문에, 인덱스가 초과된다면 다시 0부터 연결시켜야 함
    - 0,1,2,3 -> +2를 더한 인덱스 % 길이
2. 시간복잡도
- O(k): k번 반복하기
3. 변수
- int: index
'''

def solution(numbers, k):
    idx = 0 # 던지는 사람의 인덱스
    
    for i in range(1,k): # 1,2,3, ... k번
        idx += 2
        
    return numbers[idx % len(numbers)] # 연속됨을 표현하기 위하여 전체 길이로 나눈 나머지 값
        