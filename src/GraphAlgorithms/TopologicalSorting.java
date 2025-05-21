package GraphAlgorithms;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSorting {
    public static void main(String[] args) {

    }
    private static void dfs(int node, boolean[] vis, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj){
        vis[node]=true;
        for(int it: adj.get(node)){
            if(!vis[it]){
                dfs(it,vis,st,adj);
            }
            st.push(node);
        }
    }
    public static int[] topoSort(int V,ArrayList<ArrayList<Integer>> adj){
        boolean[] vis=new boolean[V];
        Stack<Integer> st=new Stack<Integer>();
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(i,vis,st,adj);
            }
        }
        int[] ans=new int[V];
        int i=0;
        while(!st.isEmpty()){
            ans[i++]=st.peek();
            st.pop();
        }
        return ans;

    }
}
/*

It only exits on directed acyclic graphs
if there is edge between u and v then u always apers before v in the ordering.

TC:V+E
SC:O(N)
 */
