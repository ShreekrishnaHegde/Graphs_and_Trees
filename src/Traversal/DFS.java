package Introduction;

import java.lang.reflect.Array;
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
        function(0,list,visited,adjList);
        return list;
    }

}

/*


Space Complexity: O(N)+O(N)+O(n)
TC: O(n)+(2*e)
 */
