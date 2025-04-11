'''
1. 아이디어
- Z가 나오면, Z바로 앞 숫자를 무용지물
- split(): 공백으로 구분하여 리스트로 생성
    -> Z의 인덱스를 찾아서, 해당 인덱스와 바로 이전 인덱스를 없애기
        -> del을 이용하여 지워버리면, 다음 인덱스가 변경되기 땜에 안됨.
        -> 슬라이싱으로? 하면, 너무 복잡해 지는군!
    -> item이 int라면 더하고, "Z"라면, 이전 값을 빼준다.
2. 시간복잡도
- O(N): 모든 원소에 접근한다.
3. 변수
- list: s를 구분자로 나누어 리스트로 저장
- int: 토탈 값 더하기
'''

def solution(s):
    s_list = s.split()
    total = 0
    
    for idx, item in enumerate(s_list):
        if item == "Z":
            total -= int(s_list[idx-1])
        else:
            total += int(item)
    
    return total    