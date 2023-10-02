package JAVA.GRAPH;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class CustomGraph {
    public class Pair{
        int node;
        int parent;

        Pair(int node,int parent){
            this.node=node;
            this.parent=parent;
        }
    }
    public CustomGraph(){

    }
    public static void showGraph(ArrayList<Integer> []graph){
        for (int i = 0; i < graph.length; i++) {
            System.out.println(graph[i]);
        }

    }
    public static List<Integer> BFS(ArrayList<Integer> graph[]){
        List<Integer> list=new ArrayList<>();
        if(graph.length<=0){
            return list;
        }
        Queue<Integer> q=new LinkedList();
        q.offer(0);
        boolean visited[]=new boolean[graph.length];
        visited[0]=true;
        while(!q.isEmpty()){
            Integer cur=q.poll();
            list.add(cur);
            for (int i = 0; i < graph[cur].size(); i++) {
                if(visited[graph[cur].get(i)]==false){
                    visited[graph[cur].get(i)]=true;
                    q.offer(graph[cur].get(i));
                }

                
            }
            
        }
        return list; 
    }
    
    public static void DFS(ArrayList<Integer> graph[], List<Integer> list, boolean visited[], int index) {
        // Check if the graph is empty or the index is out of bounds
        if (graph.length == 0 || index < 0 || index >= graph.length) {
            return;
        }
    
        // Mark the current node as visited
        visited[index] = true;
    
        // Add the current node to the list
        list.add(index);
    
        // Iterate through the neighbors of the current node
        for (int i = 0; i < graph[index].size(); i++) {
            int neighbor = graph[index].get(i);
            if (!visited[neighbor]) {
                // Recursively call DFS on unvisited neighbors
                DFS(graph, list, visited, neighbor);
            }
        }
    }
    public boolean isCycle(ArrayList<Integer>[] g){
        boolean visited[]=new boolean[g.length];
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(0,-1));
        while(!q.isEmpty()){
            Pair p=q.poll();
            int node=p.node;
            int parent=p.parent;

            for (Integer i : g[node]) {
                if(visited[i]==false){
                    q.offer(new Pair(i,node));
                    visited[i]=true;
                }
                else if(parent!=i){
                    return true;
                }
                
            }
        }
        return false;
        
    }
    
    

    public static void main(String[] args) {
        int nodes = 4;
        int edges = 4;
        ArrayList<Integer>[] graph = new ArrayList[nodes];
        graph[0] = new ArrayList<Integer>();
        graph[0].add(1);
        graph[0].add(3);
        graph[1] = new ArrayList<Integer>();
        graph[1].add(0);
        graph[1].add(2);
        graph[2] = new ArrayList<Integer>();
        graph[2].add(1);
        graph[2].add(3);
        graph[3] = new ArrayList<>();
        graph[3].add(0);
        graph[3].add(2);
    
        // Show graph
        CustomGraph c=new CustomGraph();
        boolean ans=c.isCycle(graph);
        System.out.println(ans);  
    }
    
    
}
