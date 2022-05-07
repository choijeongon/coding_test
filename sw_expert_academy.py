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
# t = input()

# count = 1

# dic = {}

# for index in range(int(t)):
#     data = list(map(int, input().split()))
#     result = ''

#     if data[0] > data[1]:
#         result = '>'
#     elif data[0] < data[1]:
#         result = '<'
#     elif data[0] == data[1]:
#         result = '='

#     dic[index+1] = result


# while count <= int(t):
#     print('#' + str(count) + " " + str(dic[count]))
#     count += 1

# 4. 최대수 구하기
# t = input()

# count = 1

# dic = {}

# for index in range(int(t)):
#     data = list(map(int, input().split()))
#     result = 0

#     for i in range(len(data)):
#         result = max(result, data[i])

#     dic[index+1] = result


# while count <= int(t):
#     print('#' + str(count) + " " + str(dic[count]))
#     count += 1

# 5. 중간값 구하기
# t = input()

# data = list(map(int, input().split()))

# data = sorted(data)

# print(data[len(data)//2])

# 6. 거꾸로 출력해 보아요
# val = int(input())

# li = ''

# for i in range(val, -1, -1):
#     li += str(i)
#     li += ' '

# print(li)

# 7. 신문 헤드라인
# t = input()

# t = t.upper()

# print(t)

# 8. 알파벳을 숫자로 변환
# t = input()

# letter_list = list("ABCDEFGHIJKLMNOPQRSTUVWXYZ")
# number_li = list(range(1, 27))

# string_list = ''

# for value in list(t):
#     for check in letter_list:
#         if(check == value):
#             string_list += str(number_li[letter_list.index(check)])
#             string_list += ' '

# print(string_list)

# 9. 스탬프 찍기
stemp = int(input())

letter = ''

for i in range(stemp):
    letter += "#"

print(letter)