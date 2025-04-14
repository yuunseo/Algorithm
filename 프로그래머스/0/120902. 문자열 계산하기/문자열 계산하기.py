'''
1. 아이디어
- 공백을 기준으로 문자를 나누어 리스트에 담는다
    -> 하나씩 읽어온다.
        - 숫자면 int로 변경 후 저장
        - 연산자면 + 혹은 -로 구분하여 다음 인덱스 숫자 가져오기? for loop로 어려워보임
    -> 맨 처음 인덱스(이전 결과값) 제외하고, 다음 2개의 인덱스를 가져와서 결과에 더하기
2. 시간복잡도
- 총 문자열을 split한 리스트의 길이가 최대 100이라고 치면, O(N): 하나씩 접근해서 확인해야 하니까
3. 변수
- int: 결과 값 저장할 정수
- int: index 계산할 정수
- char[]: 문자열 split해서 저장할 리스트
'''

def solution(my_string):

    char_list = my_string.split(" ")
    total = int(char_list[0])

    idx = 1
    while idx < len(char_list):
        if char_list[idx] == '+':
            total += int(char_list[idx+1])
        else:
            total -= int(char_list[idx+1])
        idx += 2
        
    return total
            