'''
1. 아이디어
- 가로 세로로 k배씩 늘려야 한다 하지만 . 혹은 x로 구분해야 하므로 나눠서 해야함
- .뭉텅이, x뭉텅이로 구분해야 한다 > 정규식 사용하기
'''

import re

def solution(picture, k):
    
    p = [i for i in picture for j in range(k)]
            
    part_string = [re.findall(r'\.+|x+',part) for part in p ]
    
    new_part=[[j*k for j in i]for i in part_string ]


    return ["".join(i) for i in new_part]