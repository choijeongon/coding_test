
def solution(n, lost:list, reserve:list):
    for value in lost:
        if value in reserve:
            reserve.remove(value)
            lost.remove(value)

    n -= len(lost)

    temp = lost[:]
    
    for value in temp:
        lost_plus = value+1
        lost_minus = value-1

        if lost_minus in reserve:
            reserve.remove(lost_minus)
            lost.remove(value)
            n += 1
            continue

        if lost_plus in reserve:
            reserve.remove(lost_plus)
            lost.remove(value)
            n += 1
            
    return n
