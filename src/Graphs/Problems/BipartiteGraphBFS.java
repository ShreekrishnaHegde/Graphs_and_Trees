package Graphs.Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*

https://leetcode.com/problems/is-graph-bipartite/description/
 */
public class BipartiteGraphBFS {
    public static void main(String[] args) {

    }
    private boolean check(int start,int v,ArrayList<ArrayList<Integer>> adj,int[] color){
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()){
            int node=q.poll();
            for(int item : adj.get(node)){
                if(color[item]==-1){
                    color[item]=1-color[node];
                    q.add(item);
                }
                else if (color[item] ==color[node]){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int v, ArrayList<ArrayList<Integer>> adj){
        int[] color=new int[v];
        Arrays.fill(color,-1);
        for(int i=0;i<v;i++){
            if (color[i]==-1 && !check(i,v,adj,color)){
                return false;
            }
        }
        return true;
    }

}
/*

->Odd length cycle graph cannot be bipartite

 */