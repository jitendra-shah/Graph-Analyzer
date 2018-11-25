/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphanalyzer;

import static graphanalyzer.New_interface1.adj;
import static graphanalyzer.New_interface1.jTextArea2;
import static graphanalyzer.New_interface1.outnode;
import static graphanalyzer.New_interface1.outnodec;
import java.util.Iterator;

/**
 *
 * @author WOLFy
 */
public class DFS1 {
    
    static final int V=50;   
    
    void DFSUtil(int v,boolean visited[])
    {
        visited[v] = true;
        jTextArea2.append(v+" ");
        outnode[++outnodec]=v;
 
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }
 
    void DFS(int v)
    {
        boolean visited[] = new boolean[V];
        DFSUtil(v, visited);
    }
}
