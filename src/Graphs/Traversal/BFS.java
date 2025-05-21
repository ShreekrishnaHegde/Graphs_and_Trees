package Graphs.Traversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(1, 2)));
        adj.add(new ArrayList<>(Arrays.asList(0, 2, 3)));
        adj.add(new ArrayList<>(Arrays.asList(0, 4)));
        adj.add(new ArrayList<>(Arrays.asList(1,4)));
        adj.add(new ArrayList<>(Arrays.asList(2,3)));
        ArrayList<Integer> list=bfs(5,adj);
        System.out.println(list);
    }
    //For 0 indexed graph
    static ArrayList<Integer> bfs(int V, ArrayList<ArrayList<Integer>> adjList){
        boolean visited[]=new boolean[V];
        Queue<Integer> q=new LinkedList<>();
        ArrayList<Integer> bfs=new ArrayList<>();
        q.add(0);
        visited[0]=true;
        while(!q.isEmpty()){
            Integer node=q.poll();
            bfs.add(node);
            for(Integer it: adjList.get(node)){
                if(!visited[it]){
                    visited[it]=true;
                    q.add(it);
                }
            }
        }
        return bfs;
    }
}
/*
Breadth First Search (BFS)  is a fundamental  graph traversal algorithm.
It begins with a node, then first traverses all its adjacent nodes.
Once all adjacent are visited, then their adjacent are traversed.

-------------------Algorithm------------------
Initialization: Enqueue the given source vertex into a queue and mark it as visited.
Exploration: While the queue is not empty:
    Dequeue a node from the queue and visit it (e.g., print its value).
    For each unvisited neighbor of the dequeued node:
    Enqueue the neighbor into the queue.
    Mark the neighbor as visited.
Termination: Repeat step 2 until the queue is empty.


Space Complexity: O(V)
Time Complexity: O(2*E)+O(V)
 */