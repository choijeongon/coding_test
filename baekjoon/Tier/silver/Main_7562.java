package silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_7562 {
    static int N;
    static int[][] board;
    static boolean[][] visited;
    static int dept;
    
    static Position startPosition;
    static Position endPosition;
    
    static final int[] dx = {-1,-2,-2,-1,+1,+2,+2,+1}; //8방향
    static final int[] dy = {-2,-1,+1,+2,+2,+1,-1,-2};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int TC = sc.nextInt();
        
        for (int tc = 1; tc <= TC; tc++) {
            N = sc.nextInt();
            board = new int[N][N];
            visited = new boolean[N][N];
            dept = 0;
            
            startPosition = new Position(sc.nextInt(), sc.nextInt());
            endPosition = new Position(sc.nextInt(), sc.nextInt());
            
            bfs(startPosition.x, startPosition.y);
            
            System.out.println(dept);
        }

    }
    
    static void bfs(int x, int y) {
        Queue<Position> queue = new LinkedList<>();
        
        //처음꺼 넣고 방문 체크
        queue.add(new Position(x, y));
        visited[x][y] = true;
        
        loop:
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            for (int s = 0; s < size; s++) {
                Position currentPosition = queue.poll();
                
                //탈출 조건
                if(currentPosition.x == endPosition.x && currentPosition.y == endPosition.y) {
                    break loop;
                }
                
                for (int d = 0; d < 8; d++) {
                    int nextX = currentPosition.x + dx[d];
                    int nextY = currentPosition.y +dy[d];
                    
                    if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
                        continue;
                    }
                    
                    if(visited[nextX][nextY]) {
                        continue;
                    }
                    
                    queue.add(new Position(nextX, nextY));
                    visited[nextX][nextY] = true;
                }
                
            }
            dept++;
        }
        
    }
    
    static class Position{
        int x;
        int y;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public String toString() {
            return "Position [x=" + x + ", y=" + y + "]";
        }
    }
}