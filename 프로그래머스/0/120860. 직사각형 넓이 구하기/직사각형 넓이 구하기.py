
def solution(dots):
    
    dots = sorted(dots, key=lambda x: x[0])
    width = abs(dots[0][0] - dots[2][0])
    length = abs(dots[0][1] - dots[1][1])
    
    return width*length