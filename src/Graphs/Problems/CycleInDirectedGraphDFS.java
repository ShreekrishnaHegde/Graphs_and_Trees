package Graphs.Problems;

import java.util.ArrayList;

public class CycleInDirectedGraphDFS {
    public static void main(String[] args) {

    }
    public boolean isCyclic(int v, ArrayList<ArrayList<Integer>> adj){
        boolean[] isVisited=new boolean[v];
        boolean[] pathVisited=new boolean[v];
        for(int i=0;i<v;i++){
            if(!isVisited[i]){
                if(dfs(i,adj,isVisited,pathVisited))
                    return true;
            }
        }
        return false;
    }
    public boolean dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean[] isVisited,boolean[] pathVisited){
        isVisited[node]=true;
        pathVisited[node]=true;

        for(int item: adj.get(node)){
            if(!isVisited[item]){
                if(dfs(item,adj,isVisited,pathVisited))
                    return true;
            }
            else if(pathVisited[item]){
                return true;
            }
        }

        pathVisited[node]=false;
        return false;
    }
}
/*
TC: v + e since it is directed
SC: 2n is space complexity , how to use single

use single visited array

cycles in dorected and undirected graph
 */
