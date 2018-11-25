/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphanalyzer;

import static graphanalyzer.New_interface1.i;
import static graphanalyzer.New_interface1.jTextArea2;
import static graphanalyzer.New_interface1.node_names;
import static graphanalyzer.New_interface1.outnode;
import static graphanalyzer.New_interface1.outnodec;

/**
 *
 * @author WOLFy
 */
public class Prims {
    
    private static final int V=i+1; 
  
    int minKey(int key[], Boolean mstSet[]) 
    { 
        int min = Integer.MAX_VALUE, min_index=-1; 
  
        for (int v = 0; v < V; v++) 
            if (mstSet[v] == false && key[v] < min) 
            { 
                min = key[v]; 
                min_index = v; 
            } 
  
        return min_index; 
    } 
  
    void printMST(int parent[], int n, int graph[][]) 
    { 
        jTextArea2.append("\nEdge \tWeight"); 
        for (int i = 1; i < V; i++) 
            jTextArea2.append("\n"+node_names[parent[i]]+" - "+ node_names[i]+"\t"+ 
                            graph[i][parent[i]]+"\n"); 
        
        outnode[++outnodec]=parent[i];
        outnode[++outnodec]=i;
    } 
  
    void primMST(int graph[][]) 
    { 

        int parent[] = new int[V]; 

        int key[] = new int [V]; 

        Boolean mstSet[] = new Boolean[V]; 

        for (int i = 0; i < V; i++) 
        { 
            key[i] = Integer.MAX_VALUE; 
            mstSet[i] = false; 
        } 
 
        key[0] = 0;     
                        
        parent[0] = -1; 
  
        // The MST will have V vertices 
        for (int count = 0; count < V-1; count++) 
        {
            int u = minKey(key, mstSet); 
 
            mstSet[u] = true; 

            for (int v = 0; v < V; v++) 
                if (graph[u][v]!=0 && mstSet[v] == false && 
                    graph[u][v] < key[v]) 
                { 
                    parent[v] = u; 
                    key[v] = graph[u][v]; 
                } 
        } 

        printMST(parent, V, graph);
    }
}
