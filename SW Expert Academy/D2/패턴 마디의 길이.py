
T = int(input())

result_map = {}

for index in range(1, T+1):
    data = input()

    mady = ''

    for i in range(1, len(data) + 1):
        if data[:i] == data[i:i*2]:
            mady = data[:i]
            break

    result_map[index] = len(mady)

for index in range(1, T+1):
    print("#" + str(index) + " " + str(result_map[index]))