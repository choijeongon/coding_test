t = input()

count = 1

dic = {}

for index in range(int(t)):
    data = list(map(int, input().split()))
    result = 0
    for value in range(len(data)):
        result += data[value]
        average = round(result / len(data))
    dic[index+1] = average


while count <= int(t):
    print('#' + str(count) + " " + str(dic[count]))
    count += 1