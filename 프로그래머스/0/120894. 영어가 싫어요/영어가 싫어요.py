'''
1. 아이디어
- one, two, ... : 딕셔너리로 만들어두고 바꾸기
    > 문자들의 글자 수가 다 다르므로, 어떻게 매치할 것인지 알아야 함.
    > dict에서 키 값을 하나씩 가져오면서, in을 이용하여 포함되는지 확인 > replace로 대체하기
2. 시간복잡도
- 10개의 딕셔너리를 접근해야 하므로, O(1)
3. 변수
- 영문숫자-정수 저장할 딕셔너리
- 바꾼 결과를 저장할 문자열 -> 정수로 바꿔서 반환
'''

def solution(numbers):
    num_dict = {'zero':'0', 'one':'1', 'two':'2', 'three':'3', 'four':'4', 'five':'5', 'six':'6', 'seven':'7', 'eight':'8', 'nine':'9'}
    
    for k,v in num_dict.items():
        if k in numbers:
            numbers = numbers.replace(k,v)
            
    return int(numbers)