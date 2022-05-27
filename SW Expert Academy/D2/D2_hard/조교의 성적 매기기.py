#1
# T = int(input())
# grades = ['A+', 'A0', 'A-', 'B+', 'B0', 'B-', 'C+', 'C0', 'C-', 'D0']

# result_map = {}

# for tc in range(1, T+1):
#     N, K = map(int, input().split())
#     total_list = []
#     for _ in range(N): # n번 돌아
#         mid, final, hws = map(int, input().split())
#         total = (mid * 0.35) + (final * 0.45) + (hws*0.2)
#         total_list.append(total)
#         # [74.6, 92.55000000000001, 88.8, 99.45, 72.35, 85.85000000000001, 96.25, 68.95, 85.5, 85.75]

#     # k번 학생의 점수
#     # 먼저 k번째 학생의 인덱스를 구해주고
#     k_score = total_list[K-1]
    
#     # 정렬
#     total_list.sort(reverse=True)
#     # [99.45, 96.25, 92.55000000000001, 88.8, 85.85000000000001, 85.75, 85.5, 74.6, 72.35, 68.95]
#     div = N//10
#     final_k_score = total_list.index(k_score) // div

#     result_map[tc] = grades[final_k_score]

# for tc in range(1, T+1):
#     print("#" + str(tc) + " " + result_map[tc])

#2


score_list = ['A+', 'A0', 'A-', 'B+', 'B0', 'B-', 'C+', 'C0', 'C-', 'D)']

T = int(input())

for testcase in range(1, T+1):
    # N: 학생 수, K는 학점을 알고 싶은 학생의 번호
    N, K = map(int, input().split())

    total_score_list = []

    for _ in range(N):
        middle_score, final_score, subject_score = map(int, input().split())
        total_score = (middle_score * 0.35) + (final_score * 0.45) + (subject_score * 0.2)
        total_score_list.append(total_score)

    K_Score = total_score_list[K-1]

    total_score_list.sort(reverse=True)
    div = N//10
    final_k_score = total_score_list.index(K_Score) // div

    print("#{} {}".format(testcase, score_list[final_k_score]))