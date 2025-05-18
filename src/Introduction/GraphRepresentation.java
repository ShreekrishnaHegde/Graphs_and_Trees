package Introduction;

public class GraphRepresentation {
    public static void main(String[] args) {
    }

}

/*
Given n nodes and m edges and type of the graph
m lines / rows to represent the connection b/w the edges

Adjacency Matrix Representation:
    ->An adjacency matrix is a way of representing a graph as a matrix.
    ->Let's assume there are n vertices in the graph So, create a 2D matrix adjMat[n][n] having dimension n x n.
        ->If there is an edge from vertex i to j, mark adjMat[i][j] as 1.
        ->If there is no edge from vertex i to j, mark adjMat[i][j] as 0.
    ->Space required is V^2 where V is number of vertices.
        O(V²)

Adjacency List Representation
    ->An array of Lists is used to store edges between two vertices. The size of array is equal to the
        number of vertices (i.e, n).
    ->Each index in this array represents a specific vertex in the graph.
    ->The entry at the index i of the array contains a linked list containing the vertices that are adjacent
        to vertex i.
    ->Let's assume there are n vertices in the graph So, create an array of list of size n as adjList[n].
        ->adjList[0] will have all the nodes which are connected (neighbour) to vertex 0.
        ->adjList[1] will have all the nodes which are connected (neighbour) to vertex 1 and so on.
    ->O(V) for vertex pointers,O(2E) for all adjacency entries
        O(V + E)

Example:
    1
    / \
   2   3
    \ / \
     4---5
Nodes: 1, 2, 3, 4, 5
Edges:
1 — 2
1 — 3
2 — 4
3 — 4
3 — 5
4 — 5

AM representation:
    [ 0 1 1 0 0 ]
    [ 1 0 0 1 0 ]
    [ 1 0 0 1 1 ]
    [ 0 1 1 0 1 ]
    [ 0 0 1 1 0 ]
adj_list={
    1: [2, 3],
    2: [1, 4],
    3: [1, 4, 5],
    4: [2, 3, 5],
    5: [3, 4]
}
 */