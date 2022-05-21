
T = int(input())

result_map = {}

for index in range(1, T+1):
    N, M = map(int, input().split())
    arr = []
    for i in range(N):
        temp = list(map(int, input().split()))
        arr.append(temp)
    
    n = M-1
    max_v = 0

    for i in range(N-n):
        for j in range(N-n):
            sum_v = 0

            for di in range(M):
                for dj in range(M):
                    sum_v += arr[i+di][j+dj]
            
            if sum_v > max_v:
                max_v = sum_v
    
    result_map[index] = max_v

for index in range(1, T+1):
    print("#" + str(index) +" " +str(result_map[index]))

