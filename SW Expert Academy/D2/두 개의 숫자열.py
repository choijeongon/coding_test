

T = int(input())

for testcase in range(1, T+1):
    N, M = map(int, input().split())

    a_list = list(map(int, input().split()))
    b_list = list(map(int, input().split()))

    max_value = 0

    if N == M:
        for index in range(N):
            max_value += (a_list[index] * b_list[index])
    elif N < M:
        for i in range(M-N+1):
            temp = 0
            for j in range(N):
                temp += a_list[j] * b_list[i+j]

            max_value = max(temp, max_value)

    elif N > M:
        for i in range(N-M+1):
            temp = 0
            for j in range(M):
                temp += a_list[i+j] * b_list[j]
            max_value = max(temp, max_value)

    print("#{} {}".format(testcase, max_value))

