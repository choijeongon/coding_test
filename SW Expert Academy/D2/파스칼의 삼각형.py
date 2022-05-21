

T = int(input())

result_map = {}

for i in range(0, T):
    N = int(input())

    arr = [[0] * N for _ in range(N)]

    for i in range(N):
        for j in range(i+1):
            if j==0 or j==i:
                arr[i][j] = 1
            else:
                arr[i][j] = arr[i-1][j] + arr[i-1][j-1]
    
    result_map[i+1] = arr

for i in range(0, T):
    print("#" + str(i+1))
    for j in range(len(result_map[i+1])):
        for k in range(len(result_map[i+1][j])):
            if result_map[i+1][j][k] != 0:
                print(result_map[i+1][j][k], end = " ")
        print()


    
