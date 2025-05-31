package Graphs.Problems;

import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/*
https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1
 */
public class ShortestPathInDAG {
    class Pair{
        int first;
        int second;
        Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public static void main(String[] args) {

    }
    public int[] shortestPath(int m,int n,int[][] edges){
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        boolean[] isVisited=new boolean[m];
        Stack<Integer> st=new Stack<>();
        int[] distance=new int[n];
        Arrays.fill(distance,Integer.MAX_VALUE);
        for(int i=0;i<n;i++){
            ArrayList<Pair> temp=new ArrayList<>();
            adj.add(temp);
        }
        for(int i=0;i<m;i++){
            int u= edges[i][0];
            int v=edges[i][1];
            int wt=edges[i][2];
            adj.get(u).add(new Pair(v,wt));
        }
        for(int i=0;i<n;i++){
            if(!isVisited[i]){
                topoSort(i,adj,isVisited,st);
            }
        }

        distance[0]=0;
        while (!st.isEmpty()){
            int node=st.peek();
            st.pop();
            for(int i=0;i<adj.get(node).size();i++){
                int v=adj.get(node).get(i).first;
                int wt=adj.get(node).get(i).second;

                if(distance[node]+wt<distance[v]){
                    distance[v]=wt+distance[node];
                }
            }
        }
        return distance;
    }
    private void topoSort(int node,ArrayList<ArrayList<Pair>> adj,boolean[] isVisited,Stack<Integer> st){
        isVisited[node]=true;
        for(int i=0;i<adj.get(node).size();i++){
            int v=adj.get(node).get(i).first;
            if(!isVisited[v]){
               topoSort(v,adj,isVisited,st);
            }
        }
    }
}
/*

O(N+M) TC
 */

