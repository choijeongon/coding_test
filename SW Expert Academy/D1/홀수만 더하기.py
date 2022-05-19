# t = input()

# count = 1

# dic = {}

# for index in range(int(t)):
#     data = list(map(int, input().split()))
#     result = 0
#     for value in range(len(data)):
#         if(data[value] % 2 != 0):
#             result += data[value]
#     dic[index+1] = result


# while count <= int(t):
#     print('#' + str(count) + " " + str(dic[count]))
#     count += 1

T = int(input())

result_map = {}

for i in range(T):
    data = list(map(int, input().split()))

    result = 0

    for val in data:
        if(val % 2 != 0):
            result += val
    
    result_map[i+1] = result

for i in range(T):
    print("#" + str(i+1) + " " + str(result_map[i+1]))