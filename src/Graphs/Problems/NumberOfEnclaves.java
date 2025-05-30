package Graphs.Problems;

import java.awt.image.ImageConsumer;
import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/problems/number-of-enclaves/
https://www.geeksforgeeks.org/problems/number-of-enclaves/1
 */
public class NumberOfEnclaves {
    class Pair{
        int first;
        int second;
        Pair(int first,int second) {
            this.first = first;
            this.second = second;
        }
    }
    public static void main(String[] args) {

    }
    public int numberOfEnclaves(int[][] grid){
        int count=0;
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] isVisited=new boolean[n][m];
        Queue<Pair> q=new LinkedList<>();
        int[] delRow={-1,0,1,0};
        int[] delCol={0,1,0,-1};

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i == 0 || i==n-1 || j==0 || j==m-1){
                    if(grid[i][j]==1){
                        isVisited[i][j]=true;
                        q.add(new Pair(i,j));
                    }
                }
            }
        }

        while (!q.isEmpty()){
            int row=q.peek().first;
            int col=q.peek().second;
            q.remove();
            for(int i=0;i<4;i++){
                int nRow=row+delRow[i];
                int nCol=col+delCol[i];
                if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && !isVisited[nRow][nCol] && grid[nRow][nCol]==1){
                    isVisited[nRow][nCol]=true;
                    q.add(new Pair(nRow,nCol));
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!isVisited[i][j] && grid[i][j]==1){
                    count++;
                }
            }
        }


        return count;
    }
}
/*
TC: N x N
SC: O(Nx N)
 */