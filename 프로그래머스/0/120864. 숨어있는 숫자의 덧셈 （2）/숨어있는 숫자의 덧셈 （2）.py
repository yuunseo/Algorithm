'''
1. 아이디어
- my_string for문으로 가져오면서 숫자면 ""로 합치고, 숫자 아니면 공백 > 나중에 공백으로 split해서 더하면 됨.
2. 시간복잡도
- my_str의 길이반큼 반복 > O(1)
3. 변수
- int[] : list
'''

def solution(my_string):

    str_list = "".join(i if i.isdigit() else ' ' for i in my_string)  # list comprehension
    return sum(int(i) for i in str_list.split())