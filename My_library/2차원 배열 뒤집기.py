# 2차원 배열 뒤집기
N = int(input())

board = [list(map(int, input().split()))for _ in range(N)]
reversed_b = [[0] * N for _ in range(N)]

for i in range(N):
    for j in range(N):
        reversed_b[j][N-1-i] = board[i][j]

print(board)
print(reversed_b)