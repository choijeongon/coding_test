N = int(input())

result_map = {}

for i in range(N):
    data = list(input().split())
    # data[0]: 이름, data[1]: 성적
    result_map[int(data[1])] = data[0]

result_li = []


while result_map:
    result = min(result_map.keys())

    result_li.append(result_map[result])
    del result_map[result]

for value in result_li:
    print(value, end=' ')




