def solution(id_pw, db):
    
    '''success = 0
    wrong = 0
    fail = 0
    
    for ID,PW in db:
        if ID == id_pw[0] and PW == id_pw[1]:
            success += 1
        elif ID == id_pw[0] and PW != id_pw[1]:
            wrong += 1
        else:
            fail += 1
    
    if success > 0:
        return "login"
    elif wrong > 0:
        return "wrong pw"
    else:
        return "fail"
    '''
    
    if any(id_pw == data for data in db):
        return "login"
    elif any(id_pw[0] == data[0] for data in db):
        return "wrong pw"
    else:
        return "fail"