package Introduction;

public class Intro {

}

/*

Types of Graph
1.Directed/Undirected
2.Weighted/Unweighted
3.Cyclic/Acyclic
4.Connected/Unconnected Graph

Nodes/Vertex
    ->It represents an entity within the graph.
    ->Nodes are represented by a number, there is no specific order for numbering the nodes
    ->V/N represents number of nodes or vertex

Edge
    ->An Edge is a connection between two vertices in a graph.
    ->Two nodes are connected by a line which is called as edge

Directed and undirected edge
    ->In a directed graph, edges have a specific direction, indicating a one-way connection between vertices.
    ->Undirected graphs have edges that do not have a direction and represent bidirectional connections.

Degrees in a graph
    ->The number of edges that are attached to a node are called degree of that node.
    ->The Degree of a Vertex in a graph is the number of edges incident to that vertex.
    ->In a directed graph, the degree is further categorized into the in-degree
        (number of incoming edges) and out-degree (number of outgoing edges) of the vertex.
    ->Total degree of the graph= 2 times number of edges
        Degree=2*E

Cycles in a graph
    ->A Cycle in a graph is a path that starts and ends at the same vertex, with no repetitions of vertices
        (except the starting and ending vertex, which are the same).

A Graph is connected if there is a path between every pair of vertices in the graph.
A disconnected graph has isolated components that are not connected to each other.
    These components are separate subgraphs.

Path
    ->A Path in a graph is a sequence of vertices where each adjacent pair is connected by an edge.


Applications of Graph:
Transportation Systems: Google Maps employs graphs to map roads, where intersections are vertices and roads
    are edges. It calculates shortest paths for efficient navigation.
Social Networks: Platforms like Facebook model users as vertices and friendships as edges,
    using graph theory for friend suggestions.
World Wide Web: Web pages are vertices, and links between them are directed edges,
    inspiring Google's Page Ranking Algorithm.
Resource Allocation and Deadlock Prevention: Operating systems use resource allocation graphs
    to prevent deadlocks by detecting cycles.
Mapping Systems and GPS Navigation: Graphs help in locating places and optimizing routes in mapping systems
    and GPS navigation.
Graph Algorithms and Measures: Graphs are analyzed for structural properties and measurable quantities,
    including dynamic properties in networks.
 */
