'''
1.아이디어
    - 수포자 3인방의 찍는 가장 간단한 part를 따로 저장한하여, answers가 주어지면 해당 순서에 맞게 반복해서 비교한다
    - 맞은 개수를 저장하고, 가장 많은 문제를 맞힌 사람을 배열에 담아 반환/여러 명 가능
'''

def solution(answers):
    # 수포자들이 찍는 규칙
    std1 = [1, 2, 3, 4, 5]
    std2 = [2, 1, 2, 3, 2, 4, 2, 5]
    std3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    
    # 맞춘 개수 카운트 초기화
    cnt1 = 0
    cnt2 = 0
    cnt3 = 0 
    
    # 각 수포자들이 찍은 답과 answers를 비교해서 맞춘 개수 세기
    for idx, answer in enumerate(answers):
        if std1[idx % len(std1)] == answer:
            cnt1 += 1
        if std2[idx % len(std2)] == answer:
            cnt2 += 1
        if std3[idx % len(std3)] == answer:
            cnt3 += 1
    
    # 각 수포자들의 점수 리스트
    std_scores = [cnt1, cnt2, cnt3]
    max_score = max(std_scores)  # 가장 많이 맞춘 점수를 구함
    
    # 가장 많은 점수를 맞춘 사람들의 번호 반환
    return [idx + 1 for idx, score in enumerate(std_scores) if score == max_score]

