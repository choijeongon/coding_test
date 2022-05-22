

N = int(input())

board = [list(map(int, input().split()))for _ in range(N)]
reversed_b = [[0] * N for _ in range(N)]

for i in range(N):
    for j in range(N):
        reversed_b[j][N-1-i] = board[i][j]