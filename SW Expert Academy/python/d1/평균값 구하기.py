# t = input()

# count = 1

# dic = {}

# for index in range(int(t)):
#     data = list(map(int, input().split()))
#     result = 0
#     for value in range(len(data)):
#         result += data[value]
#         average = round(result / len(data))
#     dic[index+1] = average


# while count <= int(t):
#     print('#' + str(count) + " " + str(dic[count]))
#     count += 1



T = int(input())

result_map = {}

for i in range(T):
    data = list(map(int, input().split()))
    result = 0

    for val in data:
        result += val

    average = round(result / len(data))

    result_map[i+1] = average

for i in range(T):
    print("#" + str(i+1) + " " + str(result_map[i+1]))
    
     
