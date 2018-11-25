/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphanalyzer;
import static graphanalyzer.New_interface1.adj;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author WOLFy
 */
public class FindCycle_Undirected {

    static final int V=50;
    
    Boolean isCyclicUtil(int v, Boolean visited[], int parent)
    {

        visited[v] = true;
        Integer i;
 
        Iterator<Integer> it = adj[v].iterator();
        while (it.hasNext())
        {
            i = it.next();

            if (!visited[i])
            {
                if (isCyclicUtil(i, visited, v))
                    return true;
            }

            else if (i != parent)
                return true;
        }
        return false;
    }
    
    Boolean isCyclic()
    {
        Boolean visited[] = new Boolean[50];
        for (int j = 0; j < 50; j++)
            visited[j] = false;

        for (int u = 0; u < V; u++)
            if (!visited[u]) 
                if (isCyclicUtil(u, visited, -1))
                    return true;
 
        return false;
    }
}
