
def calcul(number, value):
    for a in range(10):
        for b in range(10):
            for c in range(10):
                for d in range(10):
                    for e in range(10):
                        if value == (2 ** a) * (3 ** b) * (5 ** c) * (7 ** d) * (11 ** e):
                            print('#{} {} {} {} {} {}'.format(number, a, b, c, d, e))

T = int(input())

for testcase in range(1, T+1):
    N = int(input())

    calcul(testcase, N)

