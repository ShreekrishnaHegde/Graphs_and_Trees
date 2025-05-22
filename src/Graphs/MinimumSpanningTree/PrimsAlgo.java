package Graphs.MinimumSpanningTree;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgo {
    static class Pair{
        int node;
        int distance;
        public Pair(int distance,int node){
            this.node=node;
            this.distance=distance;
        }
    }
    public static void main(String[] args) {

    }
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj){
        //x.distance < y.distance: result is negative → x has higher priority.
        PriorityQueue<Pair> pq=new PriorityQueue<Pair>((x,y) -> x.distance-y.distance);
        boolean[] vis=new boolean[V];
        int sum=0;
        pq.add(new Pair(0,0));
        while (!pq.isEmpty()){
            int wt=pq.peek().distance;
            int node=pq.peek().node;
            pq.remove();
            if(vis[node])
                continue;
            vis[node]=true;
            sum+=wt;
            for (int i=0;i<adj.get(node).size();i++){
                int adjNode=adj.get(node).get(i).get(0);
                int edgeWt=adj.get(node).get(i).get(1);
                if(!vis[adjNode]){
                    pq.add(new Pair(edgeWt,adjNode));
                }

            }
        }
        return sum;


    }
}
