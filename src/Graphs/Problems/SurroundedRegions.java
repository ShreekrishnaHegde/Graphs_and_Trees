package Graphs.Problems;
/*

https://leetcode.com/problems/surrounded-regions/description/
https://www.geeksforgeeks.org/problems/replace-os-with-xs0052/1
 */
public class SurroundedRegions {
    public static void main(String[] args) {

    }
    public static char[][] fill(int n,int m,char[][] mat){
        boolean[][] isVisited=new boolean[n][m];
        int[] delRow={-1,0,1,0};
        int[] delCol={0,1,0,-1};

        //Traverse first row and last row
        for(int i=0;i<m;i++){
            //first row
            if(!isVisited[0][i] && mat[0][i]=='0'){
                dfs(0,i,isVisited,delRow,delCol,mat);
            }
            if(!isVisited[n-1][i] && mat[n-1][i]=='0'){
                dfs(n-1,i,isVisited,delRow,delCol,mat);
            }
        }
        for(int i=0;i<n;i++){
            //first col
            if(!isVisited[i][0] && mat[i][0]=='0') {
                dfs(i,0,isVisited,delRow,delCol,mat);
            }
            //last col
            if(!isVisited[i][m-1] && mat[i][m-1]=='0'){
                dfs(i,n-1,isVisited,delRow,delCol,mat);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!isVisited[i][j] && mat[i][j]=='0')
                    mat[i][j]='X';
            }
        }
        return mat;
    }
    public static void dfs(int row,int col,boolean[][] isVisited,int[] delRow,int[] delCol,char[][] mat){
        isVisited[row][col]=true;
        int n=mat.length;
        int m=mat[0].length;
        for(int i=0;i<4;i++){
            int nRow=row+delRow[i];
            int nCol=col+delCol[i];
            if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && !isVisited[nRow][nCol] && mat[nRow][nCol]=='0'){
                dfs(nRow,nCol,isVisited,delRow,delCol,mat);
            }
        }
    }

}
/*

TC: O(N x M) times 4 for dfs + O(N)
SC: O( N x M)
 */
