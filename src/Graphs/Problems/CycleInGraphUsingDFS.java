package Graphs.Problems;

import java.util.ArrayList;

public class CycleInGraphUsingDFS {
    public static void main(String[] args) {

    }
    public static boolean isCycle(int v,ArrayList<ArrayList<Integer>> adj){
        boolean[] isVisited=new boolean[v];
        for(int i=0;i<v;i++){
            if(!isVisited[i]){
                if(dfs(i,-1,isVisited,adj))return true;
            }
        }
        return false;
    }
    private static boolean dfs(int node, int parent, boolean[] isVisited, ArrayList<ArrayList<Integer>> adj){
        isVisited[node]=true;
        for(int adjNode : adj.get(node)){
            if(!isVisited[adjNode]){
                if(dfs(adjNode,node,isVisited,adj))
                    return true;
            }
            else if(adjNode!=parent)
                return true;
        }
        return false;

    }
}

/*

SC: O(N) + O(n)
SC: O(N+2E) +O(N)
 */
