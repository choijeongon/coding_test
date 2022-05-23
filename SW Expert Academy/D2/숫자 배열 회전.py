
T = int(input())

for index in range(1, T+1):
    N = int(input())

    board = [list(map(int, input().split())) for _ in range(N)]

    reversed_board = [[0] * N for _ in range(N)]
    reversed_180_board = [[0] * N for _ in range(N)]
    reversed_270_board = [[0] * N for _ in range(N)]

    for i in range(N):
        for j in range(N):
            reversed_board[j][N-1-i] = board[i][j]

    for i in range(N):
        for j in range(N):
            reversed_180_board[j][N-1-i] = reversed_board[i][j]

    for i in range(N):
        for j in range(N):
            reversed_270_board[j][N-1-i] = reversed_180_board[i][j]
    
    print("#" + str(index))
    for index in range(N):
        print(''.join(str(n) for n in reversed_board[index]) + " " + ''.join(str(n) for n in reversed_180_board[index]) + " " + ''.join(str(n) for n in reversed_270_board[index]))