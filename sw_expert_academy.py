# 1. 홀수만 더하기
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

# 2. 평균값 구하기
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

# 3. 큰 놈, 작은 놈, 같은 놈
t = input()

count = 1

dic = {}

for index in range(int(t)):
    data = list(map(int, input().split()))
    result = ''

    if data[0] > data[1]:
        result = '>'
    elif data[0] < data[1]:
        result = '<'
    elif data[0] == data[1]:
        result = '='

    dic[index+1] = result


while count <= int(t):
    print('#' + str(count) + " " + str(dic[count]))
    count += 1