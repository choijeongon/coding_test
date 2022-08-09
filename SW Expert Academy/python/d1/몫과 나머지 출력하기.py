T = int(input())

result_map = {}

for i in range(T):
    a, b = map(int, input().split())

    dap = a // b
    namuzi = a % b
    result_map[i+1] = str(dap) + " " + str(namuzi)


for i in range(T):
    print("#" + str(i+1) + " " + result_map[i+1])

