package d4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_1227 {

    static int[][] map = null;
    static int sx,sy, ex, ey;
    static int res;
    static int[] dx = {0,0,-1,1}; // 상하좌우
    static int[] dy = {-1,1,0,0};
    static int[][] v;
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        for(int t = 1; t <=10; t ++) {
            sc.nextInt();
            res = 0;
            map = new int[100][100];
            v = new int[100][100]; //0으로 초기화
            String s = "";
            for(int i = 0 ; i < 100; i++) {
                s = sc.next();
                for(int j = 0; j < 100; j++) {
                    map[i][j] = s.charAt(j) - '0';
                    if(map[i][j] == 2) {
                        sx = j;
                        sy = i;
                    }
                    if(map[i][j] == 3) {
                        ex = j;
                        ey = i;
                    }
                }
            }
            //입력데이터 출력
            //시물레이션
//        시작점에서 4방위로 이동해보면서 목적지인지 아닌지 판단해봐야겠군
//            dfs(sx, sy);
            bfs(sx, sy);
            //출력
            System.out.println("#" + t + " " + res);
        }

    }
    static class Data{
    	int x, y;

		public Data(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Data [x=" + x + ", y=" + y + "]";
		}
    }
    
    static void bfs(int x, int y) {
    	// 큐 자료구조 필요
    	Queue<Data> q = new LinkedList<>();
    	q.offer(new Data(x,y));
    	v[y][x] = 1;
    	
    	while(!q.isEmpty()) {
    		Data cur = q.poll();
    		if(cur.x == ex && cur.y == ey) {
    			res = 1;
    			return;
    		}
    		
    		int nx, ny;
    		for(int d = 0; d < 4; d++) {
    			nx = cur.x + dx[d];
    			ny = cur.y + dy[d];
    			
    			// 배열의 범위를 벗어나는 것은 유망하지 않다.
    			if(nx < 0 || nx >= 100 || ny < 0 || ny >= 100) {
    				continue;
    			}
    			// 이미 방문했어? 유망하지 않아(가지 치기)
    			if(v[ny][nx] == 1) {
    				continue;
    			}
    			// 문제 요구 사항 처리
    			if(map[ny][nx] == 1 || map[ny][nx] == 2) {
    				continue;
    			}
    			
    			//유망하니까 다음 작업 진행, 방문 처리
    			q.offer(new Data(nx, ny));
    			v[ny][nx] = 1;
    			
    		}
    	}
    	
    }
    
    static void dfs(int x, int y) {
        v[y][x] = 1;
        //종료조건
        if(x == ex && y == ey) {
            res = 1;
            return;
        }
        //실행& 자기호출
        int nx, ny;
        for(int d = 0; d < 4; d++) {
            nx = x + dx[d];
            ny = y + dy[d];
            //배열범위 넘어가지 마라
            if(nx < 0 || nx >= 100 || ny < 0 || ny >= 100) {
                continue;
            }
            //갔던곳 또가면 안돼
            if(v[ny][nx] == 1) {
                continue;
            }
            //길이아니면 못간다.(목적지는 간다.)
            if(map[ny][nx] == 1 || map[ny][nx] == 2) {
                continue;
            }
            //4방위 가본다.
//            v[ny][nx] = 1;
            dfs(nx, ny);
        }
    }

}