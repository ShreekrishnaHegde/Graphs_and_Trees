package Introduction;

import java.util.ArrayList;

public class DFS {
    public static void main(String[] args) {

    }
    static void function(Integer node, ArrayList<Integer> list,boolean[] visited,ArrayList<ArrayList<Integer>> adjList){
         visited[node]=true;
         list.add(node);
         for(Integer it:adjList.get(node)){
             if(!visited[it]){
                 function(node,list,visited,adjList);
             }
         }
    }
    static ArrayList<Integer> dfs(int V,ArrayList<ArrayList<Integer>> adjList){
        boolean visited[]=new boolean[V];
        visited[0]=true;
        ArrayList<Integer> list=new ArrayList<>();
        function(0,list,visited,adjList);
        return list;
    }

}

/*



 */
