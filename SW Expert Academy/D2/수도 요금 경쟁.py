T = int(input())

result_map = {}

for i in range(T):
    P, Q, R, S, W = map(int, input().split())

    A = P * W

    B = 0

    if W <= R:
        B = Q
    else:
        B = Q + ((W-R)*S)

    if A > B:
        result_map[i+1] = B
    else:
        result_map[i+1] = A

for i in range(T):
    print('#' + str(i+1) + ' ' + str(result_map[i+1]))
    
