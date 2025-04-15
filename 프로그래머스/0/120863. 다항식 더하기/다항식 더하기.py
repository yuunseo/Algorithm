'''
1. 아이디어
    - 공백을 구분자로 나누어 저장한다
    - x를 포함하는 항일 경우, x를 제외한 앞 정수들끼리 더한다
    - x를 포함 안하는 항일 경우, 정수들끼리 더한다
'''
def solution(polynomial):
    List = polynomial.split(" ")
    
    xnum = 0
    num = 0

    for i in List:
        if 'x' in i:
            if len(i)>1:
                xnum += int(i[:-1])
            else:
                xnum += 1
        elif 'x' not in i and i.isdigit(): # '+'는 처리하지 않는다
            num += int(i)
    

    result = ""
    if xnum > 1:
        result += str(xnum)+"x"
    elif xnum == 1:
        result += "x"
    
    if num != 0 and result != "":
        result += " + "+str(num)
    elif num != 0 and result == "":
        result += str(num)
    
    return result