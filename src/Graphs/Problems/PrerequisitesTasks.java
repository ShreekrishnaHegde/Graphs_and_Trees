package Graphs.Problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
https://www.geeksforgeeks.org/problems/prerequisite-tasks/1
 */
public class PrerequisitesTasks {
    public static void main(String[] args) {

    }
    public boolean isPossible(int v,int[][] prerequisites){
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        List<Integer> topo=new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        for (int i=0;i< prerequisites.length;i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int inDegree[] =new int[v];

        for (int i = 0; i < v; i++) {
            for(int item: adj.get(i)){
                inDegree[item]++;
            }
        }

        for(int i=0;i<v;i++){
            if(inDegree[i]==0)
                q.add(i);
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
        if(topo.size()==v){
            return true;
        }
        else{
            return false;
        }


    }
}
