package Graphs.GraphAlgorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
Detect a Cycle in Directed Graph

if topo sort has less than v elements than it has a cycle
 */
public class KahnsAlgoCycle {
    public static void main(String[] args) {

    }
    public static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj){
        int[] inDegree=new int[V];
        Queue<Integer> q=new LinkedList<Integer>();

        for(int i=0;i<V;i++){
            for(int it:adj.get(i)){
                inDegree[it]++;
            }
        }
        for(int i=0;i<V;i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }
        int count=0;
        int i=0;
        while(!q.isEmpty()){
            int node=q.poll();
            count++;
            for(int item: adj.get(node)){
                inDegree[item]--;
                if(inDegree[item]==0)
                    q.add(item);

            }
        }
        if(count==V)return false;
        return true;

    }
}
/*
SC:
TC:
 */
