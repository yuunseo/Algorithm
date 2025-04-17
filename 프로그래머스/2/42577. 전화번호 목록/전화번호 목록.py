'''
1.아이디어
    - item을 하나씩 돌면서, startswith()를 해서 확인한다 하나라도 있으면 true 없으면 false
        -> n(n-1)번 반복해야 하므로, 시간복잡도 매우 초과 -> set()으로 바꿔서 찾으면 더 빨라진다
2.시간복잡도
    - list로도 가능한 연산이지만, 매우 많은 길이가 주어질 때 set 해시구조를 통해 복잡도를 줄일 수 있다.
'''
def solution(phone_book):
    phone_set = set(phone_book)
    
    for number in phone_book:
        prefix = ""
        for char in number[:-1]:
            prefix += char
            if prefix in phone_set:
                return False
    return True 