
T = int(input())

result_map = {}

for index in range(T):
    N = int(input())
    data = list(map(int, input().split()))
    data = sorted(data)

    M = ''

    for value in data:
        M += (str(value) + " ")
    
    result_map[index+1] = M

for index in range(T):
    print("#"+str(index+1) + " " + result_map[index+1])