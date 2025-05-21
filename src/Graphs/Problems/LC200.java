package Graphs.Problems;

import java.util.LinkedList;
import java.util.Queue;

/*

https://leetcode.com/problems/number-of-islands/
 */
public class LC200 {
    public static void main(String[] args) {

    }
    class Pair {
        int first, second;
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
        public int getKey() {
            return first;
        }
        public int getValue() {
            return second;
        }
    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        boolean[][] isVisited=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && !isVisited[i][j]){
                    bfs(i,j,isVisited,grid);
                    count++;
                }
            }
        }
        return count;
    }
    private void bfs(int rowCurrent,int colCurrent,boolean[][] isVisited,char[][] grid){
        isVisited[rowCurrent][colCurrent]=true;
        Queue<Pair> q=new LinkedList<>();
        int n=grid.length;
        int m=grid[0].length;
        q.add(new Pair(rowCurrent,colCurrent));
        while(!q.isEmpty()){
            int r=q.peek().getKey();
            int c=q.peek().getValue();
            q.remove();
            if(r+1<n && grid[r+1][c]=='1' &&!isVisited[r+1][c]){
                q.add(new Pair(r+1,c));
                isVisited[r+1][c]=true;
            }
            if(r-1>=0 && grid[r-1][c]=='1' &&!isVisited[r-1][c]){
                q.add(new Pair(r-1,c));
                isVisited[r-1][c]=true;
            }
            if(c-1>=0 && grid[r][c-1]=='1' &&!isVisited[r][c-1]){
                q.add(new Pair(r,c-1));
                isVisited[r][c-1]=true;
            }
            if(c+1<m && grid[r][c+1]=='1' &&!isVisited[r][c+1]){
                q.add(new Pair(r,c+1));
                isVisited[r][c+1]=true;
            }
        }
    }
}
