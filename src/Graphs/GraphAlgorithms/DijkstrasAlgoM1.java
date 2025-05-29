package Graphs.GraphAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstrasAlgoM1 {
    class Pair{
        int node;
        int distance;
        Pair(int distance,int node){
            this.distance=distance;
            this.node=node;
        }
    }
    public static void main(String[] args) {

    }
    public int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int src) {
        // code here
        PriorityQueue<Pair> pq=new PriorityQueue<Pair>((x,y) -> x.distance-y.distance);
        int[] dis=new int[V];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[src]=0;
        pq.add(new Pair(0,src));
        while (!pq.isEmpty()){
            int distance=pq.peek().distance;
            int node=pq.peek().node;
            pq.remove();
            pq.remove();
            for(int i=0;i<adj.get(node).size();i++){
                int edgeWt=adj.get(node).get(i).get(1);
                int adjNode=adj.get(node).get(i).get(0);
                if(distance+edgeWt<dis[adjNode]){
                    dis[adjNode]+=edgeWt;
                    pq.add(new Pair(dis[adjNode],adjNode));
                }
            }
        }
        return dis;
    }
}
/*
Why negative wts is not possible
because itll be infinite loop .
ElogV is the time complexity
why priority queue should be used why not stack or array or oridinary queue
 */
