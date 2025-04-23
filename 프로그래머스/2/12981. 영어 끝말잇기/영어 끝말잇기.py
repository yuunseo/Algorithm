'''
1.아이디어
    1~n~1(원형)
    중복 금지, 앞 사람의 마지막 글자로 시작 [-1] == [0], 한 글자 금지
    가장 먼저 탈락하는 사람의 번호와 순서 반환하기
    1) 순서를 셀 카운트 변수 생성 cnt = 0
    2) 한 글자씩 가져와서 set에 넣기 -> 이전 set의 길이와 동일하면 중복된 단어이므로 탈락!
    3) 앞뒤 글자도 확인
    4) 몇 번째 사람인지는 나누기로 : index //n = 순서, index % n = 몇 번째 사람인지
    >> 아래 짠 코드의 문제: 동일한 단어 추가 시 처리 안 됨!
'''
def solution(n, words):
    
    # 변수 초기화
    order = 0
    per_num = 0
    before = words[0]
    
    for i in range(1,len(words)):
        present = words[i]
        if present[0] == before[-1]:
            before = present
            if before not in set(words[:i]):
                continue
            else: # 단어가 추가되지 않았다면, 탈락!
                order = i//n
                per_num = i%n
                return [per_num+1,order+1]
        else: # 끝말과 다를 경우, 탈락!
            order = i//n
            per_num = i%n   
            return [per_num+1,order+1]
        
    return [per_num,order] # 탈락자가 없을 경우, 그대로 반환