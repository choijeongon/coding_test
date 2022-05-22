
# 2차원 배열 뒤집기
N = int(input())

board = [list(map(int, input().split()))for _ in range(N)]
reversed_b = [[0] * N for _ in range(N)]

for i in range(N):
    for j in range(N):
        reversed_b[j][N-1-i] = board[i][j]

print(board)
print(reversed_b)



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