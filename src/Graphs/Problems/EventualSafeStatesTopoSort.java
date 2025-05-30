package Graphs.Problems;

import java.util.*;

public class EventualSafeStatesTopoSort {
    public static void main(String[] args) {

    }
    public List<Integer> eventualSafeStates2(int v,List<List<Integer>> adj){
        List<List<Integer>> adjRev=new ArrayList<>();
        int[] inDegree=new int[v];
        Queue<Integer> q=new LinkedList<>();
        List<Integer> safeNodes= new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adjRev.add(new ArrayList<>());
        }

        for(int i=0;i<v;i++){
            for(int item:adj.get(i)){
                inDegree[i]++;
            }
        }

        while (!q.isEmpty()){
            int node=q.poll();
            safeNodes.add(node);
            for(int item: adjRev.get(node)){
                inDegree[item]--;
                if(inDegree[item]==0){
                    q.add(item);
                }
            }
        }
        Collections.sort(safeNodes);
        return safeNodes;
    }
}
/*
SC:
TC:
 */