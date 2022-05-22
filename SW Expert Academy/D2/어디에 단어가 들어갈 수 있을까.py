
T = int(input())

for test_case in range(1, T+1):
    N, K = map(int, input().split())
    board = [list(map(int, input().split()))for _ in range(N)]
    reverse_board = [[0]*N for _ in range(N)]

    for i in range(N):
        for j in range(N):
            reverse_board[j][N-1-i] = board[i][j]

    total = 0

    for col in range(N):
        count = 0
        for row in range(N):
            if board[col][row] == 0:
                if count == K:
                    total += 1
                count = 0
            else:
                count += 1
        
        if count == K:
            total += 1

    for col in range(N):
        count = 0
        for row in range(N):
            if reverse_board[col][row] == 0:
                if count == K:
                    total += 1
                count = 0
            else:
                count += 1
        
        if count == K:
            total += 1
                
    print("#{} {}".format(test_case, total))
