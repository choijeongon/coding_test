# t = input()

# count = 1

# dic = {}

# for index in range(int(t)):
#     data = input()

#     result = ''

#     temp = ''

#     for i in data:
#         temp = i + temp
    
#     if data == temp:
#         result = '1'
#     else:
#         result = '0'

#     dic[index+1] = result

# while count <= int(t):
#     print('#' + str(count) + " " + str(dic[count]))
#     count += 1

T = int(input())

result_map = {}

for i in range(T):
    data = input()

    temp = ''

    for index in range(len(data)-1, -1, -1):
        temp += data[index]
    
    if data == temp:
        result_map[i+1] = '1'
    else:
        result_map[i+1] = '0'

for i in range(T):
    print("#" + str(i+1) + " " + result_map[i+1])
