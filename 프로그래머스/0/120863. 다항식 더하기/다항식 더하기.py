def solution(polynomial):
    terms = polynomial.split()

    xnum = 0
    num = 0

    for term in terms:
        if 'x' in term:
            xnum += int(term[:-1]) if term != 'x' else 1
        elif term.isdigit():
            num += int(term)

    result = []
    if xnum:
        result.append(f"{xnum}x" if xnum > 1 else "x")
    if num:
        result.append(str(num))

    return " + ".join(result)
