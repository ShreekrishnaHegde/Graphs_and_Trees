package Graphs.Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1
 */
public class ShortestPathUndirectedGraph {
    public static void main(String[] args) {

    }
    public int[] shortestPath(int n,int m,int[][] edges,int src){
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int[] distance=new int[n];
        Arrays.fill(distance,Integer.MAX_VALUE);
        Queue<Integer> q=new LinkedList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        distance[src]=0;
        q.add(src);
        while (!q.isEmpty()){
            int node=q.poll();
            for (int item: adj.get(node)){
                if(distance[node]+1<distance[item]){
                    distance[item]=1+distance[node];
                    q.add(item);
                }
            }
        }
        for (int i=0;i<n;i++){
            if(distance[i]==Integer.MAX_VALUE){
                distance[i]=-1;
            }
        }
        return distance;
    }
}
