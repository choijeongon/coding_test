package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_10026 {
    static int N;
    static char[][] board;
    static char[][] copyBoard;
    static boolean[][] visit;
    static boolean[][] visitCopyBoard;
    static int redCount; // 1
    static int greenCount;// 2
    static int blueCount; // 3
    
    static int redGreenCount;
    
    static final int[] dx = {-1,0,+1,0};
    static final int[] dy = {0,+1,0,-1};
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        board = new char[N][N];
        
        // 그린/레드 통합 보드
        copyBoard = new char[N][N];
        visit = new boolean[N][N];
        visitCopyBoard = new boolean[N][N];
        
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }
        //Input End
        
        for (int i = 0; i < N; i++) {
        	for (int j = 0; j < N; j++) {
				if(board[i][j] == 'G') {
					copyBoard[i][j] = 'R';
				} else {
					copyBoard[i][j] = board[i][j];
				}
			}
        }
        
        //완탐
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
            	if(!visitCopyBoard[i][j]) {
            		int colorCode = bfsCopyBoard(i, j);
            		
                    switch (colorCode) {
                    case 1:
                    	redGreenCount++;
                        break;
                    }
            	}
            	
            	//blue 값은 같이 사용
                if(!visit[i][j]) {
                    int colorCode = bfs(i, j);
                    
                    switch (colorCode) {
                    case 1:
                        redCount++;
                        break;
                    case 2:
                        greenCount++;
                        break;
                    case 3:
                        blueCount++;
                        break;
                    }
                }
            }
        }
        
        int totalCount = redCount + greenCount + blueCount;
        int copyTotalCount = redGreenCount + blueCount;
        
        System.out.println(totalCount + " " + copyTotalCount);
        
    }
    
    static int bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        
        queue.add(new Point(x, y));
        //처음 들어칸 칼라를 기준으로 판별
        char color = board[x][y];
        //방문 체크
        visit[x][y] = true;
        
        while(!queue.isEmpty()) {
            Point currentPoint = queue.poll();
            
            for (int d = 0; d < 4; d++) {
                int nextX = currentPoint.x + dx[d];
                int nextY = currentPoint.y + dy[d];
                
                //예외 처리
                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
                    continue;
                }
                
                //이미 방문한 곳일시 넘기기
                if(visit[nextX][nextY]) {
                    continue;
                }
                
                //처음 color와 같은 color가 아닐경우 패스
                if(color != board[nextX][nextY]) {
                    continue;
                }
                
                queue.add(new Point(nextX, nextY));
                visit[nextX][nextY] = true;
            }
            
        }
        
        //처음 들어온 칼라에 따라 색깔 값
        switch (color) {
        case 'R':
            return 1;
        case 'G':
            return 2;
        case 'B':
            return 3;
        }
        
        return -1;
    }
    
    static int bfsCopyBoard(int x, int y) {
    	Queue<Point> queue = new LinkedList<>();
    	
    	queue.add(new Point(x, y));
    	//처음 들어칸 칼라를 기준으로 판별
    	char color = copyBoard[x][y];
    	//방문 체크
    	visitCopyBoard[x][y] = true;
    	
    	while(!queue.isEmpty()) {
    		Point currentPoint = queue.poll();
    		
    		for (int d = 0; d < 4; d++) {
    			int nextX = currentPoint.x + dx[d];
    			int nextY = currentPoint.y + dy[d];
    			
    			//예외 처리
    			if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
    				continue;
    			}
    			
    			//이미 방문한 곳일시 넘기기
    			if(visitCopyBoard[nextX][nextY]) {
    				continue;
    			}
    			
    			//처음 color와 같은 color가 아닐경우 패스
    			if(color != copyBoard[nextX][nextY]) {
    				continue;
    			}
    			
    			queue.add(new Point(nextX, nextY));
    			visitCopyBoard[nextX][nextY] = true;
    		}
    		
    	}
    	
    	//처음 들어온 칼라에 따라 색깔 값
    	switch (color) {
    	case 'R':
    		return 1;
    	}
    	
    	return -1;
    }
    
    static void printBoard() {
        for (char[] list : board) {
            System.out.println(Arrays.toString(list));
        }
    }
    
    static class Point{
        int x;
        int y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point [x=" + x + ", y=" + y + "]";
        }
    }
}