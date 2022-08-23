package d4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
class Solution_1238 {
    static int N;
    static int S;
    static boolean[] visited;
    static ArrayList<Integer>[] list;
     
    static ArrayList<Integer> resultList;
 
    static int max;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        for (int tc = 1; tc <= 10; tc++) {
            N = sc.nextInt();
            S = sc.nextInt();
 
            max = 0;
             
            resultList = new ArrayList<>();
 
            list = new ArrayList[N];
            visited = new boolean[N];
 
            for (int i = 0; i < N; i++) {
                list[i] = new ArrayList();
            }
 
            for (int i = 0; i < N / 2; i++) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                list[from].add(to);
            }
 
//          for(ArrayList li : list) {
//              for (int i = 0; i < li.size(); i++) {
//                  System.out.print(li.get(i) + " ");
//              }
//              System.out.println();
//          }
 
            bfs(S);
             
            for (int i = 0; i < resultList.size(); i++) {
                max = Math.max(max, resultList.get(i));
            }
             
            System.out.println("#" + tc + " " +max);
        }
    }
 
    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
 
        queue.offer(start);
        visited[start] = true;
 
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            resultList.clear();
            for (int s = 0; s < size; s++) {
                int currentIndex = queue.poll();
                
                // 할일 하기
                resultList.add(currentIndex);
//              System.out.println("currentIndex = " + currentIndex);
                
                for (int index : list[currentIndex]) {
                    if (visited[index] == true) {
                        continue;
                    }
                    
                    queue.offer(index);
                    visited[index] = true;
                }
            }
            
        }
    }
}