/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphanalyzer;

import static graphanalyzer.New_interface1.jTextArea2;
import static graphanalyzer.New_interface1.outnode;
import static graphanalyzer.New_interface1.outnodec;
import java.util.Arrays;

/**
 *
 * @author WOLFy
 */
public class Kruskal {

    class Edge implements Comparable<Edge> 
    { 
        int src, dest, weight; 

        @Override
        public int compareTo(Edge compareEdge) 
        { 
            return this.weight-compareEdge.weight; 
        } 
    }; 
  

    class subset 
    { 
        int parent, rank; 
    }; 
  
    int V, E;   
    Edge edge[]; 
  

    Kruskal(int v, int e) 
    { 
        V = v; 
        E = e; 
        edge = new Edge[E]; 
        for (int i=0; i<e; ++i) 
            edge[i] = new Edge(); 
    } 
  

    int find(subset subsets[], int i) 
    { 

        if (subsets[i].parent != i) 
            subsets[i].parent = find(subsets, subsets[i].parent); 
  
        return subsets[i].parent; 
    } 
  

    void Union(subset subsets[], int x, int y) 
    { 
        int xroot = find(subsets, x); 
        int yroot = find(subsets, y); 

        if (subsets[xroot].rank < subsets[yroot].rank) 
            subsets[xroot].parent = yroot; 
        else if (subsets[xroot].rank > subsets[yroot].rank) 
            subsets[yroot].parent = xroot; 

        else
        { 
            subsets[yroot].parent = xroot; 
            subsets[xroot].rank++; 
        } 
    } 

    void KruskalMST() 
    { 
        Edge result[] = new Edge[V]; 
        int e = 0;   
        int i = 0;  
        for (i=0; i<V; ++i) 
            result[i] = new Edge(); 

        Arrays.sort(edge); 

        subset subsets[] = new subset[V]; 
        for(i=0; i<V; ++i) 
            subsets[i]=new subset(); 

        for (int v = 0; v < V; ++v) 
        { 
            subsets[v].parent = v; 
            subsets[v].rank = 0; 
        } 
  
        i = 0;  

        while (e < V - 1) 
        { 

            Edge next_edge = new Edge(); 
            next_edge = edge[i++]; 
  
            int x = find(subsets, next_edge.src); 
            int y = find(subsets, next_edge.dest); 

            if (x != y) 
            { 
                result[e++] = next_edge; 
                Union(subsets, x, y); 
            } 

        } 

        jTextArea2.append("\nFollowing are the edges in the constructed MST"); 
        for (i = 0; i < e; ++i)
        {
            jTextArea2.append("\n"+result[i].src+" - " +  
                   result[i].dest+"  =  " + result[i].weight);
         
             outnode[++outnodec]=result[i].src;
             outnode[++outnodec]=result[i].dest;
        }
    }
}
