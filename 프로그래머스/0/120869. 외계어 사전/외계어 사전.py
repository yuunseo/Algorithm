'''
1. 아이디어
    1) char list 형태로 만든 후, 정렬한 리스트끼리 비교한다
'''

def solution(spell, dic):
    
    # 1. dic을 list로 변환
    part = [sorted(i) for i in dic]
    
    # 2. spell을 정렬
    spell = sorted(spell)

    # 3. part에서 spell과 같은 item이 있는지 확인
    for item in part:
        if item == spell:
            return 1
    
    return 2
    