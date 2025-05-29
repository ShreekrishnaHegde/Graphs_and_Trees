package Graphs.Traversal;

import java.util.ArrayList;
import java.util.Arrays;

public class DFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(1, 2)));
        adj.add(new ArrayList<>(Arrays.asList(0, 2, 3)));
        adj.add(new ArrayList<>(Arrays.asList(0, 4)));
        adj.add(new ArrayList<>(Arrays.asList(1,4)));
        adj.add(new ArrayList<>(Arrays.asList(2,3)));
        ArrayList<Integer> list=dfs(5,adj);
        System.out.println(list);
    }
    static void function(Integer node, ArrayList<Integer> list,boolean[] visited,ArrayList<ArrayList<Integer>> adjList){
         visited[node]=true;
         list.add(node);
         for(Integer it:adjList.get(node)){
             if(!visited[it]){
                 function(it,list,visited,adjList);
             }
         }
    }
    static ArrayList<Integer> dfs(int V,ArrayList<ArrayList<Integer>> adjList){
        boolean[] visited =new boolean[V];
        visited[0]=true;
        ArrayList<Integer> list=new ArrayList<>();
        function(V,list,visited,adjList);
        return list;
    }

}

/*
-----------------Algorithm----------------
Start by putting any one of the graph's vertices on top of a stack.
Take the top item of the stack and add it to the visited list.
Create a list of that vertex's adjacent nodes. Add the ones which aren't in the visited list
    to the top of the stack.
Keep repeating steps 2 and 3 until the stack is empty.

Space Complexity: O(V)+O(V)+O(V)
Time Complexity: O(V)+(2*E)
 */
