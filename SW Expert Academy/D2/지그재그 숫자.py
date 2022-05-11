t = input()

count = 1

dic = {}

for index in range(int(t)):
    data = int(input())

    result = 0

    for i in range(data):
        value = i+1
        if value % 2 == 0:
            result -= value
        else:
            result += value

    dic[index+1] = result

while count <= int(t):
    print('#' + str(count) + " " + str(dic[count]))
    count += 1