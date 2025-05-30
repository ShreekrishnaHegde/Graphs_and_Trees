package Graphs.Problems;

import java.util.LinkedList;
import java.util.Queue;

/*
https://www.geeksforgeeks.org/problems/distance-of-nearest-cell-having-1-1587115620/1
 */
public class DistanceOfNearestCell {
    class Node{
        int first;
        int second;
        int third;
        Node(int first,int second,int third){
            this.first=first;
            this.second=second;
            this.third=third;
        }
    }
    public static void main(String[] args) {

    }
    public int[][] grid(int[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] isVisited=new boolean[n][m];
        int[][] distance=new int[n][m];
        Queue<Node> q= new LinkedList<>();
        int[] delRow={-1,0,1,0};
        int[] delCol={0,1,0,-1};

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!isVisited[i][j]){
                    isVisited[i][j]=true;
                    q.add(new Node(i,j,0));
                }
            }
        }
        while (!q.isEmpty()){
            int row=q.peek().first;
            int col=q.peek().second;
            int steps=q.peek().third;
            q.remove();
            distance[row][col]=steps;
            for(int i=0;i<4;i++){
                int nRow=row+delRow[i];
                int nCol=col+delCol[i];
                if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && !isVisited[nRow][nCol]){
                    isVisited[nRow][nCol]=true;
                    q.add(new Node(nRow,nCol,steps+1));
                }
            }
        }
        return distance;
    }
}
/*
TC:N x M
Sc:N x M
 */