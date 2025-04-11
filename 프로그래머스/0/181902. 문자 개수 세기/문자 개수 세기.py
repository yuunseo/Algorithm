'''
1. 아이디어
- a~z까지의 딕셔너리를 만든 후, my_string에서 읽어서 value 증가하기
2. 시간복잡도
- O(N): 주어진 string의 길이 만큼 추가
3. 변수
- dict: alpha 딕셔너리

'''
import string

def solution(my_string):
    
    # 대문자 + 소문자
    letters = string.ascii_uppercase + string.ascii_lowercase   
    
    alpha_dict = {char:0 for char in letters} 
    
    for char in my_string:
        alpha_dict[char] += 1
        
    return list(alpha_dict.values())