
def check():
    if binary[:N] == '1' * N:
        print("#{} {}".format(index, "ON"))
    else:
        print("#{} {}".format(index, "OFF"))

T = int(input())

for index in range(1, T+1):
    N, M = map(int, input().split())

    binary = format(M, 'b')

    binary = binary[::-1]

    check()