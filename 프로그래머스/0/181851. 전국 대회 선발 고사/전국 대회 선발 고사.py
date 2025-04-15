'''
1. 아이디어
- rank별 학생들 중, true인 학생들로만 골라놓고, 상위 3명을 a,b,c로 고른다.
'''

def solution(rank, attendance):
    avail_student = [(i,rank[i]) for i in range(len(rank)) if attendance[i]] # i번 학생의 등수: rank[i]
        
    sortedList =sorted(avail_student, key=lambda x:x[1])
    
    a,b,c = sortedList[0][0], sortedList[1][0], sortedList[2][0]
    
    return 10000*a + 100*b + c
    