# 설명
# https://gsmesie692.tistory.com/113

def knapsack(W, wt, val, n): # W: 배낭의 무게한도, wt: 각 보석의 무게, val: 각 보석의 가격, n: 보석의 수
    K = [[0 for x in range(W+1)] for x in range(n+1)] # DP를 위한 2차원 리스트 초기화    
    for i in range(n+1): 
        for w in range(W+1): # 각 칸을 돌면서            
            if i==0 or w==0: # 0번째 행/열은 0으로 세팅                
                K[i][w] = 0 
            elif wt[i-1] <= w: # 점화식을 그대로 프로그램으로                
                K[i][w] = max(val[i-1]+K[i-1][w-wt[i-1]], K[i-1][w]) # max 함수 사용하여 큰 것 선택            
            else: 
                K[i][w] = K[i-1][w] 
    return K[n][W]

def dp(W, N, weight_list, value_list):
    K = [[0] * (W+1) for _ in range(N+1)]
    
    for index in range(N+1):
        for weight in range(W+1):
            if index == 0 or weight == 0:
                K[index][weight] = 0
            elif weight_list[index - 1] <= W:
                K[index][weight] = max(value_list[index-1] + K[index-1][weight - weight_list[index-1]], K[index-1][weight])
            else:
                K[index][weight] = K[index-1][weight]
    return K[N][W]