package Graphs.Problems;

import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/problems/number-of-provinces/
 */
public class LC547 {
    public static void main(String[] args) {

    }
    public static int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int count=0;
        boolean[] isVisited=new boolean[n];
        for(int v=0;v<n;v++){
            if(!isVisited[v]){
                dfs(isConnected,isVisited,v);
                count++;
            }
        }
        return count;
    }
    private static void dfs(int[][] isConnected,boolean[] isVisited,int v){
        Queue<Integer> q=new LinkedList<>();
        q.add(v);
        isVisited[v]=true;
        while(!q.isEmpty()){
            int node=q.poll();
            for(int i=0;i<isConnected.length;i++){
                if(isConnected[node][i]==1 && !isVisited[i]){
                    isVisited[i]=true;
                    q.add(i);
                }
            }
        }
        return;
    }
}
