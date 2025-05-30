package Graphs.Problems;

import java.util.ArrayList;
import java.util.HashSet;

/*

https://www.geeksforgeeks.org/problems/number-of-distinct-islands/1

 */
public class DistinctIslands {
    public static void main(String[] args) {

    }
    public int countDistinctIslands(int[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] isVisited=new boolean[n][m];
        HashSet<ArrayList<String>> st=new HashSet<>();
        int[] delRow={-1,0,1,0};
        int[] delCol={0,-1,0,1};
        for(int i=0;i<n;i++){
            for (int j = 0; j < m; j++) {
                if(!isVisited[i][j] && grid[i][j]==1){
                    ArrayList<String> vec=new ArrayList<>();
                    dfs(i,j,grid,isVisited,vec,delRow,delCol,i,j);
                    st.add(vec);
                }
            }
        }
        return st.size();
    }
    public void dfs(int row,int col,int[][] grid,boolean[][] isVisited,ArrayList<String> vec,int[] delRow,int[] delCol,int row0,int col0){
        int n=grid.length;
        int m=grid[0].length;

        isVisited[row][col]=true;
        vec.add(toString(row-row0,col-col0));
        for(int i=0;i<4;i++){
            int nRow=row+delRow[i];
            int nCol=col+delCol[i];
            if( nRow>=0 && nRow<n && nCol>=0 && nCol<m && !isVisited[nRow][nCol] && grid[nRow][nCol]==1){
                dfs(nRow,nCol,grid,isVisited,vec,delRow,delCol,row0,col0);
            }
        }
    }

    private String toString(int r, int c) {
        return r +" "+ c;
    }
}
/*


 */