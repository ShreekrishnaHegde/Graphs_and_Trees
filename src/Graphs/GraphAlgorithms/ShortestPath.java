package Graphs.GraphAlgorithms;

import javax.net.ssl.SSLContext;
import java.security.spec.EdDSAParameterSpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class ShortestPath {
    class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first=first;
            this.second=second;
        }
    }
    public static void main(String[] args) {

    }
    public  List<Integer> shortestPath(int n,int m,int edges[][]){
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y) -> x.first-y.second);
        int[] distance=new int[n+1];
        int[] parent=new int[n+1];

        for (int i=0;i<=n;i++){
            parent[i]=i;
            distance[i]=Integer.MAX_VALUE;
        }
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for (int i=0;i<m;i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0],edges[i][2]));
        }

        distance[1]=0;
        pq.add(new Pair(0,1));

        while (!pq.isEmpty()){
            Pair pair=pq.poll();
            int node=pair.first;
            int dis=pair.second;
            for (Pair item: adj.get(node)){
                int adjNode=item.first;
                int edW=item.second;
                if (dis+edW<distance[adjNode]){
                    distance[adjNode]=dis+ edW;
                    pq.add(new Pair(dis+edW,adjNode));
                    parent[adjNode]=node;
                }
            }
        }
        List<Integer> path=new ArrayList<>();
        if(distance[n]==Integer.MAX_VALUE){
            path.add(-1);
            return path;
        }
        int node=n;
        while (parent[node]!=node){
            path.add(node);
            node=parent[node];
        }
        path.add(1);
        Collections.reverse(path);
        return path;
    }
}
