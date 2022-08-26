# 최장 증가 부분 수열
import bisect

def get_lis(sequence):
    L = [sequence[0]]
    for i in range(1, len(sequence)):
        if L[-1] < sequence[i]:
            L.append(sequence[i])
        else:
            lower_bound = bisect.bisect_left(L, sequence[i])
            L[lower_bound] = sequence[i]
        print(L)
    
    return len(L)