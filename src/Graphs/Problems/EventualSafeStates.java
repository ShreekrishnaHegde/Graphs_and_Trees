package Graphs.Problems;

import java.util.ArrayList;
import java.util.List;

/*

https://www.geeksforgeeks.org/problems/eventual-safe-states/1
https://leetcode.com/problems/find-eventual-safe-states/description/
 */
public class EventualSafeStates {
    public static void main(String[] args) {

    }
    public boolean dfs(int node,List<List<Integer>> adj,boolean[] isVisited,boolean[] check,boolean[] pathVisited){
        isVisited[node]=true;
        pathVisited[node]=true;
        check[node]=false;

        for(int item: adj.get(node)){
            if(!isVisited[item]){
                if(dfs(item,adj,isVisited,check,pathVisited))return true;
            }
            else if (pathVisited[item])return true;
        }
        check[node]=true;
        pathVisited[node]=false;
        return false;
    }
    public List<Integer> eventualSafeNodes(int v,List<List<Integer>> adj){
        boolean[] isVisited=new boolean[v];
        boolean[] pathVisited=new boolean[v];
        boolean[] check=new boolean[v];
        List<Integer> safeNodes=new ArrayList<>();

        for (int i = 0; i < v; i++) {
            if(!isVisited[i]){
                dfs(i,adj,isVisited,check,pathVisited);
            }
        }
        for (int i = 0; i < v; i++) {
            if(check[i]){
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }
}
/*
SC: 3n since 3 arrays
TC: same as dfs
 */