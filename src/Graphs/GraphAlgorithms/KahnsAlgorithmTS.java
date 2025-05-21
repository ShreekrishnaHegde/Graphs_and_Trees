package Graphs.GraphAlgorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class KahnsAlgorithmTS {
    public static void main(String[] args) {

    }
    public static function(int V, ArrayList<ArrayList<Integer>> adj){
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
        int[] topo=new int[V];
        int i=0;
        while(!q.isEmpty()){
            int node=q.poll();
            topo[i++]=node;

        }

    }


}
/*
insrt all the nodes with indree=0 to the queue
take them out and remove the in degree
only valid in DAG
 */