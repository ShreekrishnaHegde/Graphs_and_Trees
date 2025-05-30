package Graphs.Problems;

import java.util.ArrayList;
import java.util.Arrays;

public class BipartiteGraphDFS {
    public static void main(String[] args) {

    }
    private boolean dfs(int node,int col,int[] color,ArrayList<ArrayList<Integer>> adj){
        color[node]=col;
        for(int item: adj.get(node)){
            if(color[node]==-1){
                if(!dfs(item,1-col,color,adj)) {
                    return false;
                }
            } else if (color[item]==col) {
                return false;
            }
        }
    }
    public boolean isBipartite(int v, ArrayList<ArrayList<Integer>> adj){
        int[] color=new int[v];
        Arrays.fill(color,-1);
        for (int i = 0; i < v; i++) {
            if(color[i]==-1){
                if(dfs(i,0,color,adj))
                    return false;
            }
        }
        return true;
    }
}
/*
TC: same as dfs v+2e
SC: v
 */
