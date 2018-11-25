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
import java.util.LinkedList;

/**
 *
 * @author WOLFy
 */
public class BFS {
    
    static final int V=50;   


    void BFS1(int s)
    {

        boolean visited[] = new boolean[V];

        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[s]=true;
        queue.add(s);
        
        
        while (queue.size() != 0)
        {
            s = queue.poll();
            jTextArea2.append(s+" ");
            outnode[++outnodec]=s;

            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
}
