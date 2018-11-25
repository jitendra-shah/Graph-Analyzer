/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphanalyzer;

import static graphanalyzer.New_interface1.i;
import static graphanalyzer.New_interface1.jTextArea2;

/**
 *
 * @author WOLFy
 */
public class DijSktra {

    static final int V=i+1; 
    int minDistance(int dist[], Boolean sptSet[]) 
    { 
        int min = Integer.MAX_VALUE, min_index=-1; 
  
        for (int v = 0; v < V; v++) 
            if (sptSet[v] == false && dist[v] <= min) 
            { 
                min = dist[v]; 
                min_index = v; 
            } 
  
        return min_index; 
    } 
    void printSolution(int dist[], int n) 
    { 
        jTextArea2.append("\nVertex   Distance from Source"); 
        for (int i = 0; i < V; i++) 
            jTextArea2.append("\n"+i+" tt "+dist[i]); 
    } 

    void dijkstra(int graph[][], int src) 
    { 
        int dist[] = new int[V];
        Boolean sptSet[] = new Boolean[V]; 
        for (int i = 0; i < V; i++) 
        { 
            dist[i] = Integer.MAX_VALUE; 
            sptSet[i] = false; 
        } 
        dist[src] = 0; 
        for (int count = 0; count < V-1; count++) 
        { 
            int u = minDistance(dist, sptSet); 
  
            sptSet[u] = true; 
  
            for (int v = 0; v < V; v++) 
  
                if (!sptSet[v] && graph[u][v]!=0 && 
                        dist[u] != Integer.MAX_VALUE && 
                        dist[u]+graph[u][v] < dist[v]) 
                    dist[v] = dist[u] + graph[u][v]; 
        } 
  
        printSolution(dist, V); 
    }
}
