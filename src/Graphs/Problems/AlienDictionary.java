package Graphs.Problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
https://www.geeksforgeeks.org/problems/alien-dictionary/1
 */
public class AlienDictionary {
    public static void main(String[] args) {

    }
    public String findOrder(String dict[],int N,int K){
        List<List<Integer>> adj=new ArrayList<>();
        String ans="";
        for(int i=0;i<K;i++){
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < N-1; i++) {
            String s1=dict[i];
            String s2=dict[i+1];
            int length=Math.min(s1.length(),s2.length());
            for (int ptr = 0; ptr < length; ptr++) {
                if (s1.charAt(ptr) != s2.charAt(ptr)){
                    adj.get(s1.charAt(ptr)-'a').add(s2.charAt(ptr)-'a');
                    break;
                }
            }
        }
        List<Integer> topo=topoSort(K,adj);
        for(int item: topo){
            ans+=(char)(item+(int)('a'));
        }
        return ans;

    }
    public List<Integer> topoSort(int V,List<List<Integer>> adj){
        int[] inDegree=new int[V];
        Queue<Integer> q=new LinkedList<>();
        List<Integer> topo=new ArrayList<>();

        for(int i=0;i<V;i++){
            for(int item: adj.get(i)){
                inDegree[item]++;
            }
        }

        for(int i=0;i<V;i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }
        while (!q.isEmpty()){
            int node=q.poll();
            topo.add(node);
            for(int item: adj.get(node)){
                inDegree[item]--;
                if(inDegree[item]==0){
                    q.add(item);
                }
            }
        }
        return topo;
    }
}
/*
when the order is not possible

 */
